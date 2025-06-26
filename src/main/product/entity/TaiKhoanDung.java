package main.product.entity;

import jakarta.persistence.Column;

public class TaiKhoanDung extends BaseEntity {

	@Column(name = "ten_tai_khoan")
	private String accountName;
	@Column(name = "so_hieu_tai_khoan")
	private String accountCode;
	@Column(name = "loai_rut_so_du")
	private String balanceWithdrawalType;
	@Column(name = "ten_chu_quan")
	private String accountOwnerName;
	@Column(name = "ten_ngan_hang_kho_bac")
	private String treasuryBankName;
	@Column(name = "tam_ung")
	private String advanceAmount;
	@Column(name = "tai_khoan_ngan_hang_kho_bac")
	private String treasuryBankAccount;
}
