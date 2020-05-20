package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

public  class FoodItem extends GenericItem {

    private Date dateOfIncome;
    private short expires;

    public Date getDateOfIncome () {
        return dateOfIncome;
    }

    public void setDateOfIncome ( Date dateOfIncome ) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires () {
        return expires;
    }

    public void setExpires ( short expires ) {
        this.expires = expires;
    }

    @Override
    public FoodItem getAnalog () {
        return analog;
    }

    public void setAnalog ( FoodItem analog ) {
        this.analog = analog;
    }

    private FoodItem analog;



    public FoodItem(String name, float price, Category category, Date dateOfIncome, short expires, FoodItem analog) {
        super(name = "Default", price = 0.0f, category = Category.valueOf("GENERAL"));
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
        this.analog = analog;
    }



    public FoodItem ( String name, float price, short expires ) {
        super(name,price, (GenericItem) null);
        this.expires = expires;
    }

    public FoodItem ( String name) {
        super(name,0.0f,(GenericItem) null);
    }

    @Override
    public void printAll(){

        System.out.printf("ID: %d , Name: %-10s , Price: %5.2f \n ",super.getID(),super.getName(),super.getPrice());
        System.out.print(super.getCategory().toString());
        System.out.println(dateOfIncome.toString());
        System.out.print(expires);

    }


    @Override
    public String toString() {
        return "FoodItem{" +
                "dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                ", ID=" + super.getID()+
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", type=" + super.getCategory() +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }


}
