package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {

    public HashMap<Long, GenericItem> getCatalog () {
        return catalog;
    }

    public void setCatalog ( HashMap<Long, GenericItem> catalog ) {
        this.catalog = catalog;
    }

    public ArrayList<GenericItem> getALcatalog () {
        return ALcatalog;
    }

    public void setALcatalog ( ArrayList<GenericItem> ALcatalog ) {
        this.ALcatalog = ALcatalog;
    }

        private HashMap<Long,GenericItem> catalog = new HashMap<Long, GenericItem>();
        private ArrayList<GenericItem> ALcatalog = new ArrayList<GenericItem>();


        public void addItem(GenericItem item) {
            catalog.put(item.getID(),item);
            ALcatalog.add(item);
        }

        public void printItems() {
            for (GenericItem i : ALcatalog) {
                System.out.println(i.toString());
            }
        }
//findItemBy(Name ; Category; Price;)
//вернет все совпадения
//максимально быстро
//
        public GenericItem findItemByID(long id){
            return catalog.getOrDefault(id, null);
        }

        public GenericItem findItemByIDAL(long id){

                for(GenericItem i: ALcatalog){

                    if(i.getID() == id){
                        return i;
                    }
                }
                return null;
        }


}
