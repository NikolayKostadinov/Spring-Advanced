package bg.manhattan.hateoas.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private boolean deleted;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Order> orders;

}
