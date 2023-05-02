from collections import deque
def 시간더하기(time, plusTime=0):
    #time : xx:xx / plusTime xx 
    hh, mm = map(int,time.split(":"))
    return (hh*60 + mm) + int(plusTime)
    
def solution(plans):
    plans = deque(sorted(plans, key=lambda x: 시간더하기(x[1])))
    answer = []
    미뤄둔과제들 = []

    현재과목, 현재시간, 현재과목소요시간 = plans.popleft()
    while plans:
        다음과목, 다음시간, 다음과목소요시간 = plans.popleft()
        남은시간 = 시간더하기(다음시간) - 시간더하기(현재시간,현재과목소요시간)

        if 남은시간<0: #과제를 끝내지 못한경우

            미뤄둔과제들.append([현재과목,abs(남은시간)])
        if 남은시간>=0: #과제를 끝내고 미뤄둔 과제를 할 수 있는 시간이 남은 경우
            answer.append(현재과목)

            #미뤄둔과제 로직
            while 남은시간>0 and 미뤄둔과제들:
                미뤄둔과목, 미뤄둔과제소요시간 = 미뤄둔과제들.pop()
                남은시간 = 남은시간 - 미뤄둔과제소요시간
                if 남은시간<0:
                    미뤄둔과제들.append([미뤄둔과목, abs(남은시간)])
                if 남은시간>=0:
                    answer.append(미뤄둔과목)
        
        
        현재과목, 현재시간, 현재과목소요시간 = 다음과목, 다음시간, 다음과목소요시간
        
        if not plans:
            answer.append(현재과목)
    while 미뤄둔과제들:
        answer.append(미뤄둔과제들.pop()[0])
    return answer