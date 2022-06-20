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
		// TODO Auto-generated method stub
//		readCsvFileScan("D:\\TOP20.csv");
		readCsvFile("./samples/TOP20.csv");
	}

	private static void readCsvFile(String filepath) {
		
		List<CsvDto> users = new ArrayList<CsvDto>();
		try {
			Scanner scanner = new Scanner(new File(filepath));
			
			while (scanner.hasNext()) {
				
				String[] userData =scanner.nextLine().split(",");
				
				if (!userData[0].equals("id")) {
					users.add(new CsvDto(userData[0],userData[1],userData[2],userData[3]));
				}
			}
			scanner.close();
			
			System.out.println("=======================CSV => JSON 저장===========================");
			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(users));
			System.out.println("=================================================================");
			System.out.println("=================================================================");
			System.out.println("=================================================================");
			System.out.println("");
			System.out.println("=======================LicenseOrgan 출력==========================");
			for(int i=0; i<users.size(); i++)
			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(users.get(i).getLicenseOrgan()) );
			System.out.println("================================================================");
			System.out.println("=================================================================");
			System.out.println("=================================================================");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
