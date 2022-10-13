import javax.swing.JOptionPane;

public class ThreadTest {

	public static void main(String[] args) {
		//프로그램 -> 프로세스(프로그램 실행) -> 멀티쓰레드(하나의 프로세스 안에 여러 기능이 사용되는 것)
		//모든 프로그램은 기본적으로 쓰레드가 동작한다.(1개 이상의 쓰레드가 있다)
		//쓰레드 만드는 방법
		//-Thread 클래스를 상속
		//-Runnable 인터페이스 상속
		
		//원쓰레드 방식 -> 한가지 실행문이 동작한 뒤, 다음 실행문을 동작하는 것(동시에 쓰레드가 동작하지 않음)
//		for(int i=0;i<10;i++) {
//			System.out.println(i);
//		}
//
//		for(int j=0;j<10;j++) {
//			System.out.println(j);
//		}
		
		//멀티쓰레드
		//Thread 클래스 상속 방식
//		Count cnt = new Count();
//		cnt.start();  //Count클래스 안에 run메소드가 아닌 start메소드로 호출하여 독립되게 동작이 실행된다.
		
		//Runnable 인터페이스 상속 방식
//		Runnable r = new Count2();
//		Thread cnt2 = new Thread(r);
//		cnt2.start();
		
		//메인쓰레드
//		String input = JOptionPane.showInputDialog("아무 값이나 입력");
//		System.out.println("입력값은 " + input + "입니다.");
		
		//이렇게 쓰레드를 분리하게 되면 메인쓰레드의 동작과 상관없이 Count클래스는 독립적으로 동작한다. => 여러 쓰레드가 동시다발적으로 일어난다.
		
//		Threadex5 th = new Threadex5();  //세로찍기 |
//		th.start();
//		
//		for(int i=0;i<500;i++) {
//			System.out.print("-");
//		}
		//실행구문안에 메모리와 CPU 등 다른 다양한 시스템들이 처리되기 때문에 번갈아가면서 출력되긴하지만 균등하게 출력되지는 않는다.
		
		Runnable r = new Thread6();
		Thread th1 = new Thread(r,"*");
		Thread th2 = new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		
		th1.start();
		th2.start();
		th3.start();
		//쓰레드가 start의 순서에 의해 순서대로 동작하진 않는다.
		
		//쓰레드 제어
		try {
			Thread.sleep(2000);  //현재 자신을 호출한 쓰레드를 sleep한다.(일시정지)
			th1.suspend();   //쓰레드 일시정지 -> th1,2,3이 한번 실행된 뒤, 2초 뒤에 th1이 멈추고 대기 상태로 들어감, th2,3만 그뒤로 실행됨
			Thread.sleep(2000);
			th2.suspend();   //th2는 4초 뒤에 멈춤
			Thread.sleep(3000);  //main쓰레드가 7초뒤에 실행됨
			th1.resume();   //suspend 되어있는 쓰레드를 실행 대기상태로 만듬 => 즉시 실행은 아님
			Thread.sleep(3000);
			th2.resume();  
			Thread.sleep(3000);
			th1.stop();  //끝날때도 순서대로 찍히진 않음
			th2.stop();
		}catch(InterruptedException e) {  
			e.printStackTrace();
		}
		//sleep은 main쓰레드에서 호출되어진다. -> main쓰레드가 sleep된다.
		//실행되는 쓰레드는 총 4개, main, th1,2,3 => main쓰레드와 상관없이 th123은 계속 실행된다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
