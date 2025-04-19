N = int(input())
coor = []
for _ in range(N):
    a, b = input().split()
    coor.append([_, int(a), b])
coor.sort(key=lambda x: (x[1], x[0]))

for i in range(N):
    print(coor[i][1], coor[i][2]) 