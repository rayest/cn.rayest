package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Administrator on 2016/5/2 0002.
 */
public class Calculator {
    String textFieldResult = "";
    String string1 = null;
    String string2 = null;
    int operation;
    //创建各种对象
    Frame frame = new Frame();

    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Panel panel3 = new Panel();

    TextField textField = new TextField(30);
    Button buttonDelete = new Button(" D ");
    Button buttonEqual = new Button(" = ");
    Button[] buttonButton = new Button[16];

    public static void main(String[] args) {
        new Calculator().initial();
    }

    public void initial() {
        frame.setBackground(new Color(94, 94, 73));
        frame.setLayout(new BorderLayout(4, 4));
        frame.setResizable(true);
        frame.setVisible(true);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2);
        frame.add(panel3, BorderLayout.EAST);


        panel1.add(textField);
        panel2.setLayout(new GridLayout(4, 4, 4, 4));
        panel3.setLayout(new BorderLayout(4, 4));
        panel3.add(buttonDelete, BorderLayout.NORTH);
        panel3.add(buttonEqual);

        String[] buttonString = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", ".", "C", "/"};
        for (int i = 0; i < 16; i++) {
            buttonButton[i] = new Button(buttonString[i]);
            panel2.add(buttonButton[i]);
        }
        for (int i = 0; i < 16; i++) {
            buttonButton[i].setFont(new Font("Arial", Font.PLAIN, 20));
        }
        frame.pack();
        calculation();
    }

    public void calculation()
    {
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        buttonButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 1;
                string2 = string2 + 1;
                textField.setText(textFieldResult);
            }
        });
        buttonButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 2;
                string2 = string2 + 2;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 3;
                string2 = string2 + 3;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 4;
                string2 = string2 + 4;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 5;
                string2 = string2 + 5;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 6;
                string2 = string2 + 6;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 7;
                string2 = string2 + 7;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 8;
                string2 = string2 + 8;
                textField.setText(textFieldResult);
            }
        });

        buttonButton[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 9;
                string2 = string2 + 9;
                textField.setText(textFieldResult);
            }
        });
        buttonButton[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += 0;
                string2 = string2 + 0;
                textField.setText(textFieldResult);
            }
        });
        buttonButton[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += '.';
                string2 = string2 + '.';
                textField.setText(textFieldResult);
            }
        });

        buttonButton[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                string1 = textFieldResult;
                textFieldResult = textFieldResult + '+';
                string2 = "";
                textField.setText(textFieldResult);
                operation = 1;
            }
        });

        buttonButton[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                string1 = textFieldResult;
                textFieldResult = textFieldResult + '-';
                string2 = "";
                textField.setText(textFieldResult);
                operation = 2;
            }
        });
        buttonButton[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                string1 = textFieldResult;
                textFieldResult = textFieldResult + '*';
                string2 = "";
                textField.setText(textFieldResult);
                operation = 3;
            }
        });
        buttonButton[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult = "";
                string2 = "";
                textField.setText(textFieldResult);
            }
        });

        buttonButton[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                string1 = textFieldResult;
                textFieldResult = textFieldResult + '/';
                string2 = "";
                textField.setText(textFieldResult);
                operation = 4;
            }
        });

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldResult += '=';
                double input1 = Double.parseDouble(string1);
                double input2 = Double.parseDouble(string2);
                double operationResult = 0;
                switch (operation){
                    case 1: operationResult = input1 + input2; break;
                    case 2: operationResult = input1 - input2; break;
                    case 3: operationResult = input1 * input2; break;
                    case 4: operationResult = input1 / input2; break;
                }
                textFieldResult += operationResult;
                textField.setText(textFieldResult);
                textFieldResult = ""; string1 = ""; string2 = ""; operation = 0;
            }
        });
    }
}
