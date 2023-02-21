def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        스킬인덱스 = { sk : float('inf') for sk in skill}
        for sk in skill:
            for index in range(len(skill_tree)):
                if sk==skill_tree[index]:
                    스킬인덱스[sk] = index
        스킬출현인덱스=list(스킬인덱스.values())
        step = 스킬출현인덱스[0]
        for idx in range(1,len(스킬출현인덱스)):
            if 스킬출현인덱스[idx] < step:
                answer+=1
                break
            step = 스킬출현인덱스[idx] 
    return len(skill_trees)-answer