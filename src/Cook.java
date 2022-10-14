
public class Cook implements Runnable {

	//�丮�簡 ���̺��� ������ �޾ƿ�
	private Table table;
	
	public Cook(Table table) {
		super();
		this.table = table;
	}

	@Override
	public void run() {
		while(true) {
			//���� ����
			int idx = (int)(Math.random() * table.dishName());  // 0 ~ 2
			table.add(table.dishNames[idx]);  //table�� �ִ� ���� ������ �ε��� ��ȣ�� �޾ƿ�
			//���� ������ �ӵ�
			try {
				Thread.sleep(10);  //0.1���� �ӵ�    
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
	}
	
	//1. �丮�簡 ���̺�Ŭ�������� ������ �������� ���� ��ü ����
	//2. �����ڸ� ���� ���̺��� ���� �޾� �� �� �ִ� �Ű����� ���� �� �ʱ�ȭ
	//3. �ݺ����� ���� ���̺� Ŭ������ �ִ� ����� ������ �޾ƿͼ� �� ũ�⿡ �´� ������ ������ ����
	//4. ���̺��� ���� ������ �ε��� ��ȣ�� �޾ƿ�
	//5. 0.01���� �ӵ��� ������ ������
	
	
	
	
	

}
