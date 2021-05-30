package com.wuqq.sort;

import java.util.Arrays;

/**
 * @author: wuqq
 * @date: 2021/5/22 11:41 AM
 * @version: 1.0
 *
 * 每次都选择最大或者最小的元素 放在头部或者尾部（交换）
 */

public class bubbleSort {

    /**
     *
     * @description: TODO
     * @return: 降序数组  稳定 ：因为有相同值得情况下相对顺序不会变如 A 80 B 80 C 70  冒泡排序后 为C A B
     * @author: wuqq
     * @date: 2021/5/22
     */
    public static int[] sort(int[] arr1){
        int temp =0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length-1;j++){
                if(arr1[j]<arr1[j+1]){
                    temp = arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }
        }
        return arr1;
    }

    //优化 上述每次内部循环之后 最右端已经为最大或者最小 即内部循环 可减少循环次数

    public static int[] sortUpdate(int[] arr1){
        int temp =0;
        for(int i=0;i<arr1.length;i++){
            //内部循环 次数 为当前循环次数 内部循环最大下标-外部循环次数（下标左移对应关系）
            for(int j=0;j<arr1.length-i-1;j++){
                if(arr1[j]<arr1[j+1]){
                    temp = arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }
        }
        return arr1;
    }
    public static void main(String[] args) {
        int[] arr={1,4,2,3};
        sortUpdate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
