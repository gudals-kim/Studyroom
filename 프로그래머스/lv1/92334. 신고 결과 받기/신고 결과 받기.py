from collections import defaultdict 

def solution(id_list, report, k):
    id_list_to_idx = { id_list[idx] : idx for idx in range(len(id_list))}
    answer = [0] * len(id_list)
    신고리스트 = {ids : {idx:0 for idx in id_list} for ids in id_list}
    이사람을신고한사람들 = defaultdict(set)
    for repo in report:
        신고자, 피신고자 = repo.split()
        이사람을신고한사람들[피신고자].add(신고자)
        신고리스트[피신고자][신고자]+=1
    for 피신고자 in id_list:
        if len(이사람을신고한사람들[피신고자]) >= k:
            for 신고자 in 이사람을신고한사람들[피신고자]:
                answer[id_list_to_idx[신고자]]+=1

    return answer