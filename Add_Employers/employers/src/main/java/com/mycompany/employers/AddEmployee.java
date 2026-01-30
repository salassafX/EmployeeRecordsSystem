package com.mycompany.employers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AddEmployee extends JFrame implements ActionListener{
    private JLabel l1,l2,l3,l4;
    private JTextField t1,t2,t3,t4;
    private JButton b1,b2;
    
    public AddEmployee(){
         setTitle("Add Employee");
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         
         l1= new JLabel("Emploee ID:");
         l2= new JLabel("Name:");
         l3= new JLabel("Department:");
         l4= new JLabel("Salary");
         
         t1= new JTextField(10);
         t2= new JTextField(10);
         t3= new JTextField(10);
         t4= new JTextField(10);
         
         b1= new JButton("Save");
         b2= new JButton("Back");
         
         JPanel MainP=(JPanel)getContentPane();
         MainP.setLayout(new GridLayout(5,2));
         
         MainP.add(l1); MainP.add(t1);
         MainP.add(l2); MainP.add(t2);
         MainP.add(l3); MainP.add(t3);
         MainP.add(l4); MainP.add(t4);
         MainP.add(b1); MainP.add(b2);
         
         this.pack();
         setVisible(true);
         
         b1.addActionListener(this);
         b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){ //Save Button
            
            try{
             if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty()){
                 throw new empty("Fill All Fields !!!!");
             }   
             
             BufferedWriter bf= new BufferedWriter(new FileWriter("Empo.txt",true));
             String s = t1.getText() + ";" + t2.getText() + ";" + t3.getText() + ";" + t4.getText();
             bf.write(s);
             bf.newLine();
             bf.close();
             
            }catch(IOException  x){
                System.out.println("I/O error!!");
            }catch(empty y){
               JOptionPane.showMessageDialog(null,y.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        } else{ //Back Buton
           Employers c = new Employers();
           this.setVisible(false);
        }
    }
    
}
