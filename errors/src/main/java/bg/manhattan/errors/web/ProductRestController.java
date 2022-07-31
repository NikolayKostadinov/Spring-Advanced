package bg.manhattan.errors.web;

import bg.manhattan.errors.exceptions.ProductNotFoundException;
import bg.manhattan.errors.model.ApiErrorDTO;
import bg.manhattan.errors.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
        ProductDTO product = getProductDTOById(id);
        if (product == null) {
            throw new ProductNotFoundException(id);
        }

        return ResponseEntity.ok(product);
    }

    private ProductDTO getProductDTOById(Long id) {
        return null;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFoundException.class})
    public @ResponseBody ApiErrorDTO handleRESTErrors(ProductNotFoundException ex){
        return new ApiErrorDTO(ex.getId(), "Product was not found!");
    }
}
