package bg.manhattan.errors.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private final Long id;

    public ObjectNotFoundException(Long objectId) {
        this.id = objectId;
    }

    public Long getId() {
        return id;
    }
}
