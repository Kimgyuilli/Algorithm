max = num = 0
for _ in range(9):
  n = int(input())
  if n > max:
    max = n
    num = _+1
    
print(f"{max}\n{num}")