
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;




public class Rules {
    JFrame jf;

    public Rules(JFrame frame){
        this.jf = frame;
        jf.getContentPane().removeAll(); //removes all elements from the main menu        jf.revalidate();

        ImageIcon rules = new ImageIcon("Icons/rules.png");
        JLabel background = new JLabel(rules);        
        JButton backToMenu = new JButton("Back To Menu");
        backToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("BBack to menu");
                Menu m = new Menu(jf);
            }
        });
        
        jf.setLayout(new GridLayout(0,1));
        // jf.add(exit);
        jf.add(background);
        jf.add(backToMenu);

        jf.repaint();
        jf.revalidate();
        
        
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}