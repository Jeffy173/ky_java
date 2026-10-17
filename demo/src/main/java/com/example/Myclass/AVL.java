package com.example.Myclass;

import java.util.Objects;
import java.lang.reflect.Array;

public class AVL<K extends Comparable<K>,V>{
    private class Node{
        public K key;
        public V value;
        public int height;
        public Node left;
        public Node right;

        public Node(K key_,V value_){
            key=key_;
            value=value_;
            height=1;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int _size;
    
    public AVL(){
        root=null;
        _size=0;
    }

    public int size(){
        return _size;
    }

    private int max(int a,int b){
        return a>b?a:b;
    }

    private int get_height(Node n){
        return n==null?0:n.height;
    }

    private void set_height(Node n){
        n.height=max(get_height(n.left),get_height(n.right))+1;
    }

    private int d_height(Node n){
        return get_height(n.left)-get_height(n.right);
    }

    private Node LL(Node n){
        Node n_=n.left;
        n.left=n_.right;
        n_.right=n;
        set_height(n);
        set_height(n_);
        return n_;
    }

    private Node RR(Node n){
        Node n_=n.right;
        n.right=n_.left;
        n_.left=n;
        set_height(n);
        set_height(n_);
        return n_;
    }

    private Node LR(Node n){
        n.left=RR(n.left);
        return LL(n);
    }

    private Node RL(Node n){
        n.right=LL(n.right);
        return RR(n);
    }

    private Node optimize(Node n){
        if(d_height(n)>1){
            return d_height(n.left)>0?LL(n):LR(n);
        }
        if(d_height(n)<-1){
            return d_height(n.right)<0?RR(n):RL(n);
        }
        set_height(n);
        return n;
    }

    private Node _set(Node n,K key,V value){
        if(n==null){
            _size++;
            return new Node(key,value);
        }
        if(key.compareTo(n.key)<0){
            n.left=_set(n.left,key,value);
            return optimize(n);
        }
        if(key.compareTo(n.key)>0){
            n.right=_set(n.right,key,value);
            return optimize(n);
        }
        n.value=value;
        return n;
    }

    public void set(K key,V value){
        if(key==null) return ;
        root=_set(root,key,value);
    }

    private Node _get(Node n,K key){
        if(n==null) return null;
        if(key.compareTo(n.key)<0) return _get(n.left,key);
        if(key.compareTo(n.key)>0) return _get(n.right,key);
        return n;
    }

    public V get(K key,V default_value){
        Node n=_get(root,key);
        return n==null?default_value:n.value;
    }

    public V get(K key){
        return get(key,null);
    }

    private Node _delete(Node n){
        _size--;
        if(n.left==null && n.right==null) return null;
        if(n.left==null) return n.right;
        if(n.right==null) return n.left;
        Node n_=n.left;
        while(n_.right!=null) n_=n_.right;
        n.key=n_.key;
        n.value=n_.value;
        n.left=_remove(n.left,n.key);
        _size++;
        return optimize(n);
    }

    private Node _remove(Node n,K key){
        if(n==null) return null;
        if(key.compareTo(n.key)<0){
            n.left=_remove(n.left,key);
            return optimize(n);
        }
        if(key.compareTo(n.key)>0){
            n.right=_remove(n.right,key);
            return optimize(n);
        }
        return _delete(n);
    }

    public void remove(K key){
        root=_remove(root,key);
    }

    private int _keys(Node n,K[] result,int index){
        if(n==null) return index;
        index=_keys(n.left,result,index);
        result[index++]=n.key;
        index=_keys(n.right,result,index);
        return index;
    }

    @SuppressWarnings("unchecked")
    public K[] keys(){
        K[] result=(K[])(new Object[_size]);
        int index=0;
        _keys(root,result,index);
        return result;
    }

    private int _values(Node n,V[] result,int index){
        if(n==null) return index;
        index=_values(n.left,result,index);
        result[index++]=n.value;
        index=_values(n.right,result,index);
        return index;
    }

    @SuppressWarnings("unchecked")
    public V[] values(){
        V[] result=(V[])(new Object[_size]);
        int index=0;
        _values(root,result,index);
        return result;
    }

    public static class Item<K,V>{
        public K key;
        public V value;

        public Item(K key_,V value_){
            key=key_;
            value=value_;
        }

        @Override
        public boolean equals(Object other){
            if(other==this) return true;
            if(!(other instanceof Item)) return false;
            Item<?,?> item=(Item<?,?>)other;
            if(key!=item.key && (key==null || !key.equals(item.key))) return false;
            if(value!=item.value && (value==null || !value.equals(item.value))) return false;
            return true;
        }

        public int hashCode(){
            return Objects.hash(key,value);
        }
    }

    private int _items(Node n,Item<K,V>[] result,int index){
        if(n==null) return index;
        index=_items(n.left,result,index);
        result[index++]=new Item<K,V>(n.key,n.value);
        index=_items(n.right,result,index);
        return index;
    }

    @SuppressWarnings("unchecked")
    public Item<K,V>[] items(){
        Item<K,V>[] result=(Item<K,V>[])(Array.newInstance(Item.class,_size));
        int index=0;
        _items(root,result,index);
        return result;
    }

    public String toString(){
        StringBuilder result=new StringBuilder("AVL{");
        boolean first=true;
        for(Item<K,V> item:items()){
            if(first) first=false;
            else result.append(",");
            result.append(item.key).append(":").append(item.value);
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public boolean equals(Object other){
        if(other==this) return true;
        if(!(other instanceof AVL)) return false;
        AVL<?,?> avl=(AVL<?,?>)other;
        if(avl._size!=_size) return false;
        Item<K,V>[] items1=items();
        Item<?,?>[] items2=avl.items();
        for(int i=0;i<_size;i++){
            if(!items1[i].equals(items2[i])) return false;
        }
        return true;
    }

    public int hashCode(){
        int result=0;
        for(Item<K,V> item:items()){
            result=result*31+item.hashCode();
        }
        return result;
    }

}
