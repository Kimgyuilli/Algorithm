import math

Num = int(input())
for i in range(Num):
    N, M = map(int, input().split())
    print(math.lcm(N, M))