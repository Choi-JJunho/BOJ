def solution(k, m, score):
    score.sort(reverse=True)
    answer = 0
    i = 0
    while i < len(score) and len(score[i:i+m]) >=  m:
        answer += min(score[i:i+m]) * m
        i += m
    
    return answer