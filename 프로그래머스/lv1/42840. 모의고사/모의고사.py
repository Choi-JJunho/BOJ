def solution(answers):
    a = [1, 2, 3, 4, 5]
    b = [2, 1, 2, 3, 2, 4, 2, 5]
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    dic = {1:0,2:0,3:0}
    
    for i in range(len(answers)):
        if a[i % len(a)] == answers[i]:
            dic[1] += 1
        if b[i % len(b)] == answers[i]:
            dic[2] += 1
        if c[i % len(c)] == answers[i]:
            dic[3] += 1
    
    m = max(dic.values())
    answer = []
    
    for k, v in dic.items():
        if v == m:
            answer.append(k)
    
    return answer