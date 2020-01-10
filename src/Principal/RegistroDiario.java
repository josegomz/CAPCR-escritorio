package Principal;

import BD.BD;
import BD.Registro;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public final class RegistroDiario extends javax.swing.JFrame {
    Registro registro = new Registro();
    public static int id;
    public RegistroDiario() {
        initComponents();
        MostrarRegistroDiario();
    }
    public RegistroDiario(int id) {
        RegistroDiario.id=id;
        initComponents();
        MostrarRegistroDiario();
    }
    
    /*
            FUNCION QUE CREA EL ICONO DE LA APLICACION
    */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("Imagen/icono.png"));
        return retValue;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistroDiario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tblRegistroDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Grupo", "Practica", "Hora entrada", "Hora salida", "Estado", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistroDiario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistroDiarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistroDiario);
        if (tblRegistroDiario.getColumnModel().getColumnCount() > 0) {
            tblRegistroDiario.getColumnModel().getColumn(0).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(1).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(2).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(3).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(4).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(5).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(6).setResizable(false);
            tblRegistroDiario.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Registros del dia de hoy");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipal menu = new MenuPrincipal(id);
        menu.show();
        this.dispose();
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblRegistroDiarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistroDiarioMouseClicked
        int RowSelect;
        try{
            RowSelect = this.tblRegistroDiario.getSelectedRow();
            if(RowSelect==-1){
                JOptionPane.showMessageDialog(null,"No ha seleccionado ninguna fila");
            }else{
                int DialogResult = JOptionPane.showConfirmDialog(null,"Desea Cancelar este registro? ");  
                if(DialogResult == JOptionPane.YES_OPTION){
                    String Motivo=JOptionPane.showInputDialog(null,"Motivo por el que desea cancelar");
                    if(Motivo.length()==0){
                        JOptionPane.showMessageDialog(null,"Debe haber un motivo por el cual \ndesea cancelar la práctica");
                    }
                    else{
                        String Matricula=(String) modelo2.getValueAt(RowSelect,1);
                        String Practica=(String) modelo2.getValueAt(RowSelect,4);
                        String HoraInicio=(String) modelo2.getValueAt(RowSelect,6);
                        String HoraFin=(String) modelo2.getValueAt(RowSelect,7);
                        System.out.println(Matricula+" "+Practica+" "+HoraInicio+" "+HoraFin);
                        registro.CancelarRegistro(Matricula,Practica,HoraInicio,HoraFin,Motivo);
                        modelo2.setValueAt("Cancelado",RowSelect, 8);
                        modelo2.setValueAt(Motivo,RowSelect,9);
                    }
                    
                }
                else{
                    
                }
            }
        }catch(HeadlessException | SQLException e){
            System.out.println("Error al captar datos");
        }
    }//GEN-LAST:event_tblRegistroDiarioMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        MenuPrincipal menu = new MenuPrincipal(id);
        menu.show();
        this.dispose();
    }//GEN-LAST:event_formWindowClosed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDiario().setVisible(true);            
            }
        });
    }

    public void MostrarRegistroDiario() {
        modelo2 = new DefaultTableModel();
        this.tblRegistroDiario.setModel(modelo2);
        modelo2.addColumn("N°");//seccion 0
        modelo2.addColumn("Matricula");//seccion 1
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Grupo");// seccion 3
        modelo2.addColumn("codigoPractica");
        modelo2.addColumn("Practica");//seccion 5
        modelo2.addColumn("Hora entrada");
        modelo2.addColumn("Hora salida");//seccion 7
        modelo2.addColumn("Estado");
        modelo2.addColumn("Comentario");

        TableColumn columna;

        for (int i = 0; i < 8; i++) {
            columna = tblRegistroDiario.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    columna.setPreferredWidth(5);
                    break;
                case 1:
                    columna.setPreferredWidth(50);
                    break;
                case 2:
                    columna.setPreferredWidth(200);
                    break;
                case 3:
                    columna.setPreferredWidth(20);
                    break;
                case 4:
                    columna.setPreferredWidth(20);
                    break;
                case 5:
                    columna.setPreferredWidth(150);
                    break;
                case 6:
                    columna.setPreferredWidth(30);
                    break;
                case 7:
                    columna.setPreferredWidth(30);
                    break;
                case 8:
                    columna.setPreferredWidth(20);
                    break;
                case 9:
                    columna.setPreferredWidth(200);
                    break;
            }
        }
            BD bd = new BD();
            bd.conecta();
            String Matricula, Nombre, Grupo, Practica, HoraEntrada, HoraSalida, Estado, Comentario,codigo;
            int j=1;
            try {
                Statement stmnt;
                stmnt = bd.conecta().createStatement();
                String sql = "call spMostrarRegistroDiario();";
                ResultSet rs = stmnt.executeQuery(sql);
                while (rs.next()) {
                    Matricula = rs.getString("matricula");// se guarda en int de la columna tipo a la variable a
                    Nombre = rs.getString("alumno");//
                    Grupo = rs.getString("grupo");
                    codigo = rs.getString("codigoPractica");
                    Practica = rs.getString("practica");//
                    HoraEntrada = rs.getString("horaEntrada");
                    HoraSalida = rs.getString("horaSalida");
                    Estado = rs.getString("estado");
                    Comentario = rs.getString("comentario");
                    modelo2.addRow(new Object[]{j,Matricula,Nombre,Grupo,codigo,Practica,HoraEntrada,HoraSalida,Estado,Comentario});   
                    j++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            bd.close();  
    }

    private DefaultTableModel modelo2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistroDiario;
    // End of variables declaration//GEN-END:variables
}
