/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conversosdivisas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz extends javax.swing.JFrame {

    // Elementos del panel
    private JLabel datoUsuario, cantidadAConvertir, datoConvertido, label1, label2;
    private JComboBox<String> cantidad, cantidadConvertida;
    private JTextField cantidadConvertir, resultadoConversion;
    private JButton convertir;

    // Tasas de conversión
    private double dolarToEuro = 0.91;
    private double dolarToLibra = 0.78;
    private double dolarToYen = 141.15;
    private double dolarToDolarCan = 1.33;
    private double dolarToFranco = 0.97;
    private double dolarToRenminbi = 7.15;
    private double euroToDolar = 1.10;
    private double euroToLibra = 0.86;
    private double euroToYen = 155.76;
    private double euroToDolarCan = 1.46;
    private double euroToFranco = 0.96;
    private double euroToRenminbi = 7.89;
    private double libraToDolar = 1.28;
    private double libraToEuro = 1.16;
    private double libraToYen = 181.31;
    private double libraToDolarCan = 1.70;
    private double libraToFranco = 1.12;
    private double libraToRenminbi = 9.18;
    private double yenToDolar = 0.0071;
    private double yenToEuro= 0.0064;
    private double yenToLibra = 0.0055;
    private double yenToDolarCan = 0.0094;
    private double yenToFranco = 0.0062;
    private double yenToRenminbi = 0.051;
    private double dolarCanToDolar = 0.75;
    private double dolarCanToEuro = 0.68;
    private double dolarCanToLibra = 0.59;
    private double dolarCanToYen = 106.52;
    private double dolarCanToFranco = 0.66;
    private double dolarCanToRenminbi = 5.39;
    private double francoToDolar = 1.15;
    private double francoToEuro = 1.04;
    private double francoToLibra = 0.89;
    private double francoToYen = 162.21;
    private double francoToDolarCan = 1.53;
    private double francoToRenminbi = 8.21;
    private double renminbiToDolar = 0.14;
    private double renminbiToEuro = 0.13;
    private double renminbiToLibra = 0.11;
    private double renminbiToYen = 19.75;
    private double renminbiToDolarCan = 0.19;
    private double renminbiToFranco = 0.12;
            
       
    public interfaz() {
        //Elementos declarados
        datoUsuario = new JLabel("Introduce la moneda que quieres convertir: ");
        String[] opcionesCantidad = {"Dolar Estadounidense", "Euro", "Libra Esterlina", "Yen Japonés", "Dolar Canadiense", "Franco Suizo", "Renminbi Chino"};
        cantidad = new JComboBox<>(opcionesCantidad);
        cantidadAConvertir = new JLabel("Introduce la cantidad a convertir:");
        cantidadConvertir = new JTextField();
        datoConvertido = new JLabel("Introduce la moneda a la que quieres convertir");
        cantidadConvertida = new JComboBox<>(opcionesCantidad);
        convertir = new JButton("Convertir");
        resultadoConversion = new JTextField();
        label1 = new JLabel("Pulsa para convertir");
        label2 = new JLabel();

        //Convierte los datos del combo box que es un string a un double
        convertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String monedaOrigen = (String) cantidad.getSelectedItem();
                    String monedaDestino = (String) cantidadConvertida.getSelectedItem();
                    double cantidadValor = Double.parseDouble(cantidadConvertir.getText());

                    double resultado = convertirMoneda(monedaOrigen, monedaDestino, cantidadValor);
                    resultadoConversion.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(interfaz.this, "Error: Introduce una cantidad válida.");
                }
            }
        });

        // Configurar el diseño de la interfaz
        setLayout(new GridLayout(5, 2));
        add(datoUsuario);
        add(cantidad);
        add(cantidadAConvertir);
        add(cantidadConvertir);
        add(datoConvertido);
        add(cantidadConvertida);
        add(label1);
        add(convertir);
        add(label2);
        add(resultadoConversion);

        setTitle("Conversor de Moneda");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //Secuencia lógica de conversión de monedas
    private double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        if (monedaOrigen.equals("Dolar Estadounidense") && monedaDestino.equals("Euro")) {
            return cantidad * dolarToEuro;
        } else if (monedaOrigen.equals("Dolar Estadounidense") && monedaDestino.equals("Libra Esterlina")) {
            return cantidad * dolarToLibra;
        } else if (monedaOrigen.equals("Dolar Estadounidense") && monedaDestino.equals("Yen Japonés")) {
            return cantidad * dolarToYen;
        } else if (monedaOrigen.equals("Dolar Estadounidense") && monedaDestino.equals("Dolar Canadiense")) {
            return cantidad * dolarToDolarCan;
        } else if (monedaOrigen.equals("Dolar Estadounidense") && monedaDestino.equals("Franco Suizo")) {
            return cantidad * dolarToFranco;
        } else if (monedaOrigen.equals("Dolar Estadounidense") && monedaDestino.equals("Renminbi Chino")) {
            return cantidad * dolarToRenminbi;
        } else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Dolar Estadounidense")) {
            return cantidad * euroToDolar;
        } else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Libra Esterlina")) {
            return cantidad * euroToLibra;
        } else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Yen Japonés")) {
            return cantidad * euroToYen;
        } else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Dolar Canadiense")) {
            return cantidad * euroToDolarCan;
        } else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Franco Suizo")) {
            return cantidad * euroToFranco;
        } else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Renminbi Chino")) {
            return cantidad * euroToRenminbi;
        } else if (monedaOrigen.equals("Libra Esterlina") && monedaDestino.equals("Dolar Estadounidense")) {
            return cantidad * libraToDolar;
        } else if (monedaOrigen.equals("Libra Esterlina") && monedaDestino.equals("Euro")) {
            return cantidad * libraToEuro;
        } else if (monedaOrigen.equals("Libra Esterlina") && monedaDestino.equals("Yen Japonés")) {
            return cantidad * libraToYen;
        } else if (monedaOrigen.equals("Libra Esterlina") && monedaDestino.equals("Dolar Canadiense")) {
            return cantidad * libraToDolarCan;
        } else if (monedaOrigen.equals("Libra Esterlina") && monedaDestino.equals("Franco Suizo")) {
            return cantidad * libraToFranco;
        } else if (monedaOrigen.equals("Libra Esterlina") && monedaDestino.equals("Renminbi Chino")) {
            return cantidad * libraToRenminbi;
        } else if (monedaOrigen.equals("Yen Japonés") && monedaDestino.equals("Dolar Estadounidense")) {
            return cantidad * yenToDolar;
        } else if (monedaOrigen.equals("Yen Japonés") && monedaDestino.equals("Euro")) {
            return cantidad * yenToEuro;
        } else if (monedaOrigen.equals("Yen Japonés") && monedaDestino.equals("Dolar Canadiense")) {
            return cantidad * yenToDolarCan;
        }  else if (monedaOrigen.equals("Yen Japonés") && monedaDestino.equals("Libra Esterlina")) {
            return cantidad * yenToLibra;
        }  else if (monedaOrigen.equals("Yen Japonés") && monedaDestino.equals("Franco Suizo")) {
            return cantidad * yenToFranco;
        } else if (monedaOrigen.equals("Yen Japonés") && monedaDestino.equals("Renminbi Chino")) {
            return cantidad * yenToRenminbi;
        } else if (monedaOrigen.equals("Dolar Canadiense") && monedaDestino.equals("Dolar Estadounidense")) {
            return cantidad * dolarCanToDolar;
        } else if (monedaOrigen.equals("Dolar Canadiense") && monedaDestino.equals("Euro")) {
            return cantidad * dolarCanToEuro;
        } else if (monedaOrigen.equals("Dolar Canadiense") && monedaDestino.equals("Yen Japonés")) {
            return cantidad * dolarCanToYen;
        } else if (monedaOrigen.equals("Dolar Canadiense") && monedaDestino.equals("Libra Esterlina")) {
            return cantidad * dolarCanToLibra;
        } else if (monedaOrigen.equals("Dolar Canadiense") && monedaDestino.equals("Franco Suizo")) {
            return cantidad * dolarCanToFranco;
        } else if (monedaOrigen.equals("Dolar Canadiense") && monedaDestino.equals("Renminbi Chino")) {
            return cantidad * dolarCanToRenminbi;
        } else if (monedaOrigen.equals("Franco Suizo") && monedaDestino.equals("Dolar Estadounidense")) {
            return cantidad * francoToDolar;
        } else if (monedaOrigen.equals("Franco Suizo") && monedaDestino.equals("Euro")) {
            return cantidad * francoToEuro;
        } else if (monedaOrigen.equals("Franco Suizo") && monedaDestino.equals("Dolar Canadiense")) {
            return cantidad * francoToDolarCan;
        } else if (monedaOrigen.equals("Franco Suizo") && monedaDestino.equals("Libra Esterlina")) {
            return cantidad * francoToLibra;
        } else if (monedaOrigen.equals("Franco Suizo") && monedaDestino.equals("Yen Japonés")) {
            return cantidad * francoToYen;
        } else if (monedaOrigen.equals("Franco Suizo") && monedaDestino.equals("Renminbi Chino")) {
            return cantidad * francoToRenminbi;
        } else if (monedaOrigen.equals("Renminbi Chino") && monedaDestino.equals("Dolar Estadounidense")) {
            return cantidad * renminbiToDolar;
        } else if (monedaOrigen.equals("Renminbi Chino") && monedaDestino.equals("Euro")) {
            return cantidad * renminbiToEuro;
        } else if (monedaOrigen.equals("Renminbi Chino") && monedaDestino.equals("Libra Esterlina")) {
            return cantidad * renminbiToLibra;
        } else if (monedaOrigen.equals("Renminbi Chino") && monedaDestino.equals("Yen Japonés")) {
            return cantidad * renminbiToYen;
        } else if (monedaOrigen.equals("Renminbi Chino") && monedaDestino.equals("Dolar Canadiense")) {
            return cantidad * renminbiToDolarCan;
        } else if (monedaOrigen.equals("Renminbi Chino") && monedaDestino.equals("Franco Suizo")) {
            return cantidad * renminbiToFranco;
        }
        return cantidad;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(interfaz::new);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
