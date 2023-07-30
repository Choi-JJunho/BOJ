def solution(n, m):
    answer = []
    a = max(n, m)
    b = min(n, m)
    
    while(b):
        c = b
        b = a % b
        a = c
    
    return [a, n*m // a]