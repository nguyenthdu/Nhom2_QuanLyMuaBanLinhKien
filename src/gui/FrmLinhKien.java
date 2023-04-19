package gui;

import dao.DanhMucDAO;
import dao.LinhKienDAO;
import dao.NhaCungCapDAO;
import entity.DanhMucLinhKien;
import entity.LinhKien;
import entity.NhaCungCapLinhKien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrmLinhKien extends JPanel  implements ActionListener {
	private static final long serialVersionUID = 1L;
	private LinhKienDAO linhKienDAO;
	private DanhMucDAO danhMucDAO;
	private NhaCungCapDAO nhaCungCapDAO;
    private JTable table;
	private JTextField txtMaLinhKien;
	private JTextField txtTenLinhKien;
	private JTextField txtThoiGianBaoHanh;
	private JButton btnLamMoi;

	private JComboBox<String> cbxDanhMuc;
	private JComboBox<String> cbxNhaCungCap;
//	private JDateChooser dateNgayNhap;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private DefaultTableModel model;

	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnHuy;

	private JButton btnTim;
	private JButton btnXoa;
	private JButton btnSua;



	public FrmLinhKien(){
		//doc du lieu tu database
		linhKienDAO = new LinhKienDAO();
		//setsize
        setMaximumSize(new Dimension(1500, 1030));
		setMinimumSize(new Dimension(1500, 1030));
		setMaximumSize(new Dimension(1500, 1030));

		setSize(new Dimension(1550, 845));
		setLayout(null);
		/*
		Tiêu đề
		 */
		JPanel panelTitle = new JPanel();
		JLabel lblTitLe = new JLabel("THÔNG TIN LINH KIỆN");
		lblTitLe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitLe.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitLe.setForeground(Color.WHITE);
		panelTitle.add(lblTitLe);
		panelTitle.setBounds(0, 10, 1540, 45);
		panelTitle.setBackground(Color.RED);
		add(panelTitle);


		JPanel panelThongTin = new JPanel();
		panelThongTin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTin.setBounds(0, 57, 1540, 237);
		add(panelThongTin);
		panelThongTin.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 178, 33);
		panelThongTin.add(panel);
		/*
		Nhap thông tin
		 */
		JLabel lbl_titlle_panel_1 = new JLabel("Thông tin");
		panel.add(lbl_titlle_panel_1);
		lbl_titlle_panel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titlle_panel_1.setFont(new Font("Arial", Font.BOLD, 16));
		/*
		Mã linh kiện
		 */
		JLabel lblMaLinhKien = new JLabel("Mã linh kiện");
		lblMaLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaLinhKien.setBounds(31, 45, 99, 40);
		panelThongTin.add(lblMaLinhKien);

		txtMaLinhKien = new JTextField();
		txtMaLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaLinhKien.setBounds(140, 45, 203, 40);
		panelThongTin.add(txtMaLinhKien);
		txtMaLinhKien.setColumns(10);
		/*
		Tên linh kiện
		 */
		JLabel lblTenLinhKien = new JLabel("Tên linh kiện");
		lblTenLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenLinhKien.setBounds(380, 45, 99, 40);
		panelThongTin.add(lblTenLinhKien);

		txtTenLinhKien = new JTextField();
		txtTenLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenLinhKien.setColumns(10);
		txtTenLinhKien.setBounds(489, 45, 200, 40);
		panelThongTin.add(txtTenLinhKien);
		/*
		Nhà cung cấp
		 */
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp");
		lblNhaCungCap.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNhaCungCap.setBounds(734, 45, 132, 40);
		panelThongTin.add(lblNhaCungCap);
		cbxNhaCungCap = new JComboBox<String>();
		cbxNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxNhaCungCap.setBounds(843, 45, 200, 40);
		cbxNhaCungCap.setEditable(false);
		cbxNhaCungCap.addItem("Tất Cả");
		panelThongTin.add(cbxNhaCungCap);
		/*
		Thời gian bảo hành
		 */
		JLabel lblThoiGianBaoHanh = new JLabel("Thời gian bảo hành");
		lblThoiGianBaoHanh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblThoiGianBaoHanh.setBounds(1090, 45, 200, 40);
		panelThongTin.add(lblThoiGianBaoHanh);

		txtThoiGianBaoHanh = new JTextField();
		txtThoiGianBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtThoiGianBaoHanh.setColumns(10);
		txtThoiGianBaoHanh.setBounds(1250, 45, 200, 40);
		panelThongTin.add(txtThoiGianBaoHanh);
		/*
		Giá ban
		 */
		JLabel lblGiaBan = new JLabel("Giá Bán");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiaBan.setBounds(31, 100, 99, 40);
		panelThongTin.add(lblGiaBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(140, 100, 200, 40);
		panelThongTin.add(txtGiaBan);
		/*
		Số lượng
		 */
		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoLuong.setBounds(380, 100, 99, 40);
		panelThongTin.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(489, 100, 200, 40);
		panelThongTin.add(txtSoLuong);
		/*
		Danh mục
		 */
		JLabel lblDanhMuc = new JLabel("Danh mục");
		lblDanhMuc.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDanhMuc.setBounds(734, 100, 99, 40);
		panelThongTin.add(lblDanhMuc);
		cbxDanhMuc = new JComboBox<String>();
		cbxDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxDanhMuc.setBounds(843, 100, 200, 39);
		cbxDanhMuc.setEditable(false);

		cbxDanhMuc.addItem("Tất cả");
		panelThongTin.add(cbxDanhMuc);


		/*
		Nút tìm kiếm
		 */
		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim.setBounds(200, 165, 200, 50);
		panelThongTin.add(btnTim);
		//nút thêm
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(450, 165, 200, 50);
		panelThongTin.add(btnThem);
		// nút xóa
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(700, 165, 200, 50);
		panelThongTin.add(btnXoa);
		//nút xóa rỗng
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(950, 165, 200, 50);
		panelThongTin.add(btnLamMoi);
		// nút cập nhật
		btnSua = new JButton("Cập nhật");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(1200, 165, 200, 50);
		panelThongTin.add(btnSua);
		/*
		TABLE
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 359, 1540, 464);
		add(scrollPane_1);
		String[] Header = { "Mã Linh Kiện", "Tên Linh Kiện", "Nhà Cung cấp","Thời Gian BH", "Giá Bán", "Số Lượng", "Danh Mục"};
		model = new DefaultTableModel(Header, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(table);

		JLabel lblTitle_Table = new JLabel("DANH SÁCH LINH KIỆN");
		lblTitle_Table.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_Table.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle_Table.setBounds(0, 315, 1540, 45);
		add(lblTitle_Table);

		btnLuu = new JButton("Lưu");
		btnLuu.setVisible(false);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(450, 165, 200, 50);
		panelThongTin.add(btnLuu);

		btnHuy = new JButton("Hủy");
		btnHuy.setVisible(false);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBounds(700, 165, 200, 50);
		panelThongTin.add(btnHuy);

		cbxDanhMuc.setSelectedItem("Tất Cả");
		cbxNhaCungCap.setSelectedItem("Tất Cả");

		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnLamMoi.addActionListener(this);
		/*
		TODO: các phương thức xử lý
		 */
		//Nha cung cap
		nhaCungCapDAO = new NhaCungCapDAO();
		ArrayList<NhaCungCapLinhKien> dsNhaCungCap = nhaCungCapDAO.LayThongTin();
		for(NhaCungCapLinhKien ncc : dsNhaCungCap) {
			cbxNhaCungCap.addItem(ncc.getTenNhaCungCap());
		}
		//Danh muc
		danhMucDAO = new DanhMucDAO();
		ArrayList<DanhMucLinhKien> dsDanhMuc = danhMucDAO.LayThongTin();
		for(DanhMucLinhKien dm : dsDanhMuc) {
			cbxDanhMuc.addItem(dm.getTenDanhMuc());
		}
		//Table
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtMaLinhKien.setText(model.getValueAt(i, 0).toString());
				txtTenLinhKien.setText(model.getValueAt(i, 1).toString());
				cbxNhaCungCap.setSelectedItem(model.getValueAt(i, 2).toString());
				txtThoiGianBaoHanh.setText(model.getValueAt(i, 3).toString());
				txtGiaBan.setText(model.getValueAt(i, 4).toString());
				txtSoLuong.setText(model.getValueAt(i, 5).toString());
				cbxDanhMuc.setSelectedItem(model.getValueAt(i, 6).toString());
			}
		});
		docDuLieu();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		int n = 1;
		if(o.equals(btnThem)) {
			btnTim.setVisible(false);
			btnThem.setVisible(false);
			btnSua.setVisible(false);
			btnXoa.setVisible(false);

			btnLuu.setVisible(true);
			btnHuy.setVisible(true);
			btnLamMoi.setVisible(true);
			txtMaLinhKien.setEditable(false);
			//txtTenLinhKien.setText(TaoMaQuanAo());
			n = 1;
		}
		if(o.equals(btnHuy)){
			btnTim.setVisible(true);
			btnThem.setVisible(true);
			btnSua.setVisible(true);
			btnXoa.setVisible(true);

			btnLuu.setVisible(false);
			btnHuy.setVisible(false);
			btnLamMoi.setVisible(true);
			txtMaLinhKien.setEditable(false);
			//txtMaLinhKien.setText(TaoMaQuanAo());
			//DocDuLieu();
			//XoaTrang();
		}
    }
	public void XoaTrang() {
		txtMaLinhKien.setText("");
		txtTenLinhKien.setText("");
		cbxNhaCungCap.setSelectedItem("Tất Cả");
		txtThoiGianBaoHanh.setText("");
		txtGiaBan.setText("");
		txtSoLuong.setText("");
		cbxDanhMuc.setSelectedItem("Tất Cả");
	}
	public void docDuLieu() {
		ArrayList<LinhKien> dsLinhKien = linhKienDAO.layThongTin();
		ArrayList<NhaCungCapLinhKien> dsNhaCungCap = nhaCungCapDAO.LayThongTin();
		ArrayList<DanhMucLinhKien> dsDanhMuc = danhMucDAO.LayThongTin();
		model.setRowCount(0);
		for (LinhKien lk : dsLinhKien) {
			for(NhaCungCapLinhKien ncc : dsNhaCungCap) {
				for(DanhMucLinhKien dm : dsDanhMuc) {
					if(lk.g().equals(ncc.getMaNhaCungCap()) && lk.getMaDanhMuc().equals(dm.getMaDanhMuc())) {
						model.addRow(new Object[] {lk.getMaLinhKien(), lk.getTenLinhKien(), ncc.getTenNhaCungCap(), lk.getThoiGianBaoHanh(), lk.getGiaBan(), lk.getSoLuong(), dm.getTenDanhMuc()});
					}
				}
			}
		}
}
