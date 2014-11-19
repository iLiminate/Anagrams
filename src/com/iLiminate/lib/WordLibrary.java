/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iLiminate.lib;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author iLiminate
 */
public class WordLibrary {
    public static String[] WORD_LIST = {"One","Two","Three","Four","Five","Six","Seven"};
    
 /**
 * @param library The library to add @param word to.
 * @param word The word to add to @param library to.
 * 
 * @return Returns false if library was not found, or if word is already in library.
 * @author iLiminate
 */
public static boolean addWordToLibrary(String[] library, String word)  {
    String[] result = Arrays.copyOf(library, library.length + 1);
    result[library.length] = word;
    WORD_LIST = result;
return true;
}


    public static void removeWordFromLibrary(String[] library, String word) {
        Array.set(library, library.length-1, "");
    }

/**
 * @param library The library to pull the words from
 * 
 * @return Returns all of the words in @param library.
 */
public String[] getWords(String[] library)  {
    String [] endList = {};
    for (String o : library){
        Array.set(library, library.length, o);
    }
    return endList;
}
}


