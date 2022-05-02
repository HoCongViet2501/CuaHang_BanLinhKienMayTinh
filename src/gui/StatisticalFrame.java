/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.DAO_ThongKe;

/**
 *
 * @author Lenovo
 */
public class StatisticalFrame extends javax.swing.JFrame {

	DAO_ThongKe dao_thongke = new DAO_ThongKe();
	DefaultTableModel tableModel;
	List<List<String>> listHD;
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	
    /**
     * Creates new form StatisticalFrame
     */
	private String formatMoney(double tien) {
		String matter;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		matter = formatter.format(tien);
		return matter;
	}
    public StatisticalFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tableThongKe.getModel();
        dateNgayBatDau.setEnabled(false);
		dateNgayKetThuc.setEnabled(false);
		labelValueDoanhThu.setText("0");
    }
    private void checkLoaiThongKe() {
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Tùy chọn")){
    		dateNgayBatDau.setEnabled(true);
    		dateNgayKetThuc.setEnabled(true);
    	}else {
    		dateNgayBatDau.setEnabled(false);
    		dateNgayKetThuc.setEnabled(false);
    	}
    }
    private void searchHDTheoNgay() throws SQLException, ClassNotFoundException {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	if(dateNgayBatDau.getDate() == null || dateNgayKetThuc.getDate() == null) {
    		JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ các ngày","Error!",JOptionPane.ERROR_MESSAGE);
    	}else if (dateNgayBatDau.getDate().before(dateNgayKetThuc.getDate()) == false) {
    		JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc","Error!",JOptionPane.ERROR_MESSAGE);
		}else {
			String ngaybatdau = df.format(dateNgayBatDau.getDate());
	    	String ngayketthuc = df.format(dateNgayKetThuc.getDate());
			listHD = dao_thongke.searchHDTheoNgay(ngaybatdau, ngayketthuc);
	    	if(listHD.size() == 0) {
	    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
	    	}
	    	tableModel.setRowCount(0);
	    	for(List<String> l: listHD) {
	    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7)});
	    	}
	    	dataset = createDataset(ngaybatdau, ngayketthuc);
		}
    }
    private void submitTimKiem() throws SQLException, ClassNotFoundException {
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong ngày")) {
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		Date date = new Date();
    		String datenow = df.format(date);
    		listHD = dao_thongke.searchHDTheoNgay(datenow, datenow);
    		if(listHD.size() == 0) {
	    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
	    	}
	    	tableModel.setRowCount(0);
	    	for(List<String> l: listHD) {
	    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7)});
	    	}
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong tháng")) {
    		LocalDate initial = LocalDate.now();
    		LocalDate start = initial.withDayOfMonth(1);
    		LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
    		listHD = dao_thongke.searchHDTheoNgay(start.toString(), end.toString());
    		if(listHD.size() == 0) {
	    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
	    	}
	    	tableModel.setRowCount(0);
	    	for(List<String> l: listHD) {
	    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7)});
	    	}
	    	dataset = createDataset(start.toString(), end.toString());
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong năm")) {
    		LocalDate initial = LocalDate.now();
    		LocalDate start = initial.withDayOfYear(1);
    		LocalDate end = initial.withDayOfYear(initial.lengthOfYear());
    		listHD = dao_thongke.searchHDTheoNgay(start.toString(), end.toString());
    		if(listHD.size() == 0) {
	    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
	    	}
	    	tableModel.setRowCount(0);
	    	for(List<String> l: listHD) {
	    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7)});
	    	}
	    	dataset = createDataset(start.toString(), end.toString());
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Tùy chọn")) {
    		searchHDTheoNgay();
    	}
    	
    }
    private DefaultCategoryDataset createDataset(String ngaybatdau, String ngayketthuc) throws SQLException, ClassNotFoundException {
    	DefaultCategoryDataset dataset_1 = new DefaultCategoryDataset();
    	Map<String, String> map = dao_thongke.getThongkeHDTheoNgay(ngaybatdau, ngayketthuc);
    	Set<String> set = map.keySet();
    	 TreeMap<String, String> sorted = new TreeMap<String, String>(map);
    	 Set<Map.Entry<String, String>> mappings = sorted.entrySet();
    	 for (Map.Entry<String, String> mapping : mappings) {
    		 dataset_1.addValue(Double.parseDouble(mapping.getValue()), "Tổng tiền", mapping.getKey());
    	  }   
    	return dataset_1;
    }
    private JFreeChart createLineChart() throws SQLException {
    	JFreeChart lineChart = ChartFactory.createLineChart(
    			"Biều đồ thống kê doanh thu".toUpperCase(),
    			"Ngày","Tổng tiền",dataset,
    			PlotOrientation.VERTICAL,false,false,false
    			);
    	return lineChart;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        panelThongKe = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelThongKe = new javax.swing.JLabel();
        btnIn = new javax.swing.JButton();
        labelNgayBatDau = new javax.swing.JLabel();
        dateNgayBatDau = new com.toedter.calendar.JDateChooser();
        labelNgayKetThuc = new javax.swing.JLabel();
        dateNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnThoat = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        cbLoaiThongKe = new javax.swing.JComboBox<>();
        labelLoaiThongKe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongKe = new javax.swing.JTable();
        labelTongDoanhThu = new javax.swing.JLabel();
        labelValueDoanhThu = new javax.swing.JLabel();

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        jButton2.setText("Thoát");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông kê doanh thu");

        panelThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelThongKe.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelThongKe.setText("THỐNG KÊ DOANH THU");

        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        btnIn.setText("Xuất tổng tiền");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        labelNgayBatDau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNgayBatDau.setText("Thống kê từ ngày");

        dateNgayBatDau.setDateFormatString("yyyy-MM-dd");

        labelNgayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNgayKetThuc.setText("Đến ngày");

        dateNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/analytics-1.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnThongKeActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnTimActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        cbLoaiThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê trong ngày", "Thống kê trong tháng", "Thống kê trong năm", "Tùy chọn" }));
        cbLoaiThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiThongKeItemStateChanged(evt);
            }
        });

        labelLoaiThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLoaiThongKe.setText("Chọn loại thống kê:");

        javax.swing.GroupLayout panelThongKeLayout = new javax.swing.GroupLayout(panelThongKe);
        panelThongKe.setLayout(panelThongKeLayout);
        panelThongKeLayout.setHorizontalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThoat)
                .addGap(289, 289, 289)
                .addComponent(labelThongKe)
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLoaiThongKe)
                    .addComponent(labelNgayBatDau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongKeLayout.createSequentialGroup()
                        .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(labelNgayKetThuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))
                    .addGroup(panelThongKeLayout.createSequentialGroup()
                        .addComponent(cbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(383, 383, 383)
                        .addComponent(btnTim)
                        .addGap(25, 25, 25)
                        .addComponent(btnThongKe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIn)
                        .addGap(26, 26, 26))))
        );
        panelThongKeLayout.setVerticalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongKeLayout.createSequentialGroup()
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelThongKeLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNgayKetThuc)
                            .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelThongKeLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelThongKe)
                            .addComponent(btnThoat))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThongKeLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIn)
                                    .addComponent(btnThongKe)
                                    .addComponent(btnTim)))
                            .addGroup(panelThongKeLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelLoaiThongKe))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNgayBatDau)
                            .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );

        tableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa đơn", "Tên nhân viên", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Email", "Ngày lập hóa đơn", "Tổng tiền hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableThongKe);

        labelTongDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTongDoanhThu.setText("Tổng doanh thu:");

        labelValueDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelValueDoanhThu.setText("valueDoanhThu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTongDoanhThu)
                        .addGap(28, 28, 28)
                        .addComponent(labelValueDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTongDoanhThu)
                    .addComponent(labelValueDoanhThu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    	try {
			submitTimKiem();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong ngày")) {
    		JOptionPane.showMessageDialog(this, "Hệ thống không hỗ trợ biểu đồ thống kê trong ngày","Error!",JOptionPane.ERROR_MESSAGE);
    	}else {
    		if(listHD == null) {
        		JOptionPane.showMessageDialog(this, "Bạn cần tìm kiếm khoảng thời gian bạn muốn thống kê","Error!",JOptionPane.ERROR_MESSAGE);
        	}else {
        		ChartPanel chartPanel = new ChartPanel(createLineChart());
            	chartPanel.setPreferredSize(new Dimension(1000,600));
            	JFrame frame = new JFrame();
            	frame = new JFrame();
            	frame.add(chartPanel);
            	frame.setSize(2000,1000);
            	frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
    		}
		}
    }//GEN-LAST:event_btnThongKeActionPerformed

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

    private void cbLoaiThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiThongKeItemStateChanged
        // TODO add your handling code here:
    	checkLoaiThongKe();
    }//GEN-LAST:event_cbLoaiThongKeItemStateChanged

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        // TODO add your handling code here:
    	if(listHD == null) {
    		JOptionPane.showMessageDialog(this, "Bạn cần tìm kiếm khoảng thời gian bạn muốn thống kê","Error!",JOptionPane.ERROR_MESSAGE);
    	}else {
    		Double tong = 0.0;
        	for(List<String> i: listHD) {
        		tong = tong + Double.parseDouble(i.get(7));
        	}
        	
        	labelValueDoanhThu.setText(formatMoney(tong) + " VND");
		}
    }//GEN-LAST:event_btnInActionPerformed
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
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cbLoaiThongKe;
    private com.toedter.calendar.JDateChooser dateNgayBatDau;
    private com.toedter.calendar.JDateChooser dateNgayKetThuc;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelLoaiThongKe;
    private javax.swing.JLabel labelNgayBatDau;
    private javax.swing.JLabel labelNgayKetThuc;
    private javax.swing.JLabel labelThongKe;
    private javax.swing.JLabel labelTongDoanhThu;
    private javax.swing.JLabel labelValueDoanhThu;
    private javax.swing.JPanel panelThongKe;
    private javax.swing.JTable tableThongKe;
    // End of variables declaration//GEN-END:variables
}
