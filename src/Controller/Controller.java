package Controller;

import Model.*;
import gui.FormEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller
{
    Database db=new Database();


    public List<Person> getPeople()
    {
        return db.getPeople();
    }
   public void addPerson(FormEvent e)
   {
       String name=e.getName();
       String occupation=e.getOccupation();
       int ageCategoryId=e.getAgeCategory();
       AgeCategory ageCategory=null;
       switch (ageCategoryId)
       {
           case 0:
               ageCategory=AgeCategory.child;
               break;
           case 1:
               ageCategory=AgeCategory.adult;
               break;
           case 2:
               ageCategory=AgeCategory.senior;
               break;
       }
       EmploymentCategory employmentCategory=null;
       String empCat=e.getEmpCategory();
       if(empCat.equals("employed"))
           employmentCategory=EmploymentCategory.employed;
       else if(empCat.equals("selfemployed"))
           employmentCategory=EmploymentCategory.selfEmployed;
       else
           employmentCategory=EmploymentCategory.unEmployed;
       boolean isIndian=e.isIndiancitizen();
       String taxId=e.getTaxId();
       Gender genderCategory=null;
       String gendercat=e.getGender();
       if(gendercat.equals("male"))
           genderCategory=Gender.male;
       else
           genderCategory=Gender.female;
       Person person=new Person(name,occupation,ageCategory,employmentCategory,taxId,genderCategory,isIndian);
       db.addPerson(person);
   }
   public void saveFile(File file) throws IOException
   {
       db.saveToFile(file);
   }
    public void loadFile(File file) throws IOException
    {
        db.LoadfromFile(file);
    }

    public void removePerson(int row)
    {
        db.removePerson(row);
    }
}
