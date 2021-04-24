package xyz.klopina.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname );

        return "first/hello";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", defaultValue = "10") int a,
                             @RequestParam(value = "b", defaultValue = "2") int b,
                             @RequestParam(value = "action", defaultValue = "division") String action,
                             Model model)
    {
       int tmp = 0;
        switch (action){
            case "multiplication": tmp = a * b;
            break;
            case "addition": tmp = a + b;
            break;
            case "subtraction": tmp = a - b;
            break;
            case "division": tmp = a / b;
        }
        model.addAttribute("result", "" + tmp);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
