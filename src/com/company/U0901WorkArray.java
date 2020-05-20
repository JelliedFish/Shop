package com.company;

public class U0901WorkArray<T extends Number>  {

    T[] arrNums;

    U0901WorkArray(T[] numP){
        arrNums = numP;
    }

    double sum(){

        double doubleWork = 0.0;

        for(T i : arrNums){
            doubleWork+=i.doubleValue();
        }

        return doubleWork;
    }

}
