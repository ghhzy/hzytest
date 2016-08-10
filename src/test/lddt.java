package test;

public class lddt {

	/**
	 * 年轻人 new什么就是什么 别多问
	 * @author hzy
	 *
	 */
	class A{
		public String show(A obj){
			return ("A and A");
		}
		public String show(D obj){
			return ("A and D");
		}
	}
	class B extends A{
		public String show(B obj){
			return ("B and B");
		}
		public String show(A obj){
			return ("B and A");
		}
	}
	class C extends B{
		public String show(C obj){
			return ("C and B");
		}
		public String show(A obj){
			return ("C and A");
		}
	}
	class D extends B{
		public String show(D obj){
			return ("D and B");
		}
		public String show(A obj){
			return ("D and A");
		}
	}
	
	public static void main(String[] args) {
		lddt ht = new lddt();
		ht.test();
	}
	
	public void test() {
		A a1 = new A();  
		A a2 = new B();  
		B b = new B();  
		C c = new C();   
		D d = new D();   
		System.out.println(a1.show(b));     
		System.out.println(a1.show(c));     
		System.out.println(a1.show(d));     
		System.out.println(a2.show(b));     
		System.out.println(a2.show(c));   
		System.out.println(a2.show(d));    
		System.out.println(b.show(b));     
		System.out.println(b.show(c));     
		System.out.println(b.show(d));
	}
	
	
	    

}
