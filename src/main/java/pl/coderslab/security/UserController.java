package pl.coderslab.security;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.CurrentUser;
import pl.coderslab.UserService;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.needs.NeedsRepository;
import pl.coderslab.region.RegionRepository;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final CategoryRepository categoryRepository;
    private final NeedsRepository needsRepository;
//    private final UserService userService;
//    private final BCryptPasswordEncoder passwordEncoder;


    public UserController(UserRepository userRepository, RegionRepository regionRepository, CategoryRepository categoryRepository, NeedsRepository needsRepository, UserService userService, BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.regionRepository = regionRepository;
        this.categoryRepository = categoryRepository;
        this.needsRepository = needsRepository;
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("needs", needsRepository.findAll());
        return "user/list";
    }



    @GetMapping("show/{id}")//id usera!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String showUser(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userRepository.findById(currentUser.getUser().getId()).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("regions", regionRepository.findById(id));
        return "user/show";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)//id usera!!!!!!!!!!!!!!!!!!!!!
    public String showEditForm(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userRepository.findById(currentUser.getUser().getId()));
        model.addAttribute("regions", regionRepository.findAll());
        return "user/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        userRepository.save(user);
        return "user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser) {
        userRepository.deleteById(currentUser.getUser().getId());
        return "user/list";
    }


}

