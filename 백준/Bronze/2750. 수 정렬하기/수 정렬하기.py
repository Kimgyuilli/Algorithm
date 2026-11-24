N = int(input())
nums = []

for _ in range(N):
    nums.append(int(input()))
nums.sort()

for _ in range(N):
    print(nums[_])