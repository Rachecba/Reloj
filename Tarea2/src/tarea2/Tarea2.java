/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import tarea2.model.RadioReloj;
import tarea2.model.RadioRelojEngine;
import tarea2.model.RadioRelojImpl;
import tarea2.view.swing.HardwareSwing;

/**
 *
 * @author tvkev
 */
public class Tarea2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RadioReloj radio = new RadioRelojImpl(new RadioRelojEngine());
        
        HardwareSwing view = new HardwareSwing(radio);
        
    }  
}
