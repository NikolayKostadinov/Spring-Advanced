package bg.manhattan.hateoas.web;

import bg.manhattan.hateoas.model.dto.StudentDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/students")
@RestController
public class StudentController {
    @GetMapping
    public ResponseEntity<EntityModel<StudentDTO>> getStudentById(@PathVariable("id") Long id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> updateStudent(@PathVariable("id") Long id, StudentDTO studentDTO) {
        throw new UnsupportedOperationException();
    }
}
