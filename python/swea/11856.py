T = int(input())
for test_case in range(1, T + 1):
    S = input()
    ptc = "#" + str(test_case) + " ";
    check = True
    alpha = [0 for _ in range(26)]
    for i in S:
        index = S.find(i)
        alpha[index] += 1
    for i in range(26):
        if alpha[i] % 2 == 1 or alpha[i] > 2:
            check = False
    if check:
        print(ptc + "Yes")
    else:
        print(ptc + "No")