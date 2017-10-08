/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dess;

import java.util.ArrayList;

/**
 *
 * @author Hot Cakes
 */
public class UNdef {
    private ArrayList<String> Llaves;

    public UNdef() {
        Keys Keys = new Keys();
        this.Llaves = Keys.obtenerLlaves();
    }
    
    public void poop(){
        for (int i = 0; i < 16; i++) {
            System.out.println("K"+(i+1)+" = "+Llaves.get(i));
        }
    }
}
