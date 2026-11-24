angle = [int(input()) for _ in range(3)]

if sum(angle) == 180:
    if angle[0] == angle[1] and angle[1] == angle[2]:
        print('Equilateral')
    elif angle[0] != angle[1] and angle[1] != angle[2] and angle[0] != angle[2]:
        print('Scalene')
    else: print('Isosceles')
else: print('Error')