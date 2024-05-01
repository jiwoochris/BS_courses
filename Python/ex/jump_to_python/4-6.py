input = input("enter your comments: ")

with open("test.txt", "a") as f:
    f.write(input)
