package com.example.Myclass;

import java.util.Scanner;
import java.io.PrintStream;

public final class Stdio{
    private Stdio(){

    }

    private static Scanner scanner=new Scanner(System.in);
    private static PrintStream out=System.out;

    public static void print(){
        
    }

    public static void print(Object obj){
        out.print(obj);
    }

    public static void printf(){
        
    }

    public static void printf(String format,Object... args){
        out.printf(format,args);
    }

    public static String input(){
        return scanner.nextLine();
    }

    public static String input(String s){
        print(s);
        return input();
    }

    public static int input_int(){
        return scanner.nextInt();
    }

    public static int input_int(String s){
        print(s);
        return input_int();
    }
    
    public static long input_long(){
        return scanner.nextLong();
    }

    public static long input_long(String s){
        print(s);
        return input_long();
    }
    
    public static double input_double(){
        return scanner.nextDouble();
    }

    public static double input_double(String s){
        print(s);
        return input_double();
    }
    
    public static float input_float(){
        return scanner.nextFloat();
    }

    public static float input_float(String s){
        print(s);
        return input_float();
    }
    
    public static boolean input_boolean(){
        return scanner.nextBoolean();
    }

    public static boolean input_boolean(String s){
        print(s);
        return input_boolean();
    }
    
    public static byte input_byte(){
        return scanner.nextByte();
    }

    public static byte input_byte(String s){
        print(s);
        return input_byte();
    }
    
    public static short input_short(){
        return scanner.nextShort();
    }

    public static short input_short(String s){
        print(s);
        return input_short();
    }
    
    public static String input_string(){
        return scanner.next();
    }

    public static String input_string(String s){
        print(s);
        return input_string();
    }
}

