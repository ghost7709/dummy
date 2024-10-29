package com.example.demo.service;

import com.example.demo.model.DemoModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService
{
    public List<DemoModel> readExcel(/*String filePath*/) throws IOException
    {
        List<DemoModel> inputDataList = new ArrayList<>();

        String filePath = "src/main/resources/files/Data.xlsx";
        try (var workbook = new XSSFWorkbook(new File(filePath)))
        {
            var sheet = workbook.getSheet("input");
            for (int i=1; i<=sheet.getLastRowNum(); i++)
            {
                Row row = sheet.getRow(i);
                DemoModel data = new DemoModel();
                data.setColumn1(row.getCell(0).getStringCellValue());
                data.setColumn2(row.getCell(1).getStringCellValue());
                data.setColumn3(row.getCell(2).getStringCellValue());
                data.setColumn4(row.getCell(3).getStringCellValue());

                // Read the 5th cell and split by semicolon
                String cellValue = row.getCell(4).getStringCellValue();
                List<String> values = List.of(cellValue.split(";"));
                data.setColumn5(values);

                data.setColumn6(row.getCell(5).getStringCellValue());
                data.setColumn7(row.getCell(6).getStringCellValue());
                data.setColumn8(row.getCell(7).getStringCellValue());
                data.setColumn9(row.getCell(8).getStringCellValue());
                data.setColumn10(row.getCell(9).getStringCellValue());


                inputDataList.add(data);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return inputDataList;
    }
}
