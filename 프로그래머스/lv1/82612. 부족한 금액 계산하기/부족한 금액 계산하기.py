def solution(price, money, count):
    result = sum([i * price for i in range(1, count + 1)])

    if result > money:
        return result - money
    return 0