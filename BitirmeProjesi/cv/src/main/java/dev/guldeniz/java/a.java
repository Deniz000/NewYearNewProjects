package main.java.dev.guldeniz.java;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * a
 */
public class a {

    public static void main(String[] args) {

    //Bölmeişleminiçıkarmakullanarakyapanprogramınalgoritmaveakış diyagramını çiziniz.

     Scanner scanner = new Scanner(System.in);
     int bolunen = scanner.nextInt();
     int bolen = scanner.nextInt();

    int i = 0;
    while(bolen<bolunen){
        bolunen = bolunen - bolen;
        i++;
     }
     System.out.println(i+1);

}}        