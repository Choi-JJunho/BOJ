import sys

N, M = map(int, sys.stdin.readline().split())

arr = [0]

# 누적합을 구한다
for idx, a in enumerate(map(int, sys.stdin.readline().split())):
    arr.append(a + arr[idx])

for i in range(0, M):
    start, end = map(int, sys.stdin.readline().split())

    print(arr[end] - arr[start - 1])
