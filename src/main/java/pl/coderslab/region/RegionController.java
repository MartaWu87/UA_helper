package pl.coderslab.region;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/region")
public class RegionController {

    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping("/list")
    public String showPosts(Model model) {
        model.addAttribute("region", regionRepository.findAll());
        return "all_region";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String AddRegion(Model model) {
        model.addAttribute("region", new Region());
        return "add_region";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveRegion(@Valid Region region, BindingResult result) {
        if (result.hasErrors()) {
            return "add_region";
        }
        regionRepository.save(region);
        return "redirect:/region/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteRegion(@PathVariable long id) {
        regionRepository.deleteById(id);
        return "redirect:/region/list";
    }
}
