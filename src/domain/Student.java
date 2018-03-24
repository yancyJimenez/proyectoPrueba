/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author t440p
 */
public class Student {
    
    private String name, surnames, career, identification;
    private int yearOfEntry;

    public Student(String name, String surnames, String career, String identification, int yearOfEntry) {
        this.name = name;
        this.surnames = surnames;
        this.career = career;
        this.identification = identification;
        this.yearOfEntry = yearOfEntry;
    }
    
    public Student() {
        this.name = "";
        this.surnames = "";
        this.career = "";
        this.identification = "";
        this.yearOfEntry = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surnames
     */
    public String getSurnames() {
        return surnames;
    }

    /**
     * @param surnames the surnames to set
     */
    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    /**
     * @return the career
     */
    public String getCareer() {
        return career;
    }

    /**
     * @param career the career to set
     */
    public void setCareer(String career) {
        this.career = career;
    }

    /**
     * @return the identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return the yearOfEntry
     */
    public int getYearOfEntry() {
        return yearOfEntry;
    }

    /**
     * @param yearOfEntry the yearOfEntry to set
     */
    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surnames=" + surnames + ", career=" + career + ", identification=" + identification + ", yearOfEntry=" + yearOfEntry + '}';
    }
    
}//
