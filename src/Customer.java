
public class Customer implements Runnable {

	//���� ���̺�� ������ ������ ������
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
		super();
		this.table = table;
		this.food = food;
	}
	
	//���� �Դ� �ӵ�(���� �ӵ����� ������)
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);   //0.1�ʸ��� ���� ����
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
			
			String name = Thread.currentThread().getName();   //���� ����ϰ� �ִ� ������ �̸� Ȯ��
			table.remove(food);
			System.out.println(name + " ate " + food);  //���� ������ �԰� �ִ� �����尡 ������ Ȯ��
		}
	}
	
	//1. ���� ���̺� �ִ� ������ ������ ��� ���� ��ü ����
	//2. �����ڸ� ���� ���̺��� ���� �޾� �� �� �ִ� �Ű����� ���� �� �ʱ�ȭ
	//3. ������ �Դ� ����(�޼ҵ�)�� ���� ���� ���� ����
	//4. ���ĸԴ� ������ ���� �޼ҵ� ����
	//5. �ݺ����� �̿��Ͽ� 0.1�ʿ� �ѹ��� ���� ������ �Ե��� ������
	//6. ������ �԰� ��, ������ ���̺��� ����
	//7. name�̶�� ������ �����Ͽ� ���� ������ �԰��ִ� ��(������)�� ������ Ȯ���ϵ��� �����.
	
	
	
	

}
