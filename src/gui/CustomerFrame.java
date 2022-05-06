/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.DAO_HomeFrame;
import dao.DAO_Khachhang;
import entity.Khachhang;
import entity.SanPham;

/**
 *
 * @author Lenovo
 */
public class CustomerFrame extends javax.swing.JFrame implements MouseListener {

    /**
     * Creates new form CustomerFrame
     */
	DAO_HomeFrame daoHome=new DAO_HomeFrame();
	String manv=new LoginFrame().getMaNVText();
	String ten;
	Khachhang khachhang ;
    public CustomerFrame() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        disabled();
        ten=daoHome.getTenNV(manv);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        labelKH = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTenKH = new javax.swing.JTextField();
        labelTenKH = new javax.swing.JLabel();
        labelDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        labelSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnHoaDonMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();
        jTextTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnDonHang = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        labelKH.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        labelKH.setText("Thông tin khách hàng");

        labelTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTenKH.setText("Tên khách hàng");

        labelDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDiaChi.setText("Địa chỉ");

        labelSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSDT.setText("Số điện thoại");
        labelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEmail.setText("Email");

        btnThemKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemKH.setText("Thêm khách hàng");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnQuayLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnQuayLaiActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnHoaDonMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHoaDonMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt.png"))); // NOI18N
        btnHoaDonMoi.setText("Bán hàng");
        btnHoaDonMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnHoaDonMoiActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableKH);

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnTimActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnDonHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt.png"))); // NOI18N
        btnDonHang.setText("Đặt hàng");
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnDonHangActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnThoat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelKH, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDiaChi)
                                    .addComponent(labelTenKH))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(149, 149, 149))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnQuayLai)
                                .addGap(45, 45, 45)
                                .addComponent(btnHoaDonMoi)
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelEmail)
                                    .addComponent(labelSDT))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnDonHang)
                                .addGap(55, 55, 55)
                                .addComponent(jTextTim, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKH, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenKH)
                    .addComponent(labelSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoaDonMoi)
                    .addComponent(btnTim)
                    .addComponent(btnDonHang)
                    .addComponent(btnQuayLai)
                    .addComponent(btnThemKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tableKH.addMouseListener(this);
        try {
			showDSKH();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showDSKH() throws ClassNotFoundException {
		// TODO Auto-generated method stub
    	 DefaultTableModel model = new DefaultTableModel(new Object[]{"Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","Email"}, 0);
		ArrayList<Khachhang> dskh=new DAO_Khachhang().getKhachhangs();
		for(Khachhang kh : dskh) {
			model.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getSodienthoai(),kh.getDiachi(),kh.getEmail()});
		}
		tableKH.setModel(model);
	}

	private void btnHoaDonMoiActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {//GEN-FIRST:event_btnHoaDonMoiActionPerformed
        // TODO add your handling code here:
        if(kiemtratrong()) {
            khachhang = taoKhachhang();
            dispose();
            new SaleFrame(khachhang).setVisible(true);

        }
        }

        private void disabled() {
            txtDiaChi.setEnabled(false);
            txtEmail.setEnabled(false);
            txtSDT.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtDiaChi.setText("");
            txtEmail.setText("");
            txtSDT.setText("");
            txtTenKH.setText("");
        }
        private void enabled() {
            txtDiaChi.setEnabled(true);
            txtEmail.setEnabled(true);
            txtSDT.setEnabled(true);
            txtTenKH.setEnabled(true);
            txtDiaChi.setText("");
            txtEmail.setText("");
            txtSDT.setText("");
            txtTenKH.setText("");
        }
        private Khachhang taoKhachhang() {
            Khachhang khachhang = new Khachhang();
            khachhang.setDiachi(txtDiaChi.getText());
            khachhang.setEmail(txtEmail.getText());
            khachhang.setSodienthoai(txtSDT.getText());
            khachhang.setTenKH(txtTenKH.getText());
            return khachhang;
        }
        private boolean kiemtratrong() {
            if(txtDiaChi.getText().equals("")||txtEmail.getText().equals("")||txtSDT.getText().equals("")||txtTenKH.getText().equals("")||txtDiaChi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin khách hang!\nVui lòng nhập đủ thông tin!");
                return false;
            }
            return true;
        }
//GEN-LAST:event_btnHoaDonMoiActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtTenKH.setText("");
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        enabled();
        btnThemKH.setEnabled(false);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    	dispose();
    	try {
			new HomeFrame().setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {//GEN-FIRST:event_btnTimActionPerformed
        String tukhoa = jTextTim.getText();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","Email"}, 0);

        Khachhang kh= new DAO_Khachhang().getKhachhang(tukhoa);
            Object[] tableModel = {kh.getMaKH(),kh.getTenKH(),kh.getSodienthoai(),kh.getDiachi(),kh.getEmail()};
            model.addRow(tableModel);
        tableKH.setModel(model);
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {//GEN-FIRST:event_btnDonHangActionPerformed
        // TODO add your handling code here:
    	if(kiemtratrong()) {
            khachhang = taoKhachhang();
            dispose();
            new OrderFrame(khachhang).setVisible(true);

        }
        }
    //GEN-LAST:event_btnDonHangActionPerformed
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
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new CustomerFrame().setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonHang;
    private javax.swing.JButton btnHoaDonMoi;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextTim;
    private javax.swing.JLabel labelDiaChi;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelKH;
    private javax.swing.JLabel labelSDT;
    private javax.swing.JLabel labelTenKH;
    private javax.swing.JTable tableKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=tableKH.getSelectedRow();
		txtDiaChi.setText(tableKH.getValueAt(row, 3).toString());
		txtEmail.setText(tableKH.getValueAt(row, 4).toString());
		txtSDT.setText(tableKH.getValueAt(row, 2).toString());
		txtTenKH.setText(tableKH.getValueAt(row, 1).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
