def solution(n, m, section):
    answer = 0
    sec = [i-1 for i in section]
    paint = sec[0] - 1

    for i in sec:
        if paint < i:
            paint = i + m - 1
            answer += 1
    return answer