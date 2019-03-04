package com.example.xiangdada.test.sort;

import android.support.annotation.NonNull;

/**
 * Created by xdd on 2019/2/24
 *
 * 排序
 */
public class Sort {

    /**
     * 冒泡排序
     * 比较相邻的元素，第一个大于第二个则交换
     *
     * 比较的次数为：(n-1)+(n-2)+...+1 = n*(n-1)/2，约为 n²/2
     * 假若每次比较都要交换,冒泡排序运行都需要O(N²)时间级别
     *
     * @param array
     * @return
     */
    public static int[] bubble(@NonNull int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++) {
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     * 找到最小的元素，如果最小元素不是序列的第一个，则将其和第一个元素交换
     *
     * 选择排序和冒泡排序执行了相同次数的比较：N*（N-1）/2，但是至多只进行了N次交换
     * 运行时间级别为O(N²)，但由于交换次数少，多以比冒泡排序快
     * @param array
     * @return
     */
    public static int[] selecte(@NonNull int[] array){
        int minIndex =0;
        int tmp = 0;
        for(int i=0;i<array.length;i++) {
            minIndex = i;
            for(int j=i+1;j<array.length;j++) { // (i+1)内存循环不再比较已经排好序的位置
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }

    /**
     * 插入排序
     * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止
     *
     * 在第一轮排序中，它最多比较一次，第二轮最多比较两次，依次类推，第N轮，最多比较N-1次。因此有 1+2+3+...+N-1 = N*（N-1）/2，约为n²/2
     * 运行时间级别为O(N²),插入排序比冒泡快一倍，比选择排序略快
     * @param array
     * @return
     */
    public static int[] insert(@NonNull int[] array) {
        for(int i=1;i<array.length;i++) {
            int tmp = array[i]; // 用作比较的数据
            int leftIndex = i-1;
            // 用tmp与其左侧的数据从右到左依次比较，若tmp大于与其比较的数据则退出while循环，因为tmp左侧的数据原本是已经排序好了的
            while (leftIndex>=0 && array[leftIndex]>tmp){
                array[leftIndex+1] = array[leftIndex];
                leftIndex --;
            }
            array[leftIndex+1] = tmp;
        }

        return array;
    }
}
