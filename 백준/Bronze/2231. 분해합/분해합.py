N = int(input())
for i in range(N):
    M = list(map(int, str(i)))
    if  N == i + sum(M):
        print(i)
        break
    elif i == N-1:
        print(0)