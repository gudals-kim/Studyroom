def 약수구하기(약수를구하려는수):

    약수리스트 = []
    #N = A * B 로 나타낼 수 있다는 것을 이용한 풀이이다. 항상 약수를 구하면 그 짝이 되는 수가 존재한다.
    # for 문을 이용해 자연수 N의 제곱근까지의 약수를 구하면 그 짝이 되는 약수는 자동으로 구할 수 있다.
    for 예비약수 in range(1, int(약수를구하려는수**(1/2)) + 1):
        if (약수를구하려는수 % 예비약수 == 0):
            약수리스트.append(예비약수) 
            if ( (예비약수**2) != 약수를구하려는수) : 
                #N = A*B 일 때, A==B 일 수 있기 때문에 값을 중복해서 넣어주지 않기 위해 
                #if 문으로 제곱했을 때 n이 되지 않는지 검사를 해줬다
                약수리스트.append(약수를구하려는수 // 예비약수)
    
    return len(약수리스트)

def solution(number, limit, power):
    answer = 0
    
    for idx in range(1,number+1):
        무기공격력 = 약수구하기(idx)
        if 무기공격력 > limit:
            answer+=power
            continue
        answer+=무기공격력
    
    return answer