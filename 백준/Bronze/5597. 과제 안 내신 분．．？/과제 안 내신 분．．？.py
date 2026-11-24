attendance = [_ for _ in range(1, 31)]

for _l in range(0, 28):
    attendance.remove(int(input()))

print(*attendance, sep='\n')