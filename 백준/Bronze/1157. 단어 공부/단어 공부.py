str = input().upper()

dic = {}

for i in str:
    if i not in dic:
        dic[i] = 0
    dic[i] += 1

result = [key for key, val in dic.items() if max(dic.values()) == val]

if len(result) != 1:
    print('?')
else:
    print(result[0])