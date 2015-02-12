/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananthapillai.thoughtworks.assignment;

import org.junit.Test;

/**
 *
 * @author AKP
 */
public class TestClass {

    @Test
    //Test should return the decimal equivalent of the roman numeral
    public void romanShouldBeConvertedToDecimal() {
        System.out.println(DecimalFromRoman.calculateDecimal("IX")); //Shuld return the decimal equivalent of Roman Numeral
    }

    @Test
    //Test should return sentence type as one of the following:
    // "ASSIGN PRIMITIVE" , "ASSIGN DERIVED", "QUESTION PRIMITIVE", "QUESTION DERIVED", "FAILURE"- if no type can be determined
    public void findSentenceType() {
        String sentenceToEvaluate = "pish is L";
        System.out.println("\"" + sentenceToEvaluate + "\" is of type " + Input.classifyLines(sentenceToEvaluate)); //Shuld return the decimal equivalent of Roman Numeral
    }
}
