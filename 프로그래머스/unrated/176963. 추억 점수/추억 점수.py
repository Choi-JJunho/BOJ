def solution(name, yearning, photo):
    dic = {}
    answer = []
    for i, j in zip(name, yearning):
        dic[i] = j
    for k in photo:
        score = 0
        for l in k:
            if dic.get(l) is not None:
                score += dic.get(l)
            
        answer.append(score)
    
    return answer