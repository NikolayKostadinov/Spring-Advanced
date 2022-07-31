package bg.manhattan.errors.web;

import bg.manhattan.errors.exceptions.ObjectNotFoundException;
import bg.manhattan.errors.model.CategoryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Long id, Model model) {
        CategoryDTO product = getCategoryDTOById(id);
        if (product == null) {
            throw new ObjectNotFoundException(id);
        }
        model.addAttribute("name", product.getName());
        return "product";
    }

    private CategoryDTO getCategoryDTOById(Long id) {
        return null;
    }

//    @ExceptionHandler({ObjectNotFoundException.class})
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public ModelAndView productNotFoundExceptionHandler(ProductNotFoundException pnfe) {
//        ModelAndView modelAndView = new ModelAndView("object-not-found");
//        modelAndView.addObject("categoryId", pnfe.getId());
//
//        return modelAndView;
//    }
}
