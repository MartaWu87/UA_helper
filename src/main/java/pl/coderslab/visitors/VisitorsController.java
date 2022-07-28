package pl.coderslab.visitors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.needs.NeedsRepository;
import pl.coderslab.region.RegionRepository;
import pl.coderslab.security.UserRepository;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping(value = " ")
public class VisitorsController {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final NeedsRepository needsRepository;
    private final RegionRepository regionRepository;

    public VisitorsController(UserRepository userRepository, CategoryRepository categoryRepository, NeedsRepository needsRepository, RegionRepository regionRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.needsRepository = needsRepository;
        this.regionRepository = regionRepository;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("needs", needsRepository.findAll());
        return "visitors/list";
    }
    @GetMapping("/show/{id}")
    public String showUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("regions", regionRepository.findById(id));
        return "visitors/show";
    }
    @GetMapping("/index")
    public String home(){
        return "extras/index";
    }
}
