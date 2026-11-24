dec = list(map(int, input().split()))
trans = ''

while dec[0]:
    if dec[0] % dec[1] > 9:
        trans += chr(55 + dec[0] % dec[1])
    else:
        trans += str(dec[0] % dec[1])
    dec[0] //= dec[1]
print(trans[::-1])