package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGUI extends JFrame{
    panelOfButton leftPanel = new panelOfButton(); // Панель для элементов управления
    panelOfChart drawPanel = new panelOfChart(); // Панель для графика


    public MyGUI() {
        super("Столбиковая процентная диаграмма по вертикали");
        this.setBounds(100, 100, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // элементы управления - в одну линию вертикально

        Container container = this.getContentPane();
        container.add(BorderLayout.WEST, leftPanel);
        container.add(BorderLayout.CENTER, drawPanel);

    }

}
