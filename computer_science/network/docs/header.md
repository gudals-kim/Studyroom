# HTTP 헤더

## HTTP 헤더 용도
* HTTP 전송에 필요한 모든 부가 정보를 담는다.
    - 예) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리정보...

## HTTP 스펙
### [RFC2616](https://developer.mozilla.org/ko/docs/web/http/messages)
- 현재 사용하지 않는 분류체계

* 헤더 분류
    - General 헤더 
      * 메시지 전체에 적용되는 정보
      * 예) Connection: close
    - Request 헤더 
      * 요청 정보 
      * 예) User-Ahent: Mozilla/5.0(Macintosh;..)
    - Response 헤더 
      * 응답 정보
      * 예) Server: Apache
    - Entity 헤더
      * 엔티티 본문(entity body) 정보
      * 예) Content-Type:text/html,Content-Length:3423

* 바디 
    - message body(메시지 본문)은 entity body(엔티티 본문)을 전달 하는데 사용함
    - 엔티티 본문은 요청이나 응답에서 전달할 실제 데이터
    - 엔티티 헤더는 엔티티 본문의 데이터를 해석할 수 있는 정보 제공
      - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/RFC_body.png" width="400">

### [RFC7230~7235](https://www.rfc-editor.org/rfc/pdfrfc/rfc7235.txt.pdf)

* 엔티티(Entity)가 사라지고 표현(Representation)이라는 개념이 등장했다.
  - Representation = Representation Metadata + Representation Data
  - 즉, **표현은 표현 메타데이터와 표현 데이터로 이루어**져있다.

* 바디
    - 메시지 본문(message body)를 통해 표현 데이터 전달
    - 메시지 본문 = 페이로드(payload)
    - 표현은 요청이나 응답에서 전달할 실제 데이터
    - 표현 헤더는 표현 데이터를 해석할 수 있는 정보제공
      - 데이터 유형(html, json), 데이터 길이, 압축 정보 등등
    
    ~~참고: 표현 헤더는 표현 메타데이터와 페이로드 메시지를 구분해야하지만 여기선 구분하지 않음~~

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/RFC72_body.png" width="400">

---

## 표현(Representation) 헤더

* Content-Type
  - 표현 데이터의 형식
  - 미디어 타입, 문자인코딩
  - 예) text/html; charset=utf-8, application/json, image/png
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/content-type.png" width="300">
* Content-Encoding
  - 표현 데이터의 압축 방식
  - 데이터를 전달하는 곳에서 압축 후 인코딩 헤더를 추가함
  - 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축해제한다.
  - 예) gzip,deflate,identity
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/content-encoding.png" width="300">
* Content-Language
  - 표현 데이터의 자연 언어
  - 예) ko, en, en-US
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/content-Lang.png" width="300">
* Content-Length
  - 표현 데이터의 길이
  - 바이트(byte) 단위
  - Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 안된다.
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/content-length.png" width="300">
  
---
  
## [협상(Content negotiation) 헤더](https://developer.mozilla.org/ko/docs/Web/HTTP/Content_negotiation)
> 클라이언트가 선호하는 표현(Representation) 요청 <br>
> 협상 헤더는 요청시에만 사용한다.

* Accept
  - 클라이언트가 선호하는 미디어 타입 전달
* Accept-Charset
  * 클라이언트가 선호하는 문자 인코딩 전달
* Accept-Encoding
  * 클라이언트가 선호하는 압축 인코딩 전달
* Accept-language
  * 클라이언트가 선호하는 자연 언어
  
> Accept-Language 적용전<br>
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/preAccept-Language.png" width="700"><br>
> Accept-Language가 적용이 안된다면 웹 서버는 오로지 서버에 기본 설정된 언어로만 응답을 보낸다.

> Accept-Language 적용후 <br>
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/proAccept-language.png" width="700"><br>
> Accept-Language가 적용 된다면 한국으로 국가가 설정된 브라우저는 ko 언어 요청할 것이고 다중 언어 웹서버는 언어 우선순위에 따라서 응답을 보낸다.

