import javax.swing.JOptionPane;

public class ThreadTest {

	public static void main(String[] args) {
		//���α׷� -> ���μ���(���α׷� ����) -> ��Ƽ������(�ϳ��� ���μ��� �ȿ� ���� ����� ���Ǵ� ��)
		//��� ���α׷��� �⺻������ �����尡 �����Ѵ�.(1�� �̻��� �����尡 �ִ�)
		//������ ����� ���
		//-Thread Ŭ������ ���
		//-Runnable �������̽� ���
		
		//�������� ��� -> �Ѱ��� ���๮�� ������ ��, ���� ���๮�� �����ϴ� ��(���ÿ� �����尡 �������� ����)
//		for(int i=0;i<10;i++) {
//			System.out.println(i);
//		}
//
//		for(int j=0;j<10;j++) {
//			System.out.println(j);
//		}
		
		//��Ƽ������
		//Thread Ŭ���� ��� ���
//		Count cnt = new Count();
//		cnt.start();  //CountŬ���� �ȿ� run�޼ҵ尡 �ƴ� start�޼ҵ�� ȣ���Ͽ� �����ǰ� ������ ����ȴ�.
		
		//Runnable �������̽� ��� ���
//		Runnable r = new Count2();
//		Thread cnt2 = new Thread(r);
//		cnt2.start();
		
		//���ξ�����
//		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է�");
//		System.out.println("�Է°��� " + input + "�Դϴ�.");
		
		//�̷��� �����带 �и��ϰ� �Ǹ� ���ξ������� ���۰� ������� CountŬ������ ���������� �����Ѵ�. => ���� �����尡 ���ôٹ������� �Ͼ��.
		
//		Threadex5 th = new Threadex5();  //������� |
//		th.start();
//		
//		for(int i=0;i<500;i++) {
//			System.out.print("-");
//		}
		//���౸���ȿ� �޸𸮿� CPU �� �ٸ� �پ��� �ý��۵��� ó���Ǳ� ������ �����ư��鼭 ��µǱ������� �յ��ϰ� ��µ����� �ʴ´�.
		
		Runnable r = new Thread6();
		Thread th1 = new Thread(r,"*");
		Thread th2 = new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		
		th1.start();
		th2.start();
		th3.start();
		//�����尡 start�� ������ ���� ������� �������� �ʴ´�.
		
		//������ ����
		try {
			Thread.sleep(2000);  //���� �ڽ��� ȣ���� �����带 sleep�Ѵ�.(�Ͻ�����)
			th1.suspend();   //������ �Ͻ����� -> th1,2,3�� �ѹ� ����� ��, 2�� �ڿ� th1�� ���߰� ��� ���·� ��, th2,3�� �׵ڷ� �����
			Thread.sleep(2000);
			th2.suspend();   //th2�� 4�� �ڿ� ����
			Thread.sleep(3000);  //main�����尡 7�ʵڿ� �����
			th1.resume();   //suspend �Ǿ��ִ� �����带 ���� �����·� ���� => ��� ������ �ƴ�
			Thread.sleep(3000);
			th2.resume();  
			Thread.sleep(3000);
			th1.stop();  //�������� ������� ������ ����
			th2.stop();
		}catch(InterruptedException e) {  
			e.printStackTrace();
		}
		//sleep�� main�����忡�� ȣ��Ǿ�����. -> main�����尡 sleep�ȴ�.
		//����Ǵ� ������� �� 4��, main, th1,2,3 => main������� ������� th123�� ��� ����ȴ�.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
