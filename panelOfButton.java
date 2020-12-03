package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class panelOfButton extends JPanel{
    JPanel input = new JPanel();
    JScrollPane scrollPane = new JScrollPane(input);

    ArrayList<JLabel> labels = new ArrayList<JLabel>();
    ArrayList<JTextField> fields = new ArrayList<JTextField>();

    private JLabel title = new JLabel("Введите значения: ");
    private JLabel firstLabel = new JLabel("Значение 1: ");
    private JTextField firstInput = new JTextField("", 5);
    private JLabel secondLabel = new JLabel("Значение 2: ");
    private JTextField secondInput = new JTextField("", 5);
    private JButton buttonAdd = new JButton("+");
    private JButton buttonRemove = new JButton("-");
    private JButton buttonBuild = new JButton("Построить");

    public panelOfButton() {
        labels.add(firstLabel);
        labels.add(secondLabel);
        fields.add(firstInput);
        fields.add(secondInput);

        input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
        this.add(title);

        input.add(labels.get(0));
        input.add(fields.get(0));
        input.add(labels.get(1));
        input.add(fields.get(1));

        this.add(scrollPane);

        buttonAdd.addActionListener(new AddField());
        this.add(buttonAdd);

        buttonRemove.addActionListener(new RemoveField());
        this.add(buttonRemove);


        buttonBuild.addActionListener(new DrawChart());
        this.add(buttonBuild);
    }

    class AddField implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            int number = labels.size() + 1;
            JLabel label = new JLabel("Значение " + number + ": ");
            labels.add(label);
            JTextField field = new JTextField("", 5);
            fields.add(field);
            input.add(label);
            input.add(field);
            scrollPane.revalidate();
        }
    }
    class RemoveField implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            int number = labels.size() - 1;
            JLabel label = labels.remove(number);
            input.remove(label);
            JTextField field = fields.remove(number);
            input.remove(field);

            input.repaint();
            scrollPane.revalidate();
        }
    }
    class DrawChart implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            for (int i = 0; i < labels.size(); i++) {
                MyGUI.drawPanel.values.add(Integer.parseInt(fields.get(i).getText()));
            }

            MyGUI.drawPanel.repaint();
//            MyGUI.drawPanel.resize(501, 300);
            setVisible(false);
            setVisible(true);

        }
    }
}