#### 우선순위(Quality Values)
* Qurality Values(q) 값을 사용한다.
* 0~1, 클수록 높은 우선순위 이다.
  * 생략하면 1이 기본값으로 적용된다.
  * 예) Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
    1. ko-KR;(q 생략)
    2. ko;q=0.9
    3. en-US;q=0.8
    4. en;q=0.7
* 구체적인 것인 우선이다.
  * 예) Accept: text/\*, text/plain,text/plain;format=flowed,\*/*
    1. text/plain;format=flowed
    2. test/plain
    3. text/*
    4. \*/*
* 구체적인 것을 기준으로 미디어 타입을 맞춘다.
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/qualityValues.png" width="300"><br>

---

## 전송 방식 헤더

### 1. 단순 전송

단순 전송은 단순히 요청을 하면 응답을 준다. 단, content-Length를 지정해서 전송한다.<br>
즉, 컨텐츠의 길이를 정확하게 알 수 있을때 사용된다.
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/simplePass.png" width="700"><br>

### 2. 압축전송
컨텐츠의 길이를 gzip 같은 것으로 압축해서 보낸다.<br>
단, 압축전송을 할 시, 헤더에 "Content-Encoding: " 정보를 꼭 기입해주어야 한다. 
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/encodingPass.png" width="700"><br>

### 3. 분할전송
말 그대로 분할해서 보낸다.<br>
5byte Hello 를 보낸 후 서버에서 5byte world가 준비되면 또 보낸다. 결국 마지막엔 0 byte \r\n 으로 기입하면 끝이라고 받아드린다.<br>
헤더 정보에 Transfer-Encoding 정보를 기입해야한다. 단, Content-length를 기입해서는 안된다.
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/chunkPass.png" width="700"><br>

### 4. 범위전송
클리이언트 측에서 지정한 범위만큼 보낸다.
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/rangePass.png" width="700"><br>

---

## 정보 헤더

### 1. from
**유저 에이전트의 이메일 정보**
* 일반적으로 잘 사용되지않는다.
* 검색 엔진 같은 곳에서, 주로 사용된다.
* 요청에서 사용한다.

### 2. Referer
**이전 웹 페이지 주소**
* 매우 자주 쓰인다.
* 현재 요청된 페이지의 이전 웹 페이지 주소
* A->B로 이동하는 경우 B를 요청할 때 Referer: A를 포함해서 요청한다.
* Referer를 사용해서 유입 경로 분석이 가능하다
* 요청에서 사용된다

### 3. User-Agent
**유저 에이전트 애플리케이션 정보**
> user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36
* 클라이언트의 애플리케이션 정보(웹 브라우저 정보, OS정보 등등)
* 통계 정보
* 어떤 종류의 브라우저에서 장애가 발생했는지 파악 가능
* 요청에서 사용된다.

### 4. Server
**요청을 처리하는 ORIGIN 서버의 소프트웨어 정보**
>server: Testa/6.1.1<br>
>server: Apache/2.2.2.2<br>
>server: nginx
* 응답에서 사용된다.

### 5. Date
**메시지가 발생한 날짜와 시간**
> date: Fri, 02 Dec 2022 05:12:34 GMT
* 응답에서 사용된다.

### 6. Host
**요청한 호스트 정보**
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/hostHeader.png" width="400"><br>
* **필수값 헤더**
* 하나의 서버가 여러 도메인을 처리해야 할 때
* 하나의 IP 주소에 여러 도메인이 적용되어 있을 때
* 요청에서 사용된다.

### 7. Location
**페이지 리다이렉션**
* 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 리다이렉트 한다.

### 8. Allow
**허용가능한 HTTP메서드**
> Allow: GET, HEAD, PUT
* 405 (Method Not Allowed) 에서 응답에 포함해야한다.

### 9. Retry-After
**유저 에이전트가 다음 요청을 하기까지 기다려야하는 시간**
> Retry-After: Fri, 31 Dec 1999 23:59:59 GMT(날짜로 표기)<br>
> Retry-After: 120(초단위로 표기)<br>
* 503(service Unavailable): 서비스가 언제까지 불능인지 알려줄 수 있는 오류일때 

---

## 인증 헤더

### 1. Authorization 
**클라이언트 인증 정보를 서버에 전달**
> Authorization: basic xxxxxxxx

### 2. www-Authentication
**리소스 접근시 필요한 인증 방법 정의**
> www-Authenticate: Newauth realm="app", type=1, title="Login to\"apps\"",Basic realm="simple"<br>
* 401 Unauthorized 에러가 날때 응답에 포함해야한다.

---

## 쿠키(Cookie) 헤더

쿠키를 사용하는 이유는 HTTP가 기본적으로 Stateless 프로토콜이기 때문이다.
- stateless
  - 클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어진다.
  - 클라이언트가 다시 요청하면 서버는 이전 요청을 기억하지 못한다.
  - 클라이언트와 서버는 서로 상태를 유지하지 않는다.

> 쿠기를 사용하지 않는다면, 로그인 프로세스가 끝나고 다시 웹에 접근했을때, 서버는 이 사람이 로그인한 클라이언트인지 아닌지 판단을 할 수 없다.<br>

### 쿠키 로그인 프로세스

> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/cookieLogin.png" width="700"><br>

1. 웹 브라우저에서 post로 로그인 요청한다.
2. 서버에서 로그인 정보를 set-Cookie 헤더로 응답한다.
3. 이후 웹 브라우저의 쿠키저장소에 로그인 정보를 저장한다.
4. 이후 클라이언트가 서버에 요청할때 웹브라우저가 쿠키저장소에서 쿠키를 찾아서 헤더를 포함시켜준다.

### Cookie 란?
> set-cookie: sessionld=abcde1234; expires=Sat, 26-Dec-2020 00:00:00 GTM; path=/; domain=.google.com;Secure<br>
* 사용처
  * 사용자 로그인 세션 관리
  * 광고 정보 트래킹
* [주의] 쿠키 정보는 항상 서버에 전송된다.
  * 네트워크 트래픽 추가 유발
  * 최소한의 정보만 사용
  * 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 [웹 스토리지]()를 참고한다.
- [주의] 보안에 민감한 데이터 쿠키에 저장하면 안된다(주민번호, 신용카드 번호 등)

#### 쿠키 생명주기
**Expires, Max-age**
* Expires는 만료일이 되면 쿠키가 삭제된다.
> set-cookie: expires=Sat, 26-Dec-2020 00:00:00 GTM;
* max-age는 초단위 카운터이다.
> set-cookie: max-age=3600;
* 세션 쿠키 : 만료 날짜를 생략하면 브라우저 종료시 까지만 유지된다.
* 영속 쿠키 : 만료 날짜를 입력하면 해당 날짜까지 유지된다.

#### 쿠키 도메인
**Domain 쿠키를 접근할 수 잇는 도메인**
> domain=example.org
* 명시할 경우 : 문서 기준 도메인 + 서브 도마인까지 포함
  * example.org 쿠키접근 가능
  * dev.example.org 쿠키접근 가능
* 생략 할 경우 : 현재 문서 기준 도메인만 적용된다.
  * example.org 쿠키접근 가능
  * dev.example.org 쿠키접근 불가능

#### 쿠키 경로
**이 경로를 포함한 하위경로 페이지만 쿠키 접근가능**
>path=/home
* 일반적으로 path=/ 루트로 지정한다.

#### 쿠키 보안
* Secure
  * 쿠키는 http, https를 구분하지 않고 전송
  * Secure를 적용하면 https인 경우에만 전송한다.
* HttpOnly
  * XSS 공격 방지
  * 자바스크립트에서 접근 불가(document.cookie)
  * HTTP 전송에만 사용
* SameSite
  * XSRF 공격 방지
  * 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키를 전송한다.

---