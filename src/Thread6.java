
public class Thread6 implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());  //현재 쓰레드의 이름 확인
			
			try {
				Thread.sleep(1000);   //1초에 한번씩 돌아감
			}catch(InterruptedException e) {  //sleep과 관련된 예외, sleep을 사용하려면 예외처리 해줘야 함
				e.printStackTrace();
			}
		}
	}

}
