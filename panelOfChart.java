package com.company;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class panelOfChart extends JPanel {
    private Font f1 = new Font("TimesRoman", Font.BOLD, 14);
    ArrayList<Integer> values = new ArrayList<>();
    int hundredValue = 0;
    int maxValue = -1;
    int k = 1;

    public void paintComponent(Graphics g) {
        int userHeight = MyGUI.drawPanel.getHeight();
        int userWidth = values.size()*40+90;

        g.drawLine(50, 30, 50, userHeight-30); // Ось у
        g.drawLine(50, 30, 47, 35);
        g.drawLine(50, 30, 53, 35);
        g.drawLine(50, userHeight-30, userWidth-30, userHeight-30); // Ось х

        if (maxValue > hundredValue) {
            k = maxValue / hundredValue;
            maxValue = -1;
        } else {
            g.drawString("0%", 20, userHeight-25);
            g.drawLine(45, 3*userHeight/4-30, 55, 3*userHeight/4-30);
            g.drawString("50%", 15, 3*userHeight/4-25);
            g.drawLine(45, userHeight/2-30, 55, userHeight/2-30);
            g.drawString("100%", 10, userHeight/2-25);
            g.drawLine(45, userHeight/4-30, 55, userHeight/4-30);
            g.drawString("150%", 10, userHeight/4-25);
        }


        if (values.size() != 0) {
            for (int i = 0; i < values.size(); i++) {
                // Случайный цвет для столбика
                int red = (int)(Math.random() * 255);
                int green = (int)(Math.random() * 255);
                int blue = (int)(Math.random() * 255);
                Color color = new Color(red, green, blue);
                g.setColor(color);

                float onePercent = (float)(hundredValue/100.0);
                float percentHeight = (float) values.get(i) / onePercent;
                float height = percentHeight/k * (float)(userHeight/200.0);

                g.fillRect(60 + i*40, (int)((userHeight-30)-height), 30, (int)height+1);
                g.setFont(f1);
                g.drawString(String.format("%.1f",percentHeight)+"%", 60 + i*40, (int)((userHeight-30)-height-5));
                String name = "" + (i+1);
                g.drawString(name, 70 + i*40, userHeight-13);
            }
        }
    }
}