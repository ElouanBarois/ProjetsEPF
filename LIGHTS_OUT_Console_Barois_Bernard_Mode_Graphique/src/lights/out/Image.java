/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lights.out;
import javax.swing.*;

import java.awt.event.*;
/**
 *
 * @author loic1
 */
public class Image {
    public final static int HT = 300;

public final static int LG = 300;

    public static void main(String[] args) {

        JFrame F = new JFrame("Une fenetre en Swing");

        F.setSize(HT,LG);

        F.setVisible(true);

        

        ImageIcon icone = new ImageIcon("pic-puzzle-lo2000");

        JLabel image = new JLabel(icone);

        F.setVisible(true);

    }
}


