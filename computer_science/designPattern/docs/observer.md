# observer pattern
> 주체가 어던 객체의 상태 변화를 관찰하다가 상태 변화가 있을 때마다<br>
> 매서드 등을 통해 옵저버 목록에 있는 옵저버들에게 변화를 알려주는 패턴

- 주체란
  - 객체의 상태 변화를 보고 있는 관찰자임
- 옵저버란
  - 이 객체의 상태 변화에 따라 전달되는 메서드 등을 기반으로 '추가 변화 사항'이 생기는 객체들을 의미한다.

## 🙌 요약
> 옵저버 패턴은 객체의 상태 변화를 관찰하는 관찰자들<br>
> 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴입니다.

- 장점
  - 실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있다.
  - 느슨한 결합으로 시스템이 유연하고 객체간의 의존성을 제거할 수 있습니다.

- 단점
  - 너무 많이 사용하게 되면 상태 관리가 힘들 수 있다.
  - 데이터 배분에 문제가 생기면 자칫 큰 문제로 이어질 수 있습니다.


### 👍 왜 사용하는가?
> 프로그램의 유연성과 확장성을 높히기 위해 사용된다.

- 옵저버 패턴의 장점으로는 실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있다.
- 느슨한 결합으로 시스템이 유연하고 객체간의 의존성을 제거할 수 있다
- 객체 간의 의존성을 제거하고 시스템이 유연해지는 장점이 생긴다.

### 👀 언제 많이 사용하는가?
>옵저버 패턴은 한 객체의 상태 변화가 다른 객체들에게 영향을 미치는 경우에 유용하게 사용될 수 있습니다.

- 예를 들어, 한 객체의 상태가 변경되면 그 객체에 의존하는 다른 객체들이 자동으로 갱신되어야 하는 경우에 옵저버 패턴을 사용할 수 있습니다. 
- 이는 실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있고, 느슨한 결합으로 시스템이 유연하고 객체간의 의존성을 제거할 수 있습니다.

### 👎 단점도 있나?
> 이러한 단점을 고려하여 옵저버 패턴을 적절하게 사용하는 것이 중요합니다.
- 옵저버 패턴의 단점으로는 너무 많이 사용하게 되면 상태 관리가 힘들 수 있다
- 데이터 배분에 문제가 생기면 자칫 큰 문제로 이어질 수 있습니다.



## 옵저버 패턴 활용
### 서비스에서의 활용
- ```트위터의 팔로윙 시스템```에서 내가 포스팅을 올리게되면 나를 팔로우 한 사람들에게 알림이 간다.
- ```mvc 패턴```에서의 모델에서 변경이 일어나면 컨트롤러, view에도 적용이된다.

### 자바의 옵저버 패턴
> topic을 기반으로 옵저버 패턴을 구현했다. 여기서 topic은 주체이자 객체가 된다.
```java
import java.util.ArrayList;
import java.util.List;

interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}

interface Observer {
    public void update(); 
}

class Topic implements Subject {
    private List<Observer> observers;
    private String message; 

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer obj) {
        if (!observers.contains(obj)) observers.add(obj); 
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj); 
    }

    @Override
    public void notifyObservers() {   
        this.observers.forEach(Observer::update); 
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    } 
    
    public void postMessage(String msg) {
        System.out.println("Message sended to Topic: " + msg);
        this.message = msg; 
        notifyObservers();
    }
}

class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this); 
        System.out.println(name + ":: got message >> " + msg); 
    } 
}

public class HelloWorld { 
    public static void main(String[] args) {
        Topic topic = new Topic(); 
        Observer a = new TopicSubscriber("a", topic);
        Observer b = new TopicSubscriber("b", topic);
        Observer c = new TopicSubscriber("c", topic);
        topic.register(a);
        topic.register(b);
        topic.register(c); 
   
        topic.postMessage("amumu is op champion!!"); 
    }
}
/*
Message sended to Topic: amumu is op champion!!
a:: got message >> amumu is op champion!!
b:: got message >> amumu is op champion!!
c:: got message >> amumu is op champion!!
*/ 
```
> ```class Topic implement Subject```를 통해 ```Subject interface```를 구현했고<br>
> ```Observer a = new TopicSubscriber("a" topic);으로 옵저버를 선언할 때 해당 이름과 어떠한 토픽의 옵저버가 될 것인지 정한다.```

### 자바스크립트에서의 옵저버 패턴

#### 프록시 객체
> ```프록시 객체```는 어떤 대상의 기본적인 동작(속성 접근, 할당, 순회, 열거, 함수 호출 등)의 작업을 가로챌 수 잇는 객체를 뜻한다.<br>
> 자바 스크립트의 ```프록시 객체```는 두 개의 매개 변수를 가진다.<br>
> ```target```:프록시할 대상<br>
> ```handler```:target 동작을 가로채고 어떠한 동작을 할 것인지가 설정되어 있는 함수<br>

```javascript
const handler = {
    get: function(target, name){
        return name === 'name' ? `${target.a} ${target.b}` : target[name] 
    }
}
const p = new Proxy({a: 'gudals', b: 'IS AUMUMU ZANGIN'}, handler)
console.log(p.name) //gudals IS AUMUMU ZANGIN
```

- new Proxy()로 a와 b 속성을 가지고 있는 객체와 handler 함수를 매개변수로 넣고 p라는 변수를 선언했다.
- 이후 p의 name속성을 참조하니 a와 b라는 속성밖에 없는 객체가 handler의 "name 이라는 속성에 접근할 때 a와 b를 합쳐서 문자열을 만들라"는 로직에 따라 어떤 문자열을 만든다.
- 이렇게 name 속성 등 특정 속성에 접근할 때 그 부분을 가로채서 어떠한 로직을 강제할 수 있는 것이 프록시 객체이다.

```javascript
function createReactiveObject(target, callback) { 
    const proxy = new Proxy(target, {
        set(obj, prop, value){
            if(value !== obj[prop]){
                const prev = obj[prop]
                obj[prop] = value 
                callback(`${prop}가 [${prev}] >> [${value}] 로 변경되었습니다`)
            }
            return true
        }
    })
    return proxy 
} 
const a = {
    "형규" : "솔로"
} 
const b = createReactiveObject(a, console.log)
b.형규 = "솔로"
b.형규 = "커플"
// 형규가 [솔로] >> [커플] 로 변경되었습니다
```
- get() 함수는 속성과 함수에 대한 접근을 가로챈다.
- has() 함수는 in 연산자의 사용을 가로챈다.
- set() 함수는 속성에 대한 접근을 가로챈다.
- set() 함수를 통해 속성에 대한 접근을 가로채서 형규라는 속성이 솔로에서 커플로 되는 것을 감시할 수 있다.



### vue.js 3.0의 옵저버 패턴
> 프런트엔드에서 많이 사용되는 프레임워크 Vue.js에서 ref나 reactive로 정의하면 해당 갑싱 변경 되었을 때,<br>
> 자동으로 DOM에 있는 값이 변경되는데, 이는 프록시 객체를 이용한 옵저버 패턴을 이용하여 구현한 것.

```javascript
function createReactiveObject(
    target: Target,
    isReadonly: boolean,
    baseHandlers: ProxyHandler<any>,
    collectionHandlers: ProxyHandler<any>,
    proxyMap: WeakMap<Target, any>
){
    if (!isObject(target)){
        if (__DEV__){
            console.warn(`value cannot be made reactive: ${String(target)}`)
        }
        return target
    }
    if (
        target[ReactiveFlags.RAW] &&
        !(isReadonly && target[ReactiveFlags.IS_REACTIVE])
    ){
        return target
    }
    const existingProxy = proxyMap.get(target)
    if (existingProxy){
        return existingProxy
    }
    const targetType = getTargetType(target)
    if (targetType === TargetType.INVALID){
        return target
    }
    const proxy = new Proxy(
        target,
        targetType === TargetType.COLLECTION ? collectionHandlers : baseHandlers
    )
    proxyMap.set(target, proxy)
    return proxy
}
```
> 실제 Vue.js 3.0의 옵저버 패턴이 담긴 코드이다.<br>
> proxyMap이라는 프록시 객체를 사용했고, 객체 내부의 get, set 메서드를 사용했다.