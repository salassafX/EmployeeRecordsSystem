
package com.mycompany.employers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SearchEmployee extends JFrame implements ActionListener {
    private JLabel l1;
    private JTextField t1;
    private JTextArea ta;
    private JButton b1, b2;

    public SearchEmployee() {
        setTitle("Search Employee");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("Enter Employee ID");
        t1 = new JTextField(10);
        b1 = new JButton("Search");
        ta = new JTextArea();
        b2 = new JButton("Back");

        JPanel MainP = (JPanel) getContentPane();
        MainP.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);

        MainP.add(p1, BorderLayout.NORTH);
        MainP.add(ta, BorderLayout.CENTER);
        MainP.add(b2, BorderLayout.SOUTH);

        this.pack();
        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

public void actionPerformed(ActionEvent e){

    if(e.getSource()==b1){

        try{
            if(t1.getText().isEmpty()){
                throw new empty("pleases enter number to search");
            } 

            BufferedReader br= new BufferedReader(new FileReader("Empo.txt"));
            Boolean b=false;
            String Line;
            String st[];

            while((Line=br.readLine())!=null){
                st=Line.split(";");
                if(st[0].equals(t1.getText())){
                    ta.setText("Name:"+st[1]+"\nDepartment:"+st[2]+"\nSalary:"+st[3]);
                    b=true;
                }
                if(b==false){
                    JOptionPane.showMessageDialog(null,"No Employee is found","no output",JOptionPane.WARNING_MESSAGE);
                }
            }
        }catch(FileNotFoundException y){
            System.out.println("path not found");}
         catch(IOException x){
            System.out.println("I/O Exception"); 
        
        }catch(empty z){
         JOptionPane.showMessageDialog(null,"No Employee is found","no output",JOptionPane.WARNING_MESSAGE);
        }

    } else { 
        Employers o = new Employers();
          setVisible(false);
    }
}
}
