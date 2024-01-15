/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

public class tool {
    
    
    public static String inputString(String s){
        Scanner sc = new Scanner(System.in);
        System.out.println(s + " ");
        String str;
        str = sc.nextLine();
        return str;
    }
    
    public static int inputInt(String s){
        System.out.print(s + " ");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if(tmp == null || tmp.isEmpty())return 0;
        int re = Integer.parseInt(tmp);
        return re;
    }
    
    public static String inputStringRegex(String msg, String pattern){
        System.out.println(msg + " ");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if (tmp.matches(pattern)) {
            return tmp;
        }
        return "";
    }
    
    public static int inputIntRegex(String msg, String pattern){
        System.out.println(msg + " ");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if (!tmp.matches(pattern) || tmp.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(tmp);
    }
}
