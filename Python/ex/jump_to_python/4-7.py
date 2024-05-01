with open("test.txt", "r") as f:
    input = f.read()

output = input.replace("java", "python")

with open("test.txt", "w") as f:
    f.write(output)