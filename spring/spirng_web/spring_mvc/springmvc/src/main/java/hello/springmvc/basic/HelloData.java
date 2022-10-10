package hello.springmvc.basic;

import lombok.Data;

/**
 * @Data는
 * getter, setter, ToString, EqualAndHashCode, @RequiredArgsConstructor 를 자동 등록해준다.
 */

@Data
public class HelloData {

    private String username;
    private int age;
}
