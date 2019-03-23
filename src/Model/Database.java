package Model;

import java.io.*;
import java.util.*;

public class Database
{
    private List<Person> people;
    public Database()
    {
   people=new LinkedList<Person>();

    }
    public void addPerson(Person p)
    {
        people.add(p);
    }
    public List<Person> getPeople()
    {
        return Collections.unmodifiableList(people);
    }
    public void saveToFile(File file) throws IOException
    {
        FileOutputStream fileOutputStream=new FileOutputStream(file);   //using serialization
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
       Person[] persons=people.toArray(new Person[people.size()]);
    objectOutputStream.writeObject(persons);
        objectOutputStream.close();
    }
    public void LoadfromFile(File file)throws IOException
    {
        FileInputStream fileInputStream=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fileInputStream);
        try {
            Person[] persons=(Person[])ois.readObject();
            people.clear();
            people.addAll(Arrays.asList(persons));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    public void removePerson(int row) {
        people.remove(row);
    }
}
