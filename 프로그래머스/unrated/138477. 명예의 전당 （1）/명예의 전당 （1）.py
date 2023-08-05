from collections import deque
def solution(k, score):
    tmp = []
    answer = []
    for i in score:
        tmp.append(i)
        if len(tmp) > k:
            tmp.remove(min(tmp))
        answer.append(min(tmp))
        
    return answer