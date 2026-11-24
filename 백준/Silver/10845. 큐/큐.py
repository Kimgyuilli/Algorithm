from sys import stdin
n = int(stdin.readline())
q = []
for _ in range(n):
    ord = stdin.readline().split()
    if ord[0] == 'push':
        q.append(ord[1])
    elif ord[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.pop(0))
    elif ord[0] == 'size':
        print(len(q))
    elif ord[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif ord[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif ord[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])