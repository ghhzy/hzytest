package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class ReflectFields {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class demo = Class.forName("test.ReflectFields$EsA0");
		Field[] fields = demo.getDeclaredFields();
		Method[] methods = demo.getDeclaredMethods();
		for (Field f : fields) {
			System.out.println("�ֶ�:" + f.getName());
			System.out.println("�ֶ�����:" + f.getType());
		}

	}
	
	class EsA0 {

		private String ��ԱID;
		
		private String ����;
		
		private String ֤������;
		
		private String ��Ա״̬;
		
		private String ֤����;
		
		private String �Ա�;
		
		private Date ��������;
		
		private Date �μӹ���ʱ��;
		
		private List<String> ѧϰ��������;
		
		private List<String> רҵ�����ʸ񼯺�;
		
		private List<String> ��ȿ��˼���;
		
		private List<String> ������������;
		
		private List<String> ������Ŀ����;
		
		private List<String> �滮��׼����;
		
		private List<String> ���ļ���;

		public String get��ԱID() {
			return ��ԱID;
		}

		public void set��ԱID(String ��Աid) {
			��ԱID = ��Աid;
		}

		public String get����() {
			return ����;
		}

		public void set����(String ����) {
			this.���� = ����;
		}

		public String get֤������() {
			return ֤������;
		}

		public void set֤������(String ֤������) {
			this.֤������ = ֤������;
		}

		public String get��Ա״̬() {
			return ��Ա״̬;
		}

		public void set��Ա״̬(String ��Ա״̬) {
			this.��Ա״̬ = ��Ա״̬;
		}

		public String get֤����() {
			return ֤����;
		}

		public void set֤����(String ֤����) {
			this.֤���� = ֤����;
		}

		public String get�Ա�() {
			return �Ա�;
		}

		public void set�Ա�(String �Ա�) {
			this.�Ա� = �Ա�;
		}

		public Date get��������() {
			return ��������;
		}

		public void set��������(Date ��������) {
			this.�������� = ��������;
		}

		public Date get�μӹ���ʱ��() {
			return �μӹ���ʱ��;
		}

		public void set�μӹ���ʱ��(Date �μӹ���ʱ��) {
			this.�μӹ���ʱ�� = �μӹ���ʱ��;
		}

		public List<String> getѧϰ��������() {
			return ѧϰ��������;
		}

		public void setѧϰ��������(List<String> ѧϰ��������) {
			this.ѧϰ�������� = ѧϰ��������;
		}

		public List<String> getרҵ�����ʸ񼯺�() {
			return רҵ�����ʸ񼯺�;
		}

		public void setרҵ�����ʸ񼯺�(List<String> רҵ�����ʸ񼯺�) {
			this.רҵ�����ʸ񼯺� = רҵ�����ʸ񼯺�;
		}

		public List<String> get��ȿ��˼���() {
			return ��ȿ��˼���;
		}

		public void set��ȿ��˼���(List<String> ��ȿ��˼���) {
			this.��ȿ��˼��� = ��ȿ��˼���;
		}

		public List<String> get������������() {
			return ������������;
		}

		public void set������������(List<String> ������������) {
			this.������������ = ������������;
		}

		public List<String> get������Ŀ����() {
			return ������Ŀ����;
		}

		public void set������Ŀ����(List<String> ������Ŀ����) {
			this.������Ŀ���� = ������Ŀ����;
		}

		public List<String> get�滮��׼����() {
			return �滮��׼����;
		}

		public void set�滮��׼����(List<String> �滮��׼����) {
			this.�滮��׼���� = �滮��׼����;
		}

		public List<String> get���ļ���() {
			return ���ļ���;
		}

		public void set���ļ���(List<String> ���ļ���) {
			this.���ļ��� = ���ļ���;
		}
		
		
		
	}

}

