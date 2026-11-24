N = int(input())
num = 0
cnt = 666

while num < N:
    if str(cnt).find('666') != -1:
        num = num + 1
    cnt = cnt+1
print(cnt-1)