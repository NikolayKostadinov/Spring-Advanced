package bg.manhattan.errors.web;

import bg.manhattan.errors.model.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/products")
@Controller
public class ProductController {

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        ProductDto product = getProductDTOById(id);
        return "product";
    }

    private ProductDto getProductDTOById(Long id){
        return null;
    }
}
