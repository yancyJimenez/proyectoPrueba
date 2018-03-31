package file;

import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public class StudentFile {
    public RandomAccessFile studentRAF;
    private int regQuantity, regSize;
    int counter = 0;
    private String myFilePath;
    
    public void studentFile(File studentFile) throws IOException{
        myFilePath = studentFile.getPath();
        this.regSize = 100;
        if (studentFile.exists() && !studentFile.isFile()) {
            throw new IOException(studentFile.getName() + " no es un archivo");
        } else {
            studentRAF = new RandomAccessFile(studentFile, "rw");
            regQuantity = (int) Math.ceil(
                (double) studentRAF.length() / (double) regSize);
        }
    }
    
    public void close() throws IOException {
        studentRAF.close();
    }
    
    public boolean insertStudent(Student student) throws IOException {
        boolean success = putStudent(this.regQuantity, student);
        if(success){
            ++this.regQuantity;
        }
        return success;
    }
    
    public int getRegQuantity() {
        return this.regQuantity;
    }
    
    public boolean putStudent(int position, Student student) throws IOException {
        if (position < 0 && position >= getRegQuantity()) {
            System.err.println("1001 - Posición del registro está fuera de los límites");
            return false;
        } else {
            if (student.sizeInBytes() > regSize){
                System.err.println("1002 - Tamaño del registro está fuera de los límites");
                return false;
            }else{
                studentRAF.seek(position * regSize);
                studentRAF.writeUTF(student.getName());
                studentRAF.writeUTF(student.getSurnames());
                studentRAF.writeUTF(student.getCareer());
                studentRAF.writeUTF(student.getIdentification());
                studentRAF.writeInt(student.getYearOfEntry());
                return true;
            }
        }
    }
    
    public Student getStudent(int position) throws IOException {
        if (position >= 0 && position <= getRegQuantity()) {
            studentRAF.seek(position * regSize);
            return new Student(studentRAF.readUTF(), studentRAF.readUTF(), studentRAF.readUTF(), studentRAF.readUTF(), studentRAF.readInt());
        } else {
            System.out.println("1003 - Posición del registro está fuera de los límites");
            return null;
        }
    }
    
    public boolean deleteStudent(String id) throws IOException{
        Student myStudent;
        
        //buscar el estudiante
        for(int i = 0; i < this.regQuantity; i++){
            //obtener el estudiante de la posici'on actual
            myStudent = this.getStudent(i);
            
            //preguntar si es el estudiante que deseo eliminar
            if(myStudent.getName().equalsIgnoreCase(id)){
                //marcar como eliminado
                myStudent.setName("deleted");
                
                return this.putStudent(i, myStudent);
            }
        }
        return false;
    }
    
    public ArrayList<Student> getAllStudents() throws IOException{
        ArrayList<Student> studentsArray = new ArrayList<>();
        
        for(int i = 0; i < this.regQuantity; i++){
            Student sTemp = this.getStudent(i);
            
            if(sTemp != null){
                studentsArray.add(sTemp);
            }
        }//end for
        return studentsArray;
    }

    public int requestYearOfEntry(int yearOfEntry) {

        int lastDigit = yearOfEntry % 10;

        return lastDigit;

    }

    public String putCareer(String career) {

        char firstLetter = 0;

        switch (career) {

            case "Agronomía":

                firstLetter = 'A';

                break;

            case "Educación":

                firstLetter = 'E';

                break;

            case "Informática":

                firstLetter = 'I';

                break;

        }

        return firstLetter + "";

    }//Fin CursaCarrera

    public int consecutive() {
        return ++counter;
    }
    
    public String generateID(String career, int year){
        String id = "";
        if (counter < 10) {
            id = putCareer(career) + + requestYearOfEntry(year) + "00" + consecutive();
        } else if (counter < 100){
            id = putCareer(career) + requestYearOfEntry(year) + "0" + consecutive();
        } else {
            id = putCareer(career) + requestYearOfEntry(year) + consecutive() + "";
        }
        return id;
    }

}//Fin ObtenerInformacion
