create database ss02_bai_tap1;
use   ss02_bai_tap1;

create table phieu_xuat(
so_phieu_xuat varchar(30) primary key not null,
ngay_xuat date
);

create table nha_cung_cap(
ma_nha_cung_cap varchar(30) primary key not null,
ten_nha_cung_cap varchar(50),
dia_chi varchar(40),
so_dien_thoai varchar(50)
);


create table chi_tiet_phieu_xuat(
don_gia_xuat int,
so_luong_xuat int,
so_phieu_xuat varchar(30) not null,
ma_vat_tu varchar(30) not null,
primary key(so_phieu_xuat, ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);


create table phieu_nhap(
so_phieu_nhap varchar(30) primary key not null,
ngay_nhap date
);

create table chi_tiet_phieu_nhap(
don_gia_nhap double,
so_luong_nhap int,
so_phieu_nhap varchar (50),
ma_vat_tu varchar(50),
primary key(so_phieu_nhap, ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table vat_tu(
ma_vat_tu varchar(50) primary key not null,
ten_vat_tu varchar(50)
);


create table don_dat_hang(
so_don_hang varchar(30) primary key not null,
ngay_don_hang date,
ma_nha_cung_cap varchar(50),
foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table chi_tiet_don_dat_hang(
so_don_hang varchar(30) not null,
ma_vat_tu varchar(50) not null,
primary key(so_don_hang, ma_vat_tu),
foreign key(so_don_hang) references don_dat_hang(so_don_hang),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);




