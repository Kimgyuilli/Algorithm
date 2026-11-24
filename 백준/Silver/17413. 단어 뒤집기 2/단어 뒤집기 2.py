from sys import stdin
read = list(stdin.readline().strip())
flag = 0
num = 0
deque = []
for _ in range(len(read)):
        if read[_] == '<':
            flag = 1
            deque.append(read[_])
        elif read[_] == '>':
            flag = 0
            deque.append(read[_])
            num = len(deque)
        elif read[_] == ' ':
            deque.append(read[_])
            num = len(deque)
        elif flag == 0:
            deque.insert(num, read[_])
        elif flag == 1:
            deque.append(read[_])
print("".join(deque))