package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class ControladorUsuarios implements ActionListener {

    UsuariosDao dao = new UsuariosDao();
    Usuarios u = new Usuarios();
    USUARIOS_INTERFAZ interfaz = new USUARIOS_INTERFAZ();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorUsuarios(USUARIOS_INTERFAZ Usuarios) {
        this.interfaz = Usuarios;
        this.interfaz.btnListar.addActionListener(this);
        this.interfaz.btnAgregar.addActionListener(this);
        this.interfaz.btnEditar.addActionListener(this);
        this.interfaz.btnAplicar.addActionListener(this);
        this.interfaz.btnEliminar.addActionListener(this);
        this.interfaz.btnBuscar.addActionListener(this);

    }

    //Metodo para mostrar en contenido de la tabla del mysql
    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Usuarios> lista = dao.listar();
        Object[] object = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getAlias();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getEmail();
            object[4] = lista.get(i).getContraseña();
            object[5] = lista.get(i).getTelefono();
            object[6] = lista.get(i).getNacimiento();

            modelo.addRow(object);
        }
        interfaz.tabla.setModel(modelo);
    }
    
    //agregar datos
    public void agregar() {
        
        String alias = interfaz.txtAlias.getText();
        String nombre = interfaz.txtNombre.getText();
        String apellido =interfaz.txtApellido.getText();
        String email = interfaz.txtCorreo.getText();
        String contraseña = interfaz.txtContraseña.getText();
        String telefono = interfaz.txtTelefono.getText();
        String nacimiento = interfaz.txtNacimiento.getText();

        u.setAlias(alias);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setEmail(email);
        u.setContraseña(contraseña);
        u.setTelefono(telefono);
        u.setNacimiento(nacimiento);
        
        
        
        
        int r = dao.agregar(u);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(interfaz, "Usuario almacenado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(interfaz, "Se ha presentado un error, por favor consulte con su programador.");
        }

    }
    
    //Limpiar la tabla
    public void limpiarTabla(){
        for (int i =0;i <interfaz.tabla.getRowCount(); i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    //metodo para mostrar los datos en los cuadritos de abajo y poderlos editar
    public void seleccionar(){
        int fila = interfaz.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(interfaz, "Seleccione una fila.");
            } else {
                String alias = (String) interfaz.tabla.getValueAt(fila, 0);
                String nombre = (String) interfaz.tabla.getValueAt(fila, 1);
                String apellido = (String) interfaz.tabla.getValueAt(fila, 2);
                String correo = (String) interfaz.tabla.getValueAt(fila, 3);
                String contraseña = (String) interfaz.tabla.getValueAt(fila, 4);
                String telefono = (String) interfaz.tabla.getValueAt(fila, 5);
                String nacimiento = (String) interfaz.tabla.getValueAt(fila, 6);
                
                

                interfaz.txtAlias.setText(alias);
                interfaz.txtNombre.setText(nombre);
                interfaz.txtApellido.setText(apellido);
                interfaz.txtCorreo.setText(correo);
                interfaz.txtContraseña.setText(contraseña);
                interfaz.txtTelefono.setText(telefono);
                interfaz.txtNacimiento.setText(nacimiento);
            }
    }
    
    //metodo para modificar datos de la tabla 
    public void modificar() {
        String alias = interfaz.txtAlias.getText();
        String nombre = interfaz.txtNombre.getText();
        String apellido =interfaz.txtApellido.getText();
        String email = interfaz.txtCorreo.getText();
        String contraseña = interfaz.txtContraseña.getText();
        String telefono = interfaz.txtTelefono.getText();
        String nacimiento = interfaz.txtNacimiento.getText();
        

        u.setAlias(alias);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setEmail(email);
        u.setContraseña(contraseña);
        u.setTelefono(telefono);
        u.setNacimiento(nacimiento);
        

        int r = dao.modificar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(interfaz, "Usuario modificado con exito.");
        } else {
            JOptionPane.showMessageDialog(interfaz, "Tenga en cuenta que no puede modificar el alias del usuario. \n Reintente por favor.");
        }

    }
   
    
    //Metodo para eliminar datos
    public void delete(){
            
    int fila = interfaz.tabla.getSelectedRow();
            
            
            if (fila==-1){
                JOptionPane.showMessageDialog(interfaz, "Seleccione el usuario que desea eliminar.");
            }else{
                
                String alias = (String) interfaz.tabla.getValueAt(fila, 0).toString();
                
                dao.delete("'"+alias+"'");
                JOptionPane.showMessageDialog(interfaz, "Usuario eliminado.");
            }        
    }

    
        //Metodo para mostrar en contenido de la tabla del mysql
    public void buscar(JTable tabla) {
        
        modelo = (DefaultTableModel) tabla.getModel();
        
        String atributo = (String) interfaz.txtBuscar.getText();
        
        List<Usuarios> lista = dao.buscar("'"+atributo+"'");
        
        Object[] object = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getAlias();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getEmail();
            object[4] = lista.get(i).getContraseña();
            object[5] = lista.get(i).getTelefono();
            object[6] = lista.get(i).getNacimiento();

            modelo.addRow(object);
        }
        interfaz.tabla.setModel(modelo);
        
        
               
        
          
        
        
        
    }
        
         
    
        
    
    public void actionPerformed(ActionEvent e) {

        //Mostrar tabla
        if (e.getSource() == interfaz.btnListar) {
            limpiarTabla();
            listar(interfaz.tabla);
        }
        
        //agregar datos
        if (e.getSource()== interfaz.btnAgregar){
            agregar();
            limpiarTabla();
            listar(interfaz.tabla);
            
            
        }
        
        //modificar datos
        if (e.getSource()==interfaz.btnEditar){
            seleccionar();
        }
        if (e.getSource()==interfaz.btnAplicar){
            modificar();
            limpiarTabla();
            listar(interfaz.tabla);            
        }
        
        //eliminar datos
        if(e.getSource()==interfaz.btnEliminar){
            delete();
            limpiarTabla();
            listar(interfaz.tabla);
        }
        //buscar datos
        if(e.getSource()==interfaz.btnBuscar){
            limpiarTabla();
            buscar(interfaz.tabla);
            
        }
            

    }

}
