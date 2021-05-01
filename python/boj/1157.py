import sys
word = sys.stdin.readline().rstrip() # 한줄 입력받기
word = word.upper();
wordSet = list(set(word))
cnt = []
for i in wordSet:
    count = word.count(i)
    cnt.append(count)
if cnt.count(max(cnt)) >= 2:
    print("?")
else:
    print(wordSet[cnt.index(max(cnt))].upper())
