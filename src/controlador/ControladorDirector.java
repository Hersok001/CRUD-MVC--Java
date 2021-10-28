package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;


public class ControladorDirector implements ActionListener{
    
    DirectorDao dao = new DirectorDao();
    Director d = new Director();
    DIRECTOR_INTERFAZ direc = new DIRECTOR_INTERFAZ();    
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Acción al pulsar el botón
    public ControladorDirector(DIRECTOR_INTERFAZ Director) {
        this.direc = Director;

        this.direc.btnListar.addActionListener(this);

        this.direc.btnAgregar.addActionListener(this);

        this.direc.btnModificar.addActionListener(this);

        this.direc.btnAceptar.addActionListener(this);
        
        this.direc.btnEliminar.addActionListener(this);

    }
    //Metodo para mostrar en contenido de la tabla del mysql
    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Director> lista = dao.listar();
        Object[] object = new Object[2];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getDirector();
            object[1] = lista.get(i).getNacionalidad();
            
            modelo.addRow(object);
        }
        direc.tabla.setModel(modelo);
    }
    //metodo para agregar datos al mysql
    public void agregar() {
        String director = direc.txtDirector.getText();
        String nacionalidad = direc.txtNacionalidad.getText();
        

        d.setDirector(director);
        d.setNacionalidad(nacionalidad);
        
        int r = dao.agregar(d);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(direc, "Director almacenado con exito.");
        } else {
            JOptionPane.showMessageDialog(direc, "Se ha presentado un error. Por favor reintente o consulte con su programador.");
        }

    }
    
    //Metodo para limpiar la tabla en la interfaz
    public void limpiarTabla(){
        for (int i =0;i <direc.tabla.getRowCount(); i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    //metodo para modificar datos de la tabla 
    public void modificar() {
        String director = direc.txtDirector.getText();
        String nacionalidad=direc.txtNacionalidad.getText();
        

        d.setDirector(director);
        d.setNacionalidad(nacionalidad);
        

        int r = dao.modificar(d);
        if (r == 1) {
            JOptionPane.showMessageDialog(direc, "Director modificado con exito.");
        } else {
            JOptionPane.showMessageDialog(direc, "Tenga en cuenta que solo puede modificar la nacionalidad. \n Reintente seleccionando la nacionalidad a modificar.");
        }

    }
    
    //metodo para mostrar los datos en los cuadritos de abajo y poderlos editar
    public void seleccionar(){
        int fila = direc.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(direc, "Seleccione una fila");
            } else {
                String Director = (String) direc.tabla.getValueAt(fila, 0);
                String Nacionalidad = (String) direc.tabla.getValueAt(fila, 1);
                

                direc.txtDirector.setText(Director);
                direc.txtNacionalidad.setText(Nacionalidad);
                
            }
    }
    
    //Metodo para eliminar datos
    public void delete(){
            
    int fila = direc.tabla.getSelectedRow();
            
            
            if (fila==-1){
                JOptionPane.showMessageDialog(direc, "Seleccione el director que desea eliminar.");
            }else{
                
                String titulo = (String) direc.tabla.getValueAt(fila, 0).toString();
                
                dao.delete("'"+titulo+"'");
                JOptionPane.showMessageDialog(direc, "Director eliminado.");
            }        
    }
    
   
    //usar el motodo al pulsar los botones
    public void actionPerformed(ActionEvent e) {
        //Mostrar tabla
        if (e.getSource() == direc.btnListar) {
            limpiarTabla();
            listar(direc.tabla);
        }
        
        else if (e.getSource() == direc.btnAgregar) {
            agregar();
            limpiarTabla();
            listar(direc.tabla);
        }
        
        else if (e.getSource() == direc.btnModificar) {
            seleccionar();
            
        }
        else if (e.getSource() == direc.btnAceptar) {
            modificar();
            limpiarTabla();
            listar(direc.tabla);
        }  
        
        //Eliminar datos al pulsar el boton eliminar
        else if(e.getSource()==direc.btnEliminar) {
            delete();
            limpiarTabla();
            listar(direc.tabla);
                     
            
        }
        
    }
    
}
