package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
/**
 * Integer to String converter
 */
@Slf4j
public class IntegerToStringConverter implements Converter<Integer, String> {
    @Override
    public String convert(Integer source) {
        log.info("IntegerToStringConverter source = {}", source);
        return String.valueOf(source);
    }
}
