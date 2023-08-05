def solution(name, yearning, photo):
    dic = dict(zip(name, yearning))
    answer = []
    
    for k in photo:
        score = 0
        for l in k:
            if dic.get(l) is not None:
                score += dic.get(l)
            
        answer.append(score)
    
    return answer