
    
# n 사람수 words 단어들
def solution(n, words):
    단어빈도 = { word : 0 for word in words}
    person = 1
    turn = { person : 0 for person in range(1,n+1)}
    문제발생 = False
    단어빈도[words[0]] += 1
    turn[person] += 1
    for index in range(1,len(words)):
        person += 1
        if person > n:
            person = 1
        turn[person] += 1
        단어빈도[words[index]] +=1
        if 단어빈도[words[index]] > 1 or words[index-1][-1] != words[index][0]:
            문제발생 = True
            break
        print(words[index-1][-1])
        print(words[index][0])
    if 문제발생:
        return [person,turn[person]]
    return [0,0]