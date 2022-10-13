
public class AccountHolderTest {

	public static void main(String[] args) {
		
		//하나의 통장에서 2명의 사람이 돈을 출금할 수 있는 상태
		Runnable r = new AccountHolder();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();
		
		
		
		

	}

}
