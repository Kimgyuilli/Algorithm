import sys

N = int(input())
v= list(map(int, sys.stdin.readline().split()))

print(v.count(int(input())))