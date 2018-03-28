package org.elsys.P.trip.entity.enums;

public enum BookingStatus {
    CONFIRMED ("CONFIRMED"), NOT_CONFIRMED ("NOT_CONFIRMED)");

    private final String name;

    private BookingStatus (String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    public static BookingStatus stringToBookingSatus (String name) {
        if (name.toLowerCase().equals("confirmed"))
            return BookingStatus.CONFIRMED;

        return BookingStatus.NOT_CONFIRMED;
    }
}
