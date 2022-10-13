
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
	
	
	
	
	

}
