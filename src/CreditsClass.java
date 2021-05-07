public class CreditsClass {
    NotepadClass notepadClass;
    String authors = "This journal application was created for CS3100 by Oscar Rodriguez.";

    //Constructor:
    public CreditsClass (NotepadClass notepadClass){
        this.notepadClass = notepadClass;
    }
    //This method prints authors in the text area:
    public void  printAuthors(){
        notepadClass.TextArea.setText(String.valueOf(authors));
    }

}
