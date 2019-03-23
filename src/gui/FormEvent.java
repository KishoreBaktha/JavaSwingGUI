package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
    String name;
    String occupation;
    private int ageCategory;
    private String empCategory;
    private String taxId;

    public String getGender() {
        return gender;
    }

    private String gender;

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isIndiancitizen() {
        return indiancitizen;
    }

    public void setIndiancitizen(boolean indiancitizen) {
        this.indiancitizen = indiancitizen;
    }

    private boolean indiancitizen;

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
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
    public FormEvent(Object source) {
        super(source);
    }
    public FormEvent(Object source,String name,String occupation,int ageCategory,String empCategory,String taxId,boolean indiancitizen,String gender) {
        super(source);
        this.name=name;
        this.occupation=occupation;
        this.ageCategory=ageCategory;
        this.empCategory=empCategory;
        this.taxId=taxId;
        this.indiancitizen=indiancitizen;
        this.gender=gender;
    }

    public String getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
    }
}
