from sys import stdin
n = int(stdin.readline())
deque = []
for _ in range(n):
    read = stdin.readline().split()
    if read[0] == 'push_front':
        deque.insert(0, read[1])
    elif read[0] == 'push_back':
        deque.append(read[1])
    elif read[0] == 'pop_front':
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.pop(0))
    elif read[0] == 'pop_back':
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.pop())
    elif read[0] == 'size':
        print(len(deque))
    elif read[0] == 'empty':
        if len(deque) == 0:
            print(1)
        else:
            print(0)
    elif read[0] == 'front':
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[0])
    elif read[0] == 'back':
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[-1])