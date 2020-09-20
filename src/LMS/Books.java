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
public class Books extends javax.swing.JFrame {
    private Object jtRowData;

    /**
     * Creates new form Books
     */
    public Books() {
        initComponents();
        connect();
        book_load();
    }
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    Books books;
    
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/LibraryManagementSystem","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void findBooksByID(){
        int c;
        int id=Integer.parseInt(bookSearchBox.getText());
        
        try{
            st=conn.prepareStatement("select * from books where BookID=?");
            st.setInt(1,id);
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)booksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("BookID"));
                    v2.add(rs.getString("Title"));
                    v2.add(rs.getString("Author"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("Publisher"));
                    v2.add(rs.getString("Publication_year"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }
    
    public void findBooksByCategory(){
         int c;
        String cat=bookSearchBox.getText();
        
        try{
            st=conn.prepareStatement("select * from books where category=?");
            st.setString(1,cat);
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)booksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("BookID"));
                    v2.add(rs.getString("Title"));
                    v2.add(rs.getString("Author"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("Publisher"));
                    v2.add(rs.getString("Publication_year"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }
    
    public void findBooksByAuthor(){
         int c;
        String auth=bookSearchBox.getText();
        
        try{
            st=conn.prepareStatement("select * from books where Author=?");
            st.setString(1,auth);
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)booksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("BookID"));
                    v2.add(rs.getString("Title"));
                    v2.add(rs.getString("Author"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("Publisher"));
                    v2.add(rs.getString("Publication_year"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE,null,e);
            
        }
        
    }
    
    public void book_load(){
        int c;
        
        try{
            st=conn.prepareStatement("select * from books");
            rs= st.executeQuery();
            
            ResultSetMetaData rsd= rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)booksTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()){
                
                Vector v2=new Vector();
                
                for(int i=1; i<=c;i++)
                {
                    v2.add(rs.getString("BookID"));
                    v2.add(rs.getString("Title"));
                    v2.add(rs.getString("Author"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("Publisher"));
                    v2.add(rs.getString("Publication_year"));
                    
                }
                d.addRow(v2);
                
            }
            
            
        } catch(SQLException e){
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE,null,e);
            
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
        bookSearchBox = new javax.swing.JTextField();
        searchByID = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        addBooks = new javax.swing.JButton();
        deleteBook = new javax.swing.JButton();
        mainMenu = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        searchByCat = new javax.swing.JButton();
        searchByAuthor = new javax.swing.JButton();

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
        jLabel1.setText("Books");

        bookSearchBox.setText("Search....");
        bookSearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSearchBoxActionPerformed(evt);
            }
        });

        searchByID.setText("Search by ID");
        searchByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIDActionPerformed(evt);
            }
        });

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Title", "Author", "Category", "Publisher", "Publication year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(booksTable);

        addBooks.setText("Add Books");
        addBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksActionPerformed(evt);
            }
        });

        deleteBook.setText("Delete books");
        deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookActionPerformed(evt);
            }
        });

        mainMenu.setText("Main menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        searchByCat.setText("Search by Category");
        searchByCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByCatActionPerformed(evt);
            }
        });

        searchByAuthor.setText("Search by Author");
        searchByAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainMenu)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(bookSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchByID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchByCat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(searchByAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookSearchBox)
                            .addComponent(searchByID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByCat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bookSearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSearchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookSearchBoxActionPerformed

    private void addBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBooksActionPerformed
        // TODO add your handling code here:
        AddBooks ab=new AddBooks();
        this.hide();
        ab.setVisible(true);
        
    }//GEN-LAST:event_addBooksActionPerformed

    private void deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)booksTable.getModel();
        int selectIndex=booksTable.getSelectedRow();
        
        if(booksTable.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(this,"Please select a row.");
        }
        else{
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        try {
            st= conn.prepareStatement("delete from books where BookID=?");
            st.setInt(1,id);
            
            int k = st.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this,"book information deleted.");
                //this.hide();
            }
            else{
                JOptionPane.showMessageDialog(this,"Error");
            }
            
          
            
        } catch (SQLException ex) {
            Logger.getLogger(EditBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       book_load();
        }
        
    }//GEN-LAST:event_deleteBookActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        // TODO add your handling code here:
        MainMenu mm=new MainMenu();
        this.hide();
        mm.setVisible(true);
    }//GEN-LAST:event_mainMenuActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int index = booksTable.getSelectedRow();
        TableModel model = booksTable.getModel();
        
        if(booksTable.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(this,"Please select a row.");
        }
        else{
        EditBookForm ed = new EditBookForm();
        ed.setIndex(index);
        ed.setModel(model);
        ed.setBooksInstance(this);
        
        //String id=model.getValueAt(index, 0).toString();
        String title = model.getValueAt(index, 1).toString();
        String author = model.getValueAt(index, 2).toString();
        String category = model.getValueAt(index, 3).toString();
        String publisher = model.getValueAt(index, 4).toString();
        String pubYear = model.getValueAt(index, 5).toString();
        
        ed.setVisible(true);
        ed.pack();
        ed.setLocationRelativeTo(null);
        ed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        ed.title.setText(title);
        ed.author.setText(author);
        ed.category.setText(category);
        ed.publisher.setText(publisher);
        ed.pubYear.setText(pubYear);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_booksTableMouseClicked

    private void searchByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByIDActionPerformed
        // TODO add your handling code here:
        findBooksByID();
    }//GEN-LAST:event_searchByIDActionPerformed

    private void searchByCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByCatActionPerformed
        // TODO add your handling code here:
        findBooksByCategory();
    }//GEN-LAST:event_searchByCatActionPerformed

    private void searchByAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByAuthorActionPerformed
        // TODO add your handling code here:
        findBooksByAuthor();
    }//GEN-LAST:event_searchByAuthorActionPerformed

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
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBooks;
    private javax.swing.JTextField bookSearchBox;
    public javax.swing.JTable booksTable;
    private javax.swing.JButton deleteBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton searchByAuthor;
    private javax.swing.JButton searchByCat;
    private javax.swing.JButton searchByID;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
