# 타임리프 - 기본기능

## 1. 타임리프 소개

* 공식사이트 : https://www.thymeleaf.org/
* 공식 메뉴얼 - 기본기능 : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html
* 공식 메뉴얼 - 스프링 통합 : https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html

### 1.1 타임리프 특징
* 서버 사이드 HTML 렌더링 (SSR)
    - 타임리프는 백엔드 서버에서 HTML을 동적으로 렌더링하는 용도로 사용된다.
* 네츄럴 템플릿
```
    타임리프는 순수 HTML을 최대한 유지하는 특징이 있다.
    타임리프로 작성한 파일은 HTML을 유지하기 때문에 웹 브라우저에서
    파일을 직접 열어도 내용을 확인할 수 있고, 서버를 통해 뷰 템플릿을 
    거치면 동적으로 변경된 결과를 확인할 수 있다.
    
    JSP를 포함한 다른 뷰 템플릿들은 해당 파일을 열면, 예를 들어 
    JSP 파일 자체를 그대로 웹 브라우저에서 열어보면 JSP 소스코드와 HTML
    이 뒤죽박죽 섞여서 웹 브라우저에서 정상적인 HTML 결과를 확인할 수 없다.
    
    반면 타임리프로 작성된 파일은 해당 파일을 그대로 웹 브라우저에서 열어도
    정상적이 HTML 결과를 확인 할 수 있다. 물론 이 경우 동적으로 결과가 렌더링
    되지는 않는다. 
    
    하지만 HTML 마크업 결과가 어떻게 되는지 파일만 열어도 바로
    확인할 수 있다.
     
    이렇게 순수 HTML을 그대로 유지하면서 뷰 템플릿도 사용할 수
    있는 타임리프의 특징을 네츄럴 템플릿 (natural templates)이라 한다.
``` 
* 스프링 통합 지원
    - 타임리프는 스프링과 자연스럽게 통합되고, 스프링의 다양한 기능을 편리하게 사용할 수 있게 지원한다.

<br>

## 2. 타임리프 기본기능

### 2.1 기본 표현식
```html
• 간단한 표현:
    ◦ 변수 표현식: ${...}
    ◦ 선택 변수 표현식: *{...}
    ◦ 메시지 표현식: #{...}
    ◦ 링크 URL 표현식: @{...}
    ◦ 조각 표현식: ~{...}
    
• 리터럴
    ◦ 텍스트: 'one text', 'Another one!',...
    ◦ 숫자: 0, 34, 3.0, 12.3,...
    ◦ 불린: true, false
    ◦ 널: null
    ◦ 리터럴 토큰: one, sometext, main,...
    
• 문자 연산:
    ◦ 문자합치기:+
    ◦ 리터럴 대체: |The name is ${name}|
    
• 산술 연산:
    ◦ Binary operators: +, -, *, /, %
    ◦ Minus sign (unary operator): -

• 불린 연산:
    ◦  Binary operators: and, or
    ◦  Boolean negation (unary operator): !, not

• 비교와 동등:
    ◦ 비교:>,<,>=,<=(gt,lt,ge,le)
    ◦ 동등 연산: ==, != (eq, ne) 
    
• 조건 연산:
    ◦  If-then: (if) ? (then)
    ◦  If-then-else: (if) ? (then) : (else)
    ◦  Default: (value) ?: (defaultvalue)

• 특별한 토큰:
    ◦   No-Operation: _
```
참고 : https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax

### 2.2 텍스트 - text, utext
* 타임리프의 가장 기본 기능인 텍스트를 출력하는 기능
* 타임리프는 기본적으로 HTML 태그 속성에 기능을 정의해서 동작한다.
* HTML 콘텐츠에 데이터를 출력할때는 다음과 같이 ```th:text``` 를 사용하면 된다.
* ```<span th:text="${data}"```
<br>
* HTML 태그의 속성이 아니라 HTML 콘텐츠 영약안에서 직접 데이터를 출력하고 싶으면 다음과 같이 ```[[...]]``` 을 사용하면 된다.
* ```콘텐츠 안에서 직접 출력하기 -> [[${data}]]```

<br>

### 2.3  Escape
HTML 문서는 <,>같은 특수 문자를 기반으로 정의된다.<br>
따라서 뷰 템플릿으로 HTML 화면을 생성할 때는 출력하는 데이터에 이러한 특수 문자가 있는 것을 주의해서 사용해야한다.

***HTML엔티티*** <br>
웹 브라우저는 ```<```를 HTML태그의 시작으로 인식한다.<br>
따라서 ```<```를 태그의 시작이 아니라 문자로 표현해야한다.<br>
그 방법을 ```HTML엔티티``` 라 한다.<br>
그리고 이렇게 HTML에서 사용하는 특수문자를 ```HTML엔티티```로 변경하는 것을 ```이스케이프(escape)```라 한다.<br>
그리고 타임리프가 제공하는 ```th:text```, ```[[...]]```은 ***기본적으로 이스케이프를 제공한다.***
<br>

### 2.4 Unescape

* 만약 이스케이프 기능을 사용하고 싶지 않다면 타임리프에서는 이 기능을 사용해야한다.
  - ```th:text``` -> ```th:utext```
  - ```[[...]]``` -> ```[(...)]```

> 보통 필요할때만 unescape를 사용한다.

<br>


### 2.5 SpringEL 
* 타임리프에서 변수를 사용할때는 변수 표현식을 사용한다.
  - **변수 표현식** : ```${...}```

  - **Object(객체)** 
  - model에 ```user```라는 객체가 있다. html에서 사용법
    * ```user.username```  
    * ```user['username']``` 
    * ```user.getUsername()```
  
  - **List(리스트)**
  - model에 ```users``` 라는 list가 있다. html에서 사용법
    * ```users[0]``` : users의 첫번째에 접근
    * ```list.get(0)``` : 위 코드와 같음
  
  - **Map(해쉬)**
  - model에 ```userMap```이라는 Map이 있다. html에서 사용법
    * ```userMap['keyName']```
  
      - **지역변수**
        * ```th:with```를 사용하면 지역변수 사용가능 
        ```html
        <div th:with="지역변수=${users[0]}">
          <p>처음 사람의 이름은 <span th:text="${지역변수.username}"></span></p>
        </div>
        ```


      
