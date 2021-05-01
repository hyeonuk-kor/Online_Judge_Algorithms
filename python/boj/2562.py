m = 0
mi = 0
for i in range(9):
    a = int(input())
    if m<a:
        m = a
        mi = i+1
print(m)
print(mi)