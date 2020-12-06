package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class panelOfButton extends JPanel{
    JPanel input = new JPanel();
    JScrollPane scrollPane = new JScrollPane(input);

    ArrayList<JLabel> labels = new ArrayList<JLabel>();
    ArrayList<JTextField> fields = new ArrayList<JTextField>();

    final JLabel title1 = new JLabel("Какую величину принять за 100%?");
    private final JRadioButton radio1 = new JRadioButton("Максимальное значение");
    private final JRadioButton radio2 = new JRadioButton("Сумму значений");
    private final JRadioButton radio3 = new JRadioButton("Другую величину: ");
    private final JTextField field1 = new JTextField("", 5);

    private final JLabel title2 = new JLabel("Введите значения: ");
    private final JLabel firstLabel = new JLabel("Значение 1: ");
    private final JTextField firstInput = new JTextField("", 5);
    private final JLabel secondLabel = new JLabel("Значение 2: ");
    private final JTextField secondInput = new JTextField("", 5);
    private final JButton buttonAdd = new JButton("+");
    private final JButton buttonRemove = new JButton("- ");
    private final JButton buttonBuild = new JButton("Построить");

    public boolean isBuilding = false;

    public panelOfButton() {
        // Какое значение - 100%?
        this.add(title1);
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        this.add(radio1);
        radio1.setSelected(true);
        this.add(radio2);
        this.add(radio3);
        this.add(field1);

        this.add(Box.createRigidArea(new Dimension(5,30)));

        // Первые 2 поля ввода
        input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
        labels.add(firstLabel);
        labels.add(secondLabel);
        fields.add(firstInput);
        fields.add(secondInput);

        this.add(title2);
        input.add(labels.get(0));
        input.add(fields.get(0));
        input.add(labels.get(1));
        input.add(fields.get(1));
        this.add(scrollPane);

        // Кнопки управления
        buttonAdd.addActionListener(new AddField());
        this.add(buttonAdd);
        buttonRemove.addActionListener(new RemoveField());
        this.add(buttonRemove);
        this.add(Box.createRigidArea(new Dimension(5,30)));
        buttonBuild.addActionListener(new DrawChart());
        this.add(buttonBuild);
    }

    class DrawChart implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            isBuilding = true;
            // удалить старые значения
            if (MyGUI.drawPanel.values.size() != 0) {
                MyGUI.drawPanel.values.clear();
            }

            // Вычисляем величину 100%
            if (radio1.isSelected()) {
                int max = 0;
                for (int i = 0; i < labels.size(); i++) {
                    int a = Integer.parseInt(fields.get(i).getText());
                    if(a > max) {
                        max = a;
                    }
                }
                MyGUI.drawPanel.hundredValue = max;
            } else if (radio2.isSelected()) {
                int sum = 0;
                for (int i = 0; i < labels.size(); i++) {
                    sum += Integer.parseInt(fields.get(i).getText());
                }
                MyGUI.drawPanel.hundredValue = sum;
            } else {
                MyGUI.drawPanel.hundredValue = Integer.parseInt(field1.getText());
            }

            // Передаем на панель диаграммы значения столбиков
            for (int i = 0; i < labels.size(); i++) {
                MyGUI.drawPanel.values.add(Integer.parseInt(fields.get(i).getText()));
            }
            MyGUI.drawPanel.repaint();
            setVisible(false);
            setVisible(true);
        }
    }
    class AddField implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if(labels.size() < 10) {
                if (isBuilding) {
                    MyGUI.drawPanel.values.clear();
                }
                int number = labels.size() + 1;
                JLabel label = new JLabel("Значение " + number + ": ");
                labels.add(label);
                JTextField field = new JTextField("", 5);
                fields.add(field);
                input.add(label);
                input.add(field);
                scrollPane.revalidate();
                scrollPane.getViewport().setViewPosition(new Point(12, 1000));
            } else {
                JOptionPane.showMessageDialog(null, "Невозможно отобразить больше 10 значений",
                        "Внимание!", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    class RemoveField implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (isBuilding) {
                MyGUI.drawPanel.values.clear();
            }
            int number = labels.size() - 1;
            JLabel label = labels.remove(number);
            input.remove(label);
            JTextField field = fields.remove(number);
            input.remove(field);

            input.repaint();
            scrollPane.revalidate();
        }
    }
}