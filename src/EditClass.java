import java.util.Date;
public class EditClass {
    JournalClass journalClass;
    Date date = new Date();

    //Constructor:
    public EditClass(JournalClass journalClass){
        this.journalClass = journalClass;
    }

    public void copyText(){
        journalClass.TextArea.copy();
    }

    public void pasteText(){
        journalClass.TextArea.paste();
    }

    public void undoText(){
        journalClass.undoManager.undo();
    }

    public void redoText(){
        journalClass.undoManager.redo();
    }

    public void selectAllText(){
        journalClass.TextArea.selectAll();
    }

    public void deleteText(){
        journalClass.TextArea.replaceSelection("");
    }

    public void printDate(){
        journalClass.TextArea.setText(String.valueOf(date));
    }
}
