
package modelo;


public class Director {
    String director;
    String nacionalidad;

    //constructor vacio
    public Director(){
    }
    
    //constructor director
    public Director(String director,String nacionalidad){
        this.director=director;
        this.nacionalidad=nacionalidad;        
    }

    public String getDirector() {
        return director;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
}
