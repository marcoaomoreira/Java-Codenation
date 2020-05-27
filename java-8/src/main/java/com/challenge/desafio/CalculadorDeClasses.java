package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;


public class CalculadorDeClasses implements Calculavel {

    public BigDecimal sum = new BigDecimal(0);
    public BigDecimal sub = new BigDecimal(0);
    public BigDecimal tot = new BigDecimal(0);
    public BigDecimal x = new BigDecimal(0);


    public BigDecimal somar(Object obj) {
        Class<?> cls = obj.getClass();
        BigDecimal ret = null;

        for(Field f: cls.getDeclaredFields()) {
            f.setAccessible(true);

            if(f.isAnnotationPresent(Somar.class)){
                try {
                    Object value = f.get(obj);
                    if(value instanceof BigDecimal){
                        ret = (BigDecimal) value;
                        sum = sum.add(new BigDecimal(String.valueOf(ret)));
                    }
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return sum;
    }



    public BigDecimal subtrair(Object obj) {
        Class<?> cls = obj.getClass();
        BigDecimal ret = null;

        for(Field f: cls.getDeclaredFields()) {
            f.setAccessible(true);

            if(f.isAnnotationPresent(Subtrair.class)){
                try {
                    Object value = f.get(obj);
                    if(value instanceof BigDecimal){
                        ret = (BigDecimal) value;
                        sub = sub.add(new BigDecimal(String.valueOf(ret)));
                    }
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        }
        return sub;
    }




    public BigDecimal totalizar(Object obj) {
        Class<?> cls = obj.getClass();
        BigDecimal retsum = null;
        BigDecimal retsub = null;

        for(Field f: cls.getDeclaredFields()) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(Somar.class)){
                try {
                    Object value = f.get(obj);
                    if(value instanceof BigDecimal){
                        retsum = (BigDecimal) value;
                        sum = sum.add(new BigDecimal(String.valueOf(retsum)));
                    }
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }else if(f.isAnnotationPresent(Subtrair.class)){
                try {
                    Object value = f.get(obj);
                    if(value instanceof BigDecimal){
                        retsub = (BigDecimal) value;
                        sub = sub.add(new BigDecimal(String.valueOf(retsub)));
                    }
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }


        }
        tot = sum.subtract(sub);
        return tot;
    }




}
