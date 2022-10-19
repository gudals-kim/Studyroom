# 부모노드 인덱스 번호 -> 자식노드인덱스번호/2 의 몫
# 왼쪽 자식노드 인덱스 번호 -> 부모노드 인덱스번호 * 2
# 오른쪽 자식 노드 인덱스 번호 -> 부모노드 인덱스번호 * 2 + 1



class Heap:
    def __init__(self, value):
        self.heap_array = list()
        self.heap_array.append(None)
        self.heap_array.append(value)


    def move_up(self, insert_idx):
        # 추가한 인덱스가 첫 노드거나, None 이면 순회하지 않도록 false 리턴
        if insert_idx <= 1:
            return False
        #부모노드 인덱스 지정
        parent_idx = insert_idx // 2
        #추가한 노드의 값이 부모노드의 값보다 크다면 True 반환
        if self.heap_array[insert_idx] > self.heap_array[parent_idx]:
            return True
        #추가한 노드의 값이 부모노드의 값보다 작다면 순회하지 않도록 False 반환
        else:
            return False
    

    def insert(self, value):
        if len(self.heap_array) == 0:
            self.heap_array.append(None)
            self.heap_array.append(value)
        
        self.heap_array.append(value)
        #추가한 노드의 인덱스 번호
        insert_idx = len(self.heap_array) - 1
        #추가한 노드의 값이 부모노드의 값보다 클때만 순회
        while self.move_up(insert_idx):
            parent_idx = insert_idx//2
            #부모와 추가 노드의 위치를 바꾼다.
            self.heap_array[insert_idx], self.heap_array[parent_idx] = self.heap_array[parent_idx], self.heap_array[insert_idx]
            #추가한 노드의 인덱스 번호를 바꿔준다.
            insert_idx = parent_idx

        return True
    



    def move_down(self, pop_idx):
        left_child_pop_idx = pop_idx * 2
        right_child_pop_idx = pop_idx * 2 + 1

        #case1 : 왼쪽 자식 노드가 없을때 *자식노드가 없을때 (왼쪽 자식노드가 없으면 오른쪽 자식노드도 없다.)
        if left_child_pop_idx >= len(self.heap_array):
            return False
        #case2 : 오른쪽 자식 노드만 없을때 (왼쪽자식노드는 있을수도 있고 없을 수도 있지만 만약 없다면 위 if문에서 걸린다.)
        elif right_child_pop_idx >= len(self.heap_array):
            #대체 노드가 대체 노드의 왼쪽 노드보다 작을때
            if self.heap_array[pop_idx] < self.heap_array[left_child_pop_idx]:
                # True
                return True
            else: return False
        #case3 : 왼쪽, 오른쪽 자식 노드 모두 있을때
        else:
            #왼쪽 자식노드가 더 클때
            if self.heap_array[left_child_pop_idx] > self.heap_array[right_child_pop_idx]:
                #왼쪽 자식노드가 오른쪽 자식 노드보다 더 크면서 대체 노드보다도 클때
                if self.heap_array[pop_idx] < self.heap_array[left_child_pop_idx]:
                    return True
                else: return False
            #오른쪽 자식노드가 더 클때
            else:
                #오른쪽 자식노드가 왼쪽 자식 노드보다 더 크면서 대체 노드보다도 클때 
                if self.heap_array[pop_idx] < self.heap_array[right_child_pop_idx]:
                    return True
                else: return False



    def pop(self):
        #0 데이터가 없을경우 None 리턴
        if len(self.heap_array) <= 1:
            return None
        #1. 가장 상위 노드를 빼줘야하니 returned_data에 저장
        returned_data = self.heap_array[1]
        #2. 가장 차상위 노드엔 가장 마지막 노드를 추가해준다.
        self.heap_array[1] = self.heap_array[-1]
        #3. 마지막 노드를 삭제한다.
        del self.heap_array[-1]
        #4. 마지막노드위치(대체노드) 인덱스를 지정한다.
        pop_idx = 1
        #5 move_down 함수를 이용하여 교체를 해야할 조건에만 while을 수행한다.
        while self.move_down(pop_idx):
            #5.1 대체 노드의 왼쪽 자식 노드 인덱스 지정
            left_child_pop_idx = pop_idx*2
            #5.2 대체 노드의 오른쪽 자식 노드 인덱스 지정
            right_child_pop_idx = pop_idx*2+1
            #5.3 교체 수행
            # case 1 왼쪽 노드만 있을때
            if right_child_pop_idx >= len(self.heap_array):
                #왼쪽 노드가 대체노드보다 클경우
                if self.heap_array[pop_idx] < self.heap_array[left_child_pop_idx]:
                    #교체 실행
                    self.heap_array[pop_idx], self.heap_array[left_child_pop_idx] = self.heap_array[left_child_pop_idx],self.heap_array[pop_idx]
                    #교체된 인덱스로 교체해준다.
                    pop_idx = left_child_pop_idx
            # case 2 양쪽 노드 모두 있을때
            else:
                #왼쪽 노드가 오른쪽 노드보다 클 경우
                if self.heap_array[left_child_pop_idx] > self.heap_array[right_child_pop_idx]:
                    #왼쪽노드가 오른쪽 노드 및 대체노드보다 클경우
                    if self.heap_array[pop_idx] < self.heap_array[left_child_pop_idx]:
                        #교체실행
                        self.heap_array[pop_idx],self.heap_array[left_child_pop_idx] = self.heap_array[left_child_pop_idx],self.heap_array[pop_idx]
                        # 인덱스 교체
                        pop_idx = left_child_pop_idx
                #오른쪽 노드가 더 클경우
                else:
                    #오른쪽 노드가 왼쪽 노드 및 대체 노드보다 클경우
                    if self.heap_array[pop_idx] < self.heap_array[right_child_pop_idx]:
                        #교체실행
                        self.heap_array[pop_idx],self.heap_array[right_child_pop_idx] = self.heap_array[right_child_pop_idx],self.heap_array[pop_idx]
                        # 인덱스 교체
                        pop_idx = right_child_pop_idx

        return returned_data

#test code
heap = Heap(50)
heap.insert(40)
heap.insert(44)
heap.insert(46)
heap.insert(20)
heap.insert(10)
heap.insert(4)
heap.insert(67)
heap.insert(1)
heap.insert(62)
heap.insert(26)
print("67")
print(heap.pop())
print("62")
print(heap.pop())
print("50")
print(heap.pop())
print("46")
print(heap.pop())
print("44")
print(heap.pop())
print(heap.heap_array)
