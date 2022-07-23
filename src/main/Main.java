/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Util.InputUtil;
import Util.MenuUtil;


/**
 *
 * @author Azer
 */
public class Main {

    public static void main(String[] args) {
        int menu=0;   
        
        while(true){     
            menu=InputUtil.requiredNumber("What do you want to do?"
                + "\n1.Register Student"
                + "\n2.Show All Students"
                + "\n3.Find Student"
                + "\n4.Update Students"
                + "\n5.Exit");
            MenuUtil.processMenu(menu);
        }
    }    
}
