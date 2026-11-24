import sys

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
  a, b = map(int, sys.stdin.readline().split())
  print(f"Case #{_+1}: {a+b}")