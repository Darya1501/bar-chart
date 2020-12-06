package com.company;
import java.awt.*;
import javax.swing.*;

public class MyGUI extends JFrame{
    public panelOfButton leftPanel = new panelOfButton(); // Панель для элементов управления
    public static panelOfChart drawPanel = new panelOfChart(); // Панель для графика

    public MyGUI() {
        super("Столбиковая процентная диаграмма по вертикали");
        this.setBounds(100, 100, 750, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // элементы управления - в одну линию вертикально
        drawPanel.setBorder(BorderFactory.createTitledBorder("Диаграмма"));

        Container container = this.getContentPane();
        container.add(BorderLayout.WEST, leftPanel);
        container.add(BorderLayout.CENTER, drawPanel);
    }
}