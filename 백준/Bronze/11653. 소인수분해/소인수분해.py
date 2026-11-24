N = int(input())
div = 2

while div <= N:
    if N % div == 0:
        N = N / div
        print(div)
    else: div += 1