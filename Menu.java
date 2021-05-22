import javax.swing.*; 
import java.awt.event.*;    
import java.awt.*;
import java.awt.FlowLayout;

public class Menu{
  
  Menu (JFrame frame){
    frame.getContentPane().removeAll();
    System.out.println("poggers");
    frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //layout managers set how elements arrange
    frame.setLayout(new FlowLayout());
    
    JLabel title = new JLabel("Environment Game",JLabel.CENTER);
		
    //Icons
    ImageIcon iconPlay = new ImageIcon("Icons/playButtonIMG.png");
    ImageIcon iconRules = new ImageIcon("Icons/rulesButtonIMG.png");
    ImageIcon iconBckgnd = new ImageIcon("Icons/beachBkgnd.gif");
    
    frame = new JFrame() { 
      private Image backgroundImage = ImageIO.read(new File("Icons/beachBkgnd.gif"));
      public void paint( Graphics g ) { 
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, null);
      }
    };

    //JLabel background = new JLabel();
    //background.setIcon(iconBckgnd);

    // Play Button
    JButton playButton = new JButton(iconPlay);
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Game game = new Game(frame);
			}		
		});	
    playButton.setBorder(null);
    playButton.setContentAreaFilled(false);

    // Instructions Button
    JButton instructionsButton = new JButton(iconRules);
    instructionsButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        //TO-DO implement rules either through
        //1. seperate rules page
        //2. url to some doc
        System.out.println("Instructions button");
        Rules rules = new Rules(frame);
      }
    });
    instructionsButton.setBorder(null);
    instructionsButton.setContentAreaFilled(false);
    
    JPanel panel = new JPanel();
    
		//panel.add(background);
    JPanel buttonPanel = new JPanel();
    panel.add(title);
    buttonPanel.add(playButton);
    buttonPanel.add(instructionsButton);
    frame.setLocationRelativeTo(null);
		frame.setVisible(true);    
    frame.add(panel);
    frame.add(buttonPanel);
    frame.setLayout(new GridLayout(3,1));
    frame.getContentPane().add(playButton);
    frame.revalidate();
    frame.repaint();
  }
}