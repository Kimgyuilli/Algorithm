A= list(map(int, input().split()))

visited = set()

dup = [x for x in A if x in visited or (visited.add(x)) or False]

if len(dup) == 2:
  print(10000+dup[0]*1000)
elif len(dup) == 1:
  print(1000+dup[0]*100)
else:
  print(max(A)*100)