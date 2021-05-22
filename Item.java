import javax.swing.*;

public class Item {
  private ImageIcon image; 
  private String correctAnswer;
  
  Item(ImageIcon image, String correctAnswer){
    this.image = image;
    this.correctAnswer = correctAnswer;
  }
  public ImageIcon getImage(){
    return image;
  }
  public String getCorrectAnswer(){
    return correctAnswer;
  }
  public boolean checkAnswer(String userInput){
    if (userInput.equals(correctAnswer)){
      return true;
    }
    return false;
  }
}