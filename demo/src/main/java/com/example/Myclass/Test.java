package com.example.Myclass;

public class Test{
    public static void main(String[] args){
        Fileio.set_output_file("hello.txt",true);
        Fileio.print(Stdio.input("input: "));
        Fileio.print("\n");
        Fileio.reset_output();
    }
}
