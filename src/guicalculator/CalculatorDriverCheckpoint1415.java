package guicalculator;

import javax.swing.*;

public class CalculatorDriverCheckpoint1415 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CalculatorPanelCheckpoint1415 panel = new CalculatorPanelCheckpoint1415();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setResizable(false);
        frame.setLocation(800, 300);
        frame.setVisible(true);
    }
}

