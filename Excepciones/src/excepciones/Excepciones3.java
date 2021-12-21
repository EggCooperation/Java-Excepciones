package excepciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones3 {
public static void main(String[] args) throws ExcepcionPropia {
     crearPersona();
    }
    
    public static void crearPersona() {
        try {
            ingresarDatos();
        } catch (ExcepcionPropia | InputMismatchException ex) { // Recordar que en el mismo bloque puedo concatenar cosas...
            System.out.println(ex.getMessage());
            crearPersona();
        }
    }

    public static void ingresarDatos() throws ExcepcionPropia, InputMismatchException {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("ingrese su nombre");
        String nombreI = leer.next();
        if (nombreI.length() < 2) {//Inventando que si ingresa menos 2 es un 
            throw new ExcepcionPropia(" No ingreso un nombre valido - Vas a tener q reingresar el dato");
        }
        
        System.out.println("Ingrese su edad");
        byte edadI = leer.nextByte();
        if (edadI < 0) {
            throw new ExcepcionPropia(" Como vas a tener menos que 0 años.....");
        }

        System.out.println("LOS DATOS INGRESADOS  SON: "
                + "\n Nombre: " + nombreI.toUpperCase()
                + "\n Edad: " + edadI);
    }
    
}