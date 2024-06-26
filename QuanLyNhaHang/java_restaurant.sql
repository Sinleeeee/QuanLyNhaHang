USE [master]
GO
/****** Object:  Database [QUANLYNHAHANG_JAVA_D12]    Script Date: 23/05/2023 11:22:45 SA ******/
CREATE DATABASE [QUANLYNHAHANG_JAVA_D12]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QUANLYNHAHANG_JAVA_D12', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QUANLYNHAHANG_JAVA_D12.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QUANLYNHAHANG_JAVA_D12_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QUANLYNHAHANG_JAVA_D12_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QUANLYNHAHANG_JAVA_D12].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ARITHABORT OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET  MULTI_USER 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET QUERY_STORE = OFF
GO
USE [QUANLYNHAHANG_JAVA_D12]
GO
/****** Object:  Table [dbo].[BanAn]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BanAn](
	[MaBan] [varchar](15) NOT NULL,
	[TenBan] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHITIETHOADONNHAP]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETHOADONNHAP](
	[DonGia] [money] NOT NULL,
	[MaCTHDN] [varchar](10) NOT NULL,
	[SL] [int] NOT NULL,
	[ThanhTien] [money] NOT NULL,
	[MaHDN] [varchar](5) NOT NULL,
	[MaNL] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTHD]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHD](
	[MaCTHD] [varchar](5) NOT NULL,
	[MaMon] [varchar](5) NULL,
	[MaHD] [varchar](5) NOT NULL,
	[SL] [int] NOT NULL,
	[ThanhTien] [money] NOT NULL,
	[DonGia] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DangNhap]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangNhap](
	[MaDangNhap] [int] NOT NULL,
	[TaiKhoan] [varchar](10) NOT NULL,
	[MatKhau] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DatBan]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DatBan](
	[ThoiGianVao] [date] NOT NULL,
	[MaDatBan] [varchar](5) NOT NULL,
	[SLKhach] [int] NOT NULL,
	[TrangThai] [varchar](50) NOT NULL,
	[MaBan] [varchar](15) NOT NULL,
	[MaKH] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Duockhuyenmai]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Duockhuyenmai](
	[ThoiGianBD] [date] NOT NULL,
	[ThoigianKT] [date] NOT NULL,
	[MaDKM] [varchar](5) NOT NULL,
	[MaMon] [varchar](5) NULL,
	[MaKM] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](5) NOT NULL,
	[NgayTao] [date] NOT NULL,
	[GhiChu] [nvarchar](300) NOT NULL,
	[MaNV] [varchar](5) NULL,
	[MaBan] [varchar](15) NOT NULL,
	[TongTien] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADONNHAP]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADONNHAP](
	[MaHDN] [varchar](5) NOT NULL,
	[NgayTao] [date] NOT NULL,
	[GhiChu] [nvarchar](200) NULL,
	[TongTien] [money] NOT NULL,
	[MaNV] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [varchar](5) NOT NULL,
	[TenKH] [nvarchar](30) NOT NULL,
	[SDT] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MaKM] [varchar](5) NOT NULL,
	[TenKM] [nvarchar](70) NOT NULL,
	[Giam] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Loai]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loai](
	[MaLoai] [varchar](10) NOT NULL,
	[TenLoai] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MONAN]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MONAN](
	[MaMon] [varchar](5) NOT NULL,
	[TenMonAn] [nvarchar](30) NOT NULL,
	[TrangThai] [varchar](40) NOT NULL,
	[DonGia] [money] NOT NULL,
	[Hinh] [varchar](100) NOT NULL,
	[MoTa] [nvarchar](200) NOT NULL,
	[MaLoai] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGUYENLIEU]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUYENLIEU](
	[MaNL] [varchar](5) NOT NULL,
	[TenNL] [nvarchar](200) NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[DonGia] [money] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[MaNCC] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHACUNGCAP]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHACUNGCAP](
	[MaNCC] [varchar](5) NOT NULL,
	[TenNCC] [nvarchar](200) NOT NULL,
	[DiaChi] [nvarchar](200) NOT NULL,
	[SDT] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](5) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[SDT] [varchar](15) NOT NULL,
	[CCCD] [varchar](20) NOT NULL,
	[MaDangNhap] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B1', N'Bàn 1')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B10', N'Bàn 10')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B11', N'Bàn 11')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B2', N'Bàn 2')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B3', N'Bàn 3')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B4', N'Bàn 4')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B5', N'Bàn 5')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B6', N'Bàn 6')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B7', N'Bàn 7')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B8', N'Bàn 8')
INSERT [dbo].[BanAn] ([MaBan], [TenBan]) VALUES (N'B9', N'Bàn 9')
GO
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (11000.0000, N'00008', 2, 22000.0000, N'HDN06', N'DUA')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (15000.0000, N'1', 1, 6000000.0000, N'HDN01', N'DIA')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (11000.0000, N'2', 1, 4400000.0000, N'HDN01', N'DUA')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (16000.0000, N'3', 1, 6400000.0000, N'HDN01', N'THIA')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (2390000.0000, N'4', 1, 119500000.0000, N'HDN03', N'TOM')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (2590000.0000, N'5', 1, 129500000.0000, N'HDN04', N'CUA')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (100000.0000, N'6', 1, 10000000.0000, N'HDN02', N'GIAY')
INSERT [dbo].[CHITIETHOADONNHAP] ([DonGia], [MaCTHDN], [SL], [ThanhTien], [MaHDN], [MaNL]) VALUES (600000.0000, N'7', 1, 30000000.0000, N'HDN02', N'BIA')
GO
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT01', N'MA02', N'HD01', 2, 300000.0000, 150000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT02', N'MA03', N'HD12', 3, 495000.0000, 165000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT03', N'MA14', N'HD01', 4, 720000.0000, 180000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT04', N'MA04', N'HD14', 3, 945000.0000, 300000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT05', N'MA09', N'HD14', 5, 540000.0000, 135000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT06', N'MA03', N'HD14', 3, 495000.0000, 165000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT11', N'MA04', N'HD12', 2, 38000.0000, 19000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT12', N'MA05', N'HD12', 4, 528000.0000, 165000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT13', N'MA04', N'HD12', 2, 38000.0000, 19000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT14', N'MA04', N'HD12', 2, 300000.0000, 150000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT15', N'MA05', N'HD12', 2, 264000.0000, 165000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT16', N'MA03', N'HD12', 1, 165000.0000, 165000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT17', N'MA03', N'HD12', 2, 330000.0000, 165000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT22', N'MA11', N'HD12', 3, 225000.0000, 75000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT23', N'MA08', N'HD12', 2, 250000.0000, 125000.0000)
INSERT [dbo].[CTHD] ([MaCTHD], [MaMon], [MaHD], [SL], [ThanhTien], [DonGia]) VALUES (N'CT24', N'MA04', N'HD14', 2, 630000.0000, 315000.0000)
GO
INSERT [dbo].[DangNhap] ([MaDangNhap], [TaiKhoan], [MatKhau]) VALUES (1, N'Admin', N'123')
INSERT [dbo].[DangNhap] ([MaDangNhap], [TaiKhoan], [MatKhau]) VALUES (2, N'haipham', N'123')
INSERT [dbo].[DangNhap] ([MaDangNhap], [TaiKhoan], [MatKhau]) VALUES (3, N'thanhle', N'123')
GO
INSERT [dbo].[DatBan] ([ThoiGianVao], [MaDatBan], [SLKhach], [TrangThai], [MaBan], [MaKH]) VALUES (CAST(N'2023-05-02' AS Date), N'DB11', 2, N'Da dat', N'B6', N'KH16')
INSERT [dbo].[DatBan] ([ThoiGianVao], [MaDatBan], [SLKhach], [TrangThai], [MaBan], [MaKH]) VALUES (CAST(N'2023-05-17' AS Date), N'DB13', 2, N'Hoat dong', N'B9', N'KH18')
GO
INSERT [dbo].[Duockhuyenmai] ([ThoiGianBD], [ThoigianKT], [MaDKM], [MaMon], [MaKM]) VALUES (CAST(N'2023-04-17' AS Date), CAST(N'2024-04-17' AS Date), N'DKM01', N'MA05', N'KM01')
INSERT [dbo].[Duockhuyenmai] ([ThoiGianBD], [ThoigianKT], [MaDKM], [MaMon], [MaKM]) VALUES (CAST(N'2023-04-17' AS Date), CAST(N'2024-04-17' AS Date), N'DKM02', N'MA09', N'KM01')
INSERT [dbo].[Duockhuyenmai] ([ThoiGianBD], [ThoigianKT], [MaDKM], [MaMon], [MaKM]) VALUES (CAST(N'2023-04-17' AS Date), CAST(N'2024-04-17' AS Date), N'DKM03', NULL, N'KM02')
GO
INSERT [dbo].[HoaDon] ([MaHD], [NgayTao], [GhiChu], [MaNV], [MaBan], [TongTien]) VALUES (N'HD01', CAST(N'2023-12-01' AS Date), N'Đã thanh toán', N'NV01', N'B1', 1020000.0000)
INSERT [dbo].[HoaDon] ([MaHD], [NgayTao], [GhiChu], [MaNV], [MaBan], [TongTien]) VALUES (N'HD03', CAST(N'2023-12-01' AS Date), N'Đã thanh toán', N'NV01', N'B2', NULL)
INSERT [dbo].[HoaDon] ([MaHD], [NgayTao], [GhiChu], [MaNV], [MaBan], [TongTien]) VALUES (N'HD12', CAST(N'2023-05-17' AS Date), N'Chưa thanh toán', N'NV01', N'B9', 2633000.0000)
INSERT [dbo].[HoaDon] ([MaHD], [NgayTao], [GhiChu], [MaNV], [MaBan], [TongTien]) VALUES (N'HD14', CAST(N'2023-04-22' AS Date), N'Chưa thanh toán', N'NV01', N'B2', 2610000.0000)
GO
INSERT [dbo].[HOADONNHAP] ([MaHDN], [NgayTao], [GhiChu], [TongTien], [MaNV]) VALUES (N'HDN01', CAST(N'2023-12-01' AS Date), N'Chưa thanh toán', 16800000.0000, N'NV01')
INSERT [dbo].[HOADONNHAP] ([MaHDN], [NgayTao], [GhiChu], [TongTien], [MaNV]) VALUES (N'HDN02', CAST(N'2023-12-01' AS Date), N'Chưa thanh toán', 40000000.0000, N'NV01')
INSERT [dbo].[HOADONNHAP] ([MaHDN], [NgayTao], [GhiChu], [TongTien], [MaNV]) VALUES (N'HDN03', CAST(N'2023-12-01' AS Date), N'Thanh toán', 119500000.0000, N'NV01')
INSERT [dbo].[HOADONNHAP] ([MaHDN], [NgayTao], [GhiChu], [TongTien], [MaNV]) VALUES (N'HDN04', CAST(N'2023-12-01' AS Date), N'Thanh toán', 129500000.0000, N'NV01')
INSERT [dbo].[HOADONNHAP] ([MaHDN], [NgayTao], [GhiChu], [TongTien], [MaNV]) VALUES (N'HDN05', CAST(N'2023-12-01' AS Date), N'Thanh toán', 30000000.0000, N'NV01')
INSERT [dbo].[HOADONNHAP] ([MaHDN], [NgayTao], [GhiChu], [TongTien], [MaNV]) VALUES (N'HDN06', CAST(N'2023-05-02' AS Date), N'Chưa thanh toán', 22000.0000, N'NV01')
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH01', N'Nguyễn Văn Nhân', N'038294124')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH02', N'Lê Thành Văn', N'0389401352')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH03', N'Lương Thị Thúy Hồng', N'0704325123')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH04', N'Lê Kim Chi', N'0384123121')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH05', N'Winston', N'0705686868')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH06', N'Khưu Văn Hòa', N'1544654653')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH07', N'Trần Ngọc', N'120546215')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH08', N'Trinh Trinh', N'16541251')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH09', N'Lê Thúy', N'054245')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH10', N'Lê Minh Khang', N'0923510618')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH11', N'Mai Phương', N'04546514985')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH12', N'Văn Hòa', N'24242410414')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH13', N'Thi Na', N'145156156')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH14', N'Khưu Văn Hòa', N'154512122')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH15', N'Thanh Hải', N'052454121')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH16', N'Le Nhi', N'054165424')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH17', N'Tiên Sa', N'083756745')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH18', N'Thanh Trà', N'09349234')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH19', N'Văn Hòa', N'083573954')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT]) VALUES (N'KH20', N'Văn Hòa', N'083473243')
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [Giam]) VALUES (N'KM01', N'Khung Vàng Săn Sale', 20)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [Giam]) VALUES (N'KM02', N'Sale lớn 5/5', 30)
GO
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'GK', N'Giải khát')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'KV', N'Khai vị')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'MG', N'Món gỏi')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'MH', N'Món hấp')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'ML', N'Món lẫu')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'MN', N'Món nướng')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'MX', N'Món xào')
INSERT [dbo].[Loai] ([MaLoai], [TenLoai]) VALUES (N'TC', N'Trái cay')
GO
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA01', N'Salad trái cây', N'Còn', 150000.0000, N'Saladtraicay.jpg', N'Rau salad, cà rốt, sốt cay,....', N'TC')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA02', N'Cơm cuộn Kimbap', N'Còn', 150000.0000, N'ComcuonKimbap.jpg', N'Rong biển, xúc xích, trứng,...', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA03', N'Tôm hùm hấp ', N'Còn', 165000.0000, N'Tomhum.jpg', N'Hàng nhập tươi sống', N'MH')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA04', N'Cua rang me chua', N'Còn', 315000.0000, N'cuarangme.jpg', N'Cua Cà Mau, me thái', N'MX')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA05', N'Mì Udon xào hải sản', N'Còn', 165000.0000, N'myudon.jpg', N'Cua, tôm, mực,...', N'MX')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA06', N'Coca light', N'Còn', 19000.0000, N'Cocalight.jpg', N'Ít đường', N'GK')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA07', N'Mực vòng chiên giòn', N'Còn', 150000.0000, N'mucchien.jpg', N'Mực tươi nhập từ Nha Trang', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA08', N'Salad rong biển', N'Còn', 125000.0000, N'Saladrongbien.jpg', N'Rau salad, cà rốt, sốt cay', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA09', N'Kim chi cải thảo', N'Còn', 135000.0000, N'Kimchi.jpg', N'Rau salad, cà rốt, sốt cay', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA10', N'Nước suối', N'Còn', 11000.0000, N'nuocsuoi.jpg', N'Rau salad, cà rốt, sốt cay', N'GK')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA11', N'Cơm trộn Hàn Quốc', N'Còn', 75000.0000, N'Comtron.jpg', N'Rau salad, cà rốt, sốt cay', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA12', N'Canh sườn bò Hàn Quốc', N'Còn', 189000.0000, N'canhsuonbo.jpg', N'Rau salad, cà rốt, sốt cay', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA13', N'Canh rong biển', N'Còn', 55000.0000, N'Canhrongbien.jpg', N'Rau salad, cà rốt, sốt cay', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA14', N'Sashimi Cá Hồi', N'Còn', 180000.0000, N'SashimiCaHoi.jpg', N'Rau salad, cà rốt, sốt cay', N'KV')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA15', N'Cua hoàng đế hấp ', N'Còn', 2300000.0000, N'Cuahoangde.jpg', N'Rau salad, cà rốt, sốt cay', N'MH')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA16', N'Miến xào hải sản', N'Còn', 165000.0000, N'cuarangme.jpg', N'Rau salad, cà rốt, sốt cay', N'MX')
INSERT [dbo].[MONAN] ([MaMon], [TenMonAn], [TrangThai], [DonGia], [Hinh], [MoTa], [MaLoai]) VALUES (N'MA17', N'Lẫu Bò', N'Còn', 3432323.0000, N'lauboa.jpg', N'bò my', N'ML')
GO
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'BIA', N'Bia Heineken', N'Thùng', 600000.0000, 500, N'NCC01')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'CHEN', N'Chén sứ cao cấp', N'Cái', 12000.0000, 400, N'NCC02')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'CUA', N'Cua Hoàng Đế', N'KG', 2590000.0000, 50, N'NCC05')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'DIA', N'Đĩa sứ cao cấp', N'Cái', 15000.0000, 400, N'NCC02')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'DUA', N'Đũa cao cấp', N'Chiếc', 11000.0000, 800, N'NCC03')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'GIAY', N'Giấy ăn vuông', N'Gói', 100000.0000, 100, N'NCC04')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'THIA', N'Thìa inox cao cấp', N'Cái', 16000.0000, 400, N'NCC03')
INSERT [dbo].[NGUYENLIEU] ([MaNL], [TenNL], [DonVi], [DonGia], [SoLuong], [MaNCC]) VALUES (N'TOM', N'Tôm Hùm Bông', N'KG', 2390000.0000, 50, N'NCC05')
GO
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC01', N'Heineken Vietnam', N'TP.Hồ Chí Minh', N'0777777777')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC02', N'Chén đĩa Minh Châu', N'Đà Nẵng', N'0705898989')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC03', N'Đồ Gia Dụng Inox Xuân Thái Sơn', N'TP.Hồ Chí Minh', N'0366666666')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC04', N'Giấy Kim Mỹ', N'TP.Hồ Chí Minh', N'0388888888')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (N'NCC05', N'Xuất khẩu hải sản Hai Thanh', N'TP.Hồ Chí Minh', N'0389999999')
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [CCCD], [MaDangNhap]) VALUES (N'NV01', N'Phạm Văn Hải', N'03488884', N'0389283943', 2)
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [CCCD], [MaDangNhap]) VALUES (N'NV03', N'Lê Văn Thành', N'0387432523', N'0708374284', 3)
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [CCCD], [MaDangNhap]) VALUES (N'NV04', N'Admin', N'0834387434', N'3234234234', 1)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__DatBan__C752B19C87C2C246]    Script Date: 23/05/2023 11:22:45 SA ******/
ALTER TABLE [dbo].[DatBan] ADD UNIQUE NONCLUSTERED 
(
	[MaBan] ASC,
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CHITIETHOADONNHAP]  WITH CHECK ADD FOREIGN KEY([MaHDN])
REFERENCES [dbo].[HOADONNHAP] ([MaHDN])
GO
ALTER TABLE [dbo].[CHITIETHOADONNHAP]  WITH CHECK ADD FOREIGN KEY([MaNL])
REFERENCES [dbo].[NGUYENLIEU] ([MaNL])
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD FOREIGN KEY([MaMon])
REFERENCES [dbo].[MONAN] ([MaMon])
GO
ALTER TABLE [dbo].[DatBan]  WITH CHECK ADD FOREIGN KEY([MaBan])
REFERENCES [dbo].[BanAn] ([MaBan])
GO
ALTER TABLE [dbo].[DatBan]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[Duockhuyenmai]  WITH CHECK ADD FOREIGN KEY([MaMon])
REFERENCES [dbo].[MONAN] ([MaMon])
GO
ALTER TABLE [dbo].[Duockhuyenmai]  WITH CHECK ADD FOREIGN KEY([MaKM])
REFERENCES [dbo].[KhuyenMai] ([MaKM])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaBan])
REFERENCES [dbo].[BanAn] ([MaBan])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HOADONNHAP]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[MONAN]  WITH CHECK ADD FOREIGN KEY([MaLoai])
REFERENCES [dbo].[Loai] ([MaLoai])
GO
ALTER TABLE [dbo].[NGUYENLIEU]  WITH CHECK ADD FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NHACUNGCAP] ([MaNCC])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([MaDangNhap])
REFERENCES [dbo].[DangNhap] ([MaDangNhap])
GO
/****** Object:  StoredProcedure [dbo].[DatBanID_auto]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[DatBanID_auto]
    @MaDB VARCHAR(10) OUTPUT
AS
BEGIN
    SET @MaDB = 'DB' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaDatBan,2)) FROM DatBan) + 1 AS VARCHAR(2)), 2)
END
GO
/****** Object:  StoredProcedure [dbo].[delNullCTHD]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create PROCEDURE [dbo].[delNullCTHD]
    @idMonAn VARCHAR (5)
AS
BEGIN


    -- Khai báo biến cursor
    DECLARE cur_cthd CURSOR FOR
        SELECT MaCTHD FROM CTHD WHERE MaMon = @idMonAn;

    -- Khai báo biến để lưu trữ giá trị MaCTHD
    DECLARE @MaCTHD VARCHAR (5);

    -- Mở cursor
    OPEN cur_cthd;

    -- Lặp qua từng dòng trên cursor
    FETCH NEXT FROM cur_cthd INTO @MaCTHD;
    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Sửa giá trị cột MaMonAn thành NULL
         DELETE FROM CTHD WHERE MaMon = @idMonAn;

        -- Lấy dòng tiếp theo trên cursor
        FETCH NEXT FROM cur_cthd INTO @MaCTHD;
    END;

    -- Đóng cursor
    CLOSE cur_cthd;
    DEALLOCATE cur_cthd;
END;
GO
/****** Object:  StoredProcedure [dbo].[GetNewMaHD]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[GetNewMaHD]
    @NewMaHD VARCHAR(5) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT @NewMaHD = CONCAT('HD', RIGHT(CONCAT('00', CAST(RIGHT(MAX(hd.maHd), 2) + 1 AS VARCHAR)), 2))
    FROM HoaDon hd;
END
GO
/****** Object:  StoredProcedure [dbo].[IDCTHDN_Auto]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[IDCTHDN_Auto]
	@MaCTHDN VARCHAR(5) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @maxMaCTHDN VARCHAR(5);
    SELECT @maxMaCTHDN = MAX(CAST(RIGHT(MaCTHDN, 5) AS INT)) FROM CHITIETHOADONNHAP;
    SET @maxMaCTHDN = COALESCE(@maxMaCTHDN, 0) + 1;
    SET @MaCTHDN = RIGHT('00000' + CAST(@maxMaCTHDN AS VARCHAR(5)), 5);
END;
GO
/****** Object:  StoredProcedure [dbo].[IDHDN_Auto]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[IDHDN_Auto]
	@MaHDN VARCHAR(5) OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @maxMaHDN VARCHAR(5);
    SELECT @maxMaHDN = MAX(CAST(RIGHT(MaHDN, 5) AS INT)) FROM HOADONNHAP;
    SET @maxMaHDN = COALESCE(@maxMaHDN, 0) + 1;
    SET @MaHDN = RIGHT('00000' + CAST(@maxMaHDN AS VARCHAR(5)), 5);
END;
GO
/****** Object:  StoredProcedure [dbo].[KhachHangID_auto]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[KhachHangID_auto]
    @MaKH VARCHAR(10) OUTPUT
AS
BEGIN
    SET @MaKH = 'KH' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaKH,2)) FROM KhachHang) + 1 AS VARCHAR(2)), 2)
END
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertDangNhap]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertDangNhap]
    @MaDangNhap INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @maxMaDangNhap INT;
    SELECT @maxMaDangNhap = MAX(MaDangNhap) FROM DangNhap;
    SET @MaDangNhap = COALESCE(@maxMaDangNhap, 0) + 1;
END;
GO
/****** Object:  StoredProcedure [dbo].[TinhTien]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[TinhTien](@tenmon nvarchar(50), @sluong int, @giagiam money output)
as
	declare @mamon varchar(5), @giatien money, @phantram int;
	select @mamon=MaMon, @giatien=DonGia from MONAN where TenMonAn= @tenmon
	set @giatien=@giatien*@sluong
	set @phantram = (select Giam from KhuyenMai k, Duockhuyenmai d where d.MaKM= k.MaKM and d.MaMon=@mamon)
	set @giagiam =@giatien-(@giatien*(@phantram/100.0))
GO
/****** Object:  StoredProcedure [dbo].[TinhTienGiam]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[TinhTienGiam](@tenmon nvarchar(50), @giagiam money output)
as
	declare @mamon varchar(5), @giatien money, @phantram int;
	select @mamon=MaMon, @giatien=DonGia from MONAN where TenMonAn= @tenmon

	set @phantram = (select Giam from KhuyenMai k, Duockhuyenmai d where d.MaKM= k.MaKM and d.MaMon=@mamon)
	set @giagiam =@giatien-(@giatien*(@phantram/100.0))
GO
/****** Object:  Trigger [dbo].[tinhTongTien_CTHDNhap]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[tinhTongTien_CTHDNhap]
ON [dbo].[CHITIETHOADONNHAP]
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    IF EXISTS(SELECT * FROM inserted) OR EXISTS(SELECT * FROM deleted)
    BEGIN
        UPDATE HOADONNHAP
        SET TongTien = (SELECT SUM(ThanhTien) FROM CHITIETHOADONNHAP WHERE CHITIETHOADONNHAP.MaHDN = HOADONNHAP.MaHDN )
        FROM HOADONNHAP
        WHERE HOADONNHAP.MaHDN IN (SELECT MaHDN FROM inserted UNION SELECT MaHDN FROM deleted)
    END
END
GO
ALTER TABLE [dbo].[CHITIETHOADONNHAP] ENABLE TRIGGER [tinhTongTien_CTHDNhap]
GO
/****** Object:  Trigger [dbo].[CTHD_auto]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[CTHD_auto]
ON [dbo].[CTHD]
AFTER INSERT
AS
BEGIN
    DECLARE @MaCTHD VARCHAR(10)
    SELECT @MaCTHD = 'CT' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaCTHD,2)) FROM CTHD) + 1 AS VARCHAR(2)), 2)
    UPDATE CTHD SET MaCTHD =  @MaCTHD WHERE MaCTHD=(select MaCTHD FROM inserted)
END
GO
ALTER TABLE [dbo].[CTHD] ENABLE TRIGGER [CTHD_auto]
GO
/****** Object:  Trigger [dbo].[tinhTongTien]    Script Date: 23/05/2023 11:22:45 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[tinhTongTien]
ON [dbo].[CTHD]
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    IF EXISTS(SELECT * FROM inserted) OR EXISTS(SELECT * FROM deleted)
    BEGIN
        UPDATE HoaDon
        SET TongTien = (SELECT SUM(ThanhTien) FROM CTHD WHERE CTHD.MaHD = HoaDon.MaHD AND CTHD.MaMon IS NOT NULL)
        FROM HoaDon
        WHERE HoaDon.MaHD IN (SELECT MaHD FROM inserted UNION SELECT MaHD FROM deleted)
    END
END
GO
ALTER TABLE [dbo].[CTHD] ENABLE TRIGGER [tinhTongTien]
GO
/****** Object:  Trigger [dbo].[DatBan_auto]    Script Date: 23/05/2023 11:22:46 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[DatBan_auto]
ON [dbo].[DatBan]
AFTER INSERT
AS
BEGIN
    DECLARE @MaDatBan VARCHAR(10)
    SELECT @MaDatBan = 'DB' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaDatBan,2)) FROM  DatBan) + 1 AS VARCHAR(2)), 2)
    UPDATE DatBan SET MaDatBan =  @MaDatBan WHERE MaDatBan=(select MaDatBan FROM inserted)
END
GO
ALTER TABLE [dbo].[DatBan] ENABLE TRIGGER [DatBan_auto]
GO
/****** Object:  Trigger [dbo].[HoaDon_Insert]    Script Date: 23/05/2023 11:22:46 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[HoaDon_Insert]
ON [dbo].[HoaDon]
AFTER INSERT
AS
BEGIN
    DECLARE @MaHD NVARCHAR(10)
    SELECT @MaHD = 'HD' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaHD,2)) FROM HoaDon) + 1 AS NVARCHAR(2)), 2)
    UPDATE HoaDon SET MaHD = @MaHD WHERE MaHD=(select MaHD FROM inserted)
END
GO
ALTER TABLE [dbo].[HoaDon] ENABLE TRIGGER [HoaDon_Insert]
GO
/****** Object:  Trigger [dbo].[HDN_auto]    Script Date: 23/05/2023 11:22:46 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[HDN_auto]
ON [dbo].[HOADONNHAP]
AFTER INSERT
AS
BEGIN
    DECLARE @MaHDN VARCHAR(10)
    SELECT @MaHDN = 'HDN' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaHDN,2)) FROM  HOADONNHAP) + 1 AS VARCHAR(2)), 2)
    UPDATE HOADONNHAP SET MaHDN =  @MaHDN WHERE MaHDN=(select MaHDN FROM inserted)
END
GO
ALTER TABLE [dbo].[HOADONNHAP] ENABLE TRIGGER [HDN_auto]
GO
/****** Object:  Trigger [dbo].[MonAn_auto]    Script Date: 23/05/2023 11:22:46 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[MonAn_auto]
ON [dbo].[MONAN]
AFTER INSERT
AS
BEGIN
    DECLARE @MaMon VARCHAR(10)
    SELECT @MaMon = 'MA' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaMon,2)) FROM  MONAN) + 1 AS VARCHAR(2)), 2)
    UPDATE MONAN SET MaMon =  @MaMon WHERE MaMon=(select MaMon FROM inserted)
END
GO
ALTER TABLE [dbo].[MONAN] ENABLE TRIGGER [MonAn_auto]
GO
/****** Object:  Trigger [dbo].[NhanVien_auto]    Script Date: 23/05/2023 11:22:46 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[NhanVien_auto]
ON [dbo].[NhanVien]
AFTER INSERT
AS
BEGIN
    DECLARE @MaMon VARCHAR(10)
    SELECT @MaMon = 'NV' + RIGHT('00' + CAST((SELECT MAX(RIGHT(MaNV,2)) FROM  NhanVien) + 1 AS VARCHAR(2)), 2)
    UPDATE NhanVien SET MaNV =  @MaMon WHERE MaNV=(select MaNV FROM inserted)
END
GO
ALTER TABLE [dbo].[NhanVien] ENABLE TRIGGER [NhanVien_auto]
GO
USE [master]
GO
ALTER DATABASE [QUANLYNHAHANG_JAVA_D12] SET  READ_WRITE 
GO
