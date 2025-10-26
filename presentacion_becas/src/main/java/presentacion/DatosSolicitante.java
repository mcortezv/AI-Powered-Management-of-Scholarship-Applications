package presentacion;

import dto.DatosSolicitanteDTO;
import org.w3c.dom.Text;
import presentacion.interfaces.IControlPantalla;
import presentacion.panels.NorthPanel;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Panel;
import presentacion.styles.TextField;

import javax.accessibility.Accessible;
import java.awt.event.ActionEvent;

public class DatosSolicitante extends Panel {
    private TextField nombreField;
    private TextField primerApellidoField;
    private TextField segundoApellidoField;
    private TextField direccionField;
    private TextField telefonoField;
    private TextField emailField;
    Button btnNext;
    Button btnBack;

    private final IControlPantalla controlPantalla;

    public DatosSolicitante(IControlPantalla control, MainFrame frame, NorthPanel northPanel){
        super(frame, northPanel);
        this.controlPantalla = control;
    }

    public void startComponents(){
        central();
        south();


    }

    private void central(){
        Label lblPromedio= new Label("Que promedio llevas actualmente?");
        TextField campoTexto= new TextField(1);
        Label lblCarga= new Label("Estas cursando la carga completa?");
        TextField campoCarga= new TextField(1);
        Label lblIngreso= new Label("Cual es el ingreso mensual total de tu familia?");
        TextField campoIngreso= new TextField(1);
        centralPanel.add(lblPromedio);
        centralPanel.add(campoTexto);
        centralPanel.add(lblCarga);
        centralPanel.add(campoCarga);
        centralPanel.add(lblIngreso);
        centralPanel.add(campoIngreso);

    }

    private void south(){
        btnNext= new Button("Aceptar");
        southPanel.add(btnNext);
    }

    private void guardarDatos(ActionEvent e){
        String nombre = nombreField.getText();
        String primerApellido = primerApellidoField.getText();
        String segundoApellido = segundoApellidoField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();

        DatosSolicitanteDTO datosSolicitanteDTO = new DatosSolicitanteDTO(nombre,primerApellido,segundoApellido,direccion,telefono,email);
        this.controlPantalla.confirmarDatos(datosSolicitanteDTO);

    }

}
