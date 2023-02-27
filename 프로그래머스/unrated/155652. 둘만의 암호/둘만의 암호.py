def z넘으면안돼(단어):
    if 단어>122:
        단어=97+단어-122-1
    return 단어

def solution(s, skip, index):
    s = [ord(i) for i in s]
    skip = [ord(i) for i in skip]
    keepSkip = {i:False for i in range(97,123)}
    for i in skip:
        keepSkip[i]=True
    answer = ""
    for 단어 in s:
        count = 0
        while count<index:
            count += 1
            단어=단어+1
            단어=z넘으면안돼(단어)
            while keepSkip[단어]:
                단어+=1
                단어 = z넘으면안돼(단어)
        answer+=chr(단어)
        
    return answer