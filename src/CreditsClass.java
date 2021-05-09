public class CreditsClass {
    NotepadClass notepadClass;
    String author = "This notepad application was created for CS3100 by Oscar Rodriguez.";

    //Constructor:
    public CreditsClass (NotepadClass notepadClass){
        this.notepadClass = notepadClass;
    }
    //This method prints author in the text area:
    public void printAuthor(){
        notepadClass.TextArea.setText(String.valueOf(author));
    }

}
