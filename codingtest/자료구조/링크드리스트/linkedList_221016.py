#더블링크드리스트 구현
#221016



class Node:
    def __init__(self, value, prev=None, next=None):
        self.prev = prev
        self.value = value
        self.next = next


class Linkedlist:
    def __init__(self, value):
        self.head = Node(value)
        self.tail = self.head

    def addNode(self, value):

        if self.head == '':
            self.head = Node(value)
            self.tail = self.head
        else:
            node = self.head #헤드노드 지정

            while node.next: #node.next가 None이면 멈춘다. 
                node = node.next #다음노드 계속 탐색
            node.next = Node(value,node) #마지막 노드 추가
        

    def desc(self):
        node = self.head
        while node:
            print(node.value)
            node = node.next
    
    
    def searchNode(self,value):
        node = self.head
        while node.value != value:
            if node.next == None:
                return False
            node = node.next
        return node

    def delNode(self, value):
        node = self.head
        while node.value != value:
            if node.next == None:
                return False
            node = node.next
        delnode = node
        prevnode = node.prev#앞노드
        nextnode = node.next#뒷노드
        #삭제할 노드의 앞 노드의 다음 주소를 삭제할 노드의 다음 노드로
        node.prev.next = nextnode


        #삭제할 노드의 다음 노드의 prev 주소를 삭제할 노드의 앞 노드로
        node.next.prev = prevnode

        del delnode #삭제노드 삭제
        return 




#test code

linkedlist = Linkedlist(0) #헤드 노드가 0인 링크드리스트 생성
for value in range(1,10):
    linkedlist.addNode(value)

linkedlist.desc()
linkedlist.delNode(5)
print("----")
linkedlist.desc()

