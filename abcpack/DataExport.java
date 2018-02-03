package abcpack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.annotations.*;

public class DataExport {
	@Test
	public void testDataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("F:\\Selenium_Scripts_Oct14\\ABCBank\\Results\\DataExport.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("Results", 0);
		WritableSheet ws1=wwb.createSheet("Reports", 1);
		Label l1=new Label(0,0,"RFT");
		Label l2=new Label(0,1,"QTP");
		Label l3=new Label(0,2,"Sahi");
		Label l4=new Label(0,3,"Selenium");
		ws.addCell(l4);
		ws.addCell(l1);
		//ws.addCell(l2);
		ws.addCell(l3);
		wwb.write();
		wwb.close();
	}

}
