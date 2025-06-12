CREATE TABLE IF NOT EXISTS nguoi_dung (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ten VARCHAR(50) UNIQUE NOT NULL,
	mat_khau VARCHAR(256) NOT NULL,
	hoat_dong BOOLEAN DEFAULT TRUE,
	thoi_diem_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS quyen_han (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ten VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS quyen_han_nguoi_dung (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ma_nguoi_dung INT NOT NULL,
	ma_quyen_han INT NOT NULL,

	PRIMARY KEY (ma_nguoi_dung, ma_quyen_han),

	FOREIGN KEY (ma_nguoi_dung) REFERENCES nguoi_dung(ma),
	FOREIGN KEY (ma_quyen_han) REFERENCES quyen_han(ma)
);

CREATE TYPE loai_tai_khoan AS ENUM (
	"Tài sản", "Nợ", "Vốn", "Doanh Thu", "Chi phí"
);

CREATE TABLE IF NOT EXISTS he_thong_tai_khoan (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ma_tai_khoan VARCHAR(20) UNIQUE NOT NULL,
	ten_tai_khoan VARCHAR(100) UNIQUE NOT NULL,
	loai_tai_khoan loai_tai_khoan NOT NULL,
	hoat_dong BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS khoan_thu (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ma_san_pham VARCHAR(20) UNIQUE NOT NULL,
	ten VARCHAR(256) NOT NULL,
	mieu_ta TEXT,
	gia_tri NUMERIC(18, 2),
	hoat_dong BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS chung_tu (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chi_tiet_chung_tu (
	dong SMALLINT NOT NULL,
	ma_chung_tu INT NOT NULL,
	ma_tai_khoan INT NOT NULL,
	ma_khoan_thu INT NOT NULL,
	no NUMERIC(18, 2) DEFAULT 0,
	co NUMERIC(18, 2) DEFAULT 0,
	mieu_ta TEXT,

	PRIMARY KEY (dong, ma_chung_tu),

	FOREIGN KEY ma_chung_tu REFERENCES chung_tu(ma),
	FOREIGN KEY ma_khoan_thu REFERENCES khoan_thu(ma)
); -- a.k.a bút toán

CREATE TABLE IF NOT EXISTS don_vi (
    id SERIAL PRIMARY KEY,
    don_vi_chu_quan VARCHAR(256),
    ma_don_vi VARCHAR(20),
    ten_don_vi VARCHAR(256) NOT NULL,
    ten_doi_ngoai VARCHAR(256),
    dia_chi VARCHAR(256) NOT NULL,
    ma_chuong VARCHAR(6),
    ma_so_don_vi VARCHAR(20) NOT NULL,
    ma_so_thue VARCHAR(10) NOT NULL,
    cuc_thue VARCHAR(256),
    ma_chuong_thu_thue VARCHAR(6),
    ma_so_don_vi_thu_thue VARCHAR(10),
    kho_bac_chuyen_thue VARCHAR(20),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tu_dien_cong_trinh (
    id SERIAL PRIMARY KEY,
    ma_cong_trinh VARCHAR(20) NOT NULL,
    ten_cong_trinh VARCHAR(256) NOT NULL,
    ma_chuong VARCHAR(6) NOT NULL,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS muc_luc_ngan_sach (
   id SERIAL PRIMARY KEY,
   nhom VARCHAR(4) NOT NULL,
   tieu_nhom VARCHAR(5) NULL,
   ten VARCHAR(12) NOT NULL,
   noi_dung VARCHAR(256) NOT NULL,
   deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tai_khoan_dung (
    id SERIAL PRIMARY KEY,
    ten_tai_khoan VARCHAR(55) NOT NULL,
    so_hieu_tai_khoan VARCHAR(10) NOT NULL,
    loai_rut_so_du CHAR(1) NOT NULL,
    ten_chu_quan VARCHAR(60),
    tai_khoan_ngan_hang_kho_bac VARCHAR(15),
    tam_ung VARCHAR(60),
    ten_ngan_hang_kho_bac VARCHAR(256),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tu_dien_chuong_trinh (
    id SERIAL PRIMARY KEY,
    ma_chuong_trinh VARCHAR(20) NOT NULL,
    ten_chuong_trinh VARCHAR(256) NOT NULL,
    ma_chuong VARCHAR(6) NOT NULL,
    nguon_von VARCHAR(2) NOT NULL,
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS doi_tuong_kinh_te (
    id BIGSERIAL PRIMARY KEY,
    ma_doi_tuong VARCHAR(15) NOT NULL,
    doi_tuong VARCHAR(256) NOT NULL,
    dia_chi VARCHAR(256),
    ma_don_vi VARCHAR(20),
    ma_so_thue VARCHAR(20),
    so_can_cuoc_cong_dan VARCHAR(20),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS danh_muc_don_vi (
    id SERIAL PRIMARY KEY,
    ma_don_vi VARCHAR(20) NOT NULL,
    ten_don_vi VARCHAR(256) NOT NULL,
    so_tai_khoan_kho_bac VARCHAR(15),
    ten_ngan_hang_kho_bac VARCHAR(256),
    ma_so_su_dung_ngan_sach VARCHAR(10),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS so_du (
    id SERIAL PRIMARY KEY,
    ngay_thang DATE NOT NULL,
    so_hieu_tai_khoan VARCHAR(8) NOT NULL,
    ma_chuong VARCHAR(5),
    du_no INTEGER,
    du_no_ngoai_te DOUBLE PRECISION,
    du_co INTEGER,
    du_co_ngoai_te DOUBLE PRECISION,
    loai_tien VARCHAR(5),
    muc_tieu_muc VARCHAR(12),
    nhom_muc VARCHAR(4),
    ma_chuong_trinh VARCHAR(20),
    ma_cong_trinh VARCHAR(15),
    ma_nguon VARCHAR(6),
    ma_don_vi VARCHAR(10),
    dong_dau VARCHAR(10),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);


CREATE TABLE IF NOT EXISTS so_du (
    id SERIAL PRIMARY KEY,
    ngay_thang DATE NOT NULL,
    so_hieu_tai_khoan VARCHAR(8) NOT NULL,
    ma_chuong VARCHAR(5),
    du_no INTEGER,
    du_no_ngoai_te DOUBLE PRECISION,
    du_co INTEGER,
    du_co_ngoai_te DOUBLE PRECISION,
    loai_tien VARCHAR(5),
    muc_tieu_muc VARCHAR(12),
    nhom_muc VARCHAR(4),
    ma_chuong_trinh VARCHAR(20),
    ma_cong_trinh VARCHAR(15),
    ma_nguon VARCHAR(6),
    ma_don_vi VARCHAR(10),
    dong_dau VARCHAR(10),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
    );


CREATE TABLE IF NOT EXISTS so_du_chi_tiet (
    id SERIAL PRIMARY KEY,
    ngay_thang DATE NOT NULL,
    ma_doi_tuong VARCHAR(10),
    doi_tuong VARCHAR(255),
    dia_chi VARCHAR(256),
    so_hieu_tai_khoan VARCHAR(8) NOT NULL,
    ma_chuong VARCHAR(5),
    du_no INTEGER,
    du_no_ngoai_te DOUBLE PRECISION,
    du_co INTEGER,
    du_co_ngoai_te DOUBLE PRECISION,
    loai_tien VARCHAR(5),
    muc_tieu_muc VARCHAR(12),
    nhom_muc VARCHAR(4),
    ma_chuong_trinh VARCHAR(20),
    ma_cong_trinh VARCHAR(15),
    ma_nguon VARCHAR(6),
    ma_don_vi VARCHAR(10),
    dong_dau VARCHAR(10),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
    );
