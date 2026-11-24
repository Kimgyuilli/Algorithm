while True:
    result = []
    n = int(input())
    if n == -1:
        break
    for _ in range(n-1):
        if n % (_ + 1) == 0:
            result.append(_+1)
    if sum(result) == n:
        print(f"{n} = ", end = '')
        for i in range(len(result)-1):
            print(f"{result[i]} + ", end = '')
        print(result[-1])
    else:
        print(f"{n} is NOT perfect.")