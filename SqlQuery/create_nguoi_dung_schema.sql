CREATE SCHEMA IF NOT EXISTS nguoi_dung_schema;

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.quyen_han (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ten VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.nguoi_dung (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ten_dang_nhap VARCHAR(50) UNIQUE NOT NULL,
	mat_khau VARCHAR(256) NOT NULL,
	ten VARCHAR(128),
	soft_delete BOOLEAN DEFAULT FALSE,
	thoi_diem_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.quyen_han_nguoi_dung (
	ma_nguoi_dung SERIAL NOT NULL,
	ma_quyen_han SERIAL NOT NULL,

	PRIMARY KEY (ma_nguoi_dung, ma_quyen_han),

	FOREIGN KEY (ma_nguoi_dung) REFERENCES nguoi_dung_schema.nguoi_dung(ma),
	FOREIGN KEY (ma_quyen_han) REFERENCES nguoi_dung_schema.quyen_han(ma)
);

