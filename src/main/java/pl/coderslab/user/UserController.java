package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.region.Region;
import pl.coderslab.region.RegionRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;

    public UserController(UserRepository userRepository, RegionRepository regionRepository) {
        this.userRepository = userRepository;
        this.regionRepository = regionRepository;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("regions", regionRepository.findAll());
        return "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/add";
        }
        userRepository.save(user);
        return "redirect:list";
    }

    @GetMapping("/show/{id}")
    public String showUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("regions", regionRepository.findById(id));
        return "/show";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("regions", regionRepository.findAll());
        return "/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit";
        }
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }
//
//    @ModelAttribute("region")
//    public Collection<Region> regions() {
//        return this.regionRepository.getList();
//    }
}
