package Principal;

import BD.Registro;
import BD.BD;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
import java.util.Date;

public final class Vista extends javax.swing.JFrame {

    //variables
    public static int val; // ID del usuario que está operando
    public boolean bandera = false; //si existe un alumno en la tabla
    static public Object[] registro;
    public Registro registroBD;

    /**
     * Contructor del Frame
     */
    public Vista() {
        modelo = new DefaultTableModel();
        initComponents();
        diseña_tabla();
        //sobreescribir el evento "cerrando ventana"
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }

    public Vista(int val) {
        Vista.val = val;
        modelo = new DefaultTableModel();
        initComponents();
        diseña_tabla();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }

    /**
     * pregunta si desea salir de la aplicacion
     * evita transacciones en proceso 
     */
    private void close() {
        //pide confirmacion al cerrar la ventana
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?\nse perderán los registros",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            MenuPrincipal menu;
            menu = new MenuPrincipal(val);
            menu.show();
            this.dispose();
        }

    }
    
    //agrega el ícono de la lampara
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagen/icono.png"));
        return retValue;
    }

    /**
     * agrega las columnas a la tabla
     * modifica las dimensiones
     */
    public void diseña_tabla() {
        tablaRegistro.setModel(modelo);
        modelo.addColumn("No");
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nombre de la práctica");
        modelo.addColumn("Grupo");
        modelo.addColumn("Hora de entrada");
        modelo.addColumn("Sustituye");
        txtMatricula.requestFocus();
        TableColumn columna;
        for (int i = 0; i < 7; i++) {
            columna = tablaRegistro.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    //cambia el ancho a 5px
                    columna.setPreferredWidth(5);
                    break;
                case 1:
                    columna.setPreferredWidth(60);
                    break;
                case 2:
                    columna.setPreferredWidth(140);
                    break;
                case 3:
                    columna.setPreferredWidth(140);
                    break;
                case 4:
                    columna.setPreferredWidth(30);
                    break;
                case 5:
                    columna.setPreferredWidth(60);
                    break;
                case 6:
                    columna.setPreferredWidth(100);
                    break;
            }
        }
    }

    /**
     * Agrega alumnos a la tabla
     * @param matricula 
     */
    public void Agregar_Fila(String matricula) {

        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            BD bd = new BD();
            PreparedStatement st = bd.conecta().prepareStatement("call spMostrarAlumnoMatriculaEnRegistro(?)");
            st.setString(1, matricula);
            ResultSet r = st.executeQuery();
            if (r.next()) {
                PreparedStatement st2 = bd.conecta().prepareStatement("call spMostrarPracticaSemestre(?)");
                st2.setString(1, r.getString(3));
                ResultSet practica = st2.executeQuery();
                cmbPractica.removeAllItems();
                while (practica.next()) {
                    cmbPractica.addItem(practica.getString(1));
                }
                registro = new Object[7];
                registro[1] = matricula;
                registro[2] = r.getObject("a.nombre");
                registro[4] = r.getObject("a.grupo");
                registro[5] = hourFormat.format(date);
                jDSustituye.setSize(280, 300);
                jDSustituye.setLocationRelativeTo(null);
                jDSustituye.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "La matricula ingresada no existe", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
            bd.close();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * genera el numero del registro
     */
    private void actualizarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i + 1, i, 0);
        }
    }

    /**
     * limpia el txtMatricula para nuevo ingresos
     */
    public void limpiar() {
        txtMatricula.setText("");
    }

    /**
     * busca si la matricua ya está en la tabla
     * 
     * @param matricula
     * @return 
     */
    public boolean Buscar(String matricula) {
        bandera = false;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 1).equals(matricula)) {
                bandera = true;
            }
        }
        return bandera;
    }
    
    /**
     * recoge los datos de la maticula y elimina la fila
     * los datos los manda al procedimiento almacenado para registrarlo en la base de datos
     * actualiza la fabla
     * @param matricula 
     */
    public void Eliminar(String matricula) {
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        String horaSalida = hourFormat.format(date);
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 1).equals(matricula)) {
                registroBD = new Registro(matricula, (String) modelo.getValueAt(i, 3), (String) modelo.getValueAt(i, 5), horaSalida, (String) modelo.getValueAt(i, 6));
                registroBD.InsertarRegistro();
                modelo.removeRow(i);
            }
        }
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDSustituye = new javax.swing.JDialog();
        btnSusAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbPractica = new javax.swing.JComboBox<>();
        cmbHora = new javax.swing.JComboBox<>();
        panelRegistro = new javax.swing.JPanel();
        etqRegistro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        etqMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        etqHora = new javax.swing.JLabel();
        iconEnfermeria = new javax.swing.JLabel();
        iconUnsis = new javax.swing.JLabel();

        jDSustituye.setTitle("        SUSTITUYE HORAS");

        btnSusAceptar.setText("Aceptar");
        btnSusAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSusAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("ELIGE LA HORA QUE VAS A SUSTITUIR");

        jLabel2.setText("ELIGE EL NOMBRE DE LA PRACTICA");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIBRE", "BIBLIOTECA", "SALA DE COMPUTO", "OTRA" }));

        javax.swing.GroupLayout jDSustituyeLayout = new javax.swing.GroupLayout(jDSustituye.getContentPane());
        jDSustituye.getContentPane().setLayout(jDSustituyeLayout);
        jDSustituyeLayout.setHorizontalGroup(
            jDSustituyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDSustituyeLayout.createSequentialGroup()
                .addGroup(jDSustituyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDSustituyeLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnSusAceptar))
                    .addGroup(jDSustituyeLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDSustituyeLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(cmbPractica, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDSustituyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDSustituyeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDSustituyeLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jDSustituyeLayout.setVerticalGroup(
            jDSustituyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDSustituyeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbPractica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSusAceptar)
                .addGap(37, 37, 37))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAPCR  (Control de Acceso a  Practicas en Clinica Robotizada) version .01");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        panelRegistro.setBackground(new java.awt.Color(102, 0, 0));

        etqRegistro.setFont(new java.awt.Font("Noto Sans", 1, 36)); // NOI18N
        etqRegistro.setForeground(new java.awt.Color(254, 254, 254));
        etqRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqRegistro.setText("REGISTRO");

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(etqRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        tablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Matricula", "Nombre Alumno", "Nombre Practica", "Grupo", "Hora Entrada", "Sustituye"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRegistro.setEnabled(false);
        jScrollPane1.setViewportView(tablaRegistro);
        if (tablaRegistro.getColumnModel().getColumnCount() > 0) {
            tablaRegistro.getColumnModel().getColumn(0).setResizable(false);
            tablaRegistro.getColumnModel().getColumn(0).setPreferredWidth(5);
            tablaRegistro.getColumnModel().getColumn(1).setResizable(false);
            tablaRegistro.getColumnModel().getColumn(1).setPreferredWidth(60);
            tablaRegistro.getColumnModel().getColumn(2).setResizable(false);
            tablaRegistro.getColumnModel().getColumn(2).setPreferredWidth(140);
            tablaRegistro.getColumnModel().getColumn(3).setResizable(false);
            tablaRegistro.getColumnModel().getColumn(3).setPreferredWidth(140);
            tablaRegistro.getColumnModel().getColumn(4).setResizable(false);
            tablaRegistro.getColumnModel().getColumn(4).setPreferredWidth(1);
            tablaRegistro.getColumnModel().getColumn(5).setResizable(false);
            tablaRegistro.getColumnModel().getColumn(6).setResizable(false);
        }

        etqMatricula.setText("MATRICULA:");

        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });

        etqHora.setText("HORA: ");

        iconEnfermeria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/LogoEnfermeria.png"))); // NOI18N

        iconUnsis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logoUnsis.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconUnsis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(iconEnfermeria)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etqMatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etqHora)
                                .addGap(263, 263, 263))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconEnfermeria)
                    .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconUnsis))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * al presionar Enter con el teclado
     * o pasar el código con el lector
     * @param evt 
     */
    private void txtMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // valida si la matricula sea de 10 digitos
            if (txtMatricula.getText().length() == 10) {
                //si la matricula aun no está en la tabla abre sesión 
                if (!Buscar(txtMatricula.getText())) {
                    Agregar_Fila(txtMatricula.getText());
                } else {
                    //caso contrario cierra sesión
                    Eliminar(txtMatricula.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "La matricula ingresada no existe", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
    }//GEN-LAST:event_txtMatriculaKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    /**
     * valida que solo se puedan insertar números
     * @param evt 
     */
    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMatriculaKeyTyped

    /**
     * agrega a la tabla los elementos del JDialog
     * @param evt 
     */
    private void btnSusAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSusAceptarActionPerformed
        //TOMA LOS VALORES DE LOS COMPONENTES DEL JDIALOG
        registro[3] = this.cmbPractica.getSelectedItem();
        registro[6] = this.cmbHora.getSelectedItem();
        modelo.insertRow(0, registro);
        actualizarTabla();
        jDSustituye.setVisible(false);
    }//GEN-LAST:event_btnSusAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            // start application
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    private final DefaultTableModel modelo;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSusAceptar;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbPractica;
    private javax.swing.JLabel etqHora;
    private javax.swing.JLabel etqMatricula;
    private javax.swing.JLabel etqRegistro;
    private javax.swing.JLabel iconEnfermeria;
    private javax.swing.JLabel iconUnsis;
    private javax.swing.JDialog jDSustituye;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelRegistro;
    public static javax.swing.JTable tablaRegistro;
    public static javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
