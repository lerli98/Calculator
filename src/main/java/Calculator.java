import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

  //Basic components of the calculator, frame, text, buttons and panel.
  JFrame frame;
  JTextField textField;
  JButton[] numberButtons = new JButton[10]; //Amount of numbers from 0 to 9
  JButton[] functionButtons = new JButton[9]; //Amount of functions it's going to use
  JButton addButton, subButton, multButton, divButton, decimButton, equalButton, delButton, clrButton, negButton; //Buttons used
  JPanel panel;

  Font myFont = new Font("Arial", Font.BOLD,25); //Font to be used

  //Numbers and operators
  double num1 = 0, num2 = 0, result = 0;
  char operator;

  Calculator() {

    //Frame defined
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    //Text defined
    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(myFont);
    textField.setEditable(false);

    //Buttons defined
    addButton = new JButton("+");
    subButton = new JButton("-");
    multButton = new JButton("*");
    divButton = new JButton("/");
    decimButton = new JButton(".");
    equalButton = new JButton("=");
    delButton = new JButton("Delete");
    clrButton = new JButton("Clear");
    negButton = new JButton("(-)");

    //Buttons array
    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = multButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decimButton;
    functionButtons[5] = equalButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clrButton;
    functionButtons[8] = negButton;

    for(int i = 0; i < 9; i++) {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    for(int i = 0; i < 10; i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFont(myFont);
      numberButtons[i].setFocusable(false);
    }

    delButton.setBounds(30, 430, 120, 50);
    clrButton.setBounds(160, 430, 100, 50);
    negButton.setBounds(270, 430, 100, 50);

    //Buttons panel & order
    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));
    //panel.setBackground(Color.black);
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
    panel.add(multButton);
    panel.add(decimButton);
    panel.add(numberButtons[0]);
    panel.add(equalButton);
    panel.add(divButton);



    frame.add(panel);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(negButton);
    frame.add(textField);
    frame.setVisible(true);

  }

  public static void main(String[] args) {
    Calculator cal = new Calculator();
  }

  @Override
  public void actionPerformed(ActionEvent e) { //Calculator functions
    for (int i = 0; i < 10; i++) {
      if(e.getSource() == numberButtons[i]) {
        textField.setText(textField.getText().concat(String.valueOf(i)));
      }
    }

    if(e.getSource() == addButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '+';
      textField.setText("");
    }
    if(e.getSource() == subButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '-';
      textField.setText("");
    }
    if(e.getSource() == multButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '*';
      textField.setText("");
    }
    if(e.getSource() == divButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '/';
      textField.setText("");
    }
    if(e.getSource() == equalButton) {
      num2 = Double.parseDouble(textField.getText());
      switch(operator) {
        case '+':
          result = num1 + num2;
          break;
        case '-':
          result = num1 - num2;
          break;
        case '*':
          result = num1 * num2;
          break;
        case '/':
          result = num1 / num2;
          break;
      }
      textField.setText(String.valueOf(result));
      num1 = result;
    }
    if(e.getSource() == decimButton) {
      textField.setText(textField.getText().concat("."));
    }
    if(e.getSource() == clrButton) {
      textField.setText("");
    }
    if(e.getSource() == delButton) {
      String string = textField.getText();
      textField.setText("");
      for(int i = 0; i < string.length() - 1; i++) {
        textField.setText(textField.getText() + string.charAt(i));
      }
    }
    if(e.getSource() == negButton) {
      double temp = Double.parseDouble(textField.getText());
      temp *= -1;
      textField.setText(String.valueOf(temp));
    }
  }
}
