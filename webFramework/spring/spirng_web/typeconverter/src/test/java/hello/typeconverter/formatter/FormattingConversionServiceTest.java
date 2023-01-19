package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {
    @Test
    void formattingConversionService(){
        //DefaultConversionService 의 자식이다.
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //컨버터 등록
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        //포메터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용 및 검증
        assertThat(conversionService.convert("127.0.0.1:8000", IpPort.class).getClass()).isEqualTo(IpPort.class);
        //포메터 사용 및 검증
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);
    }
}
