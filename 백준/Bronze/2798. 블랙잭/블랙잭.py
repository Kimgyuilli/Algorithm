N, M = map(int, input().split())
nums = list(map(int, input().split()))
max = 0
for i in nums:
    sample = nums
    for j in nums:
        for k in nums:
            if i != j and j != k and i != k and i + j + k > max and i + j + k <= M:
                max = i + j + k
print(max)