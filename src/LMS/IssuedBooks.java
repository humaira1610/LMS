/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
    public class IssuedBooks extends javax.swing.JFrame {
    private Object jtRowData;

    /**
     * Creates new form Books
     */
    public IssuedBooks() {
        initComponents();
        connect();
        issued_book_load();
    }
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    IssuedBooks issuedbooks;
    
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/LibraryManagementSystem","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void findBooksByIssueID(){
        int c;
        int id=Integer.parseInt(searchBox.getText());
        
        try{
            st=conn.prepareStatement("select * from issuedBooks where issueID=?");
            st.setInt(1,id);
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)issuedBooksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("issueID"));
                    v2.add(rs.getString("memberID"));
                    v2.add(rs.getString("memberName"));
                    v2.add(rs.getString("bookID"));
                    v2.add(rs.getString("issueDate"));
                    v2.add(rs.getString("returnDate"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }
    
    public void returnBook(){
        
    }
    
    public void deleteIssue(){
        DefaultTableModel d1=(DefaultTableModel)issuedBooksTable.getModel();
        int selectIndex=issuedBooksTable.getSelectedRow();
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        try {
            st= conn.prepareStatement("delete from issuedBooks where issueID=?");
            st.setInt(1,id);
            
            /*int k = st.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this,"book information deleted.");
                //this.hide();
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }*/
            
          
            
        } catch (SQLException ex) {
            Logger.getLogger(EditBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        issued_book_load();
    }
        
    public void issued_book_load(){
        int c;
        
        try{
            st=conn.prepareStatement("select * from issuedbooks");
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)issuedBooksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("issueID"));
                    v2.add(rs.getString("memberID"));
                    v2.add(rs.getString("memberName"));
                    v2.add(rs.getString("bookID"));
                    v2.add(rs.getString("issueDate"));
                    v2.add(rs.getString("returnDate"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE,null,e);
            
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
        searchByID = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        issuedBooksTable = new javax.swing.JTable();
        addBooks = new javax.swing.JButton();
        mainMenu = new javax.swing.JButton();
        calculateFine = new javax.swing.JButton();
        retBoook = new javax.swing.JButton();
        searchByMemberID = new javax.swing.JButton();
        searchByBookID = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        jLabel1.setText("Issued books");

        searchBox.setText("Search....");
        searchBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBoxFocusGained(evt);
            }
        });
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });

        searchByID.setText("Search by issue ID");
        searchByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIDActionPerformed(evt);
            }
        });

        issuedBooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue ID", "Member ID", "Member name", "Book ID", "Issue date", "Return date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        issuedBooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuedBooksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(issuedBooksTable);

        addBooks.setText("Issue Books");
        addBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksActionPerformed(evt);
            }
        });

        mainMenu.setText("Main menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        calculateFine.setText("Calculate fine");
        calculateFine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateFineActionPerformed(evt);
            }
        });

        retBoook.setText("Return book");
        retBoook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retBoookActionPerformed(evt);
            }
        });

        searchByMemberID.setText("Search by member ID");
        searchByMemberID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByMemberIDActionPerformed(evt);
            }
        });

        searchByBookID.setText("Search by book ID");
        searchByBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByBookIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchByID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchByMemberID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchByBookID))
                    .addComponent(mainMenu))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(retBoook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calculateFine, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBox)
                            .addComponent(searchByID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retBoook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculateFine, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

    private void addBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBooksActionPerformed
        // TODO add your handling code here:
        IssueBookForm ib=new IssueBookForm();
        this.hide();
        ib.setVisible(true);
        
    }//GEN-LAST:event_addBooksActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        // TODO add your handling code here:
        MainMenu mm=new MainMenu();
        this.hide();
        mm.setVisible(true);
    }//GEN-LAST:event_mainMenuActionPerformed

    private void issuedBooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuedBooksTableMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_issuedBooksTableMouseClicked

    private void searchByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByIDActionPerformed
        // TODO add your handling code here:
        findBooksByIssueID();
    }//GEN-LAST:event_searchByIDActionPerformed

    private void calculateFineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateFineActionPerformed
        
        DateDifference dd=new DateDifference();
        dd.setVisible(true);
        
    }//GEN-LAST:event_calculateFineActionPerformed

    private void retBoookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retBoookActionPerformed
        // TODO add your handling code here:
        int index = issuedBooksTable.getSelectedRow();
        TableModel model = issuedBooksTable.getModel();
        
        if(issuedBooksTable.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(this,"Please select a row.");
        }
        else{
        
        int issueid = Integer.parseInt(model.getValueAt(index, 0).toString());
        int memid = Integer.parseInt(model.getValueAt(index, 1).toString());
        String memName = model.getValueAt(index, 2).toString();
        int bookid = Integer.parseInt(model.getValueAt(index, 3).toString());
        try {
            Date issueDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index,4 ));
            Date returnDate= new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index,4 ));
            
            String issueDateStr=issueDate.toString();
            String returnDateStr=returnDate.toString();
            
            
            st= conn.prepareStatement("insert into returnedBooks(issueID,memberID,memberName,bookID,issueDate,returnDate)values(?,?,?,?,?,?)");
            st.setInt(1,issueid);
            st.setInt(2,memid);
            st.setString(3,memName);
            st.setInt(4,bookid);
            st.setString(5,issueDateStr);
            st.setString(6,returnDateStr);
            
            int k = st.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this,"Book returned!");
                //title.requestFocus();
                //author.requestFocus();
                //publisher.requestFocus();
                //pubYear.requestFocus();
                st= conn.prepareStatement("delete from issuedBooks where issueID=?");
                st.setInt(1,issueid);
                st.executeUpdate();
                
                IssuedBooks ib=new IssuedBooks();
                this.hide();
                ib.setVisible(true);
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }
        } catch (Exception ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_retBoookActionPerformed

    private void searchByMemberIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByMemberIDActionPerformed
        // TODO add your handling code here:
        int c;
        int id=Integer.parseInt(searchBox.getText());
        
        try{
            st=conn.prepareStatement("select * from issuedBooks where memberID=?");
            st.setInt(1,id);
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)issuedBooksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("issueID"));
                    v2.add(rs.getString("memberID"));
                    v2.add(rs.getString("memberName"));
                    v2.add(rs.getString("bookID"));
                    v2.add(rs.getString("issueDate"));
                    v2.add(rs.getString("returnDate"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }//GEN-LAST:event_searchByMemberIDActionPerformed

    private void searchByBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByBookIDActionPerformed
        // TODO add your handling code here:
        int c;
        int id=Integer.parseInt(searchBox.getText());
        
        try{
            st=conn.prepareStatement("select * from issuedBooks where bookID=?");
            st.setInt(1,id);
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)issuedBooksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("issueID"));
                    v2.add(rs.getString("memberID"));
                    v2.add(rs.getString("memberName"));
                    v2.add(rs.getString("bookID"));
                    v2.add(rs.getString("issueDate"));
                    v2.add(rs.getString("returnDate"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE,null,e);
            
        }
    }//GEN-LAST:event_searchByBookIDActionPerformed

    private void searchBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBoxFocusGained
        // TODO add your handling code here:
        searchBox.setText("");
    }//GEN-LAST:event_searchBoxFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBooks().setVisible(true);
            }
        });
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBooks;
    private javax.swing.JButton calculateFine;
    public javax.swing.JTable issuedBooksTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton retBoook;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchByBookID;
    private javax.swing.JButton searchByID;
    private javax.swing.JButton searchByMemberID;
    // End of variables declaration//GEN-END:variables
}
