package guicalculator;


/*
 * Simple calculator that performs standard operations of +, -, x, /, =, C and
 * incorporates standard memory functions of m+, m-, mc, mr
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

import static java.awt.Label.RIGHT;
/**
 * The calculator panel
 *
 * @author Thi Thanh Huyen Nguyen
 */
public class CalculatorPanel extends JPanel {

    /**
     * Define instance variables
     */
    int CALC_WIDTH = 250;
    int CALC_HEIGHT = 235;
    float num1, num2, cal_result;
    char op;

    JLabel result;
    JButton key;

    String[] row1 = {"mc", "m+", "m-", "mr"};
    String[] row2 = {"7", "8", "9", "*"};
    String[] row3 = {"4", "5", "6", "+"};
    String[] row4 = {"1", "2", "3", "/"};
    String[] row5 = {"0", "=", "C", "-"};

    Collection<JButton> buttons = new ArrayList<>();

    /**
     * Constructor for the Calculator Panel: Sets up the GUI
     */

    public CalculatorPanel() {
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(CALC_WIDTH, CALC_HEIGHT));


        result = new JLabel("0", SwingConstants.RIGHT);
        add(result);

        result.setPreferredSize(new Dimension(CALC_WIDTH - 5, 50));


        result.setFont(new Font("Helvetica", Font.BOLD, 40));


        result.setBackground(Color.white);
        result.setOpaque(true);



        ButtonListener listener = new ButtonListener();

        for (int i = 0; i < row1.length; i++) {
            key = new JButton(row1[i]);
            //key.setMnemonic(row1[i]);
            buttons.add(key);
            add(key);
            key.setForeground(Color.blue);
        }

        for (int i = 0; i < row2.length; i++) {
            key = new JButton(row2[i]);
            buttons.add(key);
            add(key);
            if (i == row2.length - 1)
                key.setForeground(Color.blue);
        }

        for (int i = 0; i < row3.length; i++) {
            key = new JButton(row3[i]);
            buttons.add(key);
            add(key);
            if (i == row3.length - 1) {
                key.setForeground(Color.blue);
            }
        }

        for (int i = 0; i < row4.length; i++) {
            key = new JButton(row4[i]);
            buttons.add(key);
            add(key);
            if (i == row4.length - 1) {
                key.setForeground(Color.blue);
            }
        }

        for (int i = 0; i < row5.length; i++) {
            key = new JButton(row5[i]);
            buttons.add(key);
            add(key);
            if ((i == 1) || (i == 3)) {
                key.setForeground(Color.blue);
            }
            if (i == 2) {
                key.setForeground(Color.red);
            }
        }

        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(56, 30));
            button.setFont(new Font("Helvetica", Font.BOLD, 15));
            button.addActionListener(listener);
        }


    }


    /**
     * Define the calculate method
     * Perform the calculations on <i>num1</i> and <i>num2</i> depending on
     * the operation <i>op</i>
     * @param op the operation
     * @param num1 the first number of the calculation
     * @param num2 the second number of the calculation
     * @return the result of the calculation
     */
    public float calculation(char op, float num1, float num2) {
        switch (op) {
            case '+':
                cal_result = num1 + num2;
                break;
            case '-':
                cal_result = num1 - num2;
                break;
            case '*':
                cal_result = num1 * num2;
                break;
            case '/':
                cal_result = num1 / num2;
                break;
            default:
                cal_result = 0;
        }
        return cal_result;
    }


    /**
     * Define the private inner class ButtonListener
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            for (int i = 0; i < 10; i++) {
                if (source.getText().equals(String.valueOf(i))) {
                    if (result.getText() == "0")
                        result.setText(source.getText());
                    else
                        result.setText(result.getText() + source.getText());
                }
            }

            if ((source.getText().equals("+")) ||
                    (source.getText().equals("-")) ||
                    (source.getText().equals("*")) ||
                    (source.getText().equals("/"))
            ) {
                num1 = Float.parseFloat(result.getText());
                op = source.getText().charAt(0);
                result.setText("0");
            }

            if (source.getText().equals("=")) {
                num2 = Float.parseFloat(result.getText());
                if ((num2 == 0) && (op == '/')) {
                    result.setText("Error");
                } else
                    result.setText(String.valueOf(calculation(op,num1,num2)));
            }

            if (source.getText().equals("C")) {
                num1 = num2 = 0;
                result.setText("0");
            }
        }
    }

}
