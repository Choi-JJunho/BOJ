def solution(phone_number):
    return ''.join(["*" for val in phone_number[:-4]]) + str(phone_number[-4:])