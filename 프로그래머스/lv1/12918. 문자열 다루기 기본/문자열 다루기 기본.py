def solution(s):
    for i in s:
        if len(s) != 4 and len(s) != 6:
            return False
        if i.isalpha():
            return False
    return True