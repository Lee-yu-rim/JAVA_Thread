import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {
	private int balance = 1000;
	
	public /*synchronized*/ void withdraw(int money) {  //����ȭ(synchronized) : ������ ���Ѽ� ����ϰ� �Ѵ�. => Ư�� �����尡 ���� �޼ҵ带 ������ �� �ٸ� �����尡 ������� ���ϵ��� ��
		synchronized(this) {  //���� �� synchronized�� Ư�� �޼ҵ常 lock�ϴ� ���̰�, �̷��� �ۼ��ϴ� ���� Ŭ���� ��ü�� lock�� �Ŵ� ������ ������ �� �д�.
			if(balance >= money) {                      
				
				try {
					Thread.sleep(1000);  //1�ʸ��� �����  
				}catch(InterruptedException e) {  
					e.printStackTrace();
				}
				
				balance -= money;
			}
		}
	}
	
	//����ȭ�� ���� �ʰ� Account�� ���� �Ǹ�, sleep(���) ������ �� account���¸� ����Ϸ��� 2���� �����尡 ���ÿ� ���¿� �����ؼ� ����ϱ� ������ ���¿� �Ѹ��� ���� �� ��������
	//���¿� ���� 0���� �����ִ���, ���� �����尡 �����¿� �ִ� ���ȿ��� ���¿� 1�� �����尡 ���� �������� �� ���·� �ν��ϹǷ� ������ ���� ���̳ʽ��� �Ǵ� ���°� �Ǿ������.

}
