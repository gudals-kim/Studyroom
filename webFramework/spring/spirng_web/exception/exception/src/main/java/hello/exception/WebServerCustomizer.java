package hello.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        //404 에러가 나오면 /error-page/400 url의 컨트롤러를 호출해라
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");
        // runtimeEx의 자식들도 적용된다.
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/error-page/500");


        factory.addErrorPages(errorPage404,errorPage500,errorPageEx);
    }
}
