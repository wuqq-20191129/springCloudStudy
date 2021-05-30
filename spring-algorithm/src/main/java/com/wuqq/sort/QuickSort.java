package com.wuqq.sort;

import java.util.Arrays;

/**
 * @author: wuqq
 * @date: 2021/5/22 5:11 PM
 * 快速排序 双指针  高指针向左找小于基准数的 低指针向右找大于基准数的 交换位置 直至高指针等于低指针 交换基准数 在递归 错误条件写在前面
 * @version: 1.0
 */

public class QuickSort {

    public static void quicksort(int[] arr){
        int len = arr.length;
        if(arr == null|| len  == 0 || len == 1) {
            return ;
        }
        //错误条件判断
        sort(arr,0,len-1);
    }

    public static void sort(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int base = arr[left];
        int i=left;
        int j=right;
        while(i!=j) {
            while (arr[j] >=base && i < j) {
                j--;
            }
            while (arr[i] <=base && i < j) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left]=arr[i];
        arr[i]=base;

        sort(arr,left,i-1);
        sort(arr,i+1,right);
    }
    public static void main(String[] args) {
        int a[]={7, 1, 3, 5, 13, 9, 3, 6, 11};
        quicksort(a);
        System.out.println(Arrays.toString(a));
    }


}
