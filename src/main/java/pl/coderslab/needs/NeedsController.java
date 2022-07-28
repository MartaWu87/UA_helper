package pl.coderslab.needs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.security.UserRepository;

import javax.persistence.EntityNotFoundException;
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
//        model.addAttribute("needs", needsRepository.findByUserId());
//        model.addAttribute("category", categoryRepository.findAll());
//        return "needs/needs";
//    }
    @GetMapping("/list")
    public String showAllNeeds(Model model) {
        model.addAttribute("needs", needsRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        return "needs/needs";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdddForm(Model model) {
        model.addAttribute("needs", new Needs());
        model.addAttribute("category", categoryRepository.findAll());
        return "needs/add_needs";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNeeds(@Valid Needs needs, BindingResult result) {
        if (result.hasErrors()) {
            return "needs/add_needs";
        }
        needsRepository.save(needs);
        return "needs/show_needs";
    }

    @GetMapping("/show/{id}")
    public String showNeeds(Model model, @PathVariable long id) {
        model.addAttribute("needs", needsRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("category", categoryRepository.findAll());
        return "needs/show_needs";
    }

    @GetMapping("/delete/{id}")
    public String deleteNeeds(@PathVariable long id) {
        needsRepository.deleteById(id);
        return "redirect:/needs/all";
    }
}



