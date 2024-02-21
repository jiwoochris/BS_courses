import torch
import torch.nn as nn
import torch.optim as optim
from torchvision import models
import torchvision.datasets as datasets
import torchvision.transforms as transforms



use_cuda = torch.cuda.is_available() 
device = torch.device("cuda" if use_cuda else "cpu")

print(use_cuda)
print(device)



batch_size = 128
print_train_step = int(1000*16/batch_size)
#learnning_rate = 0.01
learnning_rate = 0.02
epochs = 10

kwargs = {'num_workers': 1, 'pin_memory': True} if use_cuda else {}




train_dataset = datasets.MNIST(
    './data', train=True, download=True,
    transform=transforms.Compose([
                                  transforms.Resize([112, 112]),
                                  transforms.ToTensor(),
                                  transforms.Normalize((0.1307,), (0.3081,))
                                  ])
    )

train_loader = torch.utils.data.DataLoader(train_dataset, batch_size=batch_size, shuffle=True, **kwargs)

test_dataset = datasets.MNIST(
    './data', train=False, 
    transform=transforms.Compose([
                                  transforms.Resize([112, 112]),
                                  transforms.ToTensor(),
                                  transforms.Normalize((0.1307,), (0.3081,))
                                  ])
    )

test_loader = torch.utils.data.DataLoader(test_dataset, batch_size=batch_size, shuffle=True, **kwargs)

print('number of training data : ',len(train_dataset))
print('number of test data : ',len(test_dataset))








model = models.resnet18(pretrained=True)
print(model)






model.conv1 = nn.Conv2d(1, 64, kernel_size=(3, 3), stride = (1, 1), padding = (1, 1), bias=False)
model.fc = nn.Linear(512, 10, bias = True)

model.to(device)

for name, param in model.named_parameters():
  param.requires_grad = False

model.conv1.weight.requires_grad = True
model.bn1.weight.requires_grad = True
model.bn1.bias.requires_grad = True
model.fc.weight.requires_grad = True
model.fc.bias.requires_grad = True

params_to_update = []
for name, param in model.named_parameters():
  if param.requires_grad == True:
    print(name)
    params_to_update.append(param)  

print(model)











optimizer = optim.Adadelta(params_to_update, lr=learnning_rate)
scheduler = optim.lr_scheduler.StepLR(optimizer, step_size=1, gamma=0.1)
loss_function = nn.CrossEntropyLoss()







def train(model, device, train_loader, optimizer, loss_function, epoch):
  model.train()
  for batch_idx, (data, target) in enumerate(train_loader):
    data, target = data.to(device), target.to(device)
    optimizer.zero_grad()
    output = model(data)
    loss = loss_function(output, target)
    loss.backward()
    optimizer.step()
        
    if batch_idx % print_train_step == 0:
      print('Train Epoch: {} [{}/{} ({:.0f}%)]\tLoss: {:.6f}'.format(
          epoch, batch_idx * len(data), len(train_loader.dataset),
          100. * batch_idx / len(train_loader), loss.item()))






def test(model, device, test_loader, loss_function):
  model.eval()
  test_loss = 0
  correct = 0
  
  with torch.no_grad():
    for data, target in test_loader:
      data, target = data.to(device), target.to(device)
      output = model(data)
      test_loss += loss_function(output, target) # sum up batch loss
      pred = output.argmax(dim=1, keepdim=True) # get the index of the max log-probability
      correct += pred.eq(target.view_as(pred)).sum().item()
      
  test_loss /= len(test_loader.dataset)
  print('\nTest set: Average loss: {:.4f}, Accuracy: {}/{} ({:.0f}%)\n'.format(
      test_loss, correct, len(test_loader.dataset),
      100. * correct / len(test_loader.dataset)))








for epoch in range(epochs):
  train(model, device, train_loader, optimizer, loss_function, epoch)
  test(model, device, test_loader, loss_function)
  scheduler.step()











params_to_update = []
for name, param in model.named_parameters():
  if 'conv1' in name:
    print(name)    
    param.requires_grad = True
    params_to_update.append(param)
  elif 'fc' in name:
    print(name)    
    param.requires_grad = True
    params_to_update.append(param)
  else:
    param.requires_grad = False

#print(model)








