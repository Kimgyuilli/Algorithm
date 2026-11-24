N, M  = map(int, input().split())

basket = [_+1 for _ in range(N)]
temp = 0

for _ in range(M):
    i, j = map(int, input().split())
    temp = basket[i-1]
    basket[i-1] = basket[j-1]
    basket[j-1] = temp

print(*basket)