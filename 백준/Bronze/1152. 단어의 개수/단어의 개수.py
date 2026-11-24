S = list(input())
plus = 1

if S[0] == ' ' :
    plus -= 1
if S[-1] == ' ':
    plus -= 1

print(S.count(' ')+plus)