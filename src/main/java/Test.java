
public class Test {
	
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i < 100; i++) {
			j = j++;
		}
		System.out.println(j);
	}
	
	//++ �� --������ �Լ���̬�ֲ�����
	static {
		int x = 5;
	}
	static int x,y;
	
	public static void test1() {
		x--;
		myMethod();
		System.out.println(x + y++ +x);
	}
	public static void myMethod() {
		y = x++ + ++x;
	}
}
