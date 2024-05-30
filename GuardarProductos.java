package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GuardarProductos implements ActionListener {
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    // Constructor para inicializar los componentes
    public GuardarProductos(JTextField txtNombre, JTextField txtPrecio, JButton btnRegistrar, JButton btnCancelar) {
        this.txtNombre = txtNombre;
        this.txtPrecio = txtPrecio;
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
            String nombreProducto = txtNombre.getText();
            String precioProducto = txtPrecio.getText();

            // Guardar los datos en un archivo de texto
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos_productos.txt", true))) {
                // Escribir los datos en el archivo
                writer.write("Nombre: " + nombreProducto + ", Precio: " + precioProducto);
                writer.newLine(); // Agregar nueva línea para el siguiente registro
            } catch (IOException ex) {
                ex.printStackTrace(); // Manejar el error de escritura
            }
        } else if (e.getSource() == btnCancelar) {
            // Implementa aquí la lógica para cancelar el registro si es necesario
            txtNombre.setText("");
            txtPrecio.setText("");
        }
    }

    public static void main(String[] args) {
        // Aquí se inicializan y configuran los componentes de la GUI
        JTextField txtNombre = new JTextField(20);
        JTextField txtPrecio = new JTextField(20);
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnCancelar = new JButton("Cancelar");

        // Crear una instancia de GuardarProductos y pasar los componentes
        GuardarProductos guardarProductos = new GuardarProductos(txtNombre, txtPrecio, btnRegistrar, btnCancelar);

        // Configurar la ventana y agregar los componentes...
        // Este código dependerá de cómo estés configurando tu GUI en NetBeans
    }
}