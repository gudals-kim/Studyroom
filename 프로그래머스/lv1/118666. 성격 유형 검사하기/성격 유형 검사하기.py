def solution(survey, choices):
    answer = ["R","C","J","A"]
    성격유형구분={
        "R" : 0,
        "T" : 0,
        "C" : 0,
        "F" : 0,
        "J" : 0,
        "M" : 0,
        "A" : 0,
        "N" : 0
    }
    점수표왼쪽={
        1 : 3,
        2 : 2,
        3 : 1,
        4 : 0,
        5 : 0,
        6 : 0,
        7 : 0
    }
    점수표오른쪽={
        1 : 0,
        2 : 0,
        3 : 0,
        4 : 0,
        5 : 1,
        6 : 2,
        7 : 3
    }
    
    for idx in range(len(survey)):
        성격유형구분[survey[idx][0]]+=점수표왼쪽[choices[idx]]
        성격유형구분[survey[idx][1]]+=점수표오른쪽[choices[idx]]
    
    for idx in range(4):
        if idx==0 and 성격유형구분["R"]<성격유형구분["T"]:
            answer[idx]="T"
        if idx==1 and 성격유형구분["C"]<성격유형구분["F"]:
            answer[idx]="F"
        if idx==2 and 성격유형구분["J"]<성격유형구분["M"]:
            answer[idx]="M"
        if idx==3 and 성격유형구분["A"]<성격유형구분["N"]:
            answer[idx]="N"
        
    return "".join(i for i in answer)