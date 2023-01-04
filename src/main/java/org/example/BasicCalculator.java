package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BasicCalculator implements ActionListener{
    JFrame frame; // declaring a frame i.e, a rootPane for content
    JTextField textField; //A TextField section for text visibility
    JButton[] numberButton=new JButton[10]; // we create a JButton Array for numbers 0 to 9
    JButton[] functionButton=new JButton[9]; // we create a JButton Array for functions keys
    JButton addButton,subButton,mulButton,divButton,decButton,clrButton,equButton,delButton,negButton; // JButtons for function keys
    JPanel panel; // JPanel is a lightweight container.

    Font myFont=new Font("Times New Roman", Font.BOLD,30); // Font style for displaying text on Screen/TextField
    double num1=0,num2=0,result=0; // variables to store numbers & double to handle decimals
    char Operator; // a char variable to store the action/math to be performed

    BasicCalculator(){
        frame=new JFrame("Basic Calculator"); // we will create a new JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // function to close the Frame on clicking close/Exit.
        frame.setSize(430,550); // Dimensions for JFrame
        frame.setLayout(null); // used to avoid distorted manner of arrangement
        frame.setLocationRelativeTo(null); // makes the frame appear on the centre of the screen
        frame.setResizable(false); // allows us to set size of frame fixed and not resizable

        textField=new JTextField(); // creates a new TextField
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont); // we will set Font using our new Font
        textField.setEditable(false);

        //initialising JButtons
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        clrButton=new JButton("clr");
        delButton=new JButton("Del");
        negButton=new JButton("(-)");

        //adding buttons to function Buttons Array
        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=decButton;
        functionButton[5]=equButton;
        functionButton[6]=delButton;
        functionButton[7]=clrButton;
        functionButton[8]=negButton;

        for (int i=0;i<9;i++){
            functionButton[i].addActionListener(this); // adds ActionListener
            functionButton[i].setFont(myFont); // sets font
            functionButton[i].setFocusable(true); // setting true will help us to make us everything in focus

        }
        for (int i=0;i<10;i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(true);
        }
        // setting dimensions for buttons which require different size
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300); // we will set the Panel dimensions
        panel.setLayout(new GridLayout(4,4,10,10)); // we will setlayout by creating a grid Layout with required rows & columns which will have hGap 7 vGap

        // we will add all the buttons to our Panel
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        // we will add our panel to frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);//makes the frame to be visible on screen

    }

    public static void main(String[] args) {
        BasicCalculator calculator=new BasicCalculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i))); // this will concat the text of the particular number to the textField
            }
        }
        if (e.getSource()==decButton){
            textField.setText(textField.getText().concat(".")); // this will concat decimal(.) to the textField
        }
        if (e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText()); //this will retrieve the text and parse the string as Double value to the num1
            Operator='+'; // this will store the + symbol into Operator
            textField.setText("");
        }
        if (e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText()); //this will retrieve the text and parse the string as Double value to the num1
            Operator='-'; // this will store the - symbol into Operator
            textField.setText("");
        }
        if (e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText()); //this will retrieve the text and parse the string as Double value to the num1
            Operator='*'; // this will store the * symbol into Operator
            textField.setText("");
        }
        if (e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText()); //this will retrieve the text and parse the string as Double value to the num1
            Operator='/'; // this will store the / symbol into Operator
            textField.setText("");
        }
        if (e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch (Operator){ // we will perform switch function on our Operator
                case '+':
                    result=num1+num2; // adds both values and stores in result
                    break;
                case '-':
                    result=num1-num2; // subtracts both values and stores in result
                    break;
                case '*':
                    result=num1*num2; // multiplies both values and stores in result
                    break;
                case '/':
                    result=num1/num2; // divides both values and stores in result
                    break;
            }
            // After performing math function the result will be displayed on screen
            textField.setText(String.valueOf(result)); // displays the result value
            num1=result; // to perform next continued operations result will be stored into num1
        }
        if (e.getSource()==clrButton){
            textField.setText(""); // This will clear the textField completely
        }
        if (e.getSource()==delButton){
            String temp=textField.getText(); //retrieves the value displyed on the screen
            textField.setText(""); // textField is cleared
            for (int i=0;i<temp.length()-1;i++){
                textField.setText(textField.getText()+temp.charAt(i)); // adds the number text leaving the last digit
            }
        }
        if (e.getSource()==negButton){
            double temp=Double.parseDouble(textField.getText()); //num on textfield will be stored into variable
            temp*=-1; // multiplied with -1
            textField.setText(String.valueOf(temp)); // sets the text with neg multiplied value
        }
    }
}
