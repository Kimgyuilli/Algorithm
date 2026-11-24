import sys

input = sys.stdin.readline
N = int(input())
coor1 = list(map(int, input().split()))
coor2 = sorted(list(set(coor1)))
dic = {coor2[i]:i for i in range(len(coor2))}
for _ in coor1:
    print(dic[_], end = " ")