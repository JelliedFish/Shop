package ru.billing.stocklist;

import java.util.Objects;

public class Key {

    String name;
    Category category;
    float price;

    public Key(String name, Category category, float price){
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return Float.compare(key.price, price) == 0 &&
                Objects.equals(name, key.name) &&
                category == key.category;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, category, price);
    }
}
