N = int(input())
s = ""

if N//4 > 1:
  for _i in range(1, N//4):
    s += "long "

print(f"{s}long int")