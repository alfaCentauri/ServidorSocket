/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interfaz del servidor de sockets.
 * @author Ingeniero Ricardo Presilla ricardopresilla@gmail.com.
 * @version 1.0.
 */
public class Ventana extends javax.swing.JFrame {
    Servidor servidor;
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BActivar = new javax.swing.JButton();
        Etiqueta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TInformacion = new javax.swing.JTextArea();
        BDetener = new javax.swing.JButton();
        BRecibir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BActivar.setText("Activar envio");
        BActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActivarActionPerformed(evt);
            }
        });

        Etiqueta.setText("Programa para conectar en red varios pc.");

        TInformacion.setColumns(20);
        TInformacion.setRows(5);
        TInformacion.setText("prueba");
        jScrollPane1.setViewportView(TInformacion);

        BDetener.setText("Detener");
        BDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDetenerActionPerformed(evt);
            }
        });

        BRecibir.setText("Recibir");
        BRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRecibirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Etiqueta)
                        .addGap(0, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BActivar)
                        .addGap(18, 18, 18)
                        .addComponent(BRecibir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BDetener)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Etiqueta)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BActivar)
                    .addComponent(BDetener)
                    .addComponent(BRecibir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActivarActionPerformed
        servidor = new Servidor();
        servidor.Enviar(this.TInformacion.getText());
        servidor.FinalizaComunicacion();
    }//GEN-LAST:event_BActivarActionPerformed

    private void BDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDetenerActionPerformed
        servidor.FinalizaComunicacion();
    }//GEN-LAST:event_BDetenerActionPerformed

    private void BRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRecibirActionPerformed
        servidor = new Servidor(1);
        this.TInformacion.setText("Respuesta "+servidor.Recibir());
        servidor.FinalizaComunicacion();
    }//GEN-LAST:event_BRecibirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActivar;
    private javax.swing.JButton BDetener;
    private javax.swing.JButton BRecibir;
    private javax.swing.JLabel Etiqueta;
    private javax.swing.JTextArea TInformacion;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
