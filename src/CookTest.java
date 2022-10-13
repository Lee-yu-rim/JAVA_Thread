
public class CookTest {

	public static void main(String[] args) {
		Table table = new Table();
		
		new Thread(new Cook(table),"Cook1").start();
		new Thread(new Customer(table,"donut"),"CUS1").start();
		new Thread(new Customer(table,"burger"),"CUS2").start();
		
		//2초동안만 진행
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.exit(0);

	}

}
