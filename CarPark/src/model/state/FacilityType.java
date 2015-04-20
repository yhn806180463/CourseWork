package model.state;

public enum FacilityType {
    Entrance("Entrance"), Exit("Exit"), PayStation("PayStation"), Space("Space");

    private String value;

    private FacilityType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
