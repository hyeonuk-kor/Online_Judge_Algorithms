number = list(map(int, input().split()))
sum = 0
for i in range(len(number)):
    sum += number[i] ** 2
print(sum % 10)