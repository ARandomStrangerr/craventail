CREATE SCHEMA IF NOT EXISTS ke_toan_schema;

CREATE TABLE IF NOT EXISTS ke_toan_schema.don_vi (
	ma SERIAL PRIMARY KEY,
	don_vi_chu_quan VARCHAR(256),
	ma_don_vi VARCHAR(20),
	ten_don_vi VARCHAR(256) NOT NULL,
	ten_doi_ngoai VARCHAR(256),
	dia_chi VARCHAR(256) NOT NULL,
	ma_chuong VARCHAR(6) NOT NULL,
	ma_so_thue VARCHAR(10) NOT NULL,
	cuc_thue VARCHAR(256),
	ma_so_don_vi VARCHAR(20) NOT NULL,
	ma_chuong_thu_thue VARCHAR(6),
	ma_so_don_vi_thu_thue VARCHAR(10),
	kho_bac_chuyen_thue VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.muc_luc_ngan_sach (
	ma SERIAL PRIMARY KEY,
  nhom VARCHAR(4) NOT NULL,
	tieu_nhom VARCHAR(5) NULL,
	ten VARCHAR(12) NOT NULL,
	noi_dung VARCHAR(256) NOT NULL,
	soft_delete BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.tai_khoan_dung (
	ma SERIAL PRIMARY KEY,
	ten_tai_khoan VARCHAR(55) NOT NULL,
	so_hieu_tai_khoan VARCHAR(10) NOT NULL,
	loai_rut_so_du CHAR(1) NOT NULL,
	ten_chu_quan VARCHAR(60),
	tai_khoan_ngan_hang_kho_bac VARCHAR(15),
	tam_ung VARCHAR(60),
	ten_ngan_hang_kho_bac VARCHAR(256),
	soft_delete BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TYPE ke_toan_schema.loai_tai_khoan AS ENUM (
	'Tài sản', 'Nợ', 'Vốn', 'Doanh Thu', 'Chi phí'
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.he_thong_tai_khoan (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ma_tai_khoan VARCHAR(20) UNIQUE NOT NULL,
	ten_tai_khoan VARCHAR(100) UNIQUE NOT NULL,
	loai_tai_khoan ke_toan_schema.loai_tai_khoan NOT NULL,
	hoat_dong BOOLEAN DEFAULT TRUE,
	soft_delete BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.khoan_thu (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ma_san_pham VARCHAR(20) UNIQUE NOT NULL,
	ten VARCHAR(256) NOT NULL,
	mieu_ta TEXT,
	gia_tri NUMERIC(18, 2),
	soft_delete BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.chung_tu (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	soft_delete BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.chi_tiet_chung_tu (
	dong SMALLINT NOT NULL,
	ma_chung_tu INT NOT NULL,
	ma_tai_khoan INT NOT NULL,
	ma_khoan_thu INT NOT NULL,
	no NUMERIC(18, 2) DEFAULT 0,
	co NUMERIC(18, 2) DEFAULT 0,
	mieu_ta TEXT,
	soft_delete BOOLEAN DEFAULT FALSE,

	PRIMARY KEY (dong, ma_chung_tu),

	FOREIGN KEY (ma_chung_tu) REFERENCES ke_toan_schema.chung_tu(ma),
	FOREIGN KEY (ma_khoan_thu) REFERENCES ke_toan_schema.khoan_thu(ma)
); -- a.k.a bút toán

CREATE TABLE IF NOT EXISTS ke_toan_schema.tu_dien_cong_trinh (
	id SERIAL PRIMARY KEY,
	ma_cong_trinh VARCHAR(20) NOT NULL,
	ten_cong_trinh VARCHAR(256) NOT NULL,
	ma_chuong VARCHAR(6) NOT NULL,
	soft_delete BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.tu_dien_chuong_trinh (
	id SERIAL PRIMARY KEY,
	ma_chuong_trinh VARCHAR(20) NOT NULL,
	ten_chuong_trinh VARCHAR(256) NOT NULL,
	ma_chuong VARCHAR(6) NOT NULL,
	nguon_von VARCHAR(2) NOT NULL,
	soft_delete BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ke_toan_schema.doi_tuong_kinh_te (
	id BIGSERIAL PRIMARY KEY,
	ma_doi_tuong VARCHAR(15) NOT NULL,
	doi_tuong VARCHAR(256) NOT NULL,
	dia_chi VARCHAR(256),
	ma_don_vi VARCHAR(20),
	ma_so_thue VARCHAR(20),
	so_can_cuoc_cong_dan VARCHAR(20),
	soft_delete BOOLEAN NOT NULL DEFAULT FALSE
);
