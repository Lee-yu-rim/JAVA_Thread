import java.util.ArrayList;

public class Table {
	String[] dishNames = {"donut","donut","burger"};
	final int MAX_FOOD = 6;   //음식이 올라올 수 있는 갯수 제한
	
	private ArrayList<String> dishes = new ArrayList<String>();
	
	//접시에 음식 세팅하는 메소드
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {  //음식을 담을 접시가 없다.
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting");
			
			try {   
				wait();  //wait메소드는 synchronized 해줘야한다.    
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
		
		dishes.add(dish);
		notify();   //대기하고 있던 고객이 있으면 음식 먹으라고 알려줌
		System.out.println("Dishes : " + dishes.toString());
	}
	
	//고객이 음식을 먹고, 음식을 먹고 난 뒤 접시를 빼는 메소드
	public synchronized void remove(String dishName) {  //고객이 먹을 수 있는 음식 종류가 dishName에 넘어옴
		String name = Thread.currentThread().getName();  //어떤 고객이 음식을 먹고있는지 확인
		
		//먹을 음식이 없는 상태 = 삭제할 데이터가 없는 상태
		while(dishes.size() == 0) {  
			System.out.println(name + " is waiting");
			
			try {    
				wait();  
				Thread.sleep(500);  //요리사가 요리를 만들 시간을 주기위해 쓰레드를 0.5초 동안 멈춤 / 고객이 음식을 먹지못하도록 함
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
		
		//고객이 음식을 먹음 & 접시 뺌
		while(true) {
			for(int i=0;i<dishes.size();i++) {
				if(dishName.equals(dishes.get(i))) {  //먹을 수 있는 음식이 있는지 확인
					dishes.remove(i);   //먹은 음식의 접시를 지움
					notify();   //먹었다고 알려줌 -> wait상태에 있으면 나와서 음식을 만들라고 알려줌
					return;  //먹는 것 중단
				}
			}
			
			try {    
				System.out.println(name + " is waiting");
				wait();  //음식이 나올 때 까지 기다리기 위함(먹는 것을 멈춤)
				Thread.sleep(500);  //요리사가 요리를 만들 시간을 주기위해 쓰레드를 0.5초 동안 멈춤 / 고객이 음식을 먹지못하도록 함
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
	}
	
	//재료의 갯수(배열의 크기 반환)
	public int dishName() {
		return dishNames.length;
	}
	
}
