package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tai_khoan_dung")
public class TaiKhoanDungEntity extends BaseEntity {

	@Column(name = "ten_tai_khoan")
	private String accountName;
	public String getAccountName() {
			return accountName;
	}
	public void setAccountName(String accountName) {
			this.accountName = accountName;
	}

	@Column(name = "so_hieu_tai_khoan")
	private String accountCode;
	public String getAccountCode() {
			return accountCode;
	}
	public void setAccountCode(String accountCode) {
			this.accountCode = accountCode;
	}

	@Column(name = "loai_rut_so_du")
	private String balanceWithdrawalType;
	public String getBalanceWithdrawalType() {
			return balanceWithdrawalType;
	}
	public void setBalanceWithdrawalType(String balanceWithdrawalType) {
			this.balanceWithdrawalType = balanceWithdrawalType;
	}

	@Column(name = "ten_chu_quan")
	private String accountOwnerName;
	public String getAccountOwnerName() {
			return accountOwnerName;
	}
	public void setAccountOwnerName(String accountOwnerName) {
			this.accountOwnerName = accountOwnerName;
	}
	@Column(name = "ten_ngan_hang_kho_bac")
	private String treasuryBankName;
	public void setTreasuryBankName(String treasuryBankName) {
			this.treasuryBankName = treasuryBankName;
	}
	public String getTreasuryBankName() {
			return treasuryBankName;
	}

	@Column(name = "tam_ung")
	private String advanceAmount;
	public String getAdvanceAmount() {
			return advanceAmount;
	}
	public void setAdvanceAmount(String advanceAmount) {
			this.advanceAmount = advanceAmount;
	}

	@Column(name = "tai_khoan_ngan_hang_kho_bac")
	private String treasuryBankAccount;
	public String getTreasuryBankAccount() {
			return treasuryBankAccount;
	}
	public void setTreasuryBankAccount(String treasuryBankAccount) {
			this.treasuryBankAccount = treasuryBankAccount;
	}
}
