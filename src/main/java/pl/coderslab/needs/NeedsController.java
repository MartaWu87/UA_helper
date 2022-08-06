package pl.coderslab.needs;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.CurrentUser;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.security.UserRepository;

import javax.validation.Valid;

@RequestMapping(value = "user/needs")
@Controller
public class NeedsController {
    private final NeedsRepository needsRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public NeedsController(NeedsRepository needsRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.needsRepository = needsRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }
//    @GetMapping("/all")
//    public String showNeeds(Model model) {
//        model.addAttribute("needs", needsRepository.findByUserId(user.getId())); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Po security
//        model.addAttribute("category", categoryRepository.findAll());
//        return "needs/needs";
//    }
//    @GetMapping("/list")
//    public String showAllNeeds(Model model) {
//        model.addAttribute("needs", needsRepository.findAll());
//        model.addAttribute("category", categoryRepository.findAll());
//        return "needs/needs";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdddForm(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("needs", new Needs());
        model.addAttribute("category", categoryRepository.findAll());
        return "needs/add_needs";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNeeds(@Valid Needs needs, @AuthenticationPrincipal CurrentUser currentUser, BindingResult result) {
        if (result.hasErrors()) {
            return "needs/add_needs";
        }
        needs.setUser(currentUser.getUser());
        needsRepository.save(needs);
        return "redirect:/user/show";
    }

    @GetMapping("/show")
    public String showNeeds(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("needs", needsRepository.findAllByUserId(currentUser.getUser().getId()));
        model.addAttribute("category", categoryRepository.findById(currentUser.getUser().getId()));
        return "needs/show_needs";
    }

    @GetMapping("/delete/{id}")
    public String deleteNeeds(@PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser) {
        needsRepository.deleteById(id);
        return "redirect:/user/needs/show";
    }
}



