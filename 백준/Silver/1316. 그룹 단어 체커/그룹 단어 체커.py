N = int(input())
flag = True
PopList = []
count = 0

for _ in range(N):
    s = list(input())
    for i in s:
        if PopList.count(i) == True and PopList[-1] != i:
            flag = False
            break;
        elif PopList.count(i) == False:
            PopList.append(i)
    if flag == True:
        count += 1
    else: flag = True
    PopList = []

print(count)