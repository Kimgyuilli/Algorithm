str = input()
sum = 0
dic = {"ABC" : 3, "DEF":4, "GHI":5, "JKL":6, "MNO":7, "PQRS":8, "TUV":9, "WXYZ":10,}
for _ in str:
    for key, value in dic.items():
        if _ in key:
            sum = sum + value

print(sum)