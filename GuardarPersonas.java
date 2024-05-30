package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GuardarPersonas implements ActionListener {
    private JTextField txtIdPersona;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    // Constructor para inicializar los componentes
    public GuardarPersonas(JTextField txtIdPersona, JTextField txtNombre, JTextField txtEdad, JButton btnRegistrar, JButton btnCancelar) {
        this.txtIdPersona = txtIdPersona;
        this.txtNombre = txtNombre;
        this.txtEdad = txtEdad;
        this.btnRegistrar = btnRegistrar;
        this.btnCancelar = btnCancelar;

        // Asignar el ActionListener a los botones
        this.btnRegistrar.addActionListener(this);
        this.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            // Obtener los datos ingresados por el usuario
            String idPersona = txtIdPersona.getText();
            String nombrePersona = txtNombre.getText();
            String edadPersona = txtEdad.getText();

            // Guardar los datos en un archivo de texto
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos_personas.txt", true))) {
                // Escribir los datos en el archivo
                writer.write("ID: " + idPersona + ", Nombre: " + nombrePersona + ", Edad: " + edadPersona);
                writer.newLine(); // Agregar nueva línea para el siguiente registro
            } catch (IOException ex) {
                ex.printStackTrace(); // Manejar el error de escritura
            }
        } else if (e.getSource() == btnCancelar) {
            // Implementa aquí la lógica para cancelar el registro si es necesario
            txtIdPersona.setText("");
            txtNombre.setText("");
            txtEdad.setText("");
        }
    }

    public static void main(String[] args) {
        // Aquí se inicializan y configuran los componentes de la GUI
        JTextField txtIdPersona = new JTextField(20);
        JTextField txtNombre = new JTextField(20);
        JTextField txtEdad = new JTextField(20);
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnCancelar = new JButton("Cancelar");

        // Crear una instancia de GuardarPersonas y pasar los componentes
        GuardarPersonas guardarPersonas = new GuardarPersonas(txtIdPersona, txtNombre, txtEdad, btnRegistrar, btnCancelar);

        // Configurar la ventana y agregar los componentes...
        // Este código dependerá de cómo estés configurando tu GUI en NetBeans
    }
}