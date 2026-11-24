N = int(input())
lst = [[0 for _ in range(100)] for i in range(100)]
result = 0

for i in range(N):
    a, b = map(int, input().split())

    for k in range(a, a+10):
        for j in range(b, b+10):
            lst[k][j] = 1
for _ in lst:
    result += _.count(1)
print(result)