package com.wuqq.sort;

import java.util.Arrays;

/**
 * @author: wuqq
 * @date: 2021/5/22 3:07 PM
 * @version: 1.0
 * 选择排序 将第一个元素当成最小或者最大的，后续的选择最小的与前面的比较；小于或者大于 则交换 否则排在前面排序好的后面
 */

public class SelectSort {

    /**
     *
     * @description: 选择排序 不稳定 值有相同的情况下 相对顺序 会变 如A 80 B 80 C 70 第一次排序结果为 70 80 80 C B A 不需要第二次排序了
     * @return:
     * @author: wuqq
     * @date: 2021/5/22
     */

    public static int[] select(int[] arr){
        for(int i =0;i<arr.length;i++){
 //           int min = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    //交换arr[i]和arr[j]
                    int temp =0;
                    temp=arr[i];
                    arr[i] = arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int a[]={5,4,3,2,1};
        select(a);
        System.out.println(Arrays.toString(a));
    }
}
