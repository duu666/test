package com.imooc.basic.sort;
/**
 * 冒泡排序
 * dxp
 * */
public class BubblingSort {

    /**
     * 冒泡排序
     * */
    public static void sort(int[] arr){
        for (int i=0;i < arr.length;i++) {
            int temp;
            for (int j=i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp= arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * */
    public static void selectSort(int[] arr){
        for (int i=0;i < arr.length;i++) {
            int minVal = arr[i];
            for (int j=i+1; j < arr.length; j++) {
                if (minVal > arr[j]) {
                    int temp = arr[j];
                    arr[j] = minVal;
                    minVal= temp;
                }
            }
            arr[i] = minVal;
        }
    }

    public static void main(String[] args) {
        int[] m = {4,1,6,9,2,0,3};
        //冒泡
        //sort(m);
        //选择
        selectSort(m);
        for (int n:m) {
            System.out.println(n);
        }

    }
}
