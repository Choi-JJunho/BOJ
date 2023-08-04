def solution(a, b, n):
    answer = 0
    bottle = n
    while bottle >= a:
        tmp = bottle % a
        answer += (bottle // a) * b
        bottle = (bottle // a) * b + tmp
        
    return answer