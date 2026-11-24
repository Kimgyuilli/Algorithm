import sys

N, X= map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

for _ in range(N):
  if A[_] < X:
    print(A[_], end=" ")