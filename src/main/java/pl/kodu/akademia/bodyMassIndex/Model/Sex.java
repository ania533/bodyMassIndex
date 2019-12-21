package pl.kodu.akademia.bodyMassIndex.Model;

public enum Sex {
    FEMALE("Female"),
    MALE("Male");

    private String description;

    Sex(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
