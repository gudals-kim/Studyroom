#스택 구현 
#221016


class Stack:
    def __init__(self):
        self.list = list()
    
    def push(self, data):
        self.list.append(data)
    
    def pop(self):
        print(self.list[0])
        result = self.list[0]
        del self.list[0]


#test code

stack = Stack()
for i in range(10):
    stack.push(i)

print(stack.list)
stack.pop()
stack.pop()
stack.pop()
print(stack.list)


