
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class ControladorPelis implements ActionListener{
    
 PeliculasDao dao = new PeliculasDao();
 Peliculas p = new Peliculas();
 PELIS_INTERFAZ pelis = new PELIS_INTERFAZ();
 DefaultTableModel modelo = new DefaultTableModel();
 
 public ControladorPelis (PELIS_INTERFAZ pelis){
     this.pelis = pelis;

        this.pelis.btnListar.addActionListener(this);

        this.pelis.btnAgregar.addActionListener(this);

        this.pelis.btnModificar.addActionListener(this);

        this.pelis.btnAceptar.addActionListener(this);
        
        this.pelis.btnEliminar.addActionListener(this);    
    }
    //Actualizar/mostrar la tabla
     public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Peliculas> lista = dao.Listar();
        Object[] object = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getPeli_nombre();
            object[1] = lista.get(i).getPeli_resumen();
            object[2] = lista.get(i).getPeli_año();
            object[3] = lista.get(i).getPeli_director();
            modelo.addRow(object);
        }
        pelis.tabla.setModel(modelo);
    }
    //Limpiar la tabla
    public void limpiarTabla(){
        for (int i =0;i <pelis.tabla.getRowCount(); i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    //agregar datos
    public void agregar() {
        
        String titulo = pelis.txtPelicula.getText();
        String resumen = pelis.txtResumen.getText();
        int año = Integer.parseInt(pelis.txtAño.getText());
        String director = pelis.txtDirector.getText();

        p.setPeli_nombre(titulo);
        p.setPeli_resumen(resumen);
        p.setPeli_año(año);
        p.setPeli_director(director);
        int r = dao.agregar(p);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(pelis, "Película almacenada con exito.");
        } else {
            JOptionPane.showMessageDialog(pelis, "Tenga en cuenta que el nombre del Director debe ser igual al de la tabla director. \nReintente por favor.");
        }

    }
    
    //metodo para modificar datos de la tabla 
    public void modificar() {
        String titulo = pelis.txtPelicula.getText();
        String resumen = pelis.txtResumen.getText();
        int año = Integer.parseInt(pelis.txtAño.getText());
        String director = pelis.txtDirector.getText();

        p.setPeli_nombre(titulo);
        p.setPeli_resumen(resumen);
        p.setPeli_año(año);
        p.setPeli_director(director);
        int r = dao.modificar(p);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(pelis, "Película modificada con exito.");
        } else {
            JOptionPane.showMessageDialog(pelis, "Tenga en cuenta que no puede modificar el nombre de la película. \n Intentelo nuevamente seleccionando el dato a modificar.");
        }

    }
    
    //Metodo para eliminar datos
    public void delete(){
            
    int fila = pelis.tabla.getSelectedRow();
            
            
            if (fila==-1){
                JOptionPane.showMessageDialog(pelis, "Seleccione la película que quiere eliminar.");
            }else{
                
                String titulo = (String) pelis.tabla.getValueAt(fila, 0).toString();
                
                dao.delete("'"+titulo+"'");
                JOptionPane.showMessageDialog(pelis, "Película eliminada.");
            }
        
        
        
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    




    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pelis.btnListar) {
            limpiarTabla();
            listar(pelis.tabla);
            
        } 
        
        else if(e.getSource() == pelis.btnAgregar){
            agregar();
            limpiarTabla();
            listar(pelis.tabla);
        }
        
        //Modificar datos
        else if (e.getSource() == pelis.btnModificar) {
            int fila = pelis.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(pelis, "Seleccione la fila que quiere modificar.");
            } else {
                String nom = (String) pelis.tabla.getValueAt(fila, 0);
                String resumen = (String) pelis.tabla.getValueAt(fila, 1);
                int año = Integer.parseInt((String) pelis.tabla.getValueAt(fila, 2).toString());
                String director = (String) pelis.tabla.getValueAt(fila, 3);

                pelis.txtPelicula.setText(nom);
                pelis.txtResumen.setText(resumen);
                pelis.txtAño.setText(""+año);
                pelis.txtDirector.setText(director);
            }
        } 
        //Aplicar los cambios del modificar
        else if (e.getSource() == pelis.btnAceptar) {
            modificar();
            limpiarTabla();
            listar(pelis.tabla);
        }    
        else if (e.getSource() == pelis.btnEliminar){
            delete();
            limpiarTabla();
            listar(pelis.tabla);
        }    
            
    }
    
}

