package pl.coderslab.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("user/category")
@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public String showCategories(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "all_category";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "add_category";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_category";
        }
        categoryRepository.save(category);
        return "redirect: list";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
        return "redirect:user/category/list";
    }
}
