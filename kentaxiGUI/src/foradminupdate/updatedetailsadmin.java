/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foradminupdate;

import admin.adminDashboard;
import viewdetailsusers.*;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import user.userDashboard;

/**
 *
 * @author Sofia
 */
public class updatedetailsadmin extends javax.swing.JFrame {

    /**
     * Creates new form updatedetails
     */
    public updatedetailsadmin() {
        initComponents();
    }
    
     public void getDataadmin(String id){
     
         dbConnector dbc = new dbConnector();
         
         try{
             
             String query = "SELECT * FROM tbl_user WHERE id ='"+id+"' ";
             ResultSet rs = dbc.getData(query);
              if(rs.next()){

                 Session sess = Session.getInstance(); 
                 
                 sess.setId(rs.getInt("id"));
                 sess.setFirst(rs.getString("fname"));
                 sess.setLast(rs.getString("lname"));   
                 sess.setEmail_add(rs.getString("email"));
         
              }
         
         
         }catch(Exception e){
         
         
         }
         
     
     
     }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jfname = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jlastname = new javax.swing.JTextField();
        jid = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setText("Last Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 150, 70, 30);

        jLabel3.setText("First Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 110, 80, 30);

        jLabel5.setText("Email");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 190, 60, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Personal Information");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(120, 40, 190, 17);

        jButton1.setText("Update information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(210, 240, 160, 40);

        jLabel7.setText("ID");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 70, 34, 20);

        jfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfnameActionPerformed(evt);
            }
        });
        jPanel1.add(jfname);
        jfname.setBounds(160, 110, 190, 30);
        jPanel1.add(jemail);
        jemail.setBounds(160, 190, 190, 30);
        jPanel1.add(jlastname);
        jlastname.setBounds(160, 150, 190, 30);

        jid.setText("jLabel1");
        jPanel1.add(jid);
        jid.setBounds(160, 70, 130, 14);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(310, 20, 70, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //update infor button

        
        String idss = jid.getText();
        String firstnames = jfname.getText();
        String lastnames = jlastname.getText();
        String emails = jemail.getText();
  
          dbConnector dbc = new dbConnector();
        
        try{
            
            String query =
            "UPDATE tbl_user SET fname ='"+firstnames+"', "
                    + "lname ='"+lastnames+"', " 
                                    + " email ='"+emails+"' "
                                            + "  WHERE id ='"+idss+"' ";
            
             if(dbc.insertData(query)){
              JOptionPane.showMessageDialog(null, "Data Updated!");
              
                getDataadmin(idss);
                
             
             }
                
                this.dispose();
                adminDashboard us = new adminDashboard();
                us.setVisible(true);
                
                
                          
            
              
            
            
        } catch (Exception e){
            
            System.out.println(e);
        }
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         this.dispose();
        adminDashboard us = new adminDashboard();
        us.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updatedetailsadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatedetailsadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatedetailsadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatedetailsadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updatedetailsadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jemail;
    public javax.swing.JTextField jfname;
    public javax.swing.JLabel jid;
    public javax.swing.JTextField jlastname;
    // End of variables declaration//GEN-END:variables
}
