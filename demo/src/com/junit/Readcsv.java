package com.junit;

import java.nio.charset.Charset;
import java.util.ArrayList;
import com.csvreader.CsvReader;

public class Readcsv {
	public static void readCsvFile(String filePath) {
		
		try {
			ArrayList<String[]> csvList = new ArrayList<String[]>();
			CsvReader reader = new CsvReader(filePath, ',', Charset.forName("SJIS"));
			//reader.readHeaders();
			
			while (reader.readRecord()) { // 逐行读入除表头的数据
				csvList.add(reader.getValues());
			}
			reader.close();
			for (int row = 0; row < csvList.size(); row++) {
				System.out.println(csvList.get(row)[0]); // name
				System.out.println(csvList.get(row)[1]); // email
				System.out.println(csvList.get(row)[2]); // age
				System.out.println(csvList.get(row)[3]); // sex			
				System.out.println("------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\chenjingjian\\Desktop\\CSV测试.csv";
		readCsvFile(filePath);

	}
}