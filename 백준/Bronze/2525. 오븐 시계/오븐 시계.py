A, B= map(int, input().split())
C = input()
C = int(C)
D = int((B+C)/60) #올림

if B + C >= 60:
  if A + D >= 24:
    print(A + D - 24 , B + C - D * 60)
  else:
    print(A + D, B + C - D * 60)
else:
  print(A, B + C)