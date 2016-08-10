package test;

public class substr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String yyyymm = "201501";
//		String m = yyyymm.substring(5);
//		String nj = yyyymm.substring(0,4);
//		System.out.println(nj);
		
		String yyyymm = "01asd   da£¬1";
		
		System.out.println(yyyymm.replace(" ", "").equals(yyyymm));
//		System.out.println(yyyymm.substring(0, yyyymm.length()-1));
	}

}
