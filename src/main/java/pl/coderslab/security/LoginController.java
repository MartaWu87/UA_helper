package pl.coderslab.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping(value = {"/login"})
    public String login() {
        return "extras/login";
    }

    @GetMapping(value = {"/logout"})
    public String logout() {
        return "extras/logout";
    }
}
