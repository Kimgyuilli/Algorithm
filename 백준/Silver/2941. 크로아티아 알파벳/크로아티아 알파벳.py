str = input()
sample = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in sample:
    str = str.replace(i, '*')
print(len(str))