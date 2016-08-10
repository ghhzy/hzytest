package test;

public class numberToChinese {

	static String[] units = { "", "ʮ", "��", "ǧ", "��", "ʮ��", "����", "ǧ��", "��", "ʮ��",
			"����", "ǧ��", "����" };
	static char[] numArray = { '��', 'һ', '��', '��', '��', '��', '��', '��', '��', '��' };

	
	public static void main(String[] args) {
		System.out.println(formatIntegerByString("11"));
		
	}
	
	
	//�����ַ���ת������
	public static String formatIntegerByString(String num) {
		char[] val = num.toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					// not need process if the last digital bits is 0
					continue;
				} else {
					// no unit for 0
					sb.append(numArray[n]);
				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		return sb.toString();
	}
	//����ת������
	public static String formatIntegerByInt(int num) {
		char[] val = String.valueOf(num).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					// not need process if the last digital bits is 0
					continue;
				} else {
					// no unit for 0
					sb.append(numArray[n]);
				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		return sb.toString();
	}
	
	//С��ת������
	public static String formatDecimal(double decimal) {
		String decimals = String.valueOf(decimal);
		int decIndex = decimals.indexOf(".");
		int integ = Integer.valueOf(decimals.substring(0, decIndex));
		int dec = Integer.valueOf(decimals.substring(decIndex + 1));
		String result = formatIntegerByInt(integ) + "." + formatFractionalPart(dec);
		return result;
	}

	private static String formatFractionalPart(int decimal) {
		char[] val = String.valueOf(decimal).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int n = Integer.valueOf(val[i] + "");
			sb.append(numArray[n]);
		}
		return sb.toString();
	}

}
