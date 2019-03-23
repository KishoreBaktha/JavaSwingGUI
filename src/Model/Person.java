package Model;

import java.io.Serializable;

public class Person implements Serializable
{
    private static int count=0;
    private int id;//unique key in database
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory empCategory;
    private String taxId;
    private Gender gender;
    private boolean indiancitizen;


    public Person(String name,String occupation,AgeCategory ageCategory,EmploymentCategory empCategory,String taxId,Gender gender,boolean indiancitizen)

    {
        this.name=name;
        this.occupation=occupation;
        this.ageCategory=ageCategory;
        this.empCategory=empCategory;
        this.taxId=taxId;
        this.gender=gender;
        this.indiancitizen=indiancitizen;
        this.id=count;
        count++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(EmploymentCategory empCategory) {
        this.empCategory = empCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isIndiancitizen() {
        return indiancitizen;
    }

    public void setIndiancitizen(boolean indiancitizen) {
        this.indiancitizen = indiancitizen;
    }
}
