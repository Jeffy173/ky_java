package com.example;

import com.example.Myclass.AVL;
import com.example.Myclass.Stdio;
import com.example.Myclass.Algorithm;

public class Main {
    public static void main(String[] args) {
        // AVL<Integer,Integer> avl1=new AVL<Integer,Integer>();
        // avl1.set(1,2);
        // avl1.set(7,8);
        // Stdio.printf("%s\n",avl1);
        // for(AVL.Item<Integer,Integer> item:avl1.items()){
        //     Stdio.printf("%d:%d\n",item.key,item.value);
        // }
        Integer[] array={1,6,3,2,1,7,8,5,3,3,6,6,2,9,2,4};
        for(int x:array) Stdio.printf("%d ",x);
        Stdio.printf("\n");
        Algorithm.merge_sort(array);
        for(int x:array) Stdio.printf("%d ",x);
        Stdio.printf("\n");
    }
}