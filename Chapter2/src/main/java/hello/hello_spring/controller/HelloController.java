package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 웹 어플리케이션에서 /hello가 들어오면 이 메서드를 호출해준다
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    // 웹 어플리케이션에서 /hello-mvc가 들어오면 이 메서드를 호출
    @GetMapping("hello-mvc")
    // name을 받고, view로 데이터를 넘겨야 하니 Model 사용
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // view에 name에 name이라는 데이터를 전달
        model.addAttribute("name", name);
        // hello-template라는 이름의 뷰를 반환
        return "hello-template";
    }

    @GetMapping("hello-string")
    // ResponseBody는 http의 body에 데이터를 직접 넣어주겠다는 애너테이션
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello " + name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
