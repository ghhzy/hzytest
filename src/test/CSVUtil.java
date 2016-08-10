package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * create csv file and photo
 * 
 * @author shenyin
 * 
 */
public class CSVUtil {

	/**
	 * create file ChoosedLessonData.csv
	 * 
	 * @param list
	 * @param fileName
	 * @return filepath
	 */
	public static int writeExpRelationInfoToCSV(List<Map<String, Object>> list,
			String classGuid) {
		StringBuffer write = new StringBuffer();
		String enter = "\r\n";
		int countNum = 0;
		try {
			write.append("ItemUID,");
			write.append("UserId,");
			write.append("LessonId");
			write.append(enter);
			for (Map<String, Object> record : list) {
				Set<String> keySet = record.keySet();
				for (String key : keySet) {
					write.append("\"" + record.get(key) + "\",");
				}
				write.append(enter);
				countNum++;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return countNum;
	}

	public static void WriteCSV(List<Map<String, Object>> list) {

		try {
			File csv = new File("F:/writers.csv"); // CSV�����ļ�
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // ����
			// ����µ�������

			for (Map<String, Object> record : list) {
				Set<String> keys = new LinkedHashSet<String>(record.keySet());
				for(String key : keys){
					bw.write("\"" + (String)record.get(key) + "\",");
				}
				
				/*bw.write("\"" + (String)record.get("h1") + "\",");
				bw.write("\"" + (String)record.get("h2") + "\",");
				bw.write("\"" + (String)record.get("A0101") + "\",");
				bw.write("\"" + (String)record.get("id") + "\",");
				bw.write("\"" + (String)record.get("A0177") + "\",");*/
				bw.newLine();
			}
			bw.close();

		} catch (FileNotFoundException e) {
			// File����Ĵ��������е��쳣����
			e.printStackTrace();
		} catch (IOException e) {
			// BufferedWriter�ڹرն���׽�쳣
			e.printStackTrace();
		}
	}

}
