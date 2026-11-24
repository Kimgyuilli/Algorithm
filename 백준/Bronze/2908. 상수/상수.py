S = list(input())
S.reverse()
a, b = ''.join(S).split()

print(a if int(a)>int(b) else b)