package ru.billing.client;

import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        ItemCatalog i = new ItemCatalog();

        //CatalogStubLoader loader = new CatalogStubLoader();

        //loader.Load(i);

        //i.printItems();
        for(int j = 0; j < 11; j++){

            i.addItem(new GenericItem());

        }

        long begin = new Date().getTime();

        for(int k = 0; k < 1000000; k++){
            i.findItemByID(124L);
        }

        long end = new Date().getTime();

        System.out.println("HashMap time: "+ (end-begin));



         begin = new Date().getTime();

        for(int k = 0; k < 1000000; k++){
            i.findItemByIDAL(124L);
        }

         end = new Date().getTime();

        System.out.println("ArrayList time: "+ (end-begin));
    }
}
