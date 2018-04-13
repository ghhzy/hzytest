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
			System.out.println("字段:" + f.getName());
			System.out.println("字段类型:" + f.getType());
		}

	}
	
	class EsA0 {

		private String 人员ID;
		
		private String 姓名;
		
		private String 证件类型;
		
		private String 人员状态;
		
		private String 证件号;
		
		private String 性别;
		
		private Date 出生日期;
		
		private Date 参加工作时间;
		
		private List<String> 学习经历集合;
		
		private List<String> 专业技术资格集合;
		
		private List<String> 年度考核集合;
		
		private List<String> 工作经历集合;
		
		private List<String> 科研项目集合;
		
		private List<String> 规划标准集合;
		
		private List<String> 论文集合;

		public String get人员ID() {
			return 人员ID;
		}

		public void set人员ID(String 人员id) {
			人员ID = 人员id;
		}

		public String get姓名() {
			return 姓名;
		}

		public void set姓名(String 姓名) {
			this.姓名 = 姓名;
		}

		public String get证件类型() {
			return 证件类型;
		}

		public void set证件类型(String 证件类型) {
			this.证件类型 = 证件类型;
		}

		public String get人员状态() {
			return 人员状态;
		}

		public void set人员状态(String 人员状态) {
			this.人员状态 = 人员状态;
		}

		public String get证件号() {
			return 证件号;
		}

		public void set证件号(String 证件号) {
			this.证件号 = 证件号;
		}

		public String get性别() {
			return 性别;
		}

		public void set性别(String 性别) {
			this.性别 = 性别;
		}

		public Date get出生日期() {
			return 出生日期;
		}

		public void set出生日期(Date 出生日期) {
			this.出生日期 = 出生日期;
		}

		public Date get参加工作时间() {
			return 参加工作时间;
		}

		public void set参加工作时间(Date 参加工作时间) {
			this.参加工作时间 = 参加工作时间;
		}

		public List<String> get学习经历集合() {
			return 学习经历集合;
		}

		public void set学习经历集合(List<String> 学习经历集合) {
			this.学习经历集合 = 学习经历集合;
		}

		public List<String> get专业技术资格集合() {
			return 专业技术资格集合;
		}

		public void set专业技术资格集合(List<String> 专业技术资格集合) {
			this.专业技术资格集合 = 专业技术资格集合;
		}

		public List<String> get年度考核集合() {
			return 年度考核集合;
		}

		public void set年度考核集合(List<String> 年度考核集合) {
			this.年度考核集合 = 年度考核集合;
		}

		public List<String> get工作经历集合() {
			return 工作经历集合;
		}

		public void set工作经历集合(List<String> 工作经历集合) {
			this.工作经历集合 = 工作经历集合;
		}

		public List<String> get科研项目集合() {
			return 科研项目集合;
		}

		public void set科研项目集合(List<String> 科研项目集合) {
			this.科研项目集合 = 科研项目集合;
		}

		public List<String> get规划标准集合() {
			return 规划标准集合;
		}

		public void set规划标准集合(List<String> 规划标准集合) {
			this.规划标准集合 = 规划标准集合;
		}

		public List<String> get论文集合() {
			return 论文集合;
		}

		public void set论文集合(List<String> 论文集合) {
			this.论文集合 = 论文集合;
		}
		
		
		
	}

}

