package pl.coderslab.visitors;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.security.CurrentUser;
import pl.coderslab.security.UserService;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.needs.NeedsRepository;
import pl.coderslab.region.RegionRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(value = " ")
public class VisitorsController {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final NeedsRepository needsRepository;
    private final RegionRepository regionRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;


    public VisitorsController(UserRepository userRepository, CategoryRepository categoryRepository, NeedsRepository needsRepository, RegionRepository regionRepository, BCryptPasswordEncoder passwordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.needsRepository = needsRepository;
        this.regionRepository = regionRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("needs", needsRepository.findAll());
        return "visitors/list";
    }

    @GetMapping("show/{id}")
    public String showUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("regions", regionRepository.findById(id));
        return "visitors/show";
    }

    @GetMapping(value = "/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("regions", regionRepository.findAll());
        return "visitors/add";
    }

    @PostMapping(value = "/add")
    public String add(@Valid User user, @AuthenticationPrincipal CurrentUser currentUser, BindingResult bindingResult) throws ServletException, IOException {
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
        return "redirect:/user/show/";
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

    @GetMapping("/index")
    public String home() {
        return "extras/index";
    }
}
