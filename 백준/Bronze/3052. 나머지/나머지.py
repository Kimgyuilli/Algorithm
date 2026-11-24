attendance = []

for _l in range(10):
    n = int(input())
    if n%42 not in attendance:
         attendance.append(n%42)

print(len(attendance))