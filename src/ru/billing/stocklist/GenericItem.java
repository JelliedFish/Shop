package ru.billing.stocklist;


import java.util.Objects;

public class GenericItem implements Cloneable {

    public Long getID () {
        return ID;
    }

    public void setID ( Long ID ) {
        this.ID = ID;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public float getPrice () {
        return price;
    }

    public void setPrice ( float price ) {
        this.price = price;
    }

    public Category getCategory () {
        return category;
    }

    public void setCategory ( Category category ) {
        this.category = category;
    }

    public GenericItem getAnalog () {
        return analog;
    }

    public void setAnalog ( GenericItem analog ) {
        this.analog = analog;
    }

    private Long ID;
    private String name;
    private float price;
    private Category category;
    private GenericItem analog;
    static Long currentID = 0L;


    public GenericItem ( String name, float price, Category category ) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem ( String name, float price, GenericItem analog) {
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(){
        this.name = "Test";
        this.ID = 123L;
    }

    public GenericItem ( Long id, String name, float price, Category category, GenericItem analog ) {
        this.ID = 123L;
        this.name = "Empty";
        this.price = 0.0f;
        this.category = null;
        this.analog = null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return (GenericItem) super.clone();
    }

    public GenericItem deepClone() throws CloneNotSupportedException{
        GenericItem g = (GenericItem) clone();

        if(g.analog != null) {
            g.analog = (GenericItem) g.analog.clone();
            g.analog.analog = g;
        }
        return g;
    }

    public void printAll(){
        System.out.printf("ID: %d , Name: %-10s , Price: %5.2f \n ",ID,name,price);
        System.out.print(category.toString());
        System.out.println();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return Float.compare(that.price, price) == 0 &&
                Objects.equals(ID, that.ID) &&
                Objects.equals(name, that.name) &&
                category == that.category;
    }

    @Override
    public String toString() {
        return "GenericItem{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + category +
                '}';
    }


}
