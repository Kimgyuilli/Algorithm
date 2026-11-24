S = list(input())
alp = [-1 for _ in range(26)]

for i in range(len(S)):
    if alp[ord(S[i])-97] == -1:
        alp[ord(S[i])-97] = i

print(*alp)