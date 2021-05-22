import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;



public class Game {
    JFrame jf;
    int currentItem = 0;
    ArrayList<Item> al = new ArrayList<>();
    int score = 0;
    int timeLeft = 30;
    JPanel imagePanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JPanel timerPanel = new JPanel();
    JPanel timerandScore = new JPanel();
    public Game(JFrame frame){
        this.jf = frame;
        jf.getContentPane().removeAll();
        jf.repaint();
        jf.revalidate();
        createItemList();
        //ui for buttons
        JPanel buttonPanel = new JPanel();

        JButton recycling = new JButton("Recycling");
        recycling.setBackground(Color.BLUE);
        recycling.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                callNextItem("recycling");
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });

        JButton compost = new JButton("Compost");
        compost.setBackground(Color.GREEN);
        compost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                callNextItem("compost");
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });

        JButton garbage = new JButton("Garbage");
        garbage.setBackground(Color.GRAY);
        garbage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                callNextItem("garbage");
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });


        //adding buttons
        buttonPanel.add(recycling);
        buttonPanel.add(compost);
        buttonPanel.add(garbage);
        

        //add a timer! 
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timeLeft--;
                timerPanel.removeAll();
                JLabel timerLabel = new JLabel("Time: " + timeLeft);
                timerPanel.add(timerLabel);
                timerPanel.revalidate();
                timerPanel.repaint();
                if (timeLeft == 0){
                    GameFinished gf = new GameFinished(jf, score);
                }
            }
        });
        timer.start();

        //overall layout
        

        jf.add(buttonPanel);
        Item cur = al.get(currentItem);
        JLabel imageLabel = new JLabel(cur.getImage());
        imagePanel.add(imageLabel);
        //score panel
        JLabel scoreLabel = new JLabel("Score: " + Integer.toString(score));
        scorePanel.add(scoreLabel);
        jf.repaint();
        jf.revalidate();
        timerandScore.add(scorePanel);
        timerandScore.add(timerPanel);
        jf.add(timerandScore);
        jf.add(buttonPanel);
        jf.add(imagePanel);
        jf.setLayout(new GridLayout(0,1));
        jf.setSize(600,1000);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    private void createItemList(){
        //create icon, then add the icon to the list of items
        //ADD NEW WASTE ITEMS HERE!!!
        ImageIcon styrofoam = new ImageIcon("Icons/styrofoam.png");
        al.add(new Item(styrofoam, "garbage"));

        ImageIcon food = new ImageIcon("Icons/foodScraps.png");
        al.add(new Item(food, "compost"));

        ImageIcon paperTowels = new ImageIcon("Icons/paperTowel.png");
        al.add(new Item(paperTowels, "compost"));

        ImageIcon teaBag = new ImageIcon("Icons/teaBag.png");
        al.add(new Item(teaBag, "compost"));

        ImageIcon tissueBox = new ImageIcon("Icons/tissueBox.png");
        al.add(new Item(tissueBox, "recycling"));

        ImageIcon pizzaBox = new ImageIcon("Icons/pizzaBox.png");
        al.add(new Item(pizzaBox, "recycling"));

        ImageIcon cd = new ImageIcon("Icons/cd.png");
        al.add(new Item(cd, "garbage"));

        ImageIcon mask = new ImageIcon("Icons/mask.png");
        al.add(new Item(mask, "garbage"));

        ImageIcon coke = new ImageIcon("Icons/coke.png");
        al.add(new Item(coke, "recycling"));
    }
    public void callNextItem(String whoCalledMe){
        //process score!
        if (currentItem != -1 && currentItem < al.size() && al.get(currentItem).checkAnswer(whoCalledMe)){
            score++;
            updateScorePanel();
        }

        // end the game if we reached item
        if (currentItem == al.size()-1){
            GameFinished gf = new GameFinished(jf, score);
        }
        else{ //add the next item to the pane
            currentItem++;
            Item cur = al.get(currentItem);
            imagePanel.removeAll();
            JLabel imageLabel = new JLabel(cur.getImage());
            imagePanel.add(imageLabel);
            imagePanel.revalidate();
            imagePanel.repaint();
            System.out.println("i love layout");
            jf.add(imagePanel);
            jf.revalidate();
            jf.repaint();
        }

    }
    public void updateScorePanel(){
      scorePanel.removeAll(); 
      JLabel scoreLabel = new JLabel("Score: " + Integer.toString(score));
      scorePanel.add(scoreLabel);
      scorePanel.revalidate();
      scorePanel.repaint();
      jf.revalidate();
      jf.repaint();
    }
    
}