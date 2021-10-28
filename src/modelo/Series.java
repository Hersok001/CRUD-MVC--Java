
package modelo;

// Creamos los atributos que tiene la tabla de la que queremos hacer el MVC.
public class Series {
    String titulo;
    int capitulos;
    int temporadas;
    
    //constructor vacio
    public Series(){
        
    }
    //constructor principal
    public Series(String titulo,int capitulos,int temporadas){
        this.titulo=titulo;
        this.capitulos=capitulos;
        this.temporadas=temporadas;
    }

    //geters y setters de los atributos
    public String getTitulo() {
        return titulo;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    
    
    
    
}
