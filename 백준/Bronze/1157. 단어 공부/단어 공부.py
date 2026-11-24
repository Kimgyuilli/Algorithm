str= input()
numb = [0 for i in range(26)]
answer = 0

for _ in str:
    if ord(_) >= 65 and ord(_) <= 90:
        numb[ord(_) - 65] += 1
    elif ord(_) >= 97 and ord(_) <= 122:
        numb[ord(_) - 97] += 1

for __ in numb:
    if __ == max(numb):
        answer += 1
if answer == 1:
    print(chr(numb.index(max(numb))+65))
else: print('?')