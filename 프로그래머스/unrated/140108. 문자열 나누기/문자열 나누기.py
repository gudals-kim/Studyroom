def solution(s):
    answer=[]
    a = ""
    index = 0
    n = 1
    dn = 0
    for idx in range(index+1,len(s)):
        if s[idx]==s[index]:
            n+=1
        else:
            dn+=1
        if n==dn:
            answer.append(s[index:idx+1])
            a+=s[index:idx+1]
            index = idx+1
    if len(a)!=len(s):
        return len(answer)+1
    return len(answer)