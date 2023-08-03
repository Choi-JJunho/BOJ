def solution(s, n):
    answer = ''
    for i in s:
        print(i)
        if i.isupper():
            tmp = (ord(i) + n) % (ord('Z')+1)
            if tmp < ord('A'):
                tmp += ord('A')
            answer += chr(tmp)
        elif i.islower():
            tmp = (ord(i) + n) % (ord('z')+1)
            if tmp < ord('a'):
                tmp += ord('a')
            answer += chr(tmp)
        else:
            answer += i
    return answer