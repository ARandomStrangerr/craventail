package main.product.dto.request;

public class TaiKhoanDungReq {

	private String accountName;
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	private String accountCode;
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	private String balanceWithdrawalType;
	public String getBalanceWithdrawalType() {
		return balanceWithdrawalType;
	}
	public void setBalanceWithdrawalType(String balanceWithdrawalType) {
		this.balanceWithdrawalType = balanceWithdrawalType;
	}

	private String accountOwnerName;
	public String getAccountOwnerName() {
		return accountOwnerName;
	}
	public void setAccountOwnerName(String accountOwnerName) {
		this.accountOwnerName = accountOwnerName;
	}
	
	private String treasuryBankName;
	public void setTreasuryBankName(String treasuryBankName) {
		this.treasuryBankName = treasuryBankName;
	}
	public String getTreasuryBankName() {
			return treasuryBankName;
	}

	private String advanceAmount;
	public String getAdvanceAmount() {
			return advanceAmount;
	}
	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	private String treasuryBankAccount;
	public String getTreasuryBankAccount() {
		return treasuryBankAccount;
	}
	public void setTreasuryBankAccount(String treasuryBankAccount) {
		this.treasuryBankAccount = treasuryBankAccount;
	}
}
