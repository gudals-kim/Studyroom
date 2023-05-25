def solution(babbling):
    answer = 0
    for word in babbling:
        for test in ["aya","ye","woo","ma"]:
            word = word.replace(test,"0")
            if word=="0" or word=="00" or word=="000" or word=="0000":
                answer+=1
                break
    return answer