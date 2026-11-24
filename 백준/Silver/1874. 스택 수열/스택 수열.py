n = int(input())
arr = []
result = []
count = 0
flag = 1
for _ in range(n):
    n = int(input())

    while count<n:
        count += 1
        arr.append(count)
        result.append('+')
    if n == arr[-1]:
        arr.pop()
        result.append('-')
    else:
        flag = 0
        break
if flag == 1:
    print("\n".join(result))
else: print('NO')