package bg.manhattan.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class TestController {

    @GetMapping("/npe")
    public String testNPE(){
        if (true){
            throw new NullPointerException("NPE");
        }
        return "test";
    }
}
