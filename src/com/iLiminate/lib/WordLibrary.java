/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iLiminate.lib;

import com.iLiminate.ui.addWords;
import static com.iLiminate.ui.addWords.wordList;
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
 * @return Returns false if library was not found, if word is already in library, 
 * or if the word contains illegal characters. (" ",0-9)
 * @author iLiminate
 */
public static boolean addWordToLibrary(String[] library, String word)  {
    boolean isGood = false;
    for (int n = word.length(); n > 0; n--) {//an inserted string may be more than a single character i.e a copy and paste of 'aaa123d', also we iterate from the back as super.XX implementation will put last insterted string first and so on thus 'aa123d' would be 'daa', but because we iterate from the back its 'aad' like we want
            char c = word.charAt(n - 1);//get a single character of the string
            System.out.println(c);
            if (Character.isAlphabetic(c)) {//if its an alphabetic character or white space
                isGood = true;
            } else {//it was not an alphabetic character or white space
                return false;
            }
        }
    if (!isGood){
        addWords.outputLabel.setText("Error: Invalid character. Please use letters only.");
        return false;
    } else {  
        String[] result = Arrays.copyOf(library, library.length + 1);
        result[library.length] = word;
        WORD_LIST = result;
        allToLowercase();
        return true;
    }
}

public static void allToLowercase() {
    String[] words = WordLibrary.WORD_LIST;
    for (String o : words ){o = o.toLowerCase();}
}


public static void removeWordFromLibrary(String[] library, String word) {
        if (wordList.getSelectedValue() != null && wordList.getSelectedIndex() < WORD_LIST.length){
            String[] part1;
            part1 = Arrays.copyOfRange(library,0,wordList.getSelectedIndex());
            String[] part2 = Arrays.copyOfRange(library, wordList.getSelectedIndex()+1,library.length);
            String[] result;
            result = (String[]) Array.newInstance(part1.getClass().getComponentType(), part1.length + part2.length);
            System.arraycopy(part1, 0, result, 0, part1.length);
            System.arraycopy(part2, 0, result, part1.length, part2.length);
            WORD_LIST = result;
            addWords.getWords(addWords.wordList);
            allToLowercase();
        }else if(wordList.getSelectedIndex() > WORD_LIST.length){
            String[] part1;
            part1 = Arrays.copyOfRange(library,0,wordList.getSelectedIndex());
            String[] result = part1;
            WORD_LIST = result;
            addWords.getWords(addWords.wordList);
            allToLowercase();
        }else{
            addWords.outputLabel.setText("Error: Select a word in the list.");
            
        }
        
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

    public static boolean editWordInLibrary(String[] library, int index, String newWord) {
        boolean isGood = false;
        for (int n = newWord.length(); n > 0; n--) {//an inserted string may be more than a single character i.e a copy and paste of 'aaa123d', also we iterate from the back as super.XX implementation will put last insterted string first and so on thus 'aa123d' would be 'daa', but because we iterate from the back its 'aad' like we want
            char c = newWord.charAt(n - 1);//get a single character of the string
            System.out.println(c);
            if (Character.isAlphabetic(c)) {//if its an alphabetic character or white space
                isGood = true;
            } else {//it was not an alphabetic character or white space
                return false;
            }
        }
        if(isGood){
            Array.get(library, index);
            Array.set(library, index, newWord);
            return true;
        }else{
            return false;
        }
    }
}



