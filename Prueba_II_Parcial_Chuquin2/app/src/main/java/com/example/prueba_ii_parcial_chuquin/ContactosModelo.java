package com.example.prueba_ii_parcial_chuquin;

public class ContactosModelo {

    private String nombre,telefono,correo;

    public ContactosModelo(){

     }
public ContactosModelo(String nombre, String telefono, String correo){
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;

}

public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    public String getTelefono(){return telefono;}
    public void setTelefono(String telefono){this.telefono=telefono;}

    public String getCorreo(){return correo;}
    public void setCorreo(String correo){this.correo=correo;}


}
