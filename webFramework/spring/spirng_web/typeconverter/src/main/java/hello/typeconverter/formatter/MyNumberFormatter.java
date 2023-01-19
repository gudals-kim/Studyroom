package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * 포맷터 - Formatter 만들기
 * 포맷터( Formatter )는 객체를 문자로 변경하고, 문자를 객체로 변경하는 두 가지 기능을 모두 수행한다.
 * String print(T object, Locale locale) : 객체를 문자로 변경한다.
 * T parse(String text, Locale locale) : 문자를 객체로 변경한다.
 */
@Slf4j
public class MyNumberFormatter implements Formatter<Number>{
    /**
     * parse() 를 사용해서 문자를 숫자로 변환한다. 참고로 Number 타입은 Integer , Long 과 같은 숫자 타입의 부모 클래스이다.
     */
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}",text,locale);
        //"1,000" -> 1000
        return NumberFormat.getInstance(locale).parse(text);
    }

    /**
     * print() 를 사용해서 객체를 문자로 변환한다.
     */
    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
