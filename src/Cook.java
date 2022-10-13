
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
	
	
	
	
	

}
