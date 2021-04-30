import java.awt.*;

public class ColorClass {
    JournalClass journalClass;

    //Constructor
    public ColorClass(JournalClass journalClass){
        this.journalClass = journalClass;
    }

    //This method changes the color of the background text area:
    public void changeBackgroundColor(String color){
        switch(color){
            case "White":
                journalClass.MainFrame.getContentPane().setBackground(Color.WHITE);
                journalClass.TextArea.setBackground(Color.WHITE);
                journalClass.TextArea.setForeground(Color.BLACK);
                break;

            case "Black":
                journalClass.MainFrame.getContentPane().setBackground(Color.BLACK);
                journalClass.TextArea.setBackground(Color.BLACK);
                journalClass.TextArea.setForeground(Color.WHITE);
                break;

            case "Blue":
                journalClass.MainFrame.getContentPane().setBackground(Color.BLUE);
                journalClass.TextArea.setBackground(Color.BLUE);
                journalClass.TextArea.setForeground(Color.WHITE);
                break;
        }
    }
}
