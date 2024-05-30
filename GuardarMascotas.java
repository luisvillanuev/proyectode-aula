package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class GuardarMascotas implements ActionListener {
    private JTextField txtIdDueno;
    private JTextField txtNombre;
    private JComboBox<String> comboBoxSexo;
    private JComboBox<String> comboBoxColor;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    public GuardarMascotas(JTextField txtIdDueno, JTextField txtNombre, JComboBox<String> comboBoxSexo, JComboBox<String> comboBoxColor, JButton btnRegistrar, JButton btnCancelar) {
        this.txtIdDueno = txtIdDueno;
        this.txtNombre = txtNombre;
        this.comboBoxSexo = comboBoxSexo;
        this.comboBoxColor = comboBoxColor;
        this.btnRegistrar = btnRegistrar;
        this.btnCancelar = btnCancelar;

        // Asignar el ActionListener a los botones
        this.btnRegistrar.addActionListener(this);
        this.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            // Guardar los datos ingresados en las variables
            String idDueno = txtIdDueno.getText();
            String nombreMascota = txtNombre.getText();
            String sexo = comboBoxSexo.getSelectedItem().toString();
            String color = comboBoxColor.getSelectedItem().toString();

            // Guardar los datos en un archivo de texto
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos_mascotas.txt", true))) {
                // Escribir los datos en el archivo
                writer.write("Id Dueño: " + idDueno + ", Nombre: " + nombreMascota + ", Sexo: " + sexo + ", Color: " + color);
                writer.newLine(); // Agregar nueva línea para el siguiente registro
            } catch (IOException ex) {
                ex.printStackTrace(); // Manejar el error de escritura
            }
        } else if (e.getSource() == btnCancelar) {
            // Implementa aquí la lógica para cancelar el registro si es necesario
            txtIdDueno.setText("");
            txtNombre.setText("");
            comboBoxSexo.setSelectedIndex(0);
            comboBoxColor.setSelectedIndex(0);
        }
    }
}