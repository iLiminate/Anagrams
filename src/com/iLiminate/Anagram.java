/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iLiminate;

import com.iLiminate.ui.Interface;
import javax.swing.SwingUtilities;

/**
 *
 * @author iLiminate
 */
public class Anagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
}
