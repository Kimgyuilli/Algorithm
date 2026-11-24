N = int(input())
coor = []
for _ in range(N):
    l = list(map(int, input().split()))
    l.reverse()
    coor.append(l)
coor.sort()
for i in range(N):
    print(coor[i][1], coor[i][0])