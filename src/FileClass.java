import java.awt.*;
import java.io.*;
import javax.swing.*;

public class FileClass {

    JournalClass journalClass;//import journalClass class and name it journalClass
    String FileName;
    String FileAddress;

    //Constructor:
    public FileClass(JournalClass JournalClass){
        this.journalClass = JournalClass;//we can access the journalClass class
    }

    public void createNewFile(){
        journalClass.TextArea.setText("");
        journalClass.MainFrame.setTitle("New");
        FileName = null;
        FileAddress = null;

    }

    public void openFile(){
        FileDialog fd = new FileDialog(journalClass.MainFrame, "Open", FileDialog.LOAD);//access fileClass dialog
        fd.setVisible(true);// make it appear

        if (fd.getFile()!= null){
            FileName = fd.getFile();
            FileAddress = fd.getDirectory();
            journalClass.MainFrame.setTitle(FileName);
        }
        System.out.println("File address and fileClass name: " + FileAddress + FileName);

        try{
            BufferedReader br = new BufferedReader(new FileReader(FileAddress + FileName));//you need address to read a fileClass
            journalClass.TextArea.setText("");

            String line = null;

            while ((line = br.readLine())!= null){
                journalClass.TextArea.append(line + "\n");
            }
            br.close();

        } catch(Exception e) {
            System.out.println("FILE NOT OPENED");// if you didn't openFile files, it will go through this exception
        }
    }

    public void saveFile(){
        if (FileName == null){
            saveAs();
        }
        else {
            try{
                FileWriter fw = new FileWriter(FileAddress + FileName);
                fw.write(journalClass.TextArea.getText());
                journalClass.MainFrame.setTitle(FileName);
                fw.close();

            }catch(Exception e){
                System.out.println("SOMETHING WENT WRONG");
            }
        }
    }

    public void saveAs(){
        FileDialog fd = new FileDialog(journalClass.MainFrame, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile()!= null){
            FileName = fd.getFile();
            FileAddress = fd.getDirectory();
            journalClass.MainFrame.setTitle(FileName);
        }

        try{
            FileWriter fw = new FileWriter(FileAddress + FileName);
            fw.write(journalClass.TextArea.getText());
            fw.close();

        }catch (Exception e){
            System.out.println("SOMETHING WENT WRONG.");
        }
    }
}

