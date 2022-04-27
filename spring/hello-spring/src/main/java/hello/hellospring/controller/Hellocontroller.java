package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// MVC : Model , View , Controller
// jsp -> model 1 방식
// MVC -> model 2

@Controller
public class Hellocontroller {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Hello!!");
        // template 에 hello.html 에 찾아서 thmeleaf 엔진이 처리
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //html 응답 body 부분에 값을 넣어줌
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    // json 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }
}
