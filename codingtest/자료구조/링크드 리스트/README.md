# 링크드리스트(Linked List)

### 1. 링크드 리스트 구조
* 연결 리스트라고도 부른다.
* 순차적으로 연결된 공간에 데이터를 나열하는 배열과 다르게 링크드리스트는 떨어진 공간(물리적주소)에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조

#### 1.1 기본 구조와 용어
* 노드(Node) : 데이터 저장 단위(데이터 값, 포인터)로 구성된다.
* 포인터(pointer) : 각 노드 안에서, 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간

<br>

* 일반적인 링크드 리스트의 형태
<img src="https://www.fun-coding.org/00_Images/linkedlist.png" />
(출처 : wikipedia, https://en.wikipedia.org/wiki/Linked_list)

### 2. 간단한 링크드 리스트 예

#### 2.1 노드 구현
* 보통 파이썬에서 링크드 리스트 구현시, 파이썬 클래스를 활용함
    - 파이썬 객체지향 문법의 이해가 필요하다.
    - 참고 : https://www.fun-coding.org/PL&OOP1-3.html

```
#입력
class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next
```

#### 2.2 노드와 노드 연결하기
```
#입력
node1 = Node(1)
node2 = Node(2)
node1.next = node2
head = node1
```

#### 2.3 링크드 리스트로 데이터 추가하기
```
#입력
class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next

def add(data):
    node = head
    while node.next:
        node = node.next
    node.next = Node(data)

node1 = Node(1)
head = node1
for index in range(2,11):
    add(index)

node = head
while node.next:
    print(node.data)
    node = node.next
print(node.data)
```
```
#출력
출력 > 1
출력 > 2
출력 > 3
출력 > 4
출력 > 5
출력 > 6
출력 > 7
출력 > 8
출력 > 9
출력 > 10
```

<br>

### 3.링크드 리스트의 장단점 
* 장점 
    - 미리 데이터 공간을 할당하지 않아도 된다.
        * 배열은 미리 할당해야함으로 데이터 공간의 낭비가 생길 수 있다.

* 단점
    - 연결을 위한 별도 데이터 공간이 필요하므로, 저장공간 효율이 높지 않다.
    - 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느리다.
    - 중간 데이터 삭제시, 앞 뒤 데이터의 연결을 재구성해야 하는 부가적인 작업이 필요하다.

<br>

### 4. 링크드 리스트의 복잡한 기능
* 링크드 리스트는 유지 관리에 부가적인 구현이 필요하다.
<img src="https://www.fun-coding.org/00_Images/linkedlistadd.png" />
(출처: wikipedia, https://en.wikipedia.org/wiki/Linked_list)

#### 4.1 링크드리스트 중간에 데이터 삽입하기
* #1~9까지 연결된 링크드리스트에 1.5를 1 다음에 넣어보자.

```
#입력

node = head
while node.next:
    print(node.data)
    node = node.next
print(node.data)
```
```
#출력
출력 > 1
출력 > 2
출력 > 3
출력 > 4
출력 > 5
출력 > 6
출력 > 7
출력 > 8
출력 > 9
```
```
#입력

node3 = Node(1.5) # 중간에 넣을 데이터

#1~9까지 연결된 링크드리스트에 1.5를 1 다음에 넣는 코드

node = head 
search = True
while serch: 
    if node.data == 1: #데이터가 1인 노드를 찾으면
        serch = False # serch 변수를 Fasle로 바꿔 loop를 멈춘다.
    else: #데이터가 1인 노드가 아닐때,
        node = node.next  # 다음 노드로 이동

node_next = node.next #node_next 에 1 다음 주소 (2의 주소)를 넣는다.
node.next = node3 # 1 다음 주소에 1.5를 넣는다.
node3.next = node_next # 1.5다음 주소에 2의 주소를 넣는다.

node = head
while node.next: #루프를 돌려서 출력해본다.
    print(node.data)
    node = node.next
print(node.data)
```
```
#출력
출력 > 1
출력 > 1.5
출력 > 2
출력 > 3
출력 > 4
출력 > 5
출력 > 6
출력 > 7
출력 > 8
출력 > 9
```

<br>

### 5. 파이썬 객체를 이용하여 링크드리스트 구현하기

```
#입력
class Node: # node 객체
    def __inti__(self, data, next=None):
        self.data = data
        self.next = next

class NodeMgmt: # node 추가, 삽입, 출력 객체
    def __init__(self, data):
        self.head = Node(data) #NodeMgmt(2) 를 하면 Node(2) 가 생성되고, head node가 된다.
    
    def add(self, data): #노드 삽입 매서드
        if self.head == '': #헤드 노드가 없을때
            self.head = Node(data)
        else:
            node = self.head #헤드노드 지정
            while node.next: #마지막 노드까지
                node = node.next 
            node.next = Node(data) #마지막 노드의 다음 주소엔 추가하는 node 주소를 추가한다.
    
    def desc(self):
        node = self.head #헤드노드 지정
        while node: #마지막 노드까지 loop
            print(node.data) #출력
            node = node.next #마지막 노드 다음 주소가 되면 탈출

linkedlist1 = NodeMgmt(0) #헤드 노드가 0인 노드 생성
linkedlist1.add(4) # 0노드 다음에 4노드 추가
linkedlist1.add(2) # 4 노드 다음에 0 노드 추가

linkedlist1.desc() #현재 링크드리스트 모두 출력

```
```
#출력
출력 > 0
출력 > 4
출력 > 2
```

<br>

### 6.구현한 링크드 리스트에 기능추가하기

#### 6.1 특정 노드 삭제 기능 넣기

* 기존 코드에 delete 메서드를 추가하자
```
#입력


class Node: # node 객체
    def __inti__(self, data, next=None):
        self.data = data
        self.next = next

class NodeMgmt: # node 추가, 삽입, 출력 객체
    def __init__(self, data):
        self.head = Node(data) #NodeMgmt(2) 를 하면 Node(2) 가 생성되고, head node가 된다.
    
    def add(self, data): #노드 삽입 매서드
        if self.head == '': #헤드 노드가 없을때
            self.head = Node(data)
        else:
            node = self.head #헤드노드 지정
            while node.next: #마지막 노드까지
                node = node.next 
            node.next = Node(data) #마지막 노드의 다음 주소엔 추가하는 node 주소를 추가한다.
    
    def desc(self):
        node = self.head #헤드노드 지정
        while node: #마지막 노드까지 loop
            print(node.data) #출력
            node = node.next #마지막 노드 다음 주소가 되면 탈출

# delete 메서드 추가 부분

    def delete(self, data):
        if self.head == '': #head 노드가 없을때
            print("해당 값을 가진 노드가 없습니다.")
            return
        
        if self.head.data == data: #헤드노드 데이터와 삭제노드 데이터가 같을때
            temp = self.head #temp공간에 헤드노드 저장
            self.head = self.head.next #헤드노드에 헤드노드 다음 노드 지정
            del temp #헤드노드 삭제
        else: #삭제 노드가 헤드노드가 아닐때
            node = self.head #헤드노드 지정
            while node.next: #노드 루프돌리기
                if node.next.data == data: #삭제노드 찾았을때
                    temp = node.next #삭제노드를 temp 공간에 할당
                    node.next = node.next.next #삭제노드 자리에 삭제노드 다음 노드를 할당
                    del temp #삭제할 노드 삭제
                    return
                else: # 삭제노드를 못찾았을때
                    node = node.next  #다음 노드로 이동

```
* 테스트 코드
```
#입력 
linkedlist1 = NodeMgmt(0) #헤드노드가 0인 링크드리스트 생성
linkedlist1.desc() # 링크드 생성 후 확인 desc 코드

for data in range(1,10): 
    linkedlist1.add(data) #링크드리스트에 1부터 9까지 추가
linkedlist1.desc() # 데이터 추가후 링크드 리스트 확인 desc 코드
```
```
#출력

출력 > 0 # 링크드 리스트 생성 후 확인 desc 코드
출력 > 0 # 1부터 9까지 추가했지만 기존 데이터 0뒤에 추가가 된다.
출력 > 1
출력 > 2
출력 > 3
출력 > 4
출력 > 5
출력 > 6
출력 > 7
출력 > 8
출력 > 9
```
* delete 메서드 시험해보자.
```
#입력

linkedlist.delete(4) #data가 4인 노드 삭제
linkedlist.delete(2) #data가 2인 노드 삭제
linkedlist.desc() #링크드 리스트 출력
```
```
#출력

출력 > 0
출력 > 1
출력 > 3
출력 > 5
출력 > 6
출력 > 7
출력 > 8
출력 > 9
```
<br>

#### 6.2 링크드리스트에 검색 기능 넣기
* 기존 코드에 serch_node() 메서드를 추가하자
```
#입력


class Node: # node 객체
    def __inti__(self, data, next=None):
        self.data = data
        self.next = next

class NodeMgmt: # node 추가, 삽입, 출력 객체
    def __init__(self, data):
        self.head = Node(data) #NodeMgmt(2) 를 하면 Node(2) 가 생성되고, head node가 된다.
    
    def add(self, data): #노드 삽입 매서드
        if self.head == '': #헤드 노드가 없을때
            self.head = Node(data)
        else:
            node = self.head #헤드노드 지정
            while node.next: #마지막 노드까지
                node = node.next 
            node.next = Node(data) #마지막 노드의 다음 주소엔 추가하는 node 주소를 추가한다.
    
    def desc(self):
        node = self.head #헤드노드 지정
        while node: #마지막 노드까지 loop
            print(node.data) #출력
            node = node.next #마지막 노드 다음 주소가 되면 탈출

# delete 메서드 추가 부분

    def delete(self, data):
        if self.head == '': #head 노드가 없을때
            print("해당 값을 가진 노드가 없습니다.")
            return
        
        if self.head.data == data: #헤드노드 데이터와 삭제노드 데이터가 같을때
            temp = self.head #temp공간에 헤드노드 저장
            self.head = self.head.next #헤드노드에 헤드노드 다음 노드 지정
            del temp #헤드노드 삭제
        else: #삭제 노드가 헤드노드가 아닐때
            node = self.head #헤드노드 지정
            while node.next: #노드 루프돌리기
                if node.next.data == data: #삭제노드 찾았을때
                    temp = node.next #삭제노드를 temp 공간에 할당
                    node.next = node.next.next #삭제노드 자리에 삭제노드 다음 노드를 할당
                    del temp #삭제할 노드 삭제
                    return
                else: # 삭제노드를 못찾았을때
                    node = node.next  #다음 노드로 이동

# search_node 추가부분
                    
    def search_node(self, data):
        node = self.head #헤드노드 할당
        while node: #링크드리스트 순환
            if node.data == data: #노드의 데이터가 찾는 데이터와 같을때
                return node # 그 노드 리턴
            else:
                node = node.next # 다음 노드로
```


* 테스트 코드
```
#입력

node_mgmt = NodeMgmt(0) # 헤드노드가 0인 링크드리스트 생성
for data in range(1, 10):
    node_mgmt.add(data) #링크드리스트에 1~9까지 데이터 추가

node = node_mgmt.search_node(4)
print(node.data) 
```
```
#출력

출력 > 4
```

<br>

### 7. 다양한 링크드 리스트 구조

* 더블 링크드 리스트 기본 구조
    - 이중 연결 리스트라고도 함
    - 장점 : 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 가능하다.

      <br>
<img src="https://www.fun-coding.org/00_Images/doublelinkedlist.png" />
(출처: wikipedia, https://en.wikipedia.org/wiki/Linked_list)

<br>

#### 7.1 더블링크드 리스트 파이썬 구현
```
#입력

class Node:
    def __init__(self, data, prev=None, next=None):
        self.prev = prev
        self.data = data
        self.next = next

class NodeMgmt:
    def __init__(self, data):
        self.head = Node(data)
        self.tail = self.head

    def insert(self, data):
        if self.head == None:
            self.head = Node(data)
            self.tail = self.head
        else:
            node = self.head
            while node.next:
                node = node.next
            new = Node(data)
            node.next = new
            new.prev = node
            self.tail = new

    def desc(self):
        node = self.head
        while node:
            print (node.data)
            node = node.next

```
* 테스트 코드
```
#입력

double_linked_list = NodeMgmt(0)
for data in range(1, 10):
    double_linked_list.insert(data)
double_linked_list.desc()
```
```
#출력

출력 > 0
출력 > 1
출력 > 2
출력 > 3
출력 > 4
출력 > 5
출력 > 6
출력 > 7
출력 > 8
출력 > 9
```