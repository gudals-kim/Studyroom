def solution(book_time):
    answer = 0
    예약리스트 = sorted([(tuple(map(int,startTime.split(":"))),tuple(map(int,endTime.split(":")))) for startTime, endTime in book_time])
    
    호텔방={ 방번호:False for 방번호 in range(len(예약리스트))}
    들어간방 = {예약번호:False for 예약번호 in range(len(예약리스트))}
    나가신손님 = {예약번호:False for 예약번호 in range(len(예약리스트))}
    for 예약번호 in range(len(예약리스트)):
        예약손님대실시작, 예약손님대실끝 = 예약리스트[예약번호]
        현재시간 = 예약손님대실시작[0]*60+예약손님대실시작[1]
        
        for 사용중손님 in range(예약번호):
            사용중손님대실시작, 사용중손님대실끝 = 예약리스트[사용중손님]
            if 나가신손님[사용중손님]:
                    continue
            if (사용중손님대실끝[0]*60+사용중손님대실끝[1]+10) <= 현재시간:
                호텔방[들어간방[사용중손님]] = False
                나가신손님[사용중손님] = True
        
        for 방번호 in 호텔방.keys():
            if not 호텔방[방번호]:
                호텔방[방번호] = True
                들어간방[예약번호] = 방번호
                answer = max(방번호+1,answer)
                break
    return answer