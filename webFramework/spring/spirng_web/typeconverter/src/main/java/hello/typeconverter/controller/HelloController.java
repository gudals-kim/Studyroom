package hello.typeconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    /**
     * 서블릿을 사용할때는 파라미터가 스트링으로 넘어오기 때문에
     * 타입변환을 자주 했어야함.
     */
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data");//문자 타입 조회
        Integer intValue = Integer.valueOf(data);//숫자 타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }


    /**
     * 스프링에서는 파라미터를 알아서 타입 변경을 해서 가져온다.
     */
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok";
    }



}
