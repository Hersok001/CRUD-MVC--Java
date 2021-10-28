package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

    SeriesDao dao = new SeriesDao();
    Series s = new Series();
    SERIES_INTERFAZ series_interfaz = new SERIES_INTERFAZ();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Acción al pulsar el botón
    public Controlador(SERIES_INTERFAZ series) {
        this.series_interfaz = series;

        this.series_interfaz.btnListar.addActionListener(this);

        this.series_interfaz.btnAgregar.addActionListener(this);

        this.series_interfaz.btnModificar.addActionListener(this);

        this.series_interfaz.btnAceptar.addActionListener(this);
        
        this.series_interfaz.btnEliminar.addActionListener(this);

    }
    //Metodo para mostrar en contenido de la tabla del mysql
    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Series> lista = dao.listar();
        Object[] object = new Object[3];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getTitulo();
            object[1] = lista.get(i).getCapitulos();
            object[2] = lista.get(i).getTemporadas();
            modelo.addRow(object);
        }
        series_interfaz.tabla.setModel(modelo);
    }
    //metodo para agregar datos al mysql
    public void agregar() {
        String titulo = series_interfaz.txtTitulo.getText();
        int capitulos = Integer.parseInt(series_interfaz.txtCapitulos.getText());
        int temporadas = Integer.parseInt(series_interfaz.txtTemporadas.getText());

        s.setTitulo(titulo);
        s.setCapitulos(capitulos);
        s.setTemporadas(temporadas);
        int r = dao.agregar(s);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(series_interfaz, "Serie almacenada con exito.");
        } else {
            JOptionPane.showMessageDialog(series_interfaz, "Se ha presentado un error. Por favor intentelo de nuevo o consulte con su programador.");
        }

    }
    //metodo para modificar datos de la tabla 
    public void modificar() {
        String titulo = series_interfaz.txtTitulo.getText();
        int capitulos = Integer.parseInt(series_interfaz.txtCapitulos.getText());
        int temporadas = Integer.parseInt(series_interfaz.txtTemporadas.getText());

        s.setTitulo(titulo);
        s.setCapitulos(capitulos);
        s.setTemporadas(temporadas);

        int r = dao.modificar(s);
        if (r == 1) {
            JOptionPane.showMessageDialog(series_interfaz, "Serie modificada con exito.");
        } else {
            JOptionPane.showMessageDialog(series_interfaz, "Tenga en cuenta que solo puede editar el número de temporadas y series. \n Intentelo nuevamente seleccionando otro dato a editar.");
        }

    }
    //Metodo para limpiar la tabla en la interfaz
    public void limpiarTabla(){
        for (int i =0;i <series_interfaz.tabla.getRowCount(); i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }

    public void actionPerformed(ActionEvent e) {
        //Mostrar tabla
        if (e.getSource() == series_interfaz.btnListar) {
            limpiarTabla();
            listar(series_interfaz.tabla);
        } 
       
        //AGREGAR DATOS
        else if (e.getSource() == series_interfaz.btnAgregar) {
            agregar();
            limpiarTabla();
            listar(series_interfaz.tabla);
        } 
        
        //Modificar datos
        else if (e.getSource() == series_interfaz.btnModificar) {
            int fila = series_interfaz.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(series_interfaz, "Seleccione una fila");
            } else {
                String nom = (String) series_interfaz.tabla.getValueAt(fila, 0);
                int capi = Integer.parseInt((String) series_interfaz.tabla.getValueAt(fila, 1).toString());
                int temp = Integer.parseInt((String) series_interfaz.tabla.getValueAt(fila, 2).toString());

                series_interfaz.txtTitulo.setText(nom);
                series_interfaz.txtCapitulos.setText("" + capi);
                series_interfaz.txtTemporadas.setText("" + temp);
            }
        } 
        //Aplicar los cambios del modificar
        else if (e.getSource() == series_interfaz.btnAceptar) {
            modificar();
            limpiarTabla();
            listar(series_interfaz.tabla);
        }
        //Eliminar datos al pulsar el boton eliminar
        else if(e.getSource()== series_interfaz.btnEliminar) {
            delete();
            limpiarTabla();
            listar(series_interfaz.tabla);
                     
            
        }
    }
    //Metodo para eliminar datos
    public void delete(){
            
    int fila = series_interfaz.tabla.getSelectedRow();
            
            
            if (fila==-1){
                JOptionPane.showMessageDialog(series_interfaz, "Debe seleccionar el nombre de la serie que quiere eliminar.");
            }else{
                
                String titulo = (String) series_interfaz.tabla.getValueAt(fila, 0).toString();
                
                dao.delete("'"+titulo+"'");
                JOptionPane.showMessageDialog(series_interfaz, "Serie eliminada.");
            }
        
        
        
    }
    

}
