package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class panelOfChart extends JPanel {
    int userHeight = 300;
    int userWidth = 370;
    int yAxisZero = userHeight-60;

    int firstValue;

    private JLabel title = new JLabel("Введите значения: ");

    public void paintComponent(Graphics g) {
        g.drawLine(30, 30, 30, userHeight-60); // Ось у
        g.drawLine(30, 30, 27, 35);
        g.drawLine(30, 30, 33, 35);
        g.drawLine(30, userHeight-60, userWidth-60, userHeight-60); // Ось х
        g.drawLine(userWidth-60, userHeight-60, userWidth-65, userHeight-63);
        g.drawLine(userWidth-60, userHeight-60, userWidth-65, userHeight-57);

        g.fillRect(40, 120, 30, 120);
        g.fillRect(80, 100, 30, 140);
        g.fillRect(120, 95, 30, 145);
        g.fillRect(160, 120, 30, 120);

        g.setColor(Color.orange);
        g.fillRect(200, 120, 30, firstValue);
        g.fillRect(240, 120, 30, panelOfButton.getValue(2));
    }

    public panelOfChart() {
        this.firstValue = panelOfButton.getValue(1);
        repaint();
    }

}
