N, M = map(int, input().split())

basket1 = [_ for _ in range(1, N+1)]
basket2 = [_ for _ in range(1, N+1)]

for _ in range(M):
    i, j = map(int, input().split())
    while j >= i:
        basket1[i-1] = basket2[j-1]
        basket1[j-1] = basket2[i-1]
        j -= 1
        i += 1
        basket2 = basket1.copy()

print(*basket1)