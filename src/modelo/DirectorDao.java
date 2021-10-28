
package modelo;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

//Dao
public class DirectorDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Dao para listar los datos.
    public List listar() {

        List<Director> datos = new ArrayList<>();

        String sql = "select * from director;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Director d = new Director();
                d.setDirector(rs.getString(1));
                d.setNacionalidad(rs.getString(2));                
                datos.add(d);

            }

        } catch (Exception e) {

        }

        return datos;
    }
    
    //Dao para agregar los datos
    public int agregar(Director d) {
        int rta_2=0;
        String sql = "insert into director (DIR_NOMBRE,DIR_NACIONALIDAD) values (?,?)";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, d.getDirector());
            ps.setString(2, d.getNacionalidad());
            
            
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
    public int modificar(Director d) {
        int rta = 0;
        String sql = "update director set DIR_NOMBRE=?, DIR_NACIONALIDAD=? where DIR_NOMBRE=?;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, d.getDirector());
            ps.setString(2, d.getNacionalidad());            
            ps.setString(3, d.getDirector());
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
        String sql="delete from director where DIR_NOMBRE="+titulo;
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
