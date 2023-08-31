def solution(N, stages):
    dic = {}
    cnt = 0
    for i in range(1, N+1):
        if cnt != len(stages):
            dic[i] = (stages.count(i)) / (len(stages) - cnt)
            cnt += stages.count(i)
        else:
            dic[i] = 0
    
    res = sorted(dic.items(), key=lambda x: x[1], reverse=True)
    print(res)
    return [i[0] for i in res]