T = int(input())
coin = [0 for i in range(4)]

for _ in range(T):
    C = int(input())
    coin[0] = C // 25
    extra = C % 25
    coin[1] = extra // 10
    extra = extra % 10
    coin[2] = extra // 5
    extra = extra % 5
    coin[3] = extra // 1
    print(*coin)
