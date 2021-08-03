package com.wuqq.mutilthread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author: wuqq
 * @date: 2021/6/1 8:34 PM
 * @version: 1.0
 */

public class test {
    public static void main(String[] args) {
//        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
////           int t = new Random().nextInt();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("f1");
//            return String.valueOf(1);
//        });
//        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
//
////            int t = new Random().nextInt();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("f2");
//            return String.valueOf(2);
//        });
//
//        CompletableFuture<String> f3 = f1.applyToEither(f2,p->p);
//        System.out.println(f3.join());
//        String[] players = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka", "David Ferrer",
//                "Roger Federer", "Andy Murray",
//                "Tomas Berdych", "Juan Martin Del Potro",
//                "Richard Gasquet", "John Isner"};
//        Arrays.sort(players,(s,p)->(s.compareTo(p)));
//
//            System.out.println(1);
//        int a[] = {1,2,3,4,5,6};
//        int b[] = {5,6,7,8,9};

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.forEach(a->{
            if(list1.contains(a))
                list1.remove(a);
        });
//        List<Integer> list2 = list.stream().map(a->{
//        }).collect(Collectors.toList());
        List<Integer> list2 = new ArrayList<>();
        list2 = list.stream().filter(a -> a!=5).collect(Collectors.toList());
        list2.forEach(System.out::println);


    }
}
