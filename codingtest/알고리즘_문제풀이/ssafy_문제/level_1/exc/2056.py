def 메인함수(testcase):
    #yyyy/mm/dd 로나눠야함
    날짜들 = list()
    dd=testcase%100
    testcase=testcase//100
    mm=testcase%100
    yyyy=testcase//100

    날짜들.append(yyyy)
    날짜들.append(mm)
    날짜들.append(dd) 
    return 날짜들

def 년전처리(숫자):
    if 99 < 숫자 < 1000:
        숫자 = "0%d"%숫자
    elif 9 < 숫자 < 100:
        숫자 = "00%d"%숫자
    elif 0 < 숫자 < 10:
        숫자 = "000%d"%숫자
    else:
        숫자 = "%d"%숫자
    return 숫자
def 월일전처리(숫자):
    if 0 < 숫자 < 10:
        숫자 = "0%d"%숫자
    else:
        숫자 = "%d"%숫자
    return 숫자

def 검증(날짜들):
    삼십일일월 = [1,3,5,7,8,10,12]
    삼십일월 = [4,6,9,11]
    이월 = [2]
    if 날짜들[1] in 삼십일일월 and 0<날짜들[2]<32:
        return True
    elif 날짜들[1] in 삼십일월 and 0<날짜들[2]<31:
        return True
    elif 날짜들[1] in 이월 and 0<날짜들[2]<29:
        return True
    else : return False


def 입력():
    n = int(input())
    i = 0
    testcaseList = list()
    while i<n:
        testcaseList.append(int(input()))
        i+=1
    return testcaseList

def 출력(testcaseList):
    n = 1
    for 날짜들 in testcaseList:
        연월일 = 메인함수(날짜들)
        if 검증(연월일):
            print("#%d %s/%s/%s"%(n,년전처리(연월일[0]),월일전처리(연월일[1]),월일전처리(연월일[2])))
        else:
            print("#%d -1"%n)
        n+=1

출력(입력())