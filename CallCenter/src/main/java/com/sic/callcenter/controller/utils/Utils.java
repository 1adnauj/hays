package com.sic.callcenter.controller.utils;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan-pc
 */
public class Utils {
    
    private static Utils util;
    
    /**
     * Produce a random number between the two incoming ints
     * @param min
     * @param max
     * @return 
     */
    public  synchronized  int randInt(int min, int max) {

    
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
    
    
    public  static Utils instance()
    {
        if (util== null) {
            util = new Utils();
        }
        return util;
    
    }
    
}
