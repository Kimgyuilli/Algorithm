from sys import stdin
read = list(stdin.readline().strip())
flag = 0
num = 0
pare = 0
for _ in range(len(read)):
    if read[_] == '(':
        pare += 1
        flag = 0
    elif read[_] == ')':
        if flag == 0:
            pare -= 1
            num += pare
        elif flag == 1:
            pare -= 1
            num += 1
        flag = 1
print(num)