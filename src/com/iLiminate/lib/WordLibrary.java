/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iLiminate.lib;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author iLiminate
 */
public class WordLibrary {
    public static String[] WORD_LIST = {"person","thing","world","child","woman","place","point","government",
        "company","number","group","problem","leave","adjectives","good","first","great","little","other","right",
        "different","small","large","early","young","important","public","prepositions","about","after","beneath",
        "under","above","others","would","there","their"};
 /**
 * @param library The library to add @param word to.
 * @param word The word to add to @param library to.
 * 
 * @return Returns false if library was not found, or if word is already in library.
 * @author iLiminate
 */
public static boolean addWordToLibrary(String[] library, String word)  {
    //if (Array){}
    String[] result = Arrays.copyOf(library, library.length + 1);
    result[library.length] = word;
    WORD_LIST = result;
    allToLowercase();
return true;
}

public static void allToLowercase() {
    String[] words = WordLibrary.WORD_LIST;
    for (String o : words ){o = o.toLowerCase();}
}


public static void removeWordFromLibrary(String[] library, String word) {
    Array.set(library, library.length-1, "");
    allToLowercase();
}

/**
 * @param library The library to pull the words from
 * 
 * @return Returns all of the words in @param library.
 */
public static String[] getWords(String[] library)  {
    String [] endList = {};
    for (String o : library){
        Array.set(library, library.length, o);
    }
    allToLowercase();
    return endList;
}

public static String getRandomWord(String[] library) {
    Random rand = new Random();
    int min = 0;
    int max = library.length-1;
    int randomNum = rand.nextInt((max - min) + 1) + min;
    String word =(String)Array.get(library,randomNum);
    allToLowercase();
    return word;
}
}



