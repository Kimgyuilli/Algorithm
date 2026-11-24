N = int(input())
M = int(input())
lst = []

for _ in range(N, M + 1):
    flag = True
    if _ > 1:
        for i in range(2, _):
            if _ % i == 0:
                flag = False
                break
        if flag:
            lst.append(_)
if len(lst) == 0:
    print(-1)
else: 
    print(sum(lst))
    print(min(lst))