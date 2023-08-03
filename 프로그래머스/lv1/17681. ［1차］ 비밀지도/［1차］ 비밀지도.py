def solution(n, arr1, arr2):
    result = []
    for x, y in zip(arr1, arr2):
        a = list(bin(x)[2:])
        tmp = ['0'] * (n - len(a))
        a = tmp + a

        b = list(bin(y)[2:])
        tmp = ['0'] * (n - len(b))
        b = tmp + b

        result.append([int(k) + int(j) for j, k in zip(a, b)])

    answer = []
    for l in result:
        t = ''
        for e in l:
            if e >= 1:
                t += '#'
            else:
                t += ' '
        answer.append(t)

    return answer