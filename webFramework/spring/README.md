# Spring

## spring의 특징

* 스프링의 특징은 어렵지만, 매우 중요하며 이를 명확하게 이해하지 못한다면 스프링을 사용하는 의미가 없다.

1. IOC(Inversion of Control) : 제어의 역행
    * 제어의 주체가 개발자가 아닌 spring 이다. 정해진 기준에 따라 spring이 작성된 코드를 호출한다.
    * 객체의 생명주기관리 또한 spring이 해준다.
2. DI(Dependency Injection) : 의존 주입
    * 의존정 객체를 개발자가 생성하지 않고 해당 클래스를 spring Bean으로 등록하면 spring이 Bean으로 등록된 객체를 알아서 의존관계를 주입한다.
3. AOP(Aspect Oriented Programming) : 관점지향 프로그래밍
    * 각 코드마다 공통된 관심사를 분리하여 모듈화하는 프로그래밍 기법이다.
    * 객체지향적으로 프로그래밍을 했음에도, 공통적인 관심사(로그, 트랜잭션, 성능확인 등)가 중복되는 문제점을 해결하기 위해 [프록시패턴]()을 사용하여 코드를 분리하여 관리하는 기술이다.
4. PSA(Portable Servic Abstraction) : 추상화
    * POJO 프로그래밍을 지원하기 위해 다양하게 구현되어 있는 인터페이스를 같은 방식으로 사용하도록 중간에 인터페이스 [어댑터]()역할을 해주는 레이어를 추가해준다.

### spring이 하는일
* spring을 사용하지 않고 개발을 한다면 처리해야하는 일
  1. ~~톰캣서버 연결~~ (spring boot)
  2. ~~서버 TCP/IP 대기, 소켓 연결~~
  3. ~~HTTP 요청 메시지를 파싱해서 읽기~~
  4. ~~POST 방식, /save URL 인지 확인~~
  5. ~~Content-Type 확인~~
  6. ~~HTTP 메시지 바디 내용 파싱~~
  7. ~~저장 프로세스 실행~~
  8. ***비지니스 로직 실행***
  9. ~~HTTP 응답 메시지 생성~~
     1. ~~HTTP 시작라인 생성~~
     2. ~~Header 생성~~
     3. ~~메시지 바디에 HTML 생성에서 입력~~
  10. ~~TCP/IP에 응답 전달, 소켓 종료~~

> 스프링이 없었다면 톰캣서버를 켜서 TCP/IP에서 HTTP요청 메시지를 받아와서
> 내가 필요한 데이터만 뽑아서 비지니스로직에서 사용했어야 하지만 스프링이
> 그 모든 일을 해주기 때문에 비지니스 로직 작성에만 집중할 수 있다.

### 서블릿 컨테이너 동작 방식

* 내장 톰캣 서버 생성 <br>
<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/webFramework/spring/img/tomcatServer.png">

1. 스프링 부트를 실행하면 스프링부트가 내장톰캣서버를 실행해준다.
2. 톰캣서버는 서블릿 컨테이너 기능을 가지고있다.
3. 톰캣이 스프링부트 내에 있는 프로젝트(helloServlet)을 서블릿 컨테이너에 넣어준다.
4. 이후 HTTP 요청을 기다린다.<br>
<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/webFramework/spring/img/rquestAndResponse.png">
<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/webFramework/spring/img/webappServerRequestResponse.png">
5. HTTP 요청 메시지, HTTP 응답 메시지를 request,response 객체를 싱글톤으로 생성해서 helloServlet을 실행시켜준다.
<br>





## 용어정리
- [의존성]() : 현재 객체가 다른 객체와 상호작용하고 있다면 (객체가 다른 클래스에서 사용되고 있다면) 다른 객체들은 현재 객체에 의존이라고 한다.
- [디자인패턴]() :
- [POJO]() : 