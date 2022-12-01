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

### 표현(Representation)

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

### [협상(Content negotiation)](https://developer.mozilla.org/ko/docs/Web/HTTP/Content_negotiation)
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
> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/proAccept-Language.png" width="700"><br>
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

## 전송 방식
