package org.codes.chatGPThelpimgDownloader;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class trial {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\saksh\\Desktop\\123.html"; // Path to your local text file
        String excelFilePath="C:\\Users\\saksh\\Desktop\\output.xlsx";

        List<String> matchedStrings = extractStringsFromFile(filePath);
        List<String> UrlLink=new ArrayList<>();

        System.out.println("Matched strings:");
        for (String matchedString : matchedStrings) {
            System.out.println(matchedString);
        }

        matchedStrings.forEach(match->
        {
            StringBuilder sb= new StringBuilder();
            sb.append("https://www.wallpaperflare.com/").append(match).append("/download/1920x1080");
            UrlLink.add(sb.toString());
        });


        openInChrome(UrlLink.get(1));

        buttonClicker(UrlLink.get(1));

        //WriteDataToExcel(UrlLink,excelFilePath);
    }

    private static void buttonClicker(String s) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\\Codes\\practiced_code_All\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get(s); // Replace with the actual URL

            // Locate and click the download button
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cc-message")));
            WebElement button = driver.findElement(By.id("dld_result"));
            button.click();

            // Wait for the download to complete (this is just an example)
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void openInChrome(String link) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();

            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    URI uri = new URI(link);
                    desktop.browse(uri);
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Desktop browsing is not supported.");
            }
        } else {
            System.out.println("Desktop is not supported.");
        }
    }

    private static void WriteDataToExcel(List<String> data, String excelFilePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Matched Strings");

        int rowNum = 0;
        for (String str : data) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(str);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> extractStringsFromFile(String filePath) {
        List<String> matchedStrings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String patternStart = "href=\"https://www.wallpaperflare.com/";
            String patternEnd = "\" target=\"_blank\">";

            while ((line = reader.readLine()) != null) {
                if (line.contains(patternStart) && line.contains(patternEnd)) {
                    int startIndex = line.indexOf(patternStart) + patternStart.length();
                    int endIndex = line.indexOf(patternEnd);
                    String matchedString = line.substring(startIndex, endIndex);
                    matchedStrings.add(matchedString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchedStrings;
    }
}


