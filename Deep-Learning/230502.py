import torch
import torch.nn as nn # Deep Learning Network 기본 구성 요소를 포함한 torch.nn 모듈을 nn으로 지정 
import torch.nn.functional as F # torch.nn.functional 을 F 로 지정
import torch.optim as optim 
import torchvision.datasets as dsets
import torchvision.transforms as transforms
from torch.autograd import Variable

from matplotlib import pyplot as plt # Data 시각화를 돕는 matplotlib 모듈 



use_cuda = torch.cuda.is_available() 
device = torch.device("cuda" if use_cuda else "cpu")




input_size = 784 # img_size = (28,28) ---> 28 x 28 = 784 in total
hidden_size = 500 # number of nodes at hidden layer
num_classes = 10 # number of output classes discrete range [0,9]
num_epochs = 20 # number of times which the entire dataset is passed throughout the model
batch_size = 50 # the size of input data took for one iteration "= mini batch size" 
lr = 1e-3 # size of step 



train_data = dsets.MNIST(root = './data', train = True,
                        transform = transforms.ToTensor(), download = True)

test_data = dsets.MNIST(root = './data', train = False,
                       transform = transforms.ToTensor())

print('number of training data : ',len(train_data))
print('number of test data : ',len(test_data))



image, label = train_data[0]

plt.imshow(image.squeeze().numpy(), cmap = 'gray')
plt.title('label : %s' % label)
plt.show()

exit()


train_gen = torch.utils.data.DataLoader(dataset = train_data,
                                             batch_size = batch_size,
                                             shuffle = True)

test_gen = torch.utils.data.DataLoader(dataset = test_data,
                                      batch_size = batch_size, 
                                      shuffle = False)




class MyLeNet5_1 (nn.Module): 
  def __init__(self): 
    super(MyLeNet5_1, self).__init__()
    self.conv_1 = nn.Conv2d(1, 6, kernel_size = 5, padding = 2)
    self.maxpool_1 = nn.MaxPool2d(kernel_size=(2,2), stride = 2)
    self.conv_2 = nn.Conv2d(6, 16, kernel_size = 5)
    self.maxpool_2 = nn.MaxPool2d(kernel_size=(2,2), stride = 2)
    self.conv_3 = nn.Conv2d(16, 120, kernel_size = 5)
    self.relu = nn.ReLU()
    self.fc_1 = nn.Linear(120, 84)
    self.fc_2 = nn.Linear(84, 10)

  def forward(self, x):
    x = self.conv_1(x)
    x = self.relu(x)
    x = self.maxpool_1(x)
    x = self.conv_2(x)
    x = self.relu(x)
    x = self.maxpool_2(x)
    x = self.conv_3(x)
    x = x.view(-1, 120) 
    x = self.fc_1(x)
    x = self.relu(x)
    res = self.fc_2(x)
    return res 

model = MyLeNet5_1()
print(model)



loss_function = nn.CrossEntropyLoss()
optimizer = torch.optim.Adam(model.parameters(), lr=lr)





model.train()
model = model.to(device)
i = 0 # Loss Function 현황을 확인하고자, 학습 횟수를 나타내는 보조 index 지정

for epoch in range(num_epochs):
  for data, target in train_gen:
    data = data.to(device) 
    target = target.to(device)
    optimizer.zero_grad() # optimizer gradient 초기화 
    output = model(data)
    loss = loss_function(output, target)
    loss.backward() 
    optimizer.step()

    if i % 1000 == 0:
      print('Train Step: {}\tloss: {:.3f}'.format(i, loss.item()))
    i +=1




model.eval()
model = model.to(device)
correct = 0 # 정답 개수 저장 및 확인 

for data, target in test_gen:
  data = data.to(device)
  target = target.to(device)
  output = model(data)
  prediction = output.data.max(1)[1] # Softmax 값이 가장 큰 index를 예측
  correct += prediction.eq(target.data).sum()

print('Test set: Accuracy: {:.2f}%'.format(100 * correct / len(test_gen.dataset)))




class_names = train_data.classes
class_names



image, label = test_data[0]

# See random images with their labels
torch.manual_seed(42)  # setting random seed
import matplotlib.pyplot as plt


fig = plt.figure(figsize=(12, 4))

rows, cols = 6, 6
for i in range(1, (rows * cols) + 1):
    random_idx = torch.randint(0, len(test_data), size=[1]).item()
    img, label_gt = test_data[random_idx]
    img_temp = img.unsqueeze(dim=0).to(device)
    # print(img.shape)
    label_pred = torch.argmax(model(img_temp))
    fig.add_subplot(rows, cols, i)
    img = img.permute(1, 2, 0)    # CWH --> WHC
    plt.imshow(img, cmap='gray')
    if label_pred == label_gt:
        plt.title(class_names[label_pred], color='g') # for correct prediction
    else:
        plt.title(class_names[label_pred], color='r') # for incorrect prediction
    plt.axis(False)
    plt.tight_layout();




