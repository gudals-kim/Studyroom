# singleton pattern
> 애플리케이션이 시작될 때, 어떤 클래스가 최초 한 번만 메모리를 할당(static)하고 해당 메모리에 인스턴스를 만들어 사용하는 패턴

## 🙌 요약
- 하나의 클래스에 오직 하나의 객체만 가지는 패턴이다.
- 장점 : 객체 생성 비용이 줄어든다.
- 단점 : 의존성이 높아진다.
- 사용처 : 보통 데이터베이스 연결 모듈에 많이 사용된다.

### 👍 왜 사용하는가?
> 메모리 누수를 막을 수 있다.
- 객체를 생성할 때 마다 메모리 영역을 할당 받아야한다.
- 하지만 프로그램이 실행될 때 객체를 생성시켜놓고 그걸 가져다가 쓰기만 한다면 메모리 낭비를 방지할 수 있다.

### 👀 언제 많이 사용하는가?
> 주로 공통된 객체를 여러개 생성해서 사용해야 하는 상황

- ```데이터 베이스```의 ```커넥션 풀, 스레드 풀, 캐시, 로그 기록 객체 등```
- ```안드로이드```의 ```각 액티비티```등
- ```스프링```의 ```빈과 컨테이너```등

### 👎 단점도 있나?
> 의존성이 높아진다.<br>
- 싱글턴 패턴을 구현해야하는 코드 자체가 늘어난다.
- 의존 관계상 클라이언트가 구체 클래스에 의존한다.
- 테스트하기 어렵다.
- 내부 속성을 변경하거나 초기화하기 어렵다.
- private 생성자로 자식 클래스를 만들기 어렵다.

> 보통 싱글톤을 사용할때 ```DI(의존성주입)```의 개념을 활용해서 모듈결합도(의존성)을 떨어트리려 노력한다.

## 싱글톤 활용

### 자바스크립트
> 자바스크립트에서는 ```리터럴 {}``` 또는 ```new object```로 객체를 생성하게 되면 다른 어떤 객체와도 같지 않기 때문에 이 자체만으로 ```싱글톤 패턴```을 구현할 수 있다.

```javascript
//그냥 작성
const obj = {
    a:27
}
const obj2 = {
    a:27
}
console.log(obj == obj2)
//출력: false
```
- 이렇게 코드를 작성한다면 obj와 obj2는 다른 인스턴스를 가진다.
```javascript
//싱글톤 작성
class Singleton{
    constructor(){
        if (!Singleton.instance){
            Singleton.instance = this
        }
        return Singleton.instance
    }
    getInstance(){
        return this.instance()
    }
}
const a = new Singleton()
const b = new Singleton()
console.log(a === b)
//출력 : true
```
- 싱글톤 패턴을 활용한 코드이다.
- Singleton.instance 라는 하나의 인스턴스를 가지는 Singleton 클래스를 구현했다.
- 실제로 객체를 a와 b로 가져와도 같은 객체로 인식되는 것을 확인할 수 있다.
#### 자바스크립트 데이터베이스 연결 모듈에서의 활용
> 싱글톤 패턴은 데이터베이스 연결 모듈에서 많이 사용된다.
```javascript
//데이터 베이스 연결 모듈
const URL = 'mongodb://localhost:27017/kundolapp'
const createConnection = url => ({"url":url})
class DB{
    constructor(url){
        if (!DB.instance){
            DB.instance = createConnection(url)
        }
        return DB.instance
    }
    connect(){
        return this.instance
    }
}
const a = new DB(URL)
const b = new DB(URL)
console.log(a===b)
//출력 : true
```
- 이런식으로 데이터베이스 연결할때 DB.instance라는 하나의 객체를 기반으로 a,b를 생성한다.
- 이를 통해 데이터베이스 연결에 관한 객체 생성 비용(메모리,쓰레드 등)을 아낄 수 있다.

### 자바
> 자바에서는 중첩 클래스를 이용해서 만드는 방법이 대중적이다.
```java
class Singleton {
    private static class singleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return singleInstanceHolder.INSTANCE;
    }
}

public class HelloWorld{ 
     public static void main(String []args){ 
        Singleton a = Singleton.getInstance(); 
        Singleton b = Singleton.getInstance(); 
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());  
        if (a == b){
         System.out.println(true); 
        } 
     }
}
/*
705927765
705927765
true
*/
```

1. 클래스안에 클래스(Holder), static이며 중첩된 클래스인 singleInstanceHolder를 
기반으로 객체를 선언했기 때문에 한 번만 로드되므로 싱글톤 클래스의 인스턴스는 애플리케이션 당 하나만 존재하며 
클래스가 두 번 로드되지 않기 때문에 두 스레드가 동일한 JVM에서 2개의 인스턴스를 생성할 수 없습니다. 
그렇기 때문에 동기화, 즉 synchronized를 신경쓰지 않아도 됩니다. 
2. final 키워드를 통해서 read only 즉, 다시 값이 할당되지 않도록 했습니다.
3. 중첩클래스 Holder로 만들었기 때문에 싱글톤 클래스가 로드될 때 클래스가 메모리에 로드되지 않고 
어떠한 모듈에서 getInstance()메서드가 호출할 때 싱글톤 객체를 최초로 생성 및 리턴하게 됩니다.

## 개발도구에서의 싱글톤
### 1. mongoose의 싱글톤
> 실제로 싱글톤 패턴은 Node.js에서 MongoDB 데이터베이스를 연결 할 때 쓰이는 monogoose모듈에서 볼 수 있다.
```javascript
Mongoose.prototype.connect = function (uri, options, callback){
    const _mongoose = this instanceof Mongoose ? this : mongoose;
    const conn = _mongoose.connection;
    
    return _mongoose._promiseOrCallback(callback, cd =>{
        conn.openUri(uri, options, err=>{
            if (err != null){
                return cb(err);
            }
            return cb(null, _mongoose);
        });
    });
};
```
### 2. MySQL의 커넥션 풀 싱글톤 패턴
```javascript
//메인모듈
const mysql = require('mysql');
const pool = mysql.createPool({
    connectionLimit: 10,
    host: 'example.org',
    user: 'gudals',
    password: 'secret',
    database: 'mydb'
})
pool.connect();
```
메인 모듈에서 데이터베이스 연결에 관한 인스턴스를 정의하고 다른 모듈인 A 또는 B에서 해당 인스턴스를 기반으로 쿼리르 보내는 형식으로 쓰인다.

### 3. spring 컨테이너 싱글톤 패턴
>테스트 결과로 MemberService 클래스의 인스턴스가 동일한 값임을 확인할 수 있습니다.
```java
@Test
void springContainer() {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    MemberService memberService2 = ac.getBean("memberService", MemberService.class);

    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    Assertions.assertThat(memberService1).isSameAs(memberService2);

}
//결과
//memberService1 = com.example.springdemostudy.member.MemberServiceImpl@78e16155
//memberService2 = com.example.springdemostudy.member.MemberServiceImpl@78e16155
```
- 스프링 컨테이너에서 미리 만들어진 member Service 객체를 공유하게 된다.
- 이는 db 커넥션 풀, 쓰레드 풀에서 가져오는 것과 상당히 비슷하다고 생각된다.
