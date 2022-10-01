package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter @Setter
public class ModelView {
    private String viewName; //상대경로
    private Map<String , Object> model = new HashMap<>(); //상대 경로 넣으면 object인데

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

}
