package bg.manhattan.errors.model;

import java.math.BigDecimal;

public class CategoryDTO {
    private final String name;
    private final BigDecimal price;

    public CategoryDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
