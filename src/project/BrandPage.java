package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.persistence.*;
import project.PersistenceManager;
import static project.PersistenceManager.getEntityManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
public class BrandPage extends BaseFrame {

    private DefaultListModel<String> listModel;

    /**
     * Creates new form BrandPage
     */
    public BrandPage() {
        super();
        initComponents();
        listModel = new DefaultListModel<>();
        lstProducts.setModel(listModel);
        //Brand otherBrand = null;
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            List<Brand> brands = em.createQuery("SELECT b FROM Brand b", Brand.class).getResultList();
            for (Brand brand : brands) {
                cmbBoxBrand.addItem(brand);
            }

        } finally {
            em.close();
        }

        //if (otherBrand != null) {
          //  cmbBoxBrand.addItem(otherBrand);
        //}

        // If "other" option is selected
        cmbBoxBrand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Brand selectedBrand = (Brand) cmbBoxBrand.getSelectedItem();
                if (selectedBrand.getName().equals("other")) {
                    String newBrandName = JOptionPane.showInputDialog(
                            BrandPage.this,
                            "Enter new brand name:",
                            "New Brand",
                            JOptionPane.PLAIN_MESSAGE
                    );

                    if (newBrandName != null) {
                        newBrandName = newBrandName.trim();
                    }

                    if (newBrandName != null && !newBrandName.isEmpty()) {
                        Brand existing = Brand.findByName(newBrandName);
                        if (existing == null) {

                            Brand newBrand = new Brand(newBrandName, true);
                            EntityManager em = PersistenceManager.getEntityManager();
                            EntityTransaction tx = em.getTransaction();
                            try {
                                tx.begin();
                                em.persist(newBrand);
                                tx.commit();

                                cmbBoxBrand.removeItem(selectedBrand);
                                cmbBoxBrand.addItem(newBrand);
                                cmbBoxBrand.addItem(selectedBrand);
                                cmbBoxBrand.setSelectedItem(newBrand);
                                updateProductList(newBrand.getName());
                            } catch (Exception ex) {
                                if (tx.isActive()) {
                                    tx.rollback();
                                }
                                ex.printStackTrace();
                            } finally {
                                em.close();
                            }

                        } else {
                            JOptionPane.showMessageDialog(BrandPage.this, "Brand already exists.");
                            cmbBoxBrand.setSelectedItem(0);
                        }
                    } else {
                        if (cmbBoxBrand.getItemCount() > 0) {
                            cmbBoxBrand.setSelectedIndex(0);
                        }
                    }
                } else if (selectedBrand != null) {
                    updateProductList(selectedBrand.getName());
                }

            }

        });

        //if (cmbBoxBrand.getItemCount() == 1 && "other".equals(cmbBoxBrand.getItemAt(0).getName())) {
          //  cmbBoxBrand.setSelectedItem(otherBrand);
        //}
    }

    private void updateProductList(String selectedBrand) {
        listModel.clear();

        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Brand> query = em.createQuery("SELECT b FROM Brand b WHERE b.name = :name", Brand.class);
            query.setParameter("name", selectedBrand);
            Brand brand = query.getSingleResult();

            if (brand != null) {
                // Ürünleri veritabanından da yüklemek için:
                brand.getProducts().forEach(product -> listModel.addElement(product.getName()));
            }
        } catch (NoResultException e) {
            // Marka bulunamadıysa liste boş kalır
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading products.");
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
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

        jLabel7 = new javax.swing.JLabel();
        cmbBoxBrand = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnActivityProduct = new javax.swing.JButton();
        btnActivityBrand = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel7.setText("Brand");
        jLabel7.setAutoscrolls(true);

        cmbBoxBrand.setAutoscrolls(true);

        lstProducts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProducts);

        btnAdd.setText("Add Product");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnActivityProduct.setText("Change Activity of Product");
        btnActivityProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivityProductActionPerformed(evt);
            }
        });

        btnActivityBrand.setText("Change Activity of Brand");
        btnActivityBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivityBrandActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Products:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnActivityProduct)
                            .addComponent(btnActivityBrand)
                            .addComponent(btnCancel))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(cmbBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActivityBrand, btnActivityProduct, btnAdd, btnCancel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBoxBrand)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnActivityProduct)
                        .addGap(18, 18, 18)
                        .addComponent(btnActivityBrand)
                        .addGap(26, 26, 26)
                        .addComponent(btnCancel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Brand selectedBrand = (Brand) cmbBoxBrand.getSelectedItem();

        if (selectedBrand == null || "other".equals(selectedBrand.getName())) {
            JOptionPane.showMessageDialog(BrandPage.this, "Please select a valid brand.");
            return;
        }

        Brand brand = Brand.findById(selectedBrand.getId());
        if (brand == null) {
            JOptionPane.showMessageDialog(BrandPage.this, "Selected brand not found.");
            return;
        }

        String newProduct = JOptionPane.showInputDialog(BrandPage.this, "Enter new product name:");
        if (newProduct == null || newProduct.trim().isEmpty()) {
            return;
        }

        newProduct = newProduct.trim();

        EntityManager em = null;
        try {
            em = getEntityManager();

            // Aynı isimde ürün var mı kontrolü
            TypedQuery<Product> query = em.createQuery(
                    "SELECT p FROM Product p WHERE LOWER(p.name) = :name AND p.brand.name = :brandName", Product.class);
            query.setParameter("name", newProduct.toLowerCase());
            query.setParameter("brandName", brand.getName());

            if (!query.getResultList().isEmpty()) {
                JOptionPane.showMessageDialog(BrandPage.this, "This product already exists for the brand.");
                return;
            }

            // Yeni ürün oluşturulup veritabanına kaydediliyor
            em.getTransaction().begin();
            Product product = new Product(newProduct, brand);
            em.persist(product);
            em.getTransaction().commit();

            listModel.addElement(newProduct);
            JOptionPane.showMessageDialog(BrandPage.this, "Product added successfully.");

        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BrandPage.this, "An error occurred while adding the product.");
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnActivityProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivityProductActionPerformed
        Brand selectedBrand = (Brand) cmbBoxBrand.getSelectedItem();
        if (selectedBrand == null || "other".equals(selectedBrand.getName())) {
            JOptionPane.showMessageDialog(BrandPage.this, "Please select a valid brand.");
            return;
        }
        String selectedProductName = lstProducts.getSelectedValue();
        if (selectedProductName == null) {
            JOptionPane.showMessageDialog(BrandPage.this, "Please select a product.");
            return;
        }

        EntityManager em = null;
        try {
            em = getEntityManager();

            // Markayı güncel veritabanından al
            Brand brand = em.find(Brand.class, selectedBrand.getId());

            if (brand == null) {
                JOptionPane.showMessageDialog(BrandPage.this, "Brand not found.");
                return;
            }
// Ürün var mı kontrolü

            TypedQuery<Product> query = em.createQuery(
                    "SELECT p FROM Product p WHERE LOWER(p.name) = :productName AND p.brand.id = :brandId", Product.class);
            query.setParameter("productName", selectedProductName.toLowerCase());
            query.setParameter("brandId", brand.getId());

            Product product = null;
            try {
                product = query.getSingleResult();
            } catch (NoResultException ex) {
                JOptionPane.showMessageDialog(BrandPage.this, "Product not found in brand.");
                return;
            }
            int state = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (state == JOptionPane.YES_OPTION) {
                em.getTransaction().begin();

                  
                product.setActive(!product.getActive());
                
                
                
                
                if (product.getActive() == false) {
                TypedQuery<Complaint> complaintQuery = em.createQuery(
                        "SELECT r FROM Complaint r WHERE r.product.id = :productId AND r.active = true",
                        Complaint.class);
                complaintQuery.setParameter("productId", product.getId());

                for (Complaint complaint : complaintQuery.getResultList()) {
                    complaint.setActive(false);
                    em.merge(complaint); // şikayeti güncelle
                }
            }
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Product activity updated.");
            }
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BrandPage.this, "An error occurred while removing the product.");
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }//GEN-LAST:event_btnActivityProductActionPerformed

    private void btnActivityBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivityBrandActionPerformed
        Brand selectedBrand = (Brand) cmbBoxBrand.getSelectedItem();
        if (selectedBrand == null || "other".equals(selectedBrand.getName())) {
            JOptionPane.showMessageDialog(BrandPage.this, "Please select a valid brand.");
            return;
        }
        EntityManager em = null;
        try {
            em = getEntityManager();

            // Markayı veritabanından al
            TypedQuery<Brand> brandQuery = em.createQuery(
                    "SELECT b FROM Brand b WHERE LOWER(b.name) = :name", Brand.class);
            brandQuery.setParameter("name", selectedBrand.getName().toLowerCase());

            Brand brand = null;
            try {
                brand = brandQuery.getSingleResult();
            } catch (NoResultException ex) {
                JOptionPane.showMessageDialog(BrandPage.this, "Brand not found.");
                return;
            }

            boolean currentStatus = brand.getActive();

            em.getTransaction().begin();

            // Markayı aktif/pasif yap
            brand.setActive(!currentStatus);
            em.merge(brand); // Güncellenen brand'i kaydet

            // Temsilcileri de pasif yap
            if (currentStatus == false) {
                TypedQuery<CustomerRepresentative> repQuery = em.createQuery(
                        "SELECT r FROM CustomerRepresentative r WHERE r.assignedBrand.id = :brandId AND r.active = true",
                        CustomerRepresentative.class);
                repQuery.setParameter("brandId", brand.getId());

                for (CustomerRepresentative rep : repQuery.getResultList()) {
                    rep.setActive(false);
                    em.merge(rep); // Temsilciyi güncelle
                }
            }
            
            
            
            //marka pasifse şikayetleri de pasif yap
            if (currentStatus == false) {
                TypedQuery<Complaint> complaintQuery = em.createQuery(
                        "SELECT r FROM Complaint r WHERE r.brand.id = :brandId AND r.active = true",
                        Complaint.class);
                complaintQuery.setParameter("brandId", brand.getId());

                for (Complaint complaint : complaintQuery.getResultList()) {
                    complaint.setActive(false);
                    em.merge(complaint); // Şikayeti güncelle
                }
            }
            //productı pasif yap
            if (currentStatus == false) {
                TypedQuery<Product> productQuery = em.createQuery(
                        "SELECT r FROM Product r WHERE r.brand.id  = :brandId AND r.active = true",
                        Product.class);
                productQuery.setParameter("brandId", brand.getId());

                for (Product product : productQuery.getResultList()) {
                    product.setActive(false);
                    em.merge(product); // ürünü güncelle
                }
            }

            em.getTransaction().commit();

            String message = currentStatus
                    ? "Brand deactivated and its representatives are now inactive."
                    : "Brand activated.";
            JOptionPane.showMessageDialog(BrandPage.this, message);

        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(BrandPage.this, "An error occurred while updating the brand.");
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

    }//GEN-LAST:event_btnActivityBrandActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        BrandPage.this.setVisible(false);
        AdminPage adminPage = new AdminPage();
        adminPage.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(BrandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrandPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrandPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivityBrand;
    private javax.swing.JButton btnActivityProduct;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<Brand> cmbBoxBrand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstProducts;
    // End of variables declaration//GEN-END:variables
}
