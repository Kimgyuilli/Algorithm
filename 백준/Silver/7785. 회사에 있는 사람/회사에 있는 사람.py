import sys

N = int(sys.stdin.readline())
S = {}
for _ in range(N):
    A, B = map(str, sys.stdin.readline().split())
    if B == 'enter':
        S[A] = B
    else:
        del S[A]

    
S = sorted(S.keys(), reverse = True)

for _ in S:
    print(_)