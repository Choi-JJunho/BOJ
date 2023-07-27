def solution(n):
    answer = "수박"* ((n+1) // 2)
    
    if n % 2 != 0:
        return answer[:-1]
    
    return answer