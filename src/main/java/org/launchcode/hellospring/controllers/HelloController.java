package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.PortUnreachableException;

@Controller
@ResponseBody
//@RequestMapping("hello")
public class HelloController {

//    //Handle requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Handle requests at path /goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handle requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //Handle requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form method='post' action = '/hello'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("lang")
    public String langForm(){
        return "<html>" +
                "<body>" +
                "<form action='/languages' method='get'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='German'>German</option>" +
                "<option value='Esperanto'>Esperanto</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //Handle requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value="languages")
    public String createMessage(@RequestParam String name, @RequestParam String language){
        if(name.isEmpty()){
            name = "world";
        }

        if(language.equals("French")){
            return "Salut, " + name + "!";
        } else if(language.equals("Spanish")){
            return "¡Hola, " + name + "!";
        } else if(language.equals("German")){
            return "Hallo, " + name + "!";
        } else if(language.equals("Esperanto")){
            return "Saluton, " + name + "!";
        } else{
            return "Hello, " + name + "!";
        }

    }


}

