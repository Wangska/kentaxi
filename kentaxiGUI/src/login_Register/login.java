/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_Register;

import admin.adminDashboard;
import config.Session;
import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import user.userDashboard;

/**
 *
 * @author Admin
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }
    
    static String first;
    static String last;
    static String email_add;
    static String user_name;
    static String pass_word;
    static String type;
    static String stat;
    
    
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        
        try{
            String hashedPassword = passwordHash(password);
            String query = "SELECT * FROM tbl_user  WHERE username = '" + username + "' AND password = '" + hashedPassword + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){

                 Session sess = Session.getInstance(); 
                 
                 sess.setId(resultSet.getInt("id"));
                 sess.setFirst(resultSet.getString("fname"));
                 sess.setLast(resultSet.getString("lname"));   
                 sess.setEmail_add(resultSet.getString("email"));
                 sess.setUser_name(resultSet.getString("username"));
                 sess.setPass_word(resultSet.getString("password"));
                 sess.setAccounttype(resultSet.getString("accnt_type"));
                 sess.setStatus(resultSet.getString("status"));

                return true;
                
                }else{
                return false;
            }   
           
        }catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
        }

    }
    
     public static boolean isAdmin(String username) {
        dbConnector connector = new dbConnector();
        try {

            String query = "SELECT * FROM tbl_user WHERE username ='" + username + "' AND accnt_type ='Admin'";
            ResultSet resultSet = connector.getData(query);
            return resultSet.next();
        }catch(SQLException e) {
            System.out.println(""+e);
        return false;
        }
    }
    
    public static boolean isUser(String username) {
        dbConnector connector = new dbConnector();
        try {
            String query = "SELECT * FROM tbl_user WHERE username ='" + username + "' AND accnt_type ='User'";
            ResultSet resultSet = connector.getData(query);
            return resultSet.next();
        }catch(SQLException e) {
            System.out.println(""+e);
        return false;
        }
    }
    
    public static String passwordHash(String password){
        
        try{
        
            MessageDigest md = MessageDigest.getInstance("Sha");
            md.update(password.getBytes());
            byte[] rbt = md.digest();
            StringBuilder sb = new StringBuilder();
            
            for(byte b: rbt){
                
                sb.append(String.format("%02x", b));
            
            }
            return sb.toString();
        
        }catch(Exception e){
        
        
        }
        return null;
    
    
    
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
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("USERNAME");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 120, 89, 30);
        jPanel1.add(user);
        user.setBounds(320, 120, 140, 35);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PASSWORD");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 170, 84, 30);
        jPanel1.add(pass);
        pass.setBounds(320, 170, 140, 31);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Create an account");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 270, 140, 17);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 260, 93, 34);

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 170, 400);

        jPanel3.setBackground(new java.awt.Color(102, 255, 255));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LOGIN FORM");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(130, 0, 153, 50);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(150, 0, 370, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
          
        Session sess = Session.getInstance(); 
        
        if (loginAcc(user.getText(), pass.getText())) {
            String username = user.getText();
            
        if (isAdmin(username)) {
            JOptionPane.showMessageDialog(null, "Login Successfully as Admin");
            adminDashboard ad = new adminDashboard();
            ad.firstnamefield.setText(""+sess.getFirst());
            ad.lastnamefield.setText(""+sess.getLast());
            ad.setVisible(true);
            this.dispose();
        } else  {
            JOptionPane.showMessageDialog(null, "Login Successfully as User");
            userDashboard own = new userDashboard();
            own.firstnamefield.setText(""+sess.getFirst());
            own.lastnamefield.setText(""+sess.getLast());
            own.setVisible(true);
            this.dispose();

        }
        this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(null, "Invalid User or Password");
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
       regForm rf = new regForm();
       rf.setVisible(true);
       this.dispose();
        
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}