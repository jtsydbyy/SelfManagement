/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author tuantuan
 */
public class Validation {
    public static boolean IsLegalString(String str) {
        if (str == null || str.equals("") || str.equals(" ") || str.equals("  ") || str.equals("   ") || str.equals("    ")) {
            return false;
        }
        return true;
    }
     
    public static boolean IsDigit(String str){
        return str.matches("[0-9]{1,}");
    }
}
