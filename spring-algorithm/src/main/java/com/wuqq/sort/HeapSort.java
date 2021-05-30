package com.wuqq.sort;

import java.util.Arrays;

/**
 * @author: wuqq
 * @date: 2021/5/22 7:31 PM
 * 堆排序
 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 *
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 *
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 * 第一个非叶子结点length/2-1；左节点2*i+1，右节点2*i+2 i为父节点的索引
 * @version: 1.0
 */

public class HeapSort {

    public static int[] sort(int[] arr){
        maxHeap(arr);
        return arr;
    }
    public static  void maxHeap(int[] arr){
        //第一个非叶子结点
        int start = arr.length/2-1;
        //从下至上 从左至右
        for(int i=start;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //交换堆顶和堆末 并调整
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void adjustHeap(int[] arr,int i,int length){
        //父节点
        int temp=arr[i];
        //从当前节点的左字节点开始
        for(int k=2*i+1;k<length;k=2*k+1){
            //需判断是否越界
            if(k+1<length && arr[k]<arr[k+1]){
                //指向右子节点
                k++;
            }
            if(temp<arr[k]){
                //将字节点赋值给父节点
                arr[i]=arr[k];
                //后一步交换 arr[i]中i已经覆盖为当前k
                i = k;
            }else{
                break;
            }
        }
        arr[i]=temp;
    }
    public static void main(String[] args) {
        int[] a={7,6,7,11,5,12,3,0,1};
        System.out.println(Arrays.toString(sort(a)));
    }

//    public static void main(String []args){
//        int []arr = {7,6,7,11,5,12,3,0,1};
//        System.out.println("排序前："+Arrays.toString(arr));
//        sort(arr);
//        System.out.println("排序前："+Arrays.toString(arr));
//    }
//
//    public static void sort(int []arr){
//        //1.构建大顶堆
//        for(int i=arr.length/2-1;i>=0;i--){
//            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr,i,arr.length);
//        }
//        //2.调整堆结构+交换堆顶元素与末尾元素
//        for(int j=arr.length-1;j>0;j--){
//            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
//            adjustHeap(arr,0,j);//重新对堆进行调整
//        }
//
//    }
//
//    /**
//     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
//     * @param arr
//     * @param i
//     * @param length
//     */
//    public static void adjustHeap(int []arr,int i,int length){
//        int temp = arr[i];//先取出当前元素i
//        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
//            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
//                k++;
//            }
//            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                arr[i] = arr[k];
//                i = k;
//            }else{
//                break;
//            }
//        }
//        arr[i] = temp;//将temp值放到最终的位置
//    }
//
//    /**
//     * 交换元素
//     * @param arr
//     * @param a
//     * @param b
//     */
//    public static void swap(int []arr,int a ,int b){
//        int temp=arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }
}
