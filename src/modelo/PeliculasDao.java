package modelo;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

public class PeliculasDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //Dao para listar los datos 
    public List Listar() {

        List<Peliculas> datos = new ArrayList<>();

        String sql = "select * from peliculas;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Peliculas p = new Peliculas();
                p.setPeli_nombre(rs.getString(1));
                p.setPeli_resumen(rs.getString(2));
                p.setPeli_año(rs.getInt(3));
                p.setPeli_director(rs.getString(4));
                datos.add(p);

            }

        } catch (Exception e) {

        }

        return datos;
    }
    
     //Dao para agregar los datos
    public int agregar(Peliculas p) {
        int rta_2=0;
        String sql = "insert into peliculas (PELI_NOMBRE,PELI_RESUMEN,PELI_AÑO,PELI_DIRECTOR) values (?,?,?,?)";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getPeli_nombre());
            ps.setString(2, p.getPeli_resumen());
            ps.setInt(3, p.getPeli_año());
            ps.setString(4, p.getPeli_director());
            
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
    public int modificar(Peliculas p) {
        int rta = 0;
        String sql = "update peliculas set PELI_NOMBRE=?, PELI_RESUMEN=?, PELI_AÑO=?,PELI_DIRECTOR=? where PELI_NOMBRE=?;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getPeli_nombre());
            ps.setString(2, p.getPeli_resumen());
            ps.setInt(3, p.getPeli_año());
            ps.setString(4, p.getPeli_director());
            ps.setString(5, p.getPeli_nombre());
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
        String sql="delete from peliculas where PELI_NOMBRE="+titulo;
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
