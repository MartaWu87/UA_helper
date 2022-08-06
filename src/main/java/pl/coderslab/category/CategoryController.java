package pl.coderslab.category;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public String showCategories(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "category/all_category";
    }

    @GetMapping(value = "/add")
    public String AddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/add_category";
    }

    @PostMapping(value = "/add")
    public String saveCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add_category";
        }
        categoryRepository.save(category);
        return "redirect:/admin/category/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
        return "redirect:/admin/category/all";
    }
}
