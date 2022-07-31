package bg.manhattan.errors.web;

import bg.manhattan.errors.exceptions.ObjectNotFoundException;
import bg.manhattan.errors.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice()
public class ObjectNotFoundAdvise {

    @ExceptionHandler({ObjectNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView productNotFoundExceptionHandler(ObjectNotFoundException onf) {
        ModelAndView modelAndView = new ModelAndView("object-not-found");
        modelAndView.addObject("productId", onf.getId());

        return modelAndView;
    }
}
