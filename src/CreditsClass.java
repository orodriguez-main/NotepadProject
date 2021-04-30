public class CreditsClass {
    JournalClass journalClass;
    String authors = "This journal application was created by Oscar .";

    //Constructor:
    public CreditsClass (JournalClass journalClass){
        this.journalClass = journalClass;
    }
    //This method prints authors in the text area:
    public void  printAuthors(){
        journalClass.TextArea.setText(String.valueOf(authors));
    }

}
