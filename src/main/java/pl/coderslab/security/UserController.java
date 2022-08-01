package pl.coderslab.security;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.UserService;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.needs.NeedsRepository;
import pl.coderslab.region.RegionRepository;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final CategoryRepository categoryRepository;
    private final NeedsRepository needsRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserController(UserRepository userRepository, RegionRepository regionRepository, CategoryRepository categoryRepository, NeedsRepository needsRepository, UserService userService, BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.regionRepository = regionRepository;
        this.categoryRepository = categoryRepository;
        this.needsRepository = needsRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("needs", needsRepository.findAll());
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("regions", regionRepository.findAll());
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid User user, BindingResult bindingResult) throws ServletException, IOException {
        User userExist = userService.findByName(user.getName());
        if (userExist != null) {
            bindingResult.rejectValue("name", "error.user", "Istnieje już taki użytkownik");
            return "/add";
        }
        if (bindingResult.hasErrors()) {
            return "/add";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return "redirect:/user/show/" + save.getId();
    }

    @GetMapping("show/{id}")
    public String showUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("regions", regionRepository.findById(id));
        return "user/show";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("regions", regionRepository.findAll());
        return "user/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        userRepository.save(user);
        return "user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "user/list";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setName("MartaUser");
        user.setPassword("MartaUser123");
        userService.saveUser(user);
        return "user";
    }
}

