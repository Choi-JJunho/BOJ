def solution(t, p):
    answer = 0
    tmp = int(p)
    for i in range(len(t) - len(p) + 1):
        a = t[i:i+len(p)]
        if int(a) <= tmp:
            answer += 1
    
    return answer