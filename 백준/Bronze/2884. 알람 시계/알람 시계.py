x, y= map(int, input().split())

if y - 45 >= 0:
  print(x, y - 45)
elif y - 45 < 0:
  if x == 0:
    print(23, y - 45 + 60)
  else:
    print(x - 1, y - 45 + 60)