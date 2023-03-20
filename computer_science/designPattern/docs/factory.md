# factory pattern
> 객체를 생성하기 위해 필요한 인터페이스를 만든 후, 인터페이스를 구현하는 클래스에서 어떤 객체를 만들지 결정하는 패턴이다. 

```
팩토리 메소드 패턴을 사용하는 이유는 클래스간의 결합도를 낮추기 위해 사용한다.
결합도라는 것은 간단히 말해 클래스의 변경할 부분이 생겼을 때 얼마나 다른 클래스에도 영향을 주는가이다. 
팩토리 메소드 패턴을 사용하는 경우 직접 객체를 생성해 사용하는 것을 방지하고 서브 클래스에 위임함으로써 보다 효율적인 코드 제어를 할 수 있고 의존성을 제거한다. 
결과적으로 결합도 또한 낮출 수 있다.
```


## 🙌 요약
- 객체의 생성을 캡슐화 하는 패턴이며, ```팩토리 메서드 패턴```과, ```추상 팩토리 패턴```으로 나누어 진다.
- 공통점 
  - 객체의 생성부를 캡슐화 하여 결합을 느슨하게하여 의존성을 낮춘다.
- 차이점
  - ```팩토리 메서드 패턴``` 
    - 상속을 통해 서브 클래스에서 팩토리 메소드를 오버라이딩하여 객체의 생성부를 구현
  - ```추상 팩토리 패턴```
    - 객체의 집합을 생성하기 위한 정의를 추상체에 위치시키고 하위의 구현체에서 세부적인 집합 생성 과정을 구현 (Fatory Method를 이용해 구현)
- 장점
  - 상위 클래스와 하위 클래스가 분리되기 때문에 느슨한 결합을 가지게 된다.
  - 또한 상위 클래스에서는 객체 생성 방식을 알 필요가 없기 때문에 유연성이 증가된다.
  - 객체 생성 로직이 따로 떼어져 있기 때문에 유지보수성이 증가된다.
- 단점 
  - 클래스가 많아진다. (클래스 계층도 커질 수 있다.)


### 👍 왜 사용하는가?
> ```확장```에 열려있고 ```변경```에 닫혀있는 객체지향 원칙을 적용할 수 있다.<br>
> ```확장```: 새로운 인스턴스를 추가 ```변경``` : 기존 코드를 수정
- 기존 코드(인스턴스를 만드는 과정)를 수정하지 않고 새로운 인스턴스를 다른 방법으로 생성하도록 확장할 수 있다.
  - Product 와 Creator 간의 커플링(결합)이 느슨함
- 코드가 간결해진다.
- 병렬적 클래스 계층도를 연결하는 역할을 담당할 수 있다.


> 쉽게 말하자면 공통된 인터페이스를 사용하게 된다면, 구현부를 골라서 사용할 수 있다.

### 👀 언제 많이 사용하는가?
> 객체를 생성하기 위해 인터페이스를 정의하지만, 어떤 클래스의 인스턴스를 생성할지에 대한 결정은 서브클래스에서 이루어지도록 하여 재정의 가능한 것으로 설계 하지만, 복잡해지지 않게 한다

- 생성할 객체 타입을 예측할 수 없을 때
- 생성할 객체를 기술하는 책임을 서브클래스에게 정의하고자 할 때
- 객체 생성의 책임을 서브클래스에 위임시키고 서브클래스에 대한 정보를 은닉하고자 할 때

### 👎 단점도 있나?
> 클래스가 많아진다. (클래스 계층도 커질 수 있다.)
- 제품 클래스가 바뀔 때마다 새로운 서브클래스를 생성해야 한다.
- 클라이언트가 creator 클래스를 반드시 상속해 Product를 생성해야 한다.


## 팩토리 패턴 활용

### 자바스크랩트의 팩토리 패턴
```javascript
class CoffeeFactory {
    static createCoffee(type) {
        const factory = factoryList[type]
        return factory.createCoffee()
    }
}   
class Latte {
    constructor() {
        this.name = "latte"
    }
}
class Espresso {
    constructor() {
        this.name = "Espresso"
    }
} 

class LatteFactory extends CoffeeFactory{
    static createCoffee() {
        return new Latte()
    }
}
class EspressoFactory extends CoffeeFactory{
    static createCoffee() {
        return new Espresso()
    }
}
const factoryList = { LatteFactory, EspressoFactory } 
 
 
const main = () => {
    // 라떼 커피를 주문한다.  
    const coffee = CoffeeFactory.createCoffee("LatteFactory")  
    // 커피 이름을 부른다.  
    console.log(coffee.name) // latte
}
main()
```
- coffeeFactory 라는 상위 클래스가 중요한 뼈대를 결정하고 하위 클래스인 LatteFactory가 구체적인 내용을 결정하고 있다.
- DI의 의미도 내포하고 있다고 볼 수 있다.
  - CoffeeFactory에서 LatteFactory의 인스턴스를 생성하는 것이 아닌 LatteFactory에서 생성한 인스턴스를 CoffeeFactory에 주입하고 있기 때문이다.

### 자바의 팩토리 패턴
```java
abstract class Coffee { 
    public abstract int getPrice(); 
    
    @Override
    public String toString(){
        return "Hi this coffee is "+ this.getPrice();
    }
}

class CoffeeFactory { 
    public static Coffee getCoffee(String type, int price){
        if("Latte".equalsIgnoreCase(type)) return new Latte(price);
        else if("Americano".equalsIgnoreCase(type)) return new Americano(price);
        else{
            return new DefaultCoffee();
        } 
    }
}
class DefaultCoffee extends Coffee {
    private int price;

    public DefaultCoffee() {
        this.price = -1;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
class Latte extends Coffee { 
    private int price; 
    
    public Latte(int price){
        this.price=price; 
    }
    @Override
    public int getPrice() {
        return this.price;
    } 
}
class Americano extends Coffee { 
    private int price; 
    
    public Americano(int price){
        this.price=price; 
    }
    @Override
    public int getPrice() {
        return this.price;
    } 
} 
public class HelloWorld{ 
     public static void main(String []args){ 
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee ame = CoffeeFactory.getCoffee("Americano",3000); 
        System.out.println("Factory latte ::"+latte);
        System.out.println("Factory ame ::"+ame); 
     }
} 
/*
Factory latte ::Hi this coffee is 4000
Factory ame ::Hi this coffee is 3000
*/
```
> 지금 보면 if("Latte".equalsIgnoreCase(type))를 통해 문자열 비교 기반으로 로직이 구성됨을 볼 수 있는데, 이는 Enum 또는 Map을 이용하여 if문을 쓰지않고 매핑해서 할 수 있다.



## 개발 도구에서의 팩토리 패턴
### 1. 스프링에서의 팩토리 패턴
>Object 타입의 Product를 만드는 BeanFacotry라는 Creator
```java
BeanFactory factory = new XmlBeanFactory(
            new InputStreamResource(
            new FileInputStream("oraclejavacommunity.xml")));
OracleJavaComm ojc = (OracleJavaComm)factory.getBean("oracleJavaBean");
```
- xml 설정과 java 설정으로 읽어오는 방식이다.
- Product에 해당하는 것은 Object
- ConcreteProduct에 해당하는 것은 xml 또는 class Bean