
public class Cook implements Runnable {

	//요리사가 테이블의 정보를 받아옴
	private Table table;
	
	public Cook(Table table) {
		super();
		this.table = table;
	}

	@Override
	public void run() {
		while(true) {
			//음식 생성
			int idx = (int)(Math.random() * table.dishName());  // 0 ~ 2
			table.add(table.dishNames[idx]);  //table에 있는 음식 종류의 인덱스 번호를 받아옴
			//음식 나오는 속도
			try {
				Thread.sleep(10);  //0.1초의 속도    
			}catch(InterruptedException e) {  
				e.printStackTrace();
			}
		}
	}
	
	//1. 요리사가 테이블클래스에서 정보를 가져오기 위해 객체 생성
	//2. 생성자를 통해 테이블에서 값을 받아 올 수 있는 매개변수 생성 및 초기화
	//3. 반복문을 통해 테이블 클래스에 있는 재료의 개수를 받아와서 그 크기에 맞는 랜덤한 변수를 생성
	//4. 테이블의 음식 종류의 인덱스 번호를 받아옴
	//5. 0.01초의 속도로 음식을 생성함
	
	
	
	
	

}
