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

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/RFC_body.png">

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

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/RFC72_body.png">

## 표현

* Content-Type
  - 표현 데이터의 형식
  - 미디어 타입, 문자인코딩
  - 예) text/html; charset=utf-8, application/json, image/png
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/computer_science/network/img/content-type.png" width="300">
* Content-Encoding
  - 표현 데이터의 압축 방식
* Content-Language
  - 표현 데이터의 자연 언어
* Content-Length
  - 표현 데이터의 길이

