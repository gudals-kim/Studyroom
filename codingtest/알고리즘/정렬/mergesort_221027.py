def merge(left,right):
    sorted = list()
    left_point, right_point = 0, 0

    # case1 - left/right 둘다 있을때
    while len(left) > left_point and len(right) > right_point:
        # left[0] 보다 rignt[0]이 클때
        if left[left_point] > right[right_point]:
            sorted.append(right[right_point])
            right_point += 1
        # left[0] 보다 rignt[0]이 클때
        else:
            sorted.append(left[left_point])
            left_point += 1
    
    # case2 - right 데이터가 없을때
    while len(left) > left_point:
        sorted.append(left[left_point])
        left_point += 1
    
    # case3 - left 데이터가 없을때
    while len(right) > right_point:
        sorted.append(right[right_point])
        right_point += 1

    return sorted

def mergesplit(data):
    if len(data) <= 1:
        return data
    pivot = int(len(data)/2)
    left = mergesplit(data[:pivot])
    right = mergesplit(data[pivot:])
    return merge(left,right)

import random

data_list = random.sample(range(100), 10)
print(mergesplit(data_list))