package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ItemCatalogFast {

    public class ItemCatalog {


        public HashMap<Integer,  HashMap<Long,GenericItem>> getCatalog () {
            return catalog;
        }

        public void setCatalog (HashMap<Integer, HashMap<Long,GenericItem>> catalog ) {
            this.catalog = catalog;
        }

        public HashMap<Long, GenericItem> getCatalogForID () {
            return catalogForID;
        }

        public void setCatalogForID ( HashMap<Long, GenericItem> catalogForID ) {
            this.catalogForID = catalogForID;
        }

        private HashMap<Integer,HashMap<Long,GenericItem>> catalog = new HashMap<Integer, HashMap<Long,GenericItem>>(); //для хранения больше одного объекта


        private HashMap<Long,GenericItem> catalogForID = new HashMap<Long,GenericItem>(); //для поиска одного по ID - коллизий быть не может

        public void addItem(GenericItem item) {
    //хэшируем по price+category+name  - кладем по этому хэшу - потом кладем по ID - O(1)
            HashMap<Long,GenericItem>  cur;
           if( catalog.get(new Key(item.getName(),item.getCategory(),item.getPrice()).hashCode()) != null) {
              cur = catalog.get(new Key(item.getName(),item.getCategory(),item.getPrice()).hashCode());
           }

           else {
                cur = new  HashMap<Long,GenericItem>();
           }


            catalog.put(new Key(item.getName(),item.getCategory(),item.getPrice()).hashCode(),cur);
            cur.put(item.getID(),item);

            //кладем по id O(1)
            catalogForID.put(item.getID(),item);

        }

        public void printItems() {
            for (Map.Entry<Integer, HashMap<Long, GenericItem>> i : catalog.entrySet()) {
                for (Map.Entry<Long, GenericItem> j : i.getValue().entrySet()) {
                    System.out.println(j.getValue().toString()); //  O(n)
                }
            }
        }

        public void remove(GenericItem item){

            HashMap<Long,GenericItem>  cur;

            if( catalog.get(new Key(item.getName(),item.getCategory(),item.getPrice()).hashCode()) != null) {
                cur = catalog.get(new Key(item.getName(),item.getCategory(),item.getPrice()).hashCode());
                cur.remove(item.getID(),item);
            }

            else {
                System.out.println("There is no object");
            }
            //O(1)
        }



        public GenericItem findItemByID(long id){
            return catalogForID.getOrDefault(id,null) ; // O(1)
        }

        public HashMap<Long,GenericItem> findItemByData(String name, Category category, float price){
            return catalog.getOrDefault(new Key(name,category,price).hashCode(),null); //O(1) - возрващает HashMap всех товаров , которые подошли
        }


    }


}
