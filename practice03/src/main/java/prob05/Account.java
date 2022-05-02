package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;	
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void save(int i) {
		balance += i;
		System.out.println(accountNo + " 계좌에 " + balance + " 만원이 입금되었습니다.");
	}

	public void deposit(int i) {
		balance -= i;
		System.out.println(accountNo + " 계좌에 " + balance + " 만원이 출금되었습니다.");

	}

	


	
}