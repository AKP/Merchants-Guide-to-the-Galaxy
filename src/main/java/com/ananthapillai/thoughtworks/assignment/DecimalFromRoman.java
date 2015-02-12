/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananthapillai.thoughtworks.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AKP
 */
public class DecimalFromRoman {

    //Mapping Roman Numbers to their decimal equivalent
    static final Map<String, Integer> romanMapping = new HashMap<>();

    static {
        romanMapping.put("I", 1);
        romanMapping.put("V", 5);
        romanMapping.put("X", 10);
        romanMapping.put("L", 50);
        romanMapping.put("C", 100);
        romanMapping.put("D", 500);
        romanMapping.put("M", 1000);
    }

    // Rules for nonrepeating Roman numbers
    static final List<Character> nonRepeatingRomanNumbers = new ArrayList<>(Arrays.asList('D', 'L', 'V'));

    //Validate the Roman number rules and then convert
    public static int convertToDecimal(String roman) {

        roman = roman.toUpperCase();                                            // to avoid unforseen complications in CASE statements
        if (validateNoRepeatations(roman)) {                                    //Validate repeatitions of D, L, V
            if (validateRepeatations(roman)) {                                  //Validate I, X, C, M rules repeat rules
                return (calculateDecimal(roman));
            }
        }
        return 0;                                                               //Roman system does not have 0.
    }

    public static int calculateDecimal(String romanNumber) {
        int decimal = 0;                                                        //will store final value
        int prevNumber = 0;                                                     //store the previous parsed number to decide wether to subtract & add current number.
        //Parse roman string in reverse.
        for (int x = romanNumber.length() - 1; x >= 0; x--) {
            char toDecimalValue = romanNumber.charAt(x);
            int currentDecimal = romanMapping.get(Character.toString(toDecimalValue)); //get decimal value from the mapping
            switch (toDecimalValue) {
                case 'I':
                    decimal = processDecimal(currentDecimal, prevNumber, decimal);
                    break;

                case 'V':
                    decimal += currentDecimal;                                  //"V", "L", and "D" can never be subtracted.
                    break;

                case 'X':
                    decimal = processDecimal(currentDecimal, prevNumber, decimal);
                    break;

                case 'L':
                    decimal += currentDecimal;                                  //"V", "L", and "D" can never be subtracted.
                    break;

                case 'C':
                    decimal = processDecimal(currentDecimal, prevNumber, decimal);
                    break;

                case 'D':
                    decimal += currentDecimal;                                  //"V", "L", and "D" can never be subtracted.
                    break;

                case 'M':
                    decimal = processDecimal(currentDecimal, prevNumber, decimal);
                    break;
            }
            //Save the current processed roman's decimal equivalent.
            prevNumber = currentDecimal;
        }
        return decimal;
    }

    //If ith number is less than i+1th, subtract and calculate. IV -> Subtract 1 from 5.
    //Else add, XX -> Add 10 to 10
    public static int processDecimal(int currentDecimal, int prevDecimal, int decimal) {
        //Implementation of rule "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only.
        if (currentDecimal < prevDecimal && prevDecimal <= currentDecimal * 10) {
            return (decimal - currentDecimal);
        } else {
            return (decimal + currentDecimal);
        }
    }

    //If D, L, V is repeated semantic err. Do not understand.
    public static boolean validateNoRepeatations(String roman) {
        char[] result = roman.toCharArray();
        int i, j;
        for (i = 0; i < result.length; i++) {
            for (j = i + 1; j < result.length; j++) {
                if (result[i] == result[j]) {
                    //Check if duplicate value is against rules
                    if (nonRepeatingRomanNumbers.contains(result[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //If "I", "X", "C", and "M" can be repeated three times in succession.
    //They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.
    public static boolean validateRepeatations(String roman) {
        char[] result = roman.toCharArray();
        int i, j;
        //Check if number of length is greater than 3
        if (result.length > 3) {
            for (i = 0; i < result.length - 3; i++) {
                //If sucessive 3 are equal. i, i+1 and i+2
                if ((result[i] == result[i + 1]) && (result[i + 1] == result[i + 2])) {
                    //If 4 in sucession, fail (i+3)
                    if (result[i] == result[i + 3]) {
                        return false;
                    }
                    if (result.length > i + 5) {
                        //If 1, 2, 3 and 5th are equal, check if 4th less than 5th.  
                        if (result[i + 4] == result[i]) {
                            //If 3th greater than 4th, fail
                            if (romanMapping.get(Character.toString(result[i + 3])) > romanMapping.get(Character.toString(result[i + 4]))) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
