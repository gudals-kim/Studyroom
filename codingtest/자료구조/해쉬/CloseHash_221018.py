class LinearProbing_Hash:
    def __init__(self, tableset): #hash_table 이 value개의 CloseHash 생성
        self.tableset = tableset
        self.hash_table = list([0 for i in range(tableset)])

    #키 정의
    def get_key(self,key):
        return hash(key) #hash 내장함수를 사용하여 key를 일정하게 전처리한다.

    #해쉬함수 정의
    def hash_function(self, key):
        self.index_key = self.get_key(key)
        return self.index_key%int(self.tableset) #해쉬함수는 키값을 해쉬테이블 개수만큼 나눈 몫으로 정의했다.

    def save(self, key, value):
        hash_address = self.hash_function(key)
        if self.hash_table[hash_address] != 0:
            for index in range(hash_address, len(self.hash_table)):
                if self.hash_table[index] == 0:
                    self.hash_table[index] = [self.index_key, value]
                elif self.hash_table[index][0] == self.index_key:
                    self.hash_table[index][1] = value
                else:
                    print(key+"를 저장하지 못했습니다.")
        else: self.hash_table[hash_address] = [self.index_key, value]

    def read(self, key):
        hash_address = self.hash_function(key)
        if self.hash_table[hash_address] != 0:
            for index in range(hash_address, self.tableset):
                if self.hash_table[index] == 0:
                    return print("찾지 못했습니다.")
                elif self.hash_table[index][0] == self.index_key:
                    return print(self.hash_table[index][1])
        else: return print("찾지 못했습니다.")
    

    def readAll(self):
        print(self.hash_table)

linearProbing_Hash = LinearProbing_Hash(8)
linearProbing_Hash.save("gudals","010-1234-4321")
linearProbing_Hash.save("guend","010-0202-1111")
linearProbing_Hash.save("guen","010-3333-1111")
linearProbing_Hash.save("gue","010-4444-1111")
linearProbing_Hash.save("gu","010-6666-1111")
linearProbing_Hash.save("gdales","010-8888-1111")
linearProbing_Hash.save("gudaks","010-9999-1111")
linearProbing_Hash.save("gudaos","010-0000-1111")
linearProbing_Hash.save("vlenla","010-4444-4444")
linearProbing_Hash.read("gudals")
linearProbing_Hash.read("gudaos")
linearProbing_Hash.readAll()