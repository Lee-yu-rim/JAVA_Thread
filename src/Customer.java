
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
				Thread.sleep(100);   //0.1초마다 음식 먹음
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
			
			String name = Thread.currentThread().getName();   //현재 사용하고 있는 쓰레드 이름 확인
			table.remove(food);
			System.out.println(name + " ate " + food);  //현재 음식을 먹고 있는 쓰레드가 누군지 확인
		}
	}
	
	//1. 고객이 테이블에 있는 음식의 정보를 얻기 위해 객체 생성
	//2. 생성자를 통해 테이블에서 값을 받아 올 수 있는 매개변수 생성 및 초기화
	//3. 음식을 먹는 행위(메소드)를 위한 음식 변수 생성
	//4. 음식먹는 행위를 위한 메소드 생성
	//5. 반복문을 이용하여 0.1초에 한번씩 고객이 음식을 먹도록 설정함
	//6. 음식을 먹고난 뒤, 음식을 테이블에서 없앰
	//7. name이라는 변수를 생성하여 현재 음식을 먹고있는 고객(쓰레드)이 누군지 확인하도록 출력함.
	
	
	
	

}
