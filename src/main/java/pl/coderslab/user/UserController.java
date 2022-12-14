package pl.coderslab.user;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.security.CurrentUser;
import pl.coderslab.security.UserService;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.needs.NeedsRepository;
import pl.coderslab.region.RegionRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final CategoryRepository categoryRepository;
    private final NeedsRepository needsRepository;

    public UserController(UserRepository userRepository, RegionRepository regionRepository, CategoryRepository categoryRepository, NeedsRepository needsRepository, UserService userService, BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.regionRepository = regionRepository;
        this.categoryRepository = categoryRepository;
        this.needsRepository = needsRepository;
    }

    @GetMapping("/show")
    public String showUser(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userRepository.findById(currentUser.getUser().getId()).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("regions", regionRepository.findById(1));
        return "user/show";
    }


    @GetMapping(value = "/edit")
    public String showEditForm(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userRepository.findById(currentUser.getUser().getId()));
        model.addAttribute("regions", regionRepository.findAll());
        return "user/edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@Valid User user, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        userRepository.save(user);
        return "user/show";
    }

    @GetMapping("/delete")
    public String deleteUser(@AuthenticationPrincipal CurrentUser currentUser) {
        userRepository.deleteById(currentUser.getUser().getId());
        return "user/list";
    }
}

