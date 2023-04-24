package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;
import dao.*;

import dao.ChiTietHoaDonDAO;
import dao.DanhMucDAO;
import dao.DonDatHangDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.LinhKienDAO;
import entity.ChiTietHoaDon;
import entity.ChiTietHoaDon;
import entity.DanhMucLinhKien;
import entity.DonDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.LinhKien;

public class Test extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTable tblChITietHoaDon;
	private JTable tblHoaDon;
	private JTextField txtHoaDon;
    private JComboBox<Object> cBNhanVienThanhToan;
	private JTextField txtSDTKH;
    private DefaultTableModel modelHoaDon, modelCTHoaDon;
	private DonDatHangDAO ddh_dao;

	private ChiTietHoaDonDAO cthd_dao;
	private KhachHangDAO kh_dao;
	private LinhKienDAO lk_dao;
	private DanhMucDAO dm_dao;
	private JButton btnLamMoi;
	private JTextField txtSDT;
	private JDateChooser dateNgayDat;

	private JButton btnTimHoaDon;
	private JLabel lblDonHang;
	private JComboBox<String> cbNhanVien;
	private NhanVienDAO nv_dao;
	private HoaDonDAO hd_dao;
	protected String MaDonHang;
	protected int r;
	private Locale localeVN = new Locale("vi", "VN");
	NumberFormat vn = NumberFormat.getInstance(localeVN);


	public Test() {
		setMaximumSize(new Dimension(1500, 1030));
		setMinimumSize(new Dimension(1500, 1030));
		setMaximumSize(new Dimension(1500, 1030));
		setName("Bán hàng");
		/**
		 *
		 */

		setSize(new Dimension(1550, 845));
		setLayout(null);
        kh_dao = new KhachHangDAO();
		lk_dao = new LinhKienDAO();
		dm_dao = new DanhMucDAO();
		nv_dao = new NhanVienDAO();
		hd_dao = new HoaDonDAO();
		cthd_dao = new ChiTietHoaDonDAO();
		JLabel lblTitLe = new JLabel("DANH SÁCH HOÁ ĐƠN");
		lblTitLe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitLe.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitLe.setBounds(0, 10, 1540, 37);
		add(lblTitLe);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 57, 1540, 125);
		add(panel_1);
		panel_1.setLayout(null);

		txtHoaDon = new JTextField();
		txtHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHoaDon.setColumns(10);
		txtHoaDon.setBounds(43, 65, 200, 40);
		panel_1.add(txtHoaDon);

		JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn");
		lblMaHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaHoaDon.setBounds(44, 35, 188, 33);
		panel_1.add(lblMaHoaDon);

		btnTimHoaDon = new JButton("Tìm Hóa Đơn");
		btnTimHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimHoaDon.setBounds(966, 65, 150, 40);
		panel_1.add(btnTimHoaDon);

		JLabel lblNhanVienThanhToan = new JLabel("Nhân Viên Thanh toán");
		lblNhanVienThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhanVienThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhanVienThanhToan.setBounds(745, 35, 194, 33);
		panel_1.add(lblNhanVienThanhToan);

		cBNhanVienThanhToan = new JComboBox<Object>();
		cBNhanVienThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cBNhanVienThanhToan.setBounds(745, 65, 200, 40);
		ArrayList<NhanVien> dsnv = nv_dao.layThongTin();
		for (NhanVien nv : dsnv) {


		}
		panel_1.add(cBNhanVienThanhToan);

		JLabel lblSDTKH = new JLabel("Số điện thoại khách hàng");
		lblSDTKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSDTKH.setBounds(269, 35, 188, 33);
		panel_1.add(lblSDTKH);

		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(268, 65, 200, 40);
		panel_1.add(txtSDTKH);

		JLabel lblNgayDat = new JLabel("Ngày Đặt");
		lblNgayDat.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayDat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayDat.setBounds(509, 35, 188, 33);
		panel_1.add(lblNgayDat);

		dateNgayDat = new JDateChooser();
		panel_1.add(dateNgayDat);
		dateNgayDat.setDateFormatString("yyyy-MM-dd");
		dateNgayDat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateNgayDat.setBounds(508, 65, 200, 40);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 178, 33);
		panel_1.add(panel);

		JLabel lblNewLabel = new JLabel("Tìm Hóa Đơn");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnInHoaDon = new JButton("In Hóa Đơn");
		btnInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInHoaDon.setBounds(1167, 65, 150, 40);
		panel_1.add(btnInHoaDon);
		btnLamMoi = new JButton("Làm mới dữ liệu");
		btnLamMoi.setBounds(1357, 65, 150, 40);
		panel_1.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblHoaDon.setRowSorter(null);

			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 192, 1540, 247);
		add(scrollPane_1);
		String[] header1 = { "Mã Hóa Đơn", "Tên Khách Hàng", "Số Điện Thoại", "Nhân Viên Lập Đơn", "Ngày Thanh Toán","Tổng Tiền" };
		modelHoaDon = new DefaultTableModel(header1, 0);
		tblHoaDon = new JTable(modelHoaDon);
		tblHoaDon.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(tblHoaDon);
		tblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblHoaDon.getSelectedRow();
				String MaHoaDon = modelHoaDon.getValueAt(r, 0).toString();
				txtHoaDon.setText(modelHoaDon.getValueAt(r, 0).toString());
				txtSDTKH.setText(modelHoaDon.getValueAt(r, 2).toString());
				dateNgayDat.setDate((Date) modelHoaDon.getValueAt(r, 4));
				cBNhanVienThanhToan.setSelectedItem(modelHoaDon.getValueAt(r, 3));

			}
		});


		JLabel lblChiTietHD = new JLabel("Chi Tiết Hóa Đơn");
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChiTietHD.setBounds(0, 470, 1540, 37);
		add(lblChiTietHD);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 506, 1540, 329);
		add(scrollPane_1_1);
		String[] header = {"Mã Linh Kiện", "Tên Linh Kiện", "Nhà Cung cấp", "Thời Gian BH", "Giá Bán", "Số Lượng", "Danh Mục"};
		modelCTHoaDon = new DefaultTableModel(header, 0);
		tblChITietHoaDon = new JTable(modelCTHoaDon);
		tblChITietHoaDon.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblChITietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1_1.setViewportView(tblChITietHoaDon);
		btnTimHoaDon.addActionListener(this);

		lblDonHang = new JLabel("");
		lblDonHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDonHang.setBounds(117, 470, 126, 37);
		add(lblDonHang);
		btnInHoaDon.addActionListener(this);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
    }
}
