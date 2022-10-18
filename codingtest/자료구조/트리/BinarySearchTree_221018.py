from sqlite3 import enable_callback_tracebacks
from types import NoneType


class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self, value):
        self.head = TreeNode(value)

    def insert(self, value):
        self.node = self.head
        while True:
            if value < self.node.value:
                if self.node.left != None:
                    self.node = self.node.left
                elif self.node.left == None:
                    self.node.left = TreeNode(value)
                    print(str(value)+"추가 완료")
                    break
            elif value > self.node.value:
                if self.node.right != None:
                    self.node = self.node.right
                elif self.node.right == None:
                    self.node.right = TreeNode(value)
                    print(str(value)+"추가 완료")
                    break
    
    def search(self, value):
        self.node = self.head
        while self.node:
            if self.node.value == value:
                return True
            elif value < self.node.value:
                self.node = self.node.left
            elif value > self.node.value:
                self.node = self.node.right
        return False



    def delete(self, value):
        searched = False
        self.node = self.head
        self.parent = self.head
        while self.node:
            if self.node.value == value:
                searched = True
            elif value < self.node.value:
                self.parent = self.node
                self.node = self.node.left
            elif value > self.node.value:
                self.parent = self.node
                self.node = self.node.right
        if searched == False:
            return "삭제할 노드를 찾지 못했습니다."
        else:
            #1. 삭제할 노드가 단말 노드인경우 (오른쪽 왼쪽 둘다 None 인 경우)
            if self.node.left == None and self.node.right == None:
                if value < self.parent.value:
                    self.parent.left = None
                elif value > self.parent.value:
                    self.parent.right == None
                del self.node
            
            #2. 삭제할 노드가 자식노드를 한개 가지고 있을경우
            #왼쪽 자식노드가 있을경우
            if self.node.left != None and self.node.right == None:
                if value < self.parent.value:
                    self.parent.left = self.node.left
                elif value > self.parent.value:
                    self.parent.right = self.node.left
            #오른쪽 자식노드가 있을경우
            elif self.node.left == None and self.node.right != None:
                if value < self.parent.value:
                    self.parent.left = self.node.right
                elif value > self.parent.value:
                    self.parent.right = self.node.right

            #3. 삭제할 노드가 자식노드를 두개 가지고 있을경우
            #삭제할 노드가 부모노드의 왼쪽에 있을 경우
            # 삭제할 node의 오른쪽 자식노드 중 가장 작은 값을 삭제할 노드의 부모노드의 left로 지정한다.
            if self.parent.value > value:
                self.change_node = self.node.right
                self.change_node.parent = self.node.right

                while self.change_node.left != None:
                    self.change_node_parent = self.change_node
                    self.change_node = self.change_node.left
                
                if self.change_node.right != None: 
                    self.change_node_parent.left = self.change_node.right
                else:
                    self.change_node_parent.left = None

                self.parent.left = self.change_node
                self.change_node.right = self.node.right
                self.change_node.left = self.node.left
            #삭제할 노드가 부모 노드의 오른쪽에 있을경우
            # 삭제할 node의 오른쪽 자식중 가장 작은 값을 삭제할 노드의 부모노드의 right로 지정한다.
            else:
                self.change_node = self.node.right
                self.change_node.parent = self.node.right

                while self.change_node.left != None:
                    self.change_node_parent = self.change_node
                    self.change_node = self.change_node.left
                
                if self.change_node.right != None: 
                    self.change_node_parent.left = self.change_node.right
                else:
                    self.change_node_parent.left = None

                self.parent.right = self.change_node
                self.change_node.right = self.node.right
                self.change_node.left = self.node.left
                 
#testcode


# 0 ~ 999 숫자 중에서 임의로 100개를 추출해서, 이진 탐색 트리에 입력, 검색, 삭제
import random

# 0 ~ 999 중, 100 개의 숫자 랜덤 선택
bst_nums = set()
while len(bst_nums) != 100:
    bst_nums.add(random.randint(0, 999))
# print (bst_nums)

# 선택된 100개의 숫자를 이진 탐색 트리에 입력, 임의로 루트노드는 500을 넣기로 함
binary_tree = BinarySearchTree(500)
for num in bst_nums:
    binary_tree.insert(num)
    
# 입력한 100개의 숫자 검색 (검색 기능 확인)
for num in bst_nums:
    if binary_tree.search(num) == False:
        print ('search failed', num)

# # 입력한 100개의 숫자 중 10개의 숫자를 랜덤 선택
# delete_nums = set()
# bst_nums = list(bst_nums)
# while len(delete_nums) != 10:
#     delete_nums.add(bst_nums[random.randint(0, 99)])

# # 선택한 10개의 숫자를 삭제 (삭제 기능 확인)
# for del_num in delete_nums:
#     if binary_tree.delete(del_num) == False:
#         print('delete failed', del_num)
                
                    