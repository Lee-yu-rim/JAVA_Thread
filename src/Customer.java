
public class Customer implements Runnable {

	//고객이 테이블과 음식의 정보를 가져옴
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
		super();
		this.table = table;
		this.food = food;
	}
	
	//음식 먹는 속도(만든 속도보다 느리게)
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);   
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
			
			String name = Thread.currentThread().getName();   //쓰레드 이름 확인
			table.remove(food);
			System.out.println(name + " ate " + food);
		}
	}

}
