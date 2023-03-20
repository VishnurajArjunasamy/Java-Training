package Task3;

class MyThread extends Thread{
	StringBuffer sb;
	MyThread(StringBuffer sb){
		this.sb=sb;
	}
	public void run() {
		synchronized(sb) {
			for(int i=0;i<100;i++) {
				System.out.print(sb);
			}
			char c = sb.charAt(0);
			sb.setCharAt(0, ++c);
		}
	}
}

public class MultiThreading8 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("A");
		MyThread mt1 = new MyThread(sb);
		MyThread mt2 = new MyThread(sb);
		MyThread mt3 = new MyThread(sb);

		mt1.start();
		mt2.start();
		mt3.start();
	}
}