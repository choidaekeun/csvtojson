package Read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.GsonBuilder;

import dto.CsvDto;



public class CsvFile {

	public static void main(String[] args) {		
//		readCsvFileScan("D:\\TOP20.csv");
		readCsvFile("./samples/TOP20.csv");
	}

	private static void readCsvFile(String filepath) {
		
		List<CsvDto> list = new ArrayList<CsvDto>();
		try {
			Scanner scanner = new Scanner(new File(filepath));
			
			while (scanner.hasNext()) {
				
				String[] Data =scanner.nextLine().split(",");
				
				if (!Data[0].equals("id")) {
					list.add(new CsvDto(Data[0],Data[1],Data[2],Data[3]));
				}
			}
			scanner.close();
			
			System.out.println("=======================CSV => JSON 저장===========================");
			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(list));
			System.out.println("=================================================================");
			System.out.println("=================================================================");
			System.out.println("=================================================================");
			System.out.println("");
			System.out.println("=======================LicenseOrgan 출력==========================");
			for(int i=0; i<list.size(); i++)
			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(list.get(i).getLicenseOrgan()) );
			System.out.println("================================================================");
			System.out.println("=================================================================");
			System.out.println("=================================================================");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
