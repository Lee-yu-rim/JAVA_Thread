
public class AccountHolder implements Runnable {

	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;  // 100 ~ 300원 사이의 돈이 랜덤으로 출금
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}

}
