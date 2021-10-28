
package modelo;

public class Usuarios {
    //atributos
    String alias;
    String nombre;
    String apellido;
    String email;
    String contraseña;
    String telefono;
    String nacimiento;
    

    //constructor vacio
    public Usuarios(){
    
    }
    //constructor general
    public Usuarios(String alias, String nombre, String apellido, String email, String contraseña, String telefono, String nacimiento){
        this.alias=alias;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.contraseña=contraseña;
        this.telefono=telefono;
        this.nacimiento=nacimiento;
    }
    //getters y setters.
    public String getAlias() {
        return alias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    
    
    
    
    
}
