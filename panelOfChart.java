package com.company;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class panelOfChart extends JPanel {
    int userHeight = 300;
    int userWidth = 320;
    int yAxisZero = userHeight-60;

    public static int firstValue, secondValue;
    ArrayList<Integer> values = new ArrayList<Integer>();

    public void paintComponent(Graphics g) {
        if (values.size() != 0) {
            g.drawLine(30, 30, 30, userHeight-60); // Ось у
            g.drawLine(30, 30, 27, 35);
            g.drawLine(30, 30, 33, 35);
            g.drawLine(30, userHeight-60, userWidth-30, userHeight-60); // Ось х
            g.drawLine(userWidth-30, userHeight-60, userWidth-35, userHeight-63);
            g.drawLine(userWidth-30, userHeight-60, userWidth-35, userHeight-57);



            g.setColor(Color.orange);
            for (int i = 0; i < values.size(); i++) {
                g.fillRect(40 + i*40, 240-values.get(i), 30, values.get(i));
            }
        }

    }

}
