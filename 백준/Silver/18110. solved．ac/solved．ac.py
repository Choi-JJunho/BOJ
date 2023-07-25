import sys
from collections import deque

input = sys.stdin.readline
a = int(input())
cut = int(a * 0.15 + 0.5)

b = [int(input()) for _ in range(a)]
b.sort()
dq = deque(b)

if dq:
    for _ in range(cut):
        dq.popleft()
        dq.pop()
    print(int(sum(dq) / len(dq) + 0.5))
else:
    print(0)
