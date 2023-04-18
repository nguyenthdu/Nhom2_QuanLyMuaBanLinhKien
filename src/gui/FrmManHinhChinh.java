package gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrmManHinhChinh extends JFrame implements ActionListener, MouseListener {
    private static final long serialVersionUID = 1;
    private FrmTrangChu frmTrangChu;
    private FrmLinhKien frmlinhkien;
    private FrmDanhMucLinhKien frmDanhMucLinhKien;
    private FrmNhaCungCapLinhKien frmNhaCungCapLinhKien;
    private FrmNhanVien frmNhanVien;
    private FrmKhachHang frmKhachHang;
    private FrmBanHang frmBanHang;
    private FrmHoaDon frmHoaDon;
    private FrmDonDatHang frmDonDatHang;


    private JPanel contentPane;
    public FrmManHinhChinh(){
        frmTrangChu =  new FrmTrangChu();
        frmlinhkien = new FrmLinhKien();
        frmDanhMucLinhKien = new FrmDanhMucLinhKien();
        frmNhaCungCapLinhKien = new FrmNhaCungCapLinhKien();
        frmNhanVien = new FrmNhanVien();
        frmKhachHang = new FrmKhachHang();
        frmBanHang = new FrmBanHang();
        frmHoaDon = new FrmHoaDon();
        frmDonDatHang = new FrmDonDatHang();

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("HỆ THỐNG QUẢN LÝ BÁN HÀNG TAI CỬA HÀNG THỜI TRANG");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
        /*===================================================================
        * 1. Tạo menu
         ==================================================================*/
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1920,50);
        contentPane.add(menuBar);
        JMenu mnTrangChu = new JMenu("Trang chủ");
        mnTrangChu.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnTrangChu);
        /*
        MENU LINH KIEN
         */
        JMenu mnLinhKien = new JMenu("Linh kiện");
        mnLinhKien.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnLinhKien);
        JMenuItem mntmThongTinLinhKien = new JMenuItem("Thông tin linh kiện");
        mntmThongTinLinhKien.setFont(new Font("Arial", Font.PLAIN, 20));
        mnLinhKien.add(mntmThongTinLinhKien);
        JMenuItem mntmDanhMuclinhKien = new JMenuItem("Danh mục");
        mntmDanhMuclinhKien.setFont(new Font("Arial", Font.PLAIN, 20));
        mnLinhKien.add(mntmDanhMuclinhKien);
        JMenuItem mntmNhaCungCap = new JMenuItem("Nhà cung cấp");
        mntmNhaCungCap.setFont(new Font("Arial", Font.PLAIN, 20));
        mnLinhKien.add(mntmNhaCungCap);
        /*
MENU NHAN VIEN
         */
        JMenu mnNhanVien = new JMenu("Nhân viên");
        mnNhanVien.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnNhanVien);
        /*
        MENU KHACH HANG
         */
        JMenu mnKhachHang = new JMenu("Khách hàng");
        mnKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnKhachHang);
        /*
        MENU BAN HANG
         */
        JMenu mnBanHang = new JMenu("Bán hàng");
        mnBanHang.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnBanHang);
        /*
        MENU HOA DON
         */
        JMenu mnHoaDon = new JMenu("Hóa đơn");
        mnHoaDon.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnHoaDon);
        /*
        MENU DON DAT HANG
         */
        JMenu mnDonDatHang = new JMenu("Đơn đặt hàng");
        mnDonDatHang.setFont(new Font("Arial", Font.PLAIN, 20));
        menuBar.add(mnDonDatHang);
        /*
        Liên kết các panel
         */
        JPanel panelBody = new JPanel();
        panelBody.setBounds(0,50,1550,1030);
        contentPane.add(panelBody);
        panelBody.setLayout(new BorderLayout(0,0));
        /*
        Liên kết form trang chủ
         */
        mnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new FrmTrangChu());
                panelBody.validate();
            }
        });
        /*
        Liên kết form thông tin linh kiện
         */
        mntmThongTinLinhKien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmlinhkien);
                panelBody.validate();
            }
        });
        /*
        Liên kết form danh mục linh kiện
         */
        mntmDanhMuclinhKien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmDanhMucLinhKien);
                panelBody.validate();
            }
        });
        /*
        Liên kết form nhà cung cấp
         */
        mntmNhaCungCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmNhaCungCapLinhKien);
                panelBody.validate();
            }
        });
        /*
        Liên kết form nhân viên
         */
        mnNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmNhanVien);
                panelBody.validate();
            }
        });
        /*
        Liên kết form khách hàng
         */
        mnKhachHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmKhachHang);
                panelBody.validate();
            }
        });
        /*
        Liên kết form bán hàng
         */
        mnBanHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmBanHang);
                panelBody.validate();
            }
        });
        /*
        Liên kết form hóa đơn
         */
        mnHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmHoaDon);
                panelBody.validate();
            }
        });
        /*
        Liên kết form đơn đặt hàng
         */
        mnDonDatHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(frmDonDatHang);
                panelBody.validate();
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}