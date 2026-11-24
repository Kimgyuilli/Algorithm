x = list(map(int, input().split()))
if x[0]%4 == 0:
  if x[0]%400 == 0 or x[0] % 100 != 0:
    print(1)
  else:
    print(0)
else:
  print(0)