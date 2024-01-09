package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Constents.Constent;

public class Utility extends Constent {
	
	
public static void Read_Properties() throws IOException {
		
		
		FileInputStream file = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Project_TestNG\\src\\test\\resources\\Properties\\Data.properties");
		
		Properties pro = new Properties();
		
		pro.load(file);
		Constent.Url =pro.getProperty("url");
		Constent.Name =pro.getProperty("browser");
		Constent.Browser_Path =pro.getProperty("browserPath");
		Constent.UserName =pro.getProperty("username");
		Constent.Password =pro.getProperty("password");
		Constent.Category =pro.getProperty("category");
		Constent.Product_Name =pro.getProperty("productname");
		Constent.Searchproduct =pro.getProperty("searchproduct");
		Constent.DressProduct =pro.getProperty("dressproduct");
		Constent.Menuoption =pro.getProperty("Menuoption");
		Constent.Winterproduct =pro.getProperty("Winterproduct");
		Constent.Sweatshirt =pro.getProperty("Sweatshirt");
		Constent.ReportPath=pro.getProperty("ReportPath");
		Constent.AccountName=pro.getProperty("accountname");
		Constent.secondcategory =pro.getProperty("secondcategory");
		Constent.Nightsuite= pro.getProperty("nightsuite");
		Constent.FilterOption = pro.getProperty("Filterproduct");
		
	}

}
