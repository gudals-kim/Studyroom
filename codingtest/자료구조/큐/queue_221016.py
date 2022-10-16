#큐 구현
#221016

import queue


class Queue:
    def __init__(self):
        self.list = list()
    
    def put(self, data):
        self.list.append(data)
    
    def get(self):
        print(self.list[0])
        result = self.list[0]
        del self.list[0]


#test code

queue = Queue() #큐생성

for i in range(10):
    queue.put(i) #put 테스트

print(queue.list)
queue.get()
queue.get()
queue.get()
print(queue.list)


    
