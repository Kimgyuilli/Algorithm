import sys

N = int(sys.stdin.readline())

for _ in range(N):
  print(" "*(N-_-1) + "*"*(_+1))