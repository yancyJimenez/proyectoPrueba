
package MetodosPrueba;



public class ObtenerInformacion {
 private String nombre;
 private String carne; 
 private int anoIngreso;
 private String Carrera;
 
    public int solicitarAnoIngreso(int anoIngreso) {

        int ultimoDigito = anoIngreso % 10;

        return ultimoDigito;
    }
    
    public char CursaCarrera(String Carrera){
        
        char ExtraerPrimeraLetra = 0;
        
       switch(Carrera.toUpperCase()){
            case "AGRONOMIA":
                ExtraerPrimeraLetra= ('A');
                break;
            case "EDUCACION":
                ExtraerPrimeraLetra= ('E');
                break;
            case "INFORMATICA":
                ExtraerPrimeraLetra= ('I');
                break;
          
        }
        return ExtraerPrimeraLetra;
    }//Fin CursaCarrera
    
    public String Concecutivo(){
    String concecutivo=""; 
                if (solicitarAnoIngreso(anoIngreso).length > 0) {
                    concecutivo = solicitarAnoIngreso(anoIngreso);//.getconcecutivo();
                    int concecutivoAux= Integer.parseInt(concecutivo.substring(1));
                    concecutivoAux++; // lo hago entero para aumentarlo
                    if (concecutivoAux < 10) {
                        concecutivo = CursaCarrera(Carrera)+solicitarAnoIngreso(anoIngreso)+"000"+ concecutivoAux;
                    } else if (concecutivoAux >= 10 && concecutivoAux<100 )
                        concecutivo = CursaCarrera(Carrera)+solicitarAnoIngreso(anoIngreso)+"00"+ concecutivoAux;
                    else
                        concecutivo = CursaCarrera(Carrera)+solicitarAnoIngreso(anoIngreso)+"0"+ concecutivoAux;
                }else{
                    concecutivo = CursaCarrera(Carrera)+solicitarAnoIngreso(anoIngreso)+"0001";

    }
    return concecutivo;
}
}//Fin ObtenerInformacion
