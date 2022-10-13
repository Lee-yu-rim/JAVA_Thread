import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {
	private int balance = 1000;
	
	public /*synchronized*/ void withdraw(int money) {  //동기화(synchronized) : 순서를 지켜서 사용하게 한다. => 특정 쓰레드가 먼저 메소드를 동작할 때 다른 쓰레드가 사용하지 못하도록 함
		synchronized(this) {  //위에 쓴 synchronized는 특정 메소드만 lock하는 것이고, 이렇게 작성하는 것은 클래스 자체에 lock을 거는 것으로 범위가 더 넓다.
			if(balance >= money) {                      
				
				try {
					Thread.sleep(1000);  //1초마다 출금함  
				}catch(InterruptedException e) {  
					e.printStackTrace();
				}
				
				balance -= money;
			}
		}
	}
	
	//동기화를 하지 않고 Account를 쓰게 되면, sleep(대기) 상태일 때 account계좌를 사용하려는 2개의 스레드가 동시에 계좌에 접근해서 출금하기 때문에 계좌에 한명이 돈을 다 가져가서
	//계좌에 돈이 0원이 남아있더라도, 남은 스레드가 대기상태에 있는 동안에는 계좌에 1번 스레드가 돈을 가져가기 전 상태로 인식하므로 계좌의 돈이 마이너스가 되는 상태가 되어버린다.

}
