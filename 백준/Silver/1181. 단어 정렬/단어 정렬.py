N = int(input())
coor = []
for _ in range(N):
    coor.append(input())
coor = list(set(coor))
coor.sort()
coor.sort(key = len)
for i in coor:
    print(i)