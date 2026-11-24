credit = {'A+' : 4.5, 'A0' : 4.0, 'B+' : 3.5, 'B0' : 3.0, 'C+' : 2.5, 
          'C0' : 2.0, 'D+' : 1.5, 'D0' : 1.0, 'F' : 0.0,}

Total = 0
result = 0

for _ in range(20):
    grade = list(input().split())
    if grade[2] != 'P':
        Total += float(grade[1])
        result +=  float(grade[1]) * credit[grade[2]]
print('%.6f' % (result/Total))