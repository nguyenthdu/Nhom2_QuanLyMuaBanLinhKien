CREATE TABLE NhaCungCapLinhKien (
    MaNhaCungCap NVARCHAR(20) PRIMARY KEY,
    TenNCC NVARCHAR(100) NOT NULL,
    DiaChi NVARCHAR(200) NOT NULL,
    SoDienThoai NVARCHAR(20) NOT NULL
);
GO

CREATE TABLE DanhMucLinhKien (
    maDanhMuc NVARCHAR(20) PRIMARY KEY,
    tenDanhMuc NVARCHAR(100) NOT NULL
)
GO
CREATE TABLE LinhKien (
    maLinhKien NVARCHAR(20) PRIMARY KEY,
    tenLinhKien NVARCHAR(100) NOT NULL,
    soLuong INT NOT NULL,
    giaBan FLOAT NOT NULL,
    thoiGianBaoHanh FLOAT NOT NULL,
    maDanhMuc NVARCHAR(20) NOT NULL,
    maNhaCungCap NVARCHAR(20) NOT NULL,
    FOREIGN KEY (maDanhMuc) REFERENCES DanhMucLinhKien(maDanhMuc),
    FOREIGN KEY (maNhaCungCap) REFERENCES NhaCungCapLinhKien(MaNhaCungCap)
);

GO
CREATE TABLE KhachHang (
    maKH NVARCHAR(20) PRIMARY KEY,
    tenKH NVARCHAR(100) NOT NULL,
    soDT NVARCHAR(20) NOT NULL,
    eMail NVARCHAR(50) NOT NULL,
    diaChi NVARCHAR(200) NOT NULL
);
GO
CREATE TABLE NhanVien (
    maNhanVien NVARCHAR(20) PRIMARY KEY,
    hoTen NVARCHAR(100) NOT NULL,
    ngaySinh DATE NOT NULL,
    diaChi NVARCHAR(200) NOT NULL,
    soDT NVARCHAR(20) NOT NULL,
    eMail NVARCHAR(50) NOT NULL
);
GO
CREATE TABLE HoaDon (
    maHoaDon NVARCHAR(20) PRIMARY KEY,
    maKH NVARCHAR(20) NOT NULL,
    maNV NVARCHAR(20) NOT NULL,
    ngayGiaoDuKien DATE NOT NULL,
    ngayLapHD DATE NOT NULL,
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNhanVien)
);
GO
CREATE TABLE DonDatHang (
    maDonDatHang NVARCHAR(20) PRIMARY KEY,
    maKH NVARCHAR(20) NOT NULL,
    maNV NVARCHAR(20) NOT NULL,
    ngayDat DATE NOT NULL,
    ngayGiao DATE NOT NULL,
    ngayChuyen DATE NOT NULL,
    noiNhan NVARCHAR(200) NOT NULL,
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNhanVien)
);
GO
CREATE TABLE ChiTietHD (
    maLinhKien NVARCHAR(20) NOT NULL,
    maHoaDon NVARCHAR(20) NOT NULL,
	maDonDatHang NVARCHAR(20) NOT NULL,
    soLuong INT NOT NULL,
    khuyenMai FLOAT NOT NULL,
    PRIMARY KEY (maLinhKien, maHoaDon, maDonDatHang),
    FOREIGN KEY (maLinhKien) REFERENCES LinhKien(maLinhKien),
    FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon),
	FOREIGN KEY (maDonDatHang) REFERENCES DonDatHang(maDonDatHang)
);
GO
--Insert danh mục
INSERT INTO DanhMucLinhKien (maDanhMuc, tenDanhMuc)
VALUES 
('DM001', 'Mainboard'),
('DM002', 'CPU'),
('DM003', 'RAM');
GO
--Insert nhà cung cấp
INSERT INTO NhaCungCapLinhKien (maNhaCungCap, tenNCC, diaChi, soDienThoai)
VALUES 
('NCC001', 'Công ty TNHH ABC', 'Hà Nội', '0987654321'),
('NCC002', 'Công ty TNHH XYZ', 'Hồ Chí Minh', '0912345678'),
('NCC003', 'Công ty TNHH PQR', 'Đà Nẵng', '0967890123'),
('NCC004', 'Công ty TNHH MNO', 'Nha Trang', '0901234567'),
('NCC005', 'Công ty TNHH UVW', 'Hải Phòng', '0976543210');
GO
--Insert linh kiện
INSERT INTO LinhKien (maLinhKien, tenLinhKien, soLuong, giaBan, thoiGianBaoHanh, maDanhMuc, maNhaCungCap)
VALUES 
('LK001', 'Mainboard Asus B450M-A', 30, 2500000, 24, 'DM001', 'NCC001'),
('LK002', 'Mainboard MSI B450 Tomahawk', 25, 3200000, 36, 'DM001', 'NCC001'),
('LK003', 'CPU Intel Core i7-10700K', 15, 9000000, 12, 'DM002', 'NCC002'),
('LK004', 'CPU AMD Ryzen 5 5600X', 20, 7200000, 36, 'DM002', 'NCC002'),
('LK005', 'RAM Kingston HyperX Fury DDR4 8GB', 40, 1500000, 36, 'DM003', 'NCC003'),
('LK006', 'RAM G.Skill Trident Z RGB DDR4 16GB', 30, 3500000, 36, 'DM003', 'NCC003'),
('LK007', 'HDD Seagate Barracuda 2TB', 10, 2000000, 24, 'DM001', 'NCC004'),
('LK008', 'SSD Samsung 970 Evo Plus NVMe M.2 1TB', 15, 5500000, 36, 'DM001', 'NCC004'),
('LK009', 'Case Cooler Master MasterBox Q300L', 25, 1200000, 24, 'DM003', 'NCC005'),
('LK010', 'Case NZXT H510', 20, 2400000, 36, 'DM002', 'NCC005');
GO
--Insert khách hàng
INSERT INTO KhachHang (maKH, tenKH, soDT, eMail, diaChi)
VALUES ('KH004', 'Trần Thị Bình', '0987654321', 'binhtran@gmail.com', '50 Nguyễn Văn Cừ, Hà Nội'),
       ('KH005', 'Nguyễn Văn Nam', '0909123456', 'namnguyen@gmail.com', '25 Nguyễn Trãi, TP.HCM'),
       ('KH006', 'Lê Thị Mai', '0967123456', 'maile@gmail.com', '30 Nguyễn Thị Minh Khai, Đà Nẵng'),
       ('KH007', 'Phạm Thị Thu', '0978234567', 'thupham@gmail.com', '45 Lê Lợi, Huế'),
       ('KH008', 'Vũ Ngọc Quỳnh', '0934123456', 'quynhvu@gmail.com', '40 Nguyễn Khánh Toàn, Hà Nội');
GO
--Insert nhân viên
INSERT INTO NhanVien (maNhanVien, hoTen, ngaySinh, diaChi, soDT, eMail)
VALUES ('NV004', 'Nguyễn Thị Thùy', '1990-05-15', '25 Hoàng Diệu, Hà Nội', '0987654321', 'thuynguyen@gmail.com'),
       ('NV005', 'Lê Văn Hiếu', '1995-03-12', '120 Phố Huế, Hà Nội', '0909123456', 'hieule@gmail.com'),
       ('NV006', 'Đặng Minh Hiếu', '1992-10-05', '60 Trần Phú, TP.HCM', '0967123456', 'hieudang@gmail.com'),
       ('NV007', 'Nguyễn Anh Dũng', '1993-12-30', '5 Lê Duẩn, Đà Nẵng', '0978234567', 'dungnguyen@gmail.com');
GO