while True:
    x = list(map(int, input().split()))
    if x[0] == 0:
        break
    x.sort()
    if x[0] + x[1] <= x[2]:
        print("Invalid")
    else:
        if x[0] == x[1] and x[1] == x[2]:
            print("Equilateral")
        elif x[0] == x[1] or x[1] == x[2] or x[0] == x[2]:
            print("Isosceles")
        else:
            print("Scalene")