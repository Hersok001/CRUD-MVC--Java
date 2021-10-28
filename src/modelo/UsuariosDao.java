
package modelo;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UsuariosDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //dao para listar los datos 
    public List listar() {

        List<Usuarios> datos = new ArrayList<>();

        String sql = "select * from usuarios;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setAlias(rs.getString(1));
                u.setNombre(rs.getString(2)); 
                u.setApellido(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setContraseña(rs.getString(5));
                u.setTelefono(rs.getString(6));
                u.setNacimiento(rs.getString(7));
                
                datos.add(u);

            }

        } catch (Exception e) {

        }

        return datos;
    }
    
     //Dao para agregar los datos
    public int agregar(Usuarios u) {
        int rta_2=0;
        String sql = "insert into usuarios (USER_ALIAS,USER_NOMBRE,USER_APELLIDO,USER_EMAIL,USER_CONTRASEÑA,USER_TELEFONO,USER_NACIMIENTO) values (?,?,?,?,?,?,?)";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getAlias());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getContraseña());
            ps.setString(6, u.getTelefono());
            ps.setString(7, u.getNacimiento());
            
            
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
    public int modificar(Usuarios u) {
        int rta = 0;
        String sql = "update usuarios set USER_ALIAS=?, USER_NOMBRE=?, USER_APELLIDO=?,USER_EMAIL=?,USER_CONTRASEÑA=?,USER_TELEFONO=?,USER_NACIMIENTO=? "
                + "where USER_ALIAS=?;";

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getAlias());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getContraseña());
            ps.setString(6, u.getTelefono());
            ps.setString(7, u.getNacimiento());
            ps.setString(8, u.getAlias());
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
    public int delete(String alias){
               
        int rta= 0;
        String sql="delete from usuarios where user_alias="+alias;
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
    
    //Dao para consultar un solo datos
    
    public List buscar(String atributo) {

        List<Usuarios> datos = new ArrayList<>();

        String sql = "select * from usuarios WHERE USER_ALIAS="+atributo;

        try {
            con = conectar.Getconection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setAlias(rs.getString(1));
                u.setNombre(rs.getString(2)); 
                u.setApellido(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setContraseña(rs.getString(5));
                u.setTelefono(rs.getString(6));
                u.setNacimiento(rs.getString(7));
                
                datos.add(u);

            }

        } catch (Exception e) {

        }

        return datos;
    }
    


    




















    
}
