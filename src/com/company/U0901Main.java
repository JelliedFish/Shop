package com.company;

import ru.billing.stocklist.FoodItem;

public class U0901Main {
    public static void main ( String[] args ) {

        Integer intArr[] = {10,20,15,24,15};

        Float floatArr[] = new Float[4];

        for(int i=0; i < 4; i++){
            floatArr[i] = (float) i;
        }

        String line = "Конфеты ’Маска’;45;120";
        String item_fld[];
        item_fld = line.split(";");

        FoodItem food = new FoodItem(item_fld[0],Float.parseFloat(item_fld[1]),Short.parseShort(item_fld[2]));


        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<Integer>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<Float>(floatArr);
        //U0901WorkArray<String> insWorkArrayFloat = new U0901WorkArray<Float>(floatArr);

        System.out.println("Our sum for arr of int:"+insWorkArrayInt.sum()+"\n");
        System.out.println("Our sum for arr of float:"+insWorkArrayFloat.sum()+"\n");

    }
}
