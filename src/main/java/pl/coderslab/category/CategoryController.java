package pl.coderslab.category;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
//@Secured("ROLE_ADMIN")
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
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String AddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/add_category";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
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
