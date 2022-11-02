package guicalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
public class CalculatorPanelCheckpoint1415 extends JPanel{

    int CALC_WIDTH = 250;
    int CALC_HEIGHT = 235;
    float num1, num2, cal_result;
    float memory = 0;
    char op;

    JLabel result;

    JButton[] numberBtn = new JButton[10];
    JButton[] operatorBtn = new JButton[10];
    String[] ops = {"*", "+", "/", "=", "C", "-", "mc", "m+", "m-", "mr"};

    Collection<JButton> buttons = new ArrayList<>();


    public CalculatorPanelCheckpoint1415() {

        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(CALC_WIDTH, CALC_HEIGHT));


        result = new JLabel("0", SwingConstants.RIGHT);
        add(result);
        result.setPreferredSize(new Dimension(CALC_WIDTH - 5, 50));


        result.setFont(new Font("Helvetica", Font.BOLD, 40));


        result.setBackground(Color.white);
        result.setOpaque(true);



        ButtonListener listener = new ButtonListener();

        for (int i = 0; i < 10; i++) {
            numberBtn[i] = new JButton(String.valueOf(i));

            numberBtn[i].addActionListener(listener);
            numberBtn[i].setPreferredSize(new Dimension(56, 30));
            numberBtn[i].setFont(new Font("Helvetica", Font.BOLD, 15));
        }

        for (int i = 0; i < ops.length; i++) {
            operatorBtn[i] = new JButton(ops[i]);

            operatorBtn[i].addActionListener(listener);
            operatorBtn[i].setPreferredSize(new Dimension(56, 30));
            operatorBtn[i].setFont(new Font("Helvetica", Font.BOLD, 15));
            if (i == 4)
                operatorBtn[i].setForeground(Color.red);
            else
                operatorBtn[i].setForeground(Color.blue);
        }


        add(operatorBtn[6]);
        add(operatorBtn[7]);
        add(operatorBtn[8]);
        add(operatorBtn[9]);

        add(numberBtn[7]);
        add(numberBtn[8]);
        add(numberBtn[9]);
        add(operatorBtn[0]);

        add(numberBtn[4]);
        add(numberBtn[5]);
        add(numberBtn[6]);
        add(operatorBtn[1]);

        add(numberBtn[1]);
        add(numberBtn[2]);
        add(numberBtn[3]);
        add(operatorBtn[2]);

        add(numberBtn[0]);
        add(operatorBtn[3]);
        add(operatorBtn[4]);
        add(operatorBtn[5]);
    }

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
private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (result.getText().equals("0"))
                    result.setText(command);
                else
                    result.setText(result.getText() + command);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                num1 = Float.parseFloat(result.getText());
                op = command.charAt(0);
                result.setText("0");
                break;
            case "=":
                num2 = Float.parseFloat(result.getText());
                if ((num2 == 0) && (op == '/')) {
                    result.setText("Error");
                } else
                    result.setText(String.valueOf(calculation(op, num1, num2)));
                break;
            case "C":
                num1 = num2 = 0;
                result.setText("0");
                break;
            case "m+":
                memory += Float.parseFloat(result.getText());
                result.setText(String.valueOf(memory));
                break;
            case "m-":
                memory -= Float.parseFloat(result.getText());
                result.setText(String.valueOf(memory));
                break;
            case "mr":
                result.setText(String.valueOf(memory));
                break;
            case "mc":
                memory = 0;

                break;
        }
    }
}
}
