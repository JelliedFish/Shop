package ru.billing.stocklist;

public enum Category {

    DRESS("DRESS"),
    PRINT("PRINT"),
    FOOD("FOOD"),
    GENERAL("GENERAL");

    private String title;

    Category ( String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Type{"+ this.title +
                "}";
    }
}
