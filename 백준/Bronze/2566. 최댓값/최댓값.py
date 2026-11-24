maxnum = -1
for _ in range(9):
    row = list(map(int, input().split()))
    new_max = max(row)
    if new_max >= maxnum:
        maxnum = new_max
        maxrow = _+1 
        maxcol = row.index(new_max)+1

print(maxnum)
print(maxrow, maxcol)