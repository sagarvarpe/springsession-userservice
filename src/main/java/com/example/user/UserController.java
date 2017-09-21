package com.example.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by svarpe on 21.09.17.
 */
@RestController("user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "Hallo";
    }
}
