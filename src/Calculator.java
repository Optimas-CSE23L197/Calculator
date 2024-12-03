import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[9];
    JButton addButton, subButton, multiButton, divButton;
    JButton decButton, equalButton, delButton, clrButton, negativeButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double number1 = 0, number2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negativeButton = new JButton("(-)");

        operatorButtons[0] = addButton;
        operatorButtons[1] = subButton;
        operatorButtons[2] = multiButton;
        operatorButtons[3] = divButton;
        operatorButtons[4] = decButton;
        operatorButtons[5] = equalButton;
        operatorButtons[6] = delButton;
        operatorButtons[7] = clrButton;
        operatorButtons[8] = negativeButton;

        for(int i = 0; i < 9; i++) {
            operatorButtons[i].addActionListener(this);
            operatorButtons[i].setFont(myFont);
            operatorButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); //this will convert the integer to string
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(negativeButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == multiButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == equalButton) {
            number2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = number1 + number2;
                case '-' -> result = number1 - number2;
                case '*' -> result = number1 * number2;
                case '/' -> result = number1 / number2;
            }
            textField.setText(String.valueOf(result));
            number1 = result;
        }

        if(e.getSource() == clrButton) {
            textField.setText("");
        }

        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
