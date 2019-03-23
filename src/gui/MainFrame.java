package gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {
  //  private JTextArea textArea;
    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;

    public MainFrame()
    {
        super("Hello World");
        //setting layout
        setLayout(new BorderLayout());
        toolBar=new ToolBar();
        textPanel=new TextPanel();
        formPanel=new FormPanel();
        tablePanel=new TablePanel();
        controller=new Controller();
        fileChooser=new JFileChooser();
        tablePanel.setData(controller.getPeople());


        tablePanel.setPersonTableListener(new PersonTableListener()
        {
            public void rowDeleted(int row)
            {
              controller.removePerson(row);
            }
        });
        fileChooser.addChoosableFileFilter(new PersonFileFilter());
        setJMenuBar(createMenuBar());
        //Controller listens to message and tells components what to do
        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
              textPanel.appendText(text);
            }
        });
        formPanel.setFormListener(new FormListener()
                        {
                            public void formEventOccured(FormEvent e)
                            {
//                                String name=e.getName();
//                                String occupation=e.getOccupation();
//                                int ageCategory=e.getAgeCategory();
//                                String empCategory=e.getEmpCategory();
//                                textPanel.appendText("Name is "+name+"\n");
//                                textPanel.appendText("Occupation is "+occupation+"\n");
//                                textPanel.appendText("Age Category is "+ageCategory+"\n");
//                                textPanel.appendText("Emp category is"+empCategory+"\n");
                                controller.addPerson(e);
                                tablePanel.refresh();
                            }
                        });

        add(toolBar,BorderLayout.NORTH);
        add(tablePanel,BorderLayout.CENTER);
       // add(textPanel,BorderLayout.CENTER);
        add(formPanel,BorderLayout.WEST);

        setMinimumSize(new Dimension(500,400));
        //Tells application to exit on clicking close button(x)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(600,500);
       setVisible(true);
    }
    private  JMenuBar createMenuBar()
    {
        JMenuBar menuBar=new JMenuBar();

        JMenu fileMenu=new JMenu("File");
        JMenuItem exportdataitem=new JMenuItem("Export Data...");
        JMenuItem importdataitem=new JMenuItem("Import Data...");
        JMenuItem exititem=new JMenuItem("Exit");
        fileMenu.add(exportdataitem);
        fileMenu.add(importdataitem);
        fileMenu.addSeparator();
        fileMenu.add(exititem);
        menuBar.add(fileMenu);

        JMenu windowMenu=new JMenu("Window");
        JMenu showMenu=new JMenu("Show");
        JCheckBoxMenuItem showformitem=new JCheckBoxMenuItem("Person Form");
        showformitem.setSelected(true);
        showMenu.add(showformitem);
        windowMenu.add(showMenu);//sub menu
        menuBar.add(windowMenu);

        showformitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JCheckBoxMenuItem menuItem=(JCheckBoxMenuItem)e.getSource();
            formPanel.setVisible(menuItem.isSelected());
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F); //press control+option+F on mac
        exititem.setMnemonic(KeyEvent.VK_X);
        exititem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));//Accelator,without opening menu

        importdataitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));

        exititem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                        //TO SET ICON USE INFORMATION MESSAGE OR WARNING MESSAGE OR.....
                // String text=JOptionPane.showInputDialog(MainFrame.this,"Enter name","enter name",JOptionPane.OK_OPTION|JOptionPane.WARNING_MESSAGE);
                // System.out.println(text);
               int action= JOptionPane.showConfirmDialog(MainFrame.this,"Do you want to exit?","Confirm exit",JOptionPane.OK_CANCEL_OPTION);
               if(action==JOptionPane.OK_OPTION)
                System.exit(0);

            }
        });

        importdataitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
            {
                try {
                    controller.loadFile(fileChooser.getSelectedFile());
                    tablePanel.refresh();
                } catch (IOException e1) {

                    JOptionPane.showMessageDialog(MainFrame.this,"Loading data from file failed","Error",JOptionPane.ERROR_MESSAGE);
                }
                System.out.println(fileChooser.getSelectedFile());
            }
            }
        });
        exportdataitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showSaveDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
                {
                    try {
                        controller.saveFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {

                        JOptionPane.showMessageDialog(MainFrame.this,"Saving data to file failed","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });
        return menuBar;
    }
}
