import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NotepadClass implements ActionListener{
    JFrame MainFrame;

    //Text area:
    JTextArea TextArea;
    JScrollPane ScrollPane;
    boolean WordWrapOn = false;//Word wrap off by default

    //Top menu bar
    JMenuBar MenuBar;

    //File menu:
    //There are the options that are displayed on the tab:
    JMenu File, Edit, Format, Color, Credits;

    //Items under File tab:
    JMenuItem New, Open, Save, SaveAs;

    //Items under the Edit tab:
    JMenuItem Copy, Paste, Undo, Redo, SelectAll, Delete, Date;

    //Items under the Color tab:
    JMenuItem Color1, Color2, Color3;

    //Items under the Format tab:
    JMenuItem Wrap, FontArial, FontCSMS, FontTimesNewRoman, FontSize8, FontSize12, FontSize16, FontSize20, FontSize24, FontSize28;
    JMenu Font, FontSize;

    //Item under the Credits tab:
    JMenuItem Authors;

    //Instantiate objects of the classes in order to call upon them
    FileClass fileClass = new FileClass(this);
    FormatClass formatClass = new FormatClass(this);
    ColorClass colorClass = new ColorClass(this);
    EditClass editClass = new EditClass(this);
    CreditsClass creditsClass = new CreditsClass(this);
    UndoManager undoManager = new UndoManager();


    /*Constructor for notepadClass: */
    public NotepadClass(){
        createFrame();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();
        createCreditsMenu();
        //Default font times new roman
        formatClass.selectedFont = "Times New Roman";

        //Default size 20
        formatClass.setFontType(20);

        //Word wrap on by default:
        formatClass.setWordWrap();

//        //Default background color:
//        MainFrame.getContentPane().setBackground(new Color(100,149,237));
//        TextArea.setBackground(new Color(100,149,237));
//        TextArea.setForeground(java.awt.Color.BLACK);
    }

    public void createFrame(){
        MainFrame = new JFrame("JOURNAL");//Creates a new JFrame named Journal
        MainFrame.setLocation(450, 100);//Displays the notepadClass close to the center of the screen
        MainFrame.setSize(600,600);//Sets frame size
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Frame close and program stops running when user clicks on red X
        MainFrame.setVisible(true);//Makes frame visible; won't appear otherwise
    }

    public void createTextArea(){
        TextArea = new JTextArea();

        TextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        ScrollPane = new JScrollPane(TextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setBorder(BorderFactory.createEmptyBorder());//removes border around MainFrame
        MainFrame.add(ScrollPane);

    }

    public void createMenuBar(){
        MenuBar = new JMenuBar();
        MainFrame.setJMenuBar(MenuBar);

        File = new JMenu("FILE");
        MenuBar.add(File);

        Edit = new JMenu("EDIT");
        MenuBar.add(Edit);

        Format = new JMenu("FORMAT");
        MenuBar.add(Format);

        Color = new JMenu("COLOR");
        MenuBar.add(Color);

        Credits = new JMenu("CREDITS");
        MenuBar.add(Credits);
    }

    public void createFileMenu(){
        New = new JMenuItem("New File");
        New.addActionListener(this);
        New.setActionCommand("New");
        File.add(New);

        Open = new JMenuItem("Search/Sort Files");
        Open.addActionListener(this);
        Open.setActionCommand("Open");
        File.add(Open);

        Save = new JMenuItem("Save");
        Save.addActionListener(this);
        Save.setActionCommand("Save");
        File.add(Save);

        SaveAs = new JMenuItem("Save As");
        SaveAs.addActionListener(this);
        SaveAs.setActionCommand("SaveAs");
        File.add(SaveAs);
    }

    public void createEditMenu(){
        Copy = new JMenuItem("Copy");
        Copy.addActionListener(this);
        Copy.setActionCommand("Copy");
        Edit.add(Copy);

        Paste = new JMenuItem("Paste");
        Paste.addActionListener(this);
        Paste.setActionCommand("Paste");
        Edit.add(Paste);

        Undo = new JMenuItem("Undo");
        Undo.addActionListener(this);
        Undo.setActionCommand("Undo");
        Edit.add(Undo);

        Redo = new JMenuItem("Redo");
        Redo.addActionListener(this);
        Redo.setActionCommand("Redo");
        Edit.add(Redo);

        SelectAll = new JMenuItem("Select All");
        SelectAll.addActionListener(this);
        SelectAll.setActionCommand("Select All");
        Edit.add(SelectAll);

        Delete = new JMenuItem("Delete");
        Delete.addActionListener(this);
        Delete.setActionCommand("Delete");
        Edit.add(Delete);

        Date = new JMenuItem("Date");
        Date.addActionListener(this);
        Date.setActionCommand("Date");
        Edit.add(Date);
    }

    public void createFormatMenu(){
        Wrap = new JMenuItem("Word Wrap: Off");
        Wrap.addActionListener(this);
        Wrap.setActionCommand("Word Wrap");
        Format.add(Wrap);

        Font = new JMenu("Font");
        Format.add(Font);

        FontArial = new JMenuItem("Arial");
        FontArial.addActionListener(this);
        FontArial.setActionCommand("Arial");
        Font.add(FontArial);

        FontCSMS = new JMenuItem("Comic Sans MS");
        FontCSMS.addActionListener(this);
        FontCSMS.setActionCommand("Comic Sans MS");
        Font.add(FontCSMS);

        FontTimesNewRoman = new JMenuItem("Times New Roman");
        FontTimesNewRoman.addActionListener(this);
        FontTimesNewRoman.setActionCommand("Times New Roman");
        Font.add(FontTimesNewRoman);


        FontSize = new JMenu("Font Size");
        Format.add(FontSize);

        FontSize8 = new JMenuItem("8");
        FontSize8.addActionListener(this);
        FontSize8.setActionCommand("size8");
        FontSize.add(FontSize8);

        FontSize12 = new JMenuItem("12");
        FontSize12.addActionListener(this);
        FontSize12.setActionCommand("size12");
        FontSize.add(FontSize12);

        FontSize16 = new JMenuItem("16");
        FontSize16.addActionListener(this);
        FontSize16.setActionCommand("size16");
        FontSize.add(FontSize16);

        FontSize20 = new JMenuItem("20");
        FontSize20.addActionListener(this);
        FontSize20.setActionCommand("size20");
        FontSize.add(FontSize20);

        FontSize24 = new JMenuItem("24");
        FontSize24.addActionListener(this);
        FontSize24.setActionCommand("size24");
        FontSize.add(FontSize24);

        FontSize28 = new JMenuItem("28");
        FontSize28.addActionListener(this);
        FontSize28.setActionCommand("size28");
        FontSize.add(FontSize28);
    }

    public void createColorMenu(){
        Color1 = new JMenuItem("White");
        Color1.addActionListener(this);
        Color1.setActionCommand("White");
        Color.add(Color1);

        Color2 = new JMenuItem("Black");
        Color2.addActionListener(this);
        Color2.setActionCommand("Black");
        Color.add(Color2);

        Color3 = new JMenuItem("Blue");
        Color3.addActionListener(this);
        Color3.setActionCommand("Blue");
        Color.add(Color3);
    }

    public void createCreditsMenu(){
        Authors = new JMenuItem("Authors");
        Authors.addActionListener(this);
        Authors.setActionCommand("Authors");
        Credits.add(Authors);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New": fileClass.createNewFile(); break;
            case "Open": fileClass.openFile(); break;
            case "Save": fileClass.saveFile(); break;
            case "SaveAs": fileClass.saveAs(); break;
            case "Copy": editClass.copyText(); break;
            case "Paste": editClass.pasteText(); break;
            case "Undo": editClass.undoText(); break;
            case "Redo": editClass.redoText(); break;
            case "Select All": editClass.selectAllText(); break;
            case "Delete": editClass.deleteText(); break;
            case "Date": editClass.printDate(); break;
            case "Word Wrap": formatClass.setWordWrap(); break;
            case "Arial": formatClass.setFontType(command); break;
            case "Comic Sans MS": formatClass.setFontType(command); break;
            case "Times New Roman": formatClass.setFontType(command); break;
            case "size8": formatClass.setFontType(8); break;
            case "size12": formatClass.setFontType(12); break;
            case "size16": formatClass.setFontType(16); break;
            case "size20": formatClass.setFontType(20); break;
            case "size24": formatClass.setFontType(24); break;
            case "size28": formatClass.setFontType(28); break;
            case "White": colorClass.changeBackgroundColor(command); break;
            case "Black": colorClass.changeBackgroundColor(command); break;
            case "Blue": colorClass.changeBackgroundColor(command); break;
            case "Authors": creditsClass.printAuthors(); break;
        }
    }
}



