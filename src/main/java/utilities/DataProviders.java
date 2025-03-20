package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        // Taking Excel file from test data
    	String path = ".\\testData\\Opencart123\\testData.xlsx";
    	
    	
        // Creating an object for ExcelUtility
        Excelutils xlutil = new Excelutils(path);

        int totalRows = xlutil.getRowCount("Sheet1");
        int totalCols = xlutil.getCellCount("Sheet1", 1);

        // Creating a two-dimensional array to store Excel data
        String loginData[][] = new String[totalRows][totalCols];

        // Reading data from Excel and storing it in a two-dimensional array
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return loginData; // Returning the two-dimensional array
    }
}

//dataprovider 2

//dataprovider 3