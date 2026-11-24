N, M = map(int, input().split())
chess = []
repair = []

for _ in range(N):
    chess.append(input())


for i in range(N-7):
    for j in range(M-7):
        cnt1 = 0
        cnt2 = 0
        for k in range(i, i+8):
            for l in range(j, j+8):
                if (k+l) % 2 == 0:
                    if chess[k][l] != 'W':
                        cnt1 = cnt1 + 1
                    if chess[k][l] != 'B':
                        cnt2 = cnt2 + 1
                else:
                    if chess[k][l] != 'B':
                        cnt1 = cnt1 + 1
                    if chess[k][l] != 'W':
                        cnt2 = cnt2 + 1
        repair.append(cnt1)
        repair.append(cnt2)


print(min(repair))
