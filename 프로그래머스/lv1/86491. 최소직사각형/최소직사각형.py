def solution(sizes):
    answer = 1
    w = 0
    h = 0
    for i in sizes:
        i.sort()
        w = max(w, i[0])
        h = max(h, i[1])
        
    return w*h