﻿CREATE TABLE NhaCungCapLinhKien (
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
    thoiGianBaoHanh INT NOT NULL,
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
    soLuong INT NOT NULL,
    PRIMARY KEY (maLinhKien, maHoaDon, maDonDatHang),
    FOREIGN KEY (maLinhKien) REFERENCES LinhKien(maLinhKien),
    FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon),
	FOREIGN KEY (maDonDatHang) REFERENCES DonDatHang(maDonDatHang)
);
