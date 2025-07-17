CREATE SCHEMA IF NOT EXISTS nguoi_dung_schema;

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.vai_tro (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ten VARCHAR(50) UNIQUE NOT NULL,
	soft_delete BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.nguoi_dung (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ten_dang_nhap VARCHAR(50) UNIQUE NOT NULL,
	mat_khau VARCHAR(256) NOT NULL,
	ten VARCHAR(128),
	soft_delete BOOLEAN DEFAULT FALSE,
	thoi_diem_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.vai_tro_route (
	ma INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ma_vai_tro SERIAL NOT NULL,
	route_signature varchar(128),
	soft_delete BOOLEAN DEFAULT FALSE,

	FOREIGN KEY (ma_vai_tro) REFERENCES nguoi_dung_schema.vai_tro(ma)
);

CREATE TABLE IF NOT EXISTS nguoi_dung_schema.nguoi_dung_vai_tro (
	ma INT GENERATED ALAWYS AS IDENTITY PRIMARY KEY,
	ma_nguoi_dung SERIAL NOT NULL,
	ma_vai_tro SERIAL NOT NULL,
	soft_delete BOOLEAN DEFAULT FALSE,

	FOREIGN KEY (ma_nguoi_dung) REFERENCES nguoi_dung_schema.nguoi_dung(ma),
	FOREIGN KEY (ma_vai_tro) REFERENCES nguoi_dung_schema.vai_tro(ma)
);
