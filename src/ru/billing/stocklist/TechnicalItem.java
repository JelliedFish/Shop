package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {

    public short getWarrantyTime () {
        return warrantyTime;
    }

    public void setWarrantyTime ( short warrantyTime ) {
        this.warrantyTime = warrantyTime;
    }

    private short warrantyTime;

    public TechnicalItem( Long id, String name, float price, Category category, short warrantyTime, GenericItem analog) {
       super(id, name, price, category,analog);
        this.warrantyTime = warrantyTime;
    }

    @Override
    public void printAll(){

        //TODO: call super
        super.printAll();
        System.out.print(super.getCategory().toString());
        System.out.print(warrantyTime);

    }

    @Override
    public String toString() {
        return "TechnicalItem{" +
                "warrantyTime=" + warrantyTime +
                ", ID=" + super.getID() +
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
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

}

