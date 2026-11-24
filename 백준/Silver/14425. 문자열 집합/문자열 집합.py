import sys

N, M = map(int, sys.stdin.readline().split())
S = {sys.stdin.readline() for i in range(N)}
K = [sys.stdin.readline() for i in range(M)]
cnt = 0

for _ in K:
    if _ in S:
        cnt += 1
print(cnt)