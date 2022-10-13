
public class Count extends Thread{
	
	//run 메소드를 반드시 오버라이드 해야한다.
	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	

	

}
