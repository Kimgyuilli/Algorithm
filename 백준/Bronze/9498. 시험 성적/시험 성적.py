x = list(map(int, input().split()))
if x[0] >= 90:
  print("A")
elif x[0] >= 80:
  print("B")
elif x[0] >=70:
  print("C")
elif x[0] >=60:
  print("D")
else:
  print("F")