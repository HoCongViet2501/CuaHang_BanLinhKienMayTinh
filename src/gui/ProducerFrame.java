/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_NhaCungCap;
import entity.NhaCungCap;

/**
 *
 * @author Lenovo
 */
public class ProducerFrame extends javax.swing.JFrame {

	DefaultTableModel tableModel;
	List<NhaCungCap> listNcc;
	DAO_NhaCungCap dao_nhacc = new DAO_NhaCungCap();
    /**
     * Creates new form ProducerFrame
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public ProducerFrame() throws SQLException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tableCNNCC.getModel();
        showData();
        reset();
    }

    private void showData() throws SQLException, ClassNotFoundException {
    	listNcc = dao_nhacc.getNhaCungCap();
    	tableModel.setRowCount(0);
    	for(NhaCungCap ncc: listNcc) {
    		tableModel.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getDiachi(),ncc.getSdt()});
    	}
    }
    private void regex() {
    	String mancc = txtMaNCC.getText();
    	String tenncc = txtTenNCC.getText();
    	String diachi = txtSDT.getText();
    	if(mancc.equals("")) {
    		JOptionPane.showMessageDialog(this, "Mã nhà cung cấp không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtMaNCC.setBorder(new LineBorder(Color.red));
    	}else {
    		txtMaNCC.setBorder(new LineBorder(Color.green));
    		
		}
    	if(tenncc.equals("")) {
    		JOptionPane.showMessageDialog(this, "Tên nhà cung cấp không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtTenNCC.setBorder(new LineBorder(Color.red));
    		
    	}else {
    		txtTenNCC.setBorder(new LineBorder(Color.green));
    		
		}
    	if(diachi.equals("")) {
    		JOptionPane.showMessageDialog(this, "Địa chỉ nhà cung cấp không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtMaNCC.setBorder(new LineBorder(Color.red));
    		
    	}else {
    		txtSDT.setBorder(new LineBorder(Color.green));
    		
		}
    }
    private boolean checkInput() {
    	String mancc = txtMaNCC.getText();
    	String tenncc = txtTenNCC.getText();
    	String diachi = txtSDT.getText();
    	
    	if(mancc.equals("") && tenncc.equals("") && diachi.equals("")) {
    		return false;
    	}else {
			return true;
			
		}
    }
    private void reset() {
    	txtSDT.setText("");
    	txtMaNCC.setText("");
    	txtTenNCC.setText("");
    	txtDiaChi1.setText("");
    	txtSDT.setEnabled(false);
    	txtMaNCC.setEnabled(false);
    	txtDiaChi1.setEnabled(false);
    	txtTenNCC.setEnabled(false);
    	btnLuu.setEnabled(false);
    	btnSua.setEnabled(false);
    	btnXoa.setEnabled(false);
    	btnQuayLai.setEnabled(false);
    	txtSDT.setBorder(new LineBorder(Color.black));
    	txtMaNCC.setBorder(new LineBorder(Color.black));
    	txtTenNCC.setBorder(new LineBorder(Color.black));
    	txtDiaChi1.setBorder(new LineBorder(Color.black));
    }
    private void clickBtnThem() {
    	reset();
    	txtSDT.setEnabled(true);
    	txtMaNCC.setEnabled(true);
    	txtTenNCC.setEnabled(true);
    	txtDiaChi1.setEnabled(true);
    	btnQuayLai.setEnabled(true);
    	btnLuu.setEnabled(true);
    }
    private boolean checkStatusBtnLuu(String mancc) {
    	int select = tableCNNCC.getSelectedRow();
    	if(select == -1) {
    		return false;
    	}else {
			if(mancc.equals(listNcc.get(select).getMaNCC())) {
				return true;
			}else {
				return false;
			}
		}
    }
    private boolean checkMaNCC(String mancc) {
    	for(NhaCungCap ncc : listNcc) {
    		if(mancc.equals(ncc.getMaNCC())) {
    			JOptionPane.showMessageDialog(this, "Mã nhà cung cấp đã tồn tại","Error!",JOptionPane.ERROR_MESSAGE);
        		txtMaNCC.setBorder(new LineBorder(Color.red));
    			return true;
    		}
    	}
    	txtMaNCC.setBorder(new LineBorder(Color.green));
    	return false;
    }
    private int notify(String title, String message) {
    	int n = JOptionPane.showConfirmDialog(this, message,title,JOptionPane.YES_NO_OPTION);
    	return n;
    }
    private void clickBtnLuu() throws SQLException, ClassNotFoundException {
    	String mancc = txtMaNCC.getText();
    	String tenncc= txtTenNCC.getText();
    	String diachi = txtDiaChi1.getText();
    	String sdt=txtSDT.getText();
    	if(checkStatusBtnLuu(mancc) == true) {
    		regex();
    		if(checkInput() == true && notify("", "Bạn có chắc muốn lưu thay đổi không?") == 0){
    			dao_nhacc.update(mancc, tenncc, diachi,sdt);
        		showData();
        		reset();
        		JOptionPane.showMessageDialog(this,"Bạn đã cập nhật thành công!");
    		}
    	}else {
    		regex();
    		if(checkInput() == true && checkMaNCC(mancc) == false && notify("", "Bạn có chắc muốn lưu thông tin vừa nhập không ?") == 0) {
    			dao_nhacc.insert(mancc, tenncc, diachi,sdt);
    			showData();
    			reset();
    			JOptionPane.showMessageDialog(this,"Bạn đã lưu thành công!");
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

        jLabel5 = new javax.swing.JLabel();
        panelCapNhatNCC = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelCapNhatNCC = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        labelMaNCC = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        labelTenNCC = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        labelDiaChi = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        labelSDT = new javax.swing.JLabel();
        txtDiaChi1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCNNCC = new javax.swing.JTable();

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mã nhà cung cấp");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cập nhật nhà cung cấp");

        panelCapNhatNCC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelCapNhatNCC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelCapNhatNCC.setText("Cập Nhật Nhà Cung Cấp");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnThoatActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        labelMaNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMaNCC.setText("Mã nhà cung cấp");

        labelTenNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTenNCC.setText("Tên nhà cung cấp");

        labelDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDiaChi.setText("Địa chỉ");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					try {
						btnXoaActionPerformed(evt);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fix.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					try {
						btnLuuActionPerformed(evt);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnQuayLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        labelSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSDT.setText("Số điện thoại");

        javax.swing.GroupLayout panelCapNhatNCCLayout = new javax.swing.GroupLayout(panelCapNhatNCC);
        panelCapNhatNCC.setLayout(panelCapNhatNCCLayout);
        panelCapNhatNCCLayout.setHorizontalGroup(
            panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelCapNhatNCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThoat)
                .addGap(365, 365, 365)
                .addComponent(labelCapNhatNCC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCapNhatNCCLayout.createSequentialGroup()
                .addGroup(panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCapNhatNCCLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(labelMaNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(labelTenNCC))
                    .addGroup(panelCapNhatNCCLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCapNhatNCCLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCapNhatNCCLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(labelDiaChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSDT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(55, 55, 55))
        );
        panelCapNhatNCCLayout.setVerticalGroup(
            panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCapNhatNCCLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCapNhatNCC)
                    .addComponent(btnThoat))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMaNCC)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTenNCC)
                    .addComponent(labelDiaChi)
                    .addComponent(labelSDT)
                    .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(panelCapNhatNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnQuayLai))
                .addGap(48, 48, 48))
        );

        tableCNNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCNNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCNNCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCNNCC);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCapNhatNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCapNhatNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    	dispose();
    	new HomeFrame().setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    	clickBtnThem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    	txtDiaChi1.setEnabled(true);
    	txtTenNCC.setEnabled(true);
    	txtSDT.setEnabled(true);
    	btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
    	clickBtnLuu();
    	reset();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void tableCNNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCNNCCMouseClicked
        // TODO add your handling code here:
    	int index = tableCNNCC.getSelectedRow();
    	txtMaNCC.setText(listNcc.get(index).getMaNCC());
    	txtTenNCC.setText(listNcc.get(index).getTenNCC());
    	txtDiaChi1.setText(listNcc.get(index).getDiachi());
    	txtSDT.setText(listNcc.get(index).getSdt());
    	txtDiaChi1.setEnabled(false);
    	txtMaNCC.setEnabled(false);
    	txtTenNCC.setEnabled(false);
    	txtSDT.setEnabled(false);
    	btnSua.setEnabled(true);
    	btnXoa.setEnabled(true);
    	btnQuayLai.setEnabled(true);
    }//GEN-LAST:event_tableCNNCCMouseClicked

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
    	reset();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    	String mancc = txtMaNCC.getText();
    	if(notify("", "Bạn có chắc muốn xóa nhà cung cấp này không?") == 0) {
    		boolean success =  dao_nhacc.delete(mancc);
    		if(success == true) {
    			JOptionPane.showMessageDialog(this,"Bạn đã xóa thành công!");
    			showData();
    		}else {
    			JOptionPane.showMessageDialog(this,"Lỗi không thể xóa!","", JOptionPane.ERROR_MESSAGE);
    			showData();
			}
    	}
    	reset();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

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
            java.util.logging.Logger.getLogger(ProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					try {
						new ProducerFrame().setVisible(true);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCapNhatNCC;
    private javax.swing.JLabel labelDiaChi;
    private javax.swing.JLabel labelMaNCC;
    private javax.swing.JLabel labelSDT;
    private javax.swing.JLabel labelTenNCC;
    private javax.swing.JPanel panelCapNhatNCC;
    private javax.swing.JTable tableCNNCC;
    private javax.swing.JTextField txtDiaChi1;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
