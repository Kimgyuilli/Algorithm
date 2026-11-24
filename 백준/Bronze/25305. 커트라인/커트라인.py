N, k = map(int, input().split())
Xs = sorted(list(map(int, input().split())), reverse = True)

print(Xs[k-1])