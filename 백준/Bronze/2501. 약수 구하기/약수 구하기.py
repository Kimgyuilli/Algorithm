x, y = map(int, input().split())
result = []
for _ in range(x):
    if x % (_ + 1) == 0:
        result.append(_ + 1)
if y <= len(result):
    print(result[y-1])
else: print(0)