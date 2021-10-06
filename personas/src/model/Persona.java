package model;

/**
* Esta es una clase pojo de persona
*@author Marta-D4
*@version 0.1
*@since 09/30/2021
*/
public class Persona {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    
    /**
    *Constructor de la clase Persona
    *@param id: variable tipo int, sirve de código identificador
    *@param nombre: variable tipo String, nombre de la persona
    *@param apellido1: variable tipo String, primer apellido de la persona
    *@param apellido2: variable tipo Sring, segundo apellido de la persona
    *@param dni: variable tipo int, dni de la persona
    */
    public Persona(int id, String nombre, String apellido1,String apellido2, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
    }

    /**
    *@return id de la persona en enteros
    */
    public int getID() {
        return id;
    }
    
    /**                                  
    *@return nombre de la persona
    */
    public String getNombre() {
        return nombre;
    }

    /**
    *@return primer apellido de la perona, apellido1
    */
    public String getApellido1() {
        return apellido1;
    }

    /**
    *@return dni de la persona
    */
    public String getDni() {
        return dni;
    }
    
    /**
    *@return segundo apellido de la persona, apellido2
    */
    public String getApellido2() {
        return apellido2;
    }

    /**
    *Metodo que recoge las variables apellido1 y apellido2, uniendolas en una variable String "apellidos"
    *@return los dos apellidos fusionados en un solo String
    */
    public String getApellidos() {
        String apellidos = apellido1 + " " + apellido2;
        
        return apellidos;
    }
    
}