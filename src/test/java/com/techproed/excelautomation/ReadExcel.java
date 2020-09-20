package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {

        String dosyaAdresi="src\\test\\resources\\ULKELER.xlsx";
        //JAVA'da herhangi bir dosyanin acilmasi icin ,FilInputStream
        //class'indan bir tane nesne olusturulur. ve parametre olarak,
        //acilmak istenen dosyanin adresi eklenir.
        FileInputStream fileInputStream= new FileInputStream(dosyaAdresi);

        //Excel dosyasini okumak icin workbook kullaniyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Excel   == Workbook
        //Sayfa   == Sheet
        //Satır   == Row
        //Hücre   == Cell

        //SAYFA (sheet) SECIMI (index 0'dan basliyor)
        Sheet sayfa1= workbook.getSheetAt(0);

        //SATIR (row) SEÇİMİ (index 0'dan başlıyor )
        Row satir1 = workbook.getSheetAt(0).getRow(0); //Row satir1 = sayfa1.getRow(0);
        //HÜCRE (cell) SEÇİMİ (index 0'dan başlıyor )
        Cell satir1hucre1 = workbook.getSheetAt(0).getRow(0).getCell(0); // satir1.getCell(0);
        System.out.println(satir1hucre1);

        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(1));

        int lastRowNum = workbook.getSheetAt(0).getLastRowNum();

        //Tum Ulkeler sutununu ekrana yazdirdik
        for(int i=0; i<lastRowNum; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        System.out.println();

        for(int i = 0; i<lastRowNum; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }
        System.out.println();

        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        //Belirli bir satirdaki tum hucreleri yazdirir
        for(int k=0; k<sonSutunIndex; k++){
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(k));
        }





        //Excel dosyasini kapatmak icin bu methodlari kullaniyoruz
        workbook.close();
        fileInputStream.close();


    }
}
