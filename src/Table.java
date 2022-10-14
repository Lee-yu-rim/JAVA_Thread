import java.util.ArrayList;

public class Table {
	String[] dishNames = {"donut","donut","burger"};
	final int MAX_FOOD = 6;   //������ �ö�� �� �ִ� ���� ����
	
	private ArrayList<String> dishes = new ArrayList<String>();
	
	//���ÿ� ���� �����ϴ� �޼ҵ�
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {  //������ ���� ���ð� ����.
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting");
			
			try {   
				wait();  //wait�޼ҵ�� synchronized ������Ѵ�.    
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
		
		dishes.add(dish);
		notify();   //����ϰ� �ִ� ���� ������ ���� ������� �˷���
		System.out.println("Dishes : " + dishes.toString());
	}
	
	//���� ������ �԰�, ������ �԰� �� �� ���ø� ���� �޼ҵ�
	public synchronized void remove(String dishName) {  //���� ���� �� �ִ� ���� ������ dishName�� �Ѿ��
		String name = Thread.currentThread().getName();  //� ���� ������ �԰��ִ��� Ȯ��
		
		//���� ������ ���� ���� = ������ �����Ͱ� ���� ����
		while(dishes.size() == 0) {  
			System.out.println(name + " is waiting");
			
			try {    
				wait();  
				Thread.sleep(500);  //�丮�簡 �丮�� ���� �ð��� �ֱ����� �����带 0.5�� ���� ���� / ���� ������ �������ϵ��� ��
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
		
		//���� ������ ���� & ���� ��
		while(true) {
			for(int i=0;i<dishes.size();i++) {
				if(dishName.equals(dishes.get(i))) {  //���� �� �ִ� ������ �ִ��� Ȯ��
					dishes.remove(i);   //���� ������ ���ø� ����
					notify();   //�Ծ��ٰ� �˷��� -> wait���¿� ������ ���ͼ� ������ ������ �˷���
					return;  //�Դ� �� �ߴ�
				}
			}
			
			try {    
				System.out.println(name + " is waiting");
				wait();  //������ ���� �� ���� ��ٸ��� ����(�Դ� ���� ����)
				Thread.sleep(500);  //�丮�簡 �丮�� ���� �ð��� �ֱ����� �����带 0.5�� ���� ���� / ���� ������ �������ϵ��� ��
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
	}
	
	//����� ����(�迭�� ũ�� ��ȯ)
	public int dishName() {
		return dishNames.length;
	}
	
}
