package gui;

import Model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {

private List<Person> db;
private String[] colNames={"ID","NAME","OCCUPATION","AGE Categoty","Employment Category","indian citizen","Tax Id"};

    public void setData(List<Person> db)
    {
        this.db=db;
    }
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person=db.get(rowIndex);
        switch (columnIndex)
        {
            case 0:return person.getId();
            case 1:return person.getName();
            case 2: return person.getOccupation();
            case 3:return person.getAgeCategory();
            case 4:return person.getEmpCategory();
            case 5:return person.isIndiancitizen();
            case 6:return person.getTaxId();
        }
        return null;
    }
}
