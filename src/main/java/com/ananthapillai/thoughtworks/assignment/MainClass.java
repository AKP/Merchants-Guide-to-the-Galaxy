/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ananthapillai.thoughtworks.assignment;

/**
 *
 * @author AKP
 */
public class MainClass {

    //
    public static void main(String[] args) {
        String fileLocation = null;
        if (args.length > 0) {
            fileLocation = args[0];
        }
        try {
            Input.ProcessInputFile(fileLocation);
        } catch (Exception e) {
            System.out.println("File not found!!");
        }
    }
}