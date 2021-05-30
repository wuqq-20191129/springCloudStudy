package com.wuqq.sort;

import java.util.Arrays;

/**
 * @author: wuqq
 * @date: 2021/5/22 3:38 PM
 * 插入排序
 * @version: 1.0
 */

public class InsertSort {

    /**
     *
     * @description: 插入排序 从第二个数开始 与前面的值比较 小于则交换 第三个数小于第二个数则插入  默认前面已经有序(重点在与前面排好的比较)
     * @return:  稳定
     * @author: wuqq
     * @date: 2021/5/22
     */
    public static int[] insert(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = 0;
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }else{
                    //默认前面已经有序 若第一次内部循环不满足 则不用继续循环了
                    break;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int a[]={5,4,3,2,1};
        insert(a);
        System.out.println(Arrays.toString(a));
    }
}
