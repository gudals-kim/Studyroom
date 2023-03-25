# strate pattern
> 같은 문제를 해결하는 여러 알고리즘이 클래스별로 캡슐화되어 있고 이들이 필요할 때 교체할 수 있도록 함으로써 동일한 문제를 다른 알고리즘으로 해결할 수 있게 하는 디자인 패턴

```
전략
어떤 목적을 달성하기 위해 일을 수행하는 방식, 비즈니스 규칙, 문제를 해결하는 알고리즘
ex) 게임 프로그래밍에서 게임 캐릭터가 자신이 처한 상황에 따라 공격이나 행동하는 방식을 바꾸고 싶을 때
```


## 🙌 요약
> 동일한 문제를 해결하는 여러 알고리즘 중에서 필요에 따라 적합한 알고리즘을 선택하여 사용할 수 있도록 하는 패턴입니다.
- 장점: 알고리즘을 자유롭게 바꿀 수 있고, 새로운 알고리즘을 쉽게 추가할 수 있습니다.
- 단점: 코드가 길어지거나 복잡해질 수 있고, 알고리즘 간에 통신 비용이 발생할 수 있습니다.



### 👍 왜 사용하는가?
> 프로그램의 유연성과 확장성을 높히기 위해 사용된다. 다만, 코드가 길어지고 통신비용이 추가로 들 수 있습니다.

- 프로그램의 유연성과 확장성을 높이기 위해서
- 알고리즘의 변경이나 추가에 대응하기 쉽게 하기 위해서
- 다중 상속의 문제점을 피하면서 알고리즘을 재사용하기 위해서


### 👀 언제 많이 사용하는가?

- 프로그램에서 달라지는 부분을 찾아내고, 달라지지 않는 부분과 분리하고 싶을 때
- 특정한 계열의 알고리즘들을 정의하고 각 알고리즘을 캡슐화하고 싶을 때
- 객체의 행위를 동적으로 바꾸고 싶을 때
- 다중 상속의 단점을 피하면서 알고리즘을 재사용하고 싶을 때

### 👎 단점도 있나?

- 코드가 길어지거나 복잡해질 수 있습니다.
- 알고리즘 간에 통신 비용이 발생할 수 있습니다.
- 알고리즘의 성능이나 메모리 사용량에 영향을 줄 수 있습니다.



## 전략 패턴 활용
### 자바의 전략 패턴
> 쇼핑 카트에 아이템을 담아 LUNACard 또는 KAKAOCard 라는 두 개의 전략으로 결제하는 코드
```java
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
interface PaymentStrategy { 
    public void pay(int amount);
} 

class KAKAOCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    
    public KAKAOCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount +" paid using KAKAOCard.");
    }
} 

class LUNACardStrategy implements PaymentStrategy {
    private String emailId;
    private String password;
    
    public LUNACardStrategy(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }
    
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using LUNACard.");
    }
} 

class Item { 
    private String name;
    private int price; 
    public Item(String name, int cost){
        this.name=name;
        this.price=cost;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
} 

class ShoppingCart { 
    List<Item> items;
    
    public ShoppingCart(){
        this.items=new ArrayList<Item>();
    }
    
    public void addItem(Item item){
        this.items.add(item);
    }
    
    public void removeItem(Item item){
        this.items.remove(item);
    }
    
    public int calculateTotal(){
        int sum = 0;
        for(Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }
    
    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}  

public class HelloWorld{
    public static void main(String []args){
        ShoppingCart cart = new ShoppingCart();
        
        Item A = new Item("kundolA",100);
        Item B = new Item("kundolB",300);
        
        cart.addItem(A);
        cart.addItem(B);
        
        // pay by LUNACard
        cart.pay(new LUNACardStrategy("kundol@example.com", "pukubababo"));
        // pay by KAKAOBank
        cart.pay(new KAKAOCardStrategy("Ju hongchul", "123456789", "123", "12/01"));
    }
}
/*
400 paid using LUNACard.
400 paid using KAKAOCard.
*/
```

### passport의 전략 패턴
> passport는 Node.js에서 인증 모듈을 구현할 때 쓰는 미들웨어 라이브러리<br>
> 여러가지 전략을 기반으로 인증할 수 있게 한다.
- 서비스 내의 회원가입된 아이디와 비밀번호를 기반으로 인증하는 localStrategy 전략
- 페이스북, 네이버 등 다른 서비스를 기반으로 인증하는 OAuth전략 등을 지원한다.

```javascript
var passport = require('passport')
    , LocalStrategy = require('passport-local').Strategy;

passport.use(new LocalStrategy(
    function(username, password, done) {
        User.findOne({ username: username }, function (err, user) {
          if (err) { return done(err); }
            if (!user) {
                return done(null, false, { message: 'Incorrect username.' });
            }
            if (!user.validPassword(password)) {
                return done(null, false, { message: 'Incorrect password.' });
            }
            return done(null, user);
        });
    }
));
```
> passport.use(new LocalStrategy(...처럼 passport.use()라는 전략을 매개변수로<br>
> 넣어서 로직을 수행하는 것을 볼 수 있다.