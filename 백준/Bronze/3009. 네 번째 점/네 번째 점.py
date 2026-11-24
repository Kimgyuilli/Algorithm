coord1 = []
coord2 = []
for _ in range(3):
    x,y = map(int, input().split())
    if coord1.count(x):
        coord1.remove(x)
    else: coord1.append(x)
    if coord2.count(y):
        coord2.remove(y)
    else: coord2.append(y)

print(coord1[0], coord2[0])