
package modelo;


public class Peliculas {
    String peli_nombre;
    String peli_resumen;
    int peli_año;
    String peli_director;
    
    //constructor vacio
    public Peliculas(){
    }
    //contructro pelicula
    public Peliculas(String peli_nombre,String peli_resumen, int peli_año, String peli_director){
        this.peli_nombre=peli_nombre;
        this.peli_resumen=peli_resumen;
        this.peli_año=peli_año;
        this.peli_director=peli_director;
    }
    
    //geters y setters del constructor

    public String getPeli_nombre() {
        return peli_nombre;
    }

    public String getPeli_resumen() {
        return peli_resumen;
    }

    public int getPeli_año() {
        return peli_año;
    }

    public String getPeli_director() {
        return peli_director;
    }

    public void setPeli_nombre(String peli_nombre) {
        this.peli_nombre = peli_nombre;
    }

    public void setPeli_resumen(String peli_resumen) {
        this.peli_resumen = peli_resumen;
    }

    public void setPeli_año(int peli_año) {
        this.peli_año = peli_año;
    }

    public void setPeli_director(String peli_director) {
        this.peli_director = peli_director;
    }
    
}
