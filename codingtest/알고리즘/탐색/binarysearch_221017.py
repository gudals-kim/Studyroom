from math import trunc


def binary_search(data, search):
    print(data)
    if len(data) == 1 and search == data[0]:
        return True
    if len(data) == 1 and search != data[0]:
        return False
    if len(data) == 0:
        return False

    pivot = len(data)//2
    if search == data[pivot]:
        return True
    else:
        if search < data[pivot]:
            return binary_search(data[:pivot],search)
        else:
            return binary_search(data[pivot+1:],search)



#test code
import random
data_list = random.sample(range(100), 10)
data_list.sort()

print(binary_search(data_list,55))