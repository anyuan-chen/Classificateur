
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;




public class GameFinished {
    JFrame jf;
    JPanel finalScore = new JPanel();

    public GameFinished(JFrame frame, int score){
        this.jf = frame;
        jf.getContentPane().removeAll(); //removes all elements from the main menu        jf.revalidate();
        JLabel scoreLabel = new JLabel("Score: " + Integer.toString(score));
        finalScore.add(scoreLabel);
        JButton exitToMenu = new JButton("Exit To Menu");
        exitToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("back to menu");
                Menu m = new Menu(jf);
            }
        });
        

        jf.add(finalScore);
        // jf.add(exit);
        jf.add(exitToMenu);
        jf.setLayout(new FlowLayout());
        jf.repaint();
        jf.revalidate();
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}