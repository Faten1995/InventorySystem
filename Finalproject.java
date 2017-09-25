package finalproject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @author faten
 */
public class Finalproject extends JFrame {
    static int user = 0;
    static boolean access = false;
    final JPanel panelCont = new JPanel(new CardLayout());	
    CardLayout cl = (CardLayout) panelCont.getLayout();
    public Finalproject(){
        //the frame settings
	super("Alen's store");
	setSize(600, 400);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelCont.setLayout(cl);
        panelCont.setOpaque(true);
	
        //adding the cards
	panelCont.add(new LoginPanel(), "1");	
	panelCont.add(new FirstPanel(), "2");
        panelCont.add(new LoginPanel(), "3");
        panelCont.add(new NewUserPanel(), "4");
        panelCont.add(new Inventotry(), "5");
        panelCont.add(new NewBill(), "6");
	add(panelCont);
	validate();
        setVisible(true);
    }
    public void changePanel(int num){
        switch(num){
            case 1: 
                cl.show(panelCont, "3");
                break;
            case 2: 
                cl.show(panelCont, "2");
                break;
            case 3:
                if(access){
                cl.show(panelCont, "4");
                break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Access not Allowed","Access Denied",JOptionPane.ERROR_MESSAGE);
                    //cl.show(panelCont, "2");
                    break;
                }
            case 4:
                cl.show(panelCont,"5");
                break;
            case 5:
                cl.show(panelCont,"6");
                break;
            

        }
    }


    public static void main(String[] args) {
       
        //Finalproject fp = new Finalproject();
        
	SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
		new Finalproject();
		}
	});
    }
    
    
}

 /*   public static void main(String[] args) {
       
        Finalproject fp = new Finalproject();
        JFrame frame = new JFrame();
        
        frame.getContentPane().add(fp);
         //First Ppanel
        FirstPanel first = new FirstPanel();
        fp.panelCont.add(first, "2");
        
	//panelCont.add(first, "2");
        fp.panelCont.revalidate();
       // panelCont.add(new LoginPanel(), "3");
        //panelCont.add(new NewUserPanel(), "4");
        //panelCont.add(new Inventotry(), "5");
        //fp.init();
        //fp.start();
        //frame.pack();
	frame.setTitle("Alen's store");
	frame.setSize(600, 400);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.validate();
        
        
	
    }
    
    
}
*/