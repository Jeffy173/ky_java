package com.example.Myclass;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public final class Fileio{
    private Fileio(){

    }

    private static Scanner scanner=new Scanner(System.in);
    private static PrintStream out=System.out;

    public static void set_input_file(String file_name){
        scanner.close();
        try{
            scanner=new Scanner(new File(file_name),StandardCharsets.UTF_8);
        }
        catch(Exception e){
            throw(new RuntimeException(e));
        }
    }

    public static void set_output_file(String file_name){
        set_output_file(file_name,false);
    }

    public static void set_output_file(String file_name,boolean append){
        if(out!=System.out){
            out.close();
        }
        try{
            out=new PrintStream(new FileOutputStream(file_name,append),true,StandardCharsets.UTF_8);
        }
        catch(Exception e){
            throw(new RuntimeException(e));
        }
    }

    public static void reset_input(){
        scanner.close();
        scanner=new Scanner(System.in);
    }

    public static void reset_output(){
        if(out!=System.out){
            out.close();
        }
        out=System.out;
    }

    public static void reset(){
        reset_input();
        reset_output();
    }

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

