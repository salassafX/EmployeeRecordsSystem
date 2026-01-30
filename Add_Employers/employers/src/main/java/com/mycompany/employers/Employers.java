

package com.mycompany.employers;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Employers extends JFrame implements ActionListener{
 private JButton b1,b2;
 
   
    public Employers(){
        setTitle("EmployeeManagmentsSystem");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        b1= new JButton("Add Employee");
        b2= new JButton("Search Employee");
        
        JPanel MainP= (JPanel)getContentPane();
        MainP.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        MainP.add(b1);
        MainP.add(b2);
        
        this.pack();
        setVisible(true);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==b1){
         
         AddEmployee em = new AddEmployee();   
            
    
        }else{
            
        SearchEmployee se = new SearchEmployee();
        }
           setVisible(false);
    }
    
  
    public static void main(String[] args) {
        Employers o = new Employers();
    }
}
