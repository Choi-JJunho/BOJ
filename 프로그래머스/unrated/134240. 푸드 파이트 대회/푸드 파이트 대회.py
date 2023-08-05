from collections import deque


def solution(food):
    answer = []

    for i in range(1, len(food)):
        for j in range(food[i] // 2):
            answer.append(i)
    back = reversed(answer)
    answer.append(0)
    answer += back
    return ''.join(map(str,answer))
