
public class Count extends Thread{
	
	//run �޼ҵ带 �ݵ�� �������̵� �ؾ��Ѵ�.
	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);  //1�ʿ� �ѹ��� i�� ���� �پ���.
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	

	

}
