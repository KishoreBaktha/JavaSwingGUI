package gui;

import Model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class TablePanel extends JPanel
{
    private JTable jTable;
    private PersonTableModel tableModel;
    private JPopupMenu jPopupMenu;
    private PersonTableListener personTableListener;
    public TablePanel()
    {
        tableModel=new PersonTableModel();
        jTable=new JTable(tableModel);
        jPopupMenu=new JPopupMenu();
        JMenuItem removeItem=new JMenuItem("Delete row");
        jPopupMenu.add(removeItem);
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int row= jTable.rowAtPoint(e.getPoint()); //selected row
                jTable.getSelectionModel().setSelectionInterval(row,row);//select only one row at a click
               if(e.getButton()==MouseEvent.BUTTON3) //Button3 is right
               {
                   jPopupMenu.show(jTable,e.getX(),e.getY());
               }
            }
        });
       removeItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int row=jTable.getSelectedRow();
               if(personTableListener!=null)
               {
                   personTableListener.rowDeleted(row);
                   tableModel.fireTableRowsDeleted(row,row);
               }

           }
       });
        setLayout(new BorderLayout());
        add(new JScrollPane(jTable),BorderLayout.CENTER);
    }
    public void setData(List<Person> db)
    {
     tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
    public void setPersonTableListener(PersonTableListener listener)
    {
        this.personTableListener=listener;
    }
}
