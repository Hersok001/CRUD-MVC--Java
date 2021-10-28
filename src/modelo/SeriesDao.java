package modelo;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

//Creamos el Dao que nos permitira hacer las consultas de los datos para posteriormente hacer los metodos.
public class SeriesDao {
    
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Dao para listar los datos.
    public List listar() {

        List<Series> datos = new ArrayList<>();

        String sql = "select * from series;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Series s = new Series();
                s.setTitulo(rs.getString(1));
                s.setCapitulos(rs.getInt(2));
                s.setTemporadas(rs.getInt(3));
                datos.add(s);

            }

        } catch (Exception e) {

        }

        return datos;
    }
    //Dao para agregar los datos
    public int agregar(Series s) {
        int rta_2=0;
        String sql = "insert into series (SERIE_TITULO,SER_CAPITULOS,SER_TEMPORADAS) values (?,?,?)";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, s.getTitulo());
            ps.setInt(2, s.getCapitulos());
            ps.setInt(3, s.getTemporadas());
            
           rta_2= ps.executeUpdate();
           if(rta_2==1){
               return 1;
           }else{
               return 0;
           }
        
        } catch (Exception e) {
        }

        return rta_2;
    }
    //Dao para modificar datos
    public int modificar(Series s) {
        int rta = 0;
        String sql = "update series set SERIE_TITULO=?, SER_CAPITULOS=?, SER_TEMPORADAS=? where SERIE_TITULO=?;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, s.getTitulo());
            ps.setInt(2, s.getCapitulos());
            ps.setInt(3, s.getTemporadas());
            ps.setString(4, s.getTitulo());
            rta = ps.executeUpdate();
            if (rta == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {

        }
        return rta;
    }

    //Dao para eliminar datos
    public int delete(String titulo){
               
        int rta= 0;
        String sql="delete from series where SERIE_TITULO="+titulo;
        try{
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);             
            rta= ps.executeUpdate();
        
        if(rta==1){
            return 1;
        }else{
            return 0;
        }    
                        
        }catch (Exception e){
            
        }
    return rta;
}
    
    
}
