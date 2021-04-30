import java.awt.*;

public class FormatClass {
    JournalClass journalClass;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public FormatClass(JournalClass JournalClass){
        this.journalClass = JournalClass;
    }

    public void setWordWrap(){
        if (journalClass.WordWrapOn == false){
            journalClass.WordWrapOn = true;
            journalClass.TextArea.setLineWrap(true);
            journalClass.TextArea.setWrapStyleWord(true);
            journalClass.Wrap.setText("Word Wrap: On");
        }
        else if (journalClass.WordWrapOn == true){
            journalClass.WordWrapOn = false;
            journalClass.TextArea.setLineWrap(false);
            journalClass.TextArea.setWrapStyleWord(false);
            journalClass.Wrap.setText("Word Wrap: On");
        }
    }

    public void setFontType(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        setFontType(selectedFont);
    }

    public void setFontType(String font){
        selectedFont = font;
        switch (selectedFont){
            case "Arial": journalClass.TextArea.setFont(arial);break;
            case "Comic Sans MS": journalClass.TextArea.setFont(comicSansMS);break;
            case "Times New Roman": journalClass.TextArea.setFont(timesNewRoman); break;
        }
    }
}
