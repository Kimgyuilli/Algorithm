N = int(input())
coor = []
for _ in range(N):
    coor.append(list(map(int, input().split())))
coor.sort()
for i in range(N):
    print(coor[i][0], coor[i][1])