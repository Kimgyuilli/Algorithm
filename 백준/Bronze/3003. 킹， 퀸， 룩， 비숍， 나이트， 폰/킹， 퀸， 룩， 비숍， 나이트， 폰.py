stock = list(map(int, input().split()))
nomal = [1, 1 ,2 ,2 ,2, 8]

for _ in range(len(stock)):
    print(nomal[_] - stock[_], end = ' ')