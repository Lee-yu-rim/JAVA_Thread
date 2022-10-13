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
					Thread.sleep(1000);    
				}catch(InterruptedException e) {  
					e.printStackTrace();
				}
				
				balance -= money;
			}
		}
	}

}
