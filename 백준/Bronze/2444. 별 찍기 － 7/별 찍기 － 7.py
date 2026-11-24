lines = int(input())
num = -1

for _ in range(lines * 2 - 1):
    if _ < lines:
        num += 1
        print(f"{' ' * (lines - num - 1)}*{'*' * 2 * num}")
    else:
        num -= 1
        print(f"{' ' * (lines - num - 1)}*{'*' * 2 * num}")