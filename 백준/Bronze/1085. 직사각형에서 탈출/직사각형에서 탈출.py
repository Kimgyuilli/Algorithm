x, y, w, z = list(map(int,input().split()))
print(min(x, y, w-x, z-y))