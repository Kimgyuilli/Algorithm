N, M = map(int, input().split())

basket = []
for _b in range(N):
    basket.append(0)

for _ in range(M):
    i, j, k = map(int, input().split())
    while i < j + 1:
        basket[i-1] = k
        i += 1

print(*basket)