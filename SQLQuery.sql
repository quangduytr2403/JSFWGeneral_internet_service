ALTER TABLE May 
ALTER COLUMN trangThai varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS
ALTER TABLE May
ALTER COLUMN viTri varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS

ALTER TABLE KhachHang
ALTER COLUMN diaChi varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS
ALTER TABLE KhachHang
ALTER COLUMN diaChiEmail varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS
ALTER TABLE KhachHang
ALTER COLUMN soDienThoai varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS
ALTER TABLE KhachHang
ALTER COLUMN tenKh varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS

ALTER TABLE DichVu
ALTER COLUMN donViTinh varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS
ALTER TABLE DichVu
ALTER COLUMN tenDV varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS

ALTER TABLE [dbo].[KhachHangMay]
ADD CONSTRAINT FK_MaMay FOREIGN KEY (maMay) REFERENCES May(maMay) ON DELETE CASCADE

ALTER TABLE [dbo].[KhachHangDichVu]
ADD CONSTRAINT FK_MaDv FOREIGN KEY (maDv) REFERENCES DichVu(maDv) ON DELETE CASCADE