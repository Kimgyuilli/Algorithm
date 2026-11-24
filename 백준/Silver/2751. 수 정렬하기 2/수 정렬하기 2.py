import sys
N = int(sys.stdin.readline())
arr = []
for _ in range(N):
    arr.append(int(sys.stdin.readline()))

arr.sort()

for _ in arr:
    print(_)