package writeandModifyExcelfileWithApachePoi;


import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * @author a.guindo
 * a)HSSF is prefixed before the class name to indicate operations related to a Microsoft Excel 2003 file.
 * b)XSSF is prefixed before the class name to indicate operations related to a Microsoft Excel 2007 file or later.
 * c)XSSFWorkbook and HSSFWorkbook are classes which act as an Excel Workbook
 * d)HSSFSheet and XSSFSheet are classes which act as an Excel Worksheet
 * e)Row defines an Excel row
 * f)Cell defines an Excel cell addressed in reference to a row.
 *
 */
public class WriteExcel {
	
	String [] columns = {"ID", "name", "Email", "Date Of Birth", "Salary", "JoiningDate"};
	
	private static  List<Employee> employees= new ArrayList<Employee>();
	
	// Initializing employees data to insert into the excel file
	static {
		
		Calendar dateOfBirth= Calendar.getInstance();
		dateOfBirth.set(1992, 7, 21);
		employees.add(new Employee(6557767, "Rajeev", 120000.0, LocalDate.of(2018, 5, 25), dateOfBirth.getTime(), "rajeev@eample.com"));
		dateOfBirth.set(1978, 3, 8);
		employees.add(new Employee(24343434, "Steve Maiden", 1800098.0, LocalDate.now(), dateOfBirth.getTime(), "a.guindo@yahoo.fr"));
	}
	
	
	//  main of the  application
	
	public static void main(String[] args) {
		
		// create Workbook
		
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook () for generating .xls file
		
		/*
		 * CreationHelper helps us create instances of various things like DataFormat, Hyperlink, 
		 * RichTextString etc, in a format (HSSF, XSSF) independent way
		 * 
		 */
		CreationHelper creationHelper =workbook.getCreationHelper();
		// Create a sheet
		Sheet sheet =workbook.createSheet("Employee");
		// create a font for styling header cells
		Font headerFont= workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.RED.getIndex());
		headerFont.setFontHeight((short)14);
		
		
		//Create a cellStyle with the font
		
		CellStyle headerCellStyle= workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		// Create a Row
		Row headerRow = sheet.createRow(0);
		// Create cells
		
		for (int i = 0; i < columns.length; i++) {
			
			Cell cell=headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
			//Create Cell style for formatting Date
			CellStyle dateCellStyle = workbook.createCellStyle();
			dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyy-MM-dd"));
			// Create Other rows and cells with employees data
			
			int rowNum =1;
			
			for(Employee employee: employees) {
				
				Row row =sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(employee.getId());
				row.createCell(1).setCellValue(employee.getName());
				row.createCell(3).setCellValue(employee.getDateOfBirth());
				row.createCell(2).setCellValue(employee.getEmail());
				row.createCell(4).setCellValue(employee.getSalary());
				row.createCell(5).setCellValue(employee.getJoiningDate());
				// Resize all columns to fit the content size
				
				for (int j = 0; j < columns.length; j++) {
					sheet.autoSizeColumn(i);
					
				}
				
				// Write the output to a file
				
				FileOutputStream fileout = new FileOutputStream("poi-generated-file.xlsx");
				workbook.write(fileout);
				fileout.close();
			}
			
		}

	}

}
