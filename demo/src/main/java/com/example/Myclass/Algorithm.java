package com.example.Myclass;

import java.lang.reflect.Array;

public class Algorithm{
    private Algorithm(){}

    private static <T extends Comparable<T>> void merge(T[] array,T[] temp,int begin,int end){
        int mid=(begin+end)/2;
        int i=begin;
        int j=mid;
        int index=begin;
        while(i<mid && j<end){
            if(array[i]==null) temp[index++]=array[i++];
            else if(array[j]==null) temp[index++]=array[j++];
            else if(array[i].compareTo(array[j])<=0) temp[index++]=array[i++];
            else temp[index++]=array[j++];
        }
        while(i<mid) temp[index++]=array[i++];
        while(j<end) temp[index++]=array[j++];
        System.arraycopy(temp,begin,array,begin,end-begin);
    }

    private static <T extends Comparable<T>> void merge_sort(T[] array,T[] temp,int begin,int end){
        if(end-begin<=1) return ;
        int mid=(begin+end)/2;
        merge_sort(array,temp,begin,mid);
        merge_sort(array,temp,mid,end);
        merge(array,temp,begin,end);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge_sort(T[] array){
        T[] temp=(T[])Array.newInstance(array.getClass().getComponentType(),array.length);
        merge_sort(array,temp,0,array.length);
    }

}

public class Algorithm{
    private Algorithm(){}

    private static <T extends Comparable<T>> void merge(T[] array,T[] temp,int begin,int end){
        int mid=(begin+end)/2;
        int i=begin;
        int j=mid;
        int index=begin;
        while(i<mid && j<end){
            if(array[i]==null) temp[index++]=array[i++];
            else if(array[j]==null) temp[index++]=array[j++];
            else if(array[i].compareTo(array[j])<=0) temp[index++]=array[i++];
            else temp[index++]=array[j++];
        }
        while(i<mid) temp[index++]=array[i++];
        while(j<end) temp[index++]=array[j++];
        System.arraycopy(temp,begin,array,begin,end-begin);
    }

    private static <T extends Comparable<T>> void merge_sort(T[] array,T[] temp,int begin,int end){
        if(end-begin<=1) return ;
        int mid=(begin+end)/2;
        merge_sort(array,temp,begin,mid);
        merge_sort(array,temp,mid,end);
        merge(array,temp,begin,end);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge_sort(T[] array){
        T[] temp=(T[])Array.newInstance(array.getClass().getComponentType(),array.length);
        merge_sort(array,temp,0,array.length);
    }

}