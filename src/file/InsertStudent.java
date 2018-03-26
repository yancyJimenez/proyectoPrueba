package file;

/**
 *
 * @author Jesus
 */
public class InsertStudent {
    int counter = 0;

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
        System.out.println(id);
        return id;
    }

}//Fin ObtenerInformacion
