package pl.coderslab.region;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/region")
public class RegionController {

    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("region", regionRepository.findAll());
        return "region/all_region";
    }

    @GetMapping(value = "/add")
    public String AddRegion(Model model) {
        model.addAttribute("region", new Region());
        return "region/add_region";
    }

    @PostMapping(value = "/add")
    public String saveRegion(@Valid Region region, BindingResult result) {
        if (result.hasErrors()) {
            return "region/add_region";
        }
        regionRepository.save(region);
        return "redirect:/admin/region/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteRegion(@PathVariable long id) {
        regionRepository.deleteById(id);
        return "redirect:/admin/region/list";
    }
}
