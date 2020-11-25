package com.company;
import java.awt.event.*;
import javax.swing.*;

public class panelOfButton extends JPanel{
    private JLabel title = new JLabel("Введите значения: ");
    private JLabel firstLabel = new JLabel("1 значение: ");
    private JTextField firstInput = new JTextField("", 5);
    private JLabel secondLabel = new JLabel("2 значение: ");
    private JTextField secondInput = new JTextField("", 5);
    private JButton buttonAdd = new JButton("+");
    private JButton buttonBuild = new JButton("Построить");

    public static int firstValue = 0;
    public static int secondValue = 0;

    public panelOfButton() {
        this.add(title);
        this.add(firstLabel);
        this.add(firstInput);
        this.add(secondLabel);
        this.add(secondInput);
        this.add(buttonAdd);

        buttonBuild.addActionListener(new ButtonEventListener());
        this.add(buttonBuild);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String message = "Представьте график!\n";
            int firstValue = Integer.parseInt(firstInput.getText());
            int secondValue = Integer.parseInt(secondInput.getText());


            message += "Первое: " + firstValue + ", второе: " + secondValue;
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static int getValue(int i) {
        switch (i) {
            case 1: i = firstValue; break;
            case 2: i = secondValue; break;
        }
        return i;
    }
}

