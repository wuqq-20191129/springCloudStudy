package com.wuqq.sort;

import java.util.Arrays;

/**
 * @author: wuqq
 * @date: 2021/5/22 4:10 PM
 * 希尔排序 插入排序变种 变长gap=length/2 gap=gap/2 分组 对每个gap长度的分组进行插入排序 不稳定
 * @version: 1.0
 */

public class ShellSort {
    /**
     *
     * @description: 希尔排序
     * @return:
     * @author: niaonao
     * @date: 2021/5/22
     */
    public static int[] shell(int[] arr){
        //gap 循环次数
        for(int i=arr.length/2;i>0;i=i/2){
            //分组 插入排序
            for(int j=0;j<arr.length-i;j++){
                for(int k = j+i;k>0&&k-i>=0;k=k-i){
                    if(arr[k]<arr[k-i]){
                        int temp = arr[k];
                        arr[k]=arr[k-i];
                        arr[k-i]=temp;
                    }else{
                        break;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int a[]={4,1,3,2,6,5,8,9,7};
        System.out.println(Arrays.toString(shell(a)));
    }
}
