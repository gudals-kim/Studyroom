class Chaininghash:
    def __init__(self, tableset): #hash_table 이 value개의 ChainingHash 생성
        self.tableset = tableset
        self.hash_table = list([0 for i in range(tableset)])


    #키 정의
    def get_key(self,key):
        return hash(key) #hash 내장함수를 사용하여 key를 일정하게 전처리한다.

    #해쉬함수 정의
    def hash_function(self, key):
        self.index_key = self.get_key(key)
        return self.index_key%int(self.tableset) #해쉬함수는 키값을 해쉬테이블 개수만큼 나눈 몫으로 정의했다.

    #저장 함수 정의
    def save(self, key, value):
        hash_address = self.hash_function(key) #key에 상응하는 해쉬테이블의 주소를 얻는다.
        if self.hash_table[hash_address] != 0 : #key에 상응하는 해쉬테이블의 주소가 빈값이 아니라면
            for index in range(len(self.hash_table[hash_address])):#key에 상응하는 해쉬테이블의 주소를 모두 순회
                if self.hash_table[hash_address][index][0] == self.index_key: #만약 key 값이 같다면
                    self.hash_table[hash_address][index][1] = value #그 자리에 value를 덮어씌운다.
                    return
            self.hash_table[hash_address].append([self.index_key, value]) #주소에 데이터는 있지만 같은 key값이 없으면 추가로 데이터를 넣는다. 이부분이 Chaining 기법
        else:
            self.hash_table[hash_address] = [[self.index_key,value]] #주소가 빈값일 경우 2차원 리스트의 형식으로 key,velue를 넣어준다.

    def read(self, key):
        hash_address = self.hash_function(key)
        
        if self.hash_table[hash_address] != 0:
            for index in range(len(self.hash_table[hash_address])):
                if self.hash_table[hash_address][index][0] == self.index_key:
                    return print(self.hash_table[hash_address][index][1])
            return print(None)
        else: return print(None)

#test code

chaininghash = Chaininghash(8) #해쉬테이블의 크기가 8개인 ChainingHash 생성
print(hash('gudals')%8)
print(hash('gud')%8)
print(hash('guda')%8)
chaininghash.save("gudals","010-1234-4321")
chaininghash.save("gud","010-2222-2222")
chaininghash.save("guda","010-3333-3333") 
chaininghash.read("gudals")
chaininghash.read("gud")
chaininghash.read("sadl")