package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * Created by svarpe on 21.09.17.
 */
@RestController
@RequestMapping("/user")
public class UserController {


   private  RedisOperationsSessionRepository redisOperationsSessionRepository;

   @Autowired
    public UserController(RedisOperationsSessionRepository redisOperationsSessionRepository) {
        this.redisOperationsSessionRepository = redisOperationsSessionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Principal principal) {
        return "Hallo from User Service to " + principal.getName();
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public void logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
            String sessionid = RequestContextHolder.currentRequestAttributes().getSessionId();
            redisOperationsSessionRepository.delete(sessionid);
        }
    }

}
