/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Scanner;

/**
 *
 * @author Azer
 */
public class InputUtil {
    public static String requiredText(String title){
        Scanner sc=new Scanner(System.in);
        System.out.println(title+":");
        String answer=sc.nextLine();
        return answer;
    }
    
    public static int requiredNumber(String title){
        Scanner sc=new Scanner(System.in);
        System.out.println(title+":");
        int answer=sc.nextInt();
        return answer;
    }
}
