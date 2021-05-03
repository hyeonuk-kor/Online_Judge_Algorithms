T = int(input())
for test_case in range(1, T + 1):
    S = input()
    answer = "No"
    if S[0] == S[1] and S[2] == S[3] and S[1] != S[2]:
        answer = "Yes"
    elif S[0] == S[2] and S[1] == S[3] and S[2] != S[1]:
        answer = "Yes"
    elif S[0] == S[3] and S[1] == S[2] and S[3] != S[1]:
        answer = "Yes"
    print(f"#{test_case} {answer}")
