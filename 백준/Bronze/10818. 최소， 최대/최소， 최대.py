import sys

N = int(input())
A = list(map(int, sys.stdin.readline().split()))

print(min(A), max(A))