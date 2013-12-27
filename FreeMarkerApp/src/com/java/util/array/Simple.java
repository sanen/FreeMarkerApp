package com.java.util.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:zhangkeh@hp.com">zhangkeh</a>
 * @version 1.0
 */
public class Simple {

    /**
     * java application
     * 
     * @param args
     */
    public static void main(String[] args) {
        sortIntegerList();
        System.out.println("***************************");
        sortStringList();
    }

    /**
     * sort integer list
     *
     */
    public static void sortIntegerList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(1);
        Collections.sort(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    
    public static void sortStringList(){
        List<String> list = new ArrayList<String>();
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("7");
        list.add("2");
        list.add("1");
        Collections.sort(list);

        for (String integer : list) {
            System.out.println(integer);
        }
    }
}
