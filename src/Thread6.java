
public class Thread6 implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());  //���� �������� �̸� Ȯ��
			
			try {
				Thread.sleep(1000);   //1�ʿ� �ѹ��� ���ư�
			}catch(InterruptedException e) {  //sleep�� ���õ� ����, sleep�� ����Ϸ��� ����ó�� ����� ��
				e.printStackTrace();
			}
		}
	}

}
