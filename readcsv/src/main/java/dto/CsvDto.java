package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@XmlAccessorType(XmlAccessType.FIELD)
public class CsvDto {
	
	private String id;	
	private String title;
	private String licenseOrgan;
	private String esRegdt;	

}
