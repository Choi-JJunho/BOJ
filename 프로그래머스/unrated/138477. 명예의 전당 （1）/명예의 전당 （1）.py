from collections import deque
def solution(k, score):
    answer = []
    tmp = deque()
    for i in score:
        tmp.append(i)
        tmp = sorted(tmp,reverse=True)
        if len(tmp) > k:
            tmp.pop()
        answer.append(tmp[len(tmp)-1])
        
    return answer