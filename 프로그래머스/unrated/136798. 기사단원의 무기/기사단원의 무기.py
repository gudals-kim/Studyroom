def 약수구하기(n):

    divisorsList = []

    for i in range(1, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisorsList.append(i) 
            if ( (i**2) != n) : 
                divisorsList.append(n // i)
    
    return len(divisorsList)

def solution(number, limit, power):
    answer = [0] * number
    powers = [0] * number
    
    for idx in range(1,number+1):
        powers[idx-1]=약수구하기(idx)
    
    for idx in range(len(powers)):
        if powers[idx]>limit:
            answer[idx]=power
            continue
        answer[idx] = powers[idx]
    return sum(answer)