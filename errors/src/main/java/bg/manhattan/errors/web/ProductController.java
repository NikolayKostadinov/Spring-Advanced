package bg.manhattan.errors.web;

import bg.manhattan.errors.exceptions.ObjectNotFoundException;
import bg.manhattan.errors.exceptions.ProductNotFoundException;
import bg.manhattan.errors.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        ProductDTO product = getProductDTOById(id);
//        if (product == null) {
//            throw new ProductNotFoundException(id);
//        }
        if (product == null) {
            throw new ObjectNotFoundException(id);
        }
        model.addAttribute("name", product.getName());
        return "product";
    }

    private ProductDTO getProductDTOById(Long id) {
        return null;
    }

//    @ExceptionHandler({ProductNotFoundException.class})
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public ModelAndView productNotFoundExceptionHandler(ProductNotFoundException pnfe) {
//        ModelAndView modelAndView = new ModelAndView("product-not-found");
//        modelAndView.addObject("productId", pnfe.getId());
//
//        return modelAndView;
//    }
}
