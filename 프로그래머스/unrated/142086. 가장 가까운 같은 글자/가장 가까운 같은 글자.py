def solution(s):
    tmp = {}
    answer = []
    
    for idx, ch in enumerate(s):
        if tmp.get(ch) is None:
            tmp[ch] = idx
            answer.append(-1)
        else:
            answer.append(idx - tmp[ch])
            tmp[ch] = idx
    
    return answer