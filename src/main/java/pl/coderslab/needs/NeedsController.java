package pl.coderslab.needs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.category.Category;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;
@RequestMapping(value = "/needs")
@Controller
public class NeedsController {
    private final NeedsRepository needsRepository;
    private final UserRepository userRepository;

    public NeedsController(NeedsRepository needsRepository, UserRepository userRepository) {
        this.needsRepository = needsRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/all")
    public String showNeeds(Model model) {
        model.addAttribute("needs", needsRepository.findAll());
        return "/needs";
    }

    @RequestMapping(value = "user/add", method = RequestMethod.GET)
    public String showAdddForm(Model model) {
        model.addAttribute("needs", new Needs());
        return "add_needs";
    }

    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public String saveNeeds(@Valid Needs needs, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:add_needs";
        }
        needsRepository.save(needs);
        return "show_needs";
    }

    @GetMapping("/show/{id}")
    public String showNeeds(Model model, @PathVariable long id) {
        model.addAttribute("needs", needsRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        return "/show_needs";
    }

    @GetMapping("/delete/{id}")
    public String deleteNeeds(@PathVariable long id) {
        needsRepository.deleteById(id);
        return "redirect:admin/needs/list";
    }
}



