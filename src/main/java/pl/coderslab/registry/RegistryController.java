package pl.coderslab.registry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistryController {
//
//    private final UserRepository userRepository;
//
//    public RegistryController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//        @RequestMapping(value = "/register", method = RequestMethod.GET)
//        public ModelAndView showRegister() {
//            ModelAndView mav = new ModelAndView("register");
//            mav.addObject("user", new User());
//
//            return mav;
//        }
//
//        @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
//        public ModelAndView addUser(@ModelAttribute("user") User user) {
//
//            userRepository.register(user);
//
//            return new ModelAndView("welcome", "firstname", user.getFirstname());
//        }
//    }
//    }
}
