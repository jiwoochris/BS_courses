import torch

W1 = torch.zeros(4, requires_grad=True)

W2 = torch.zeros((4, 1), requires_grad=True)

W3 = torch.zeros(4, 1, requires_grad=True)

print(W1)
print(W2)
print(W3)