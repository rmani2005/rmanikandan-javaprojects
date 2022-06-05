package com.rmani2005.pdfValidation;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.TestException;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.internal.c.a.h.internal.ms.System.IO.Path;
import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

import de.redsix.pdfcompare.*;

public class pdfMaster {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		String filePath = "/home/rocky/Desktop/DevOps/java-basic-project/MasterMani/pdfFile/Source/source.pdf";
		String targetfilePath = "/home/rocky/Desktop/DevOps/java-basic-project/MasterMani/pdfFile/target/target.pdf";
		
		String ComparefilePath = "/home/rocky/Desktop/DevOps/java-basic-project/MasterMani/pdfFile/compareResult";
		
				
		
		PDFUtil pdfUtil = new PDFUtil();
		int pageCount = pdfUtil.getPageCount(filePath); //returns the page count
		
		System.out.println("Page COunt - " + pageCount);
		
		String fileContent = pdfUtil.getText(filePath); 
		
		System.out.println("Page Content - " + fileContent);

		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		//pdfUtil.compare(filePath, targetfilePath);

		pdfUtil.highlightPdfDifference(true);
		pdfUtil.setImageDestinationPath(ComparefilePath);
		pdfUtil.compare(filePath, targetfilePath);
		 
		
		
		
		//Method two
		
		/*
		 * Comparer comparer = new Comparer(new FileInputStream("source.pdf"));
		 * comparer.add(new FileInputStream("target.pdf")); comparer.compare(new
		 * FileOutputStream("result.pdf"));
		 */
		
	}
	
	@Test(enabled=true)
	public void firstPDFTest()throws IOException 
	{
		//Current folder
		
		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir);
		String filePath = currentDir+"/pdfFile/Source/source.pdf";
		String targetfilePathwithoutFilename = currentDir+"/pdfFile/target/";
		String SourcefilePathwithoutFilename = currentDir+"/pdfFile/source/";
		String targetfilePath = currentDir+"/pdfFile/target/target.pdf";
		String ComparefilePath = currentDir+"/pdfFile/compareResult";
		String fileListExcel = currentDir + "/pdfFile/fileList.xls";
		
		String sourceFilePath = currentDir+"/pdfFile/source";
		String targetFilePath = currentDir+"/pdfFile/target";
		String sourceFinalFilePath = currentDir+"/pdfFile/sourceFinal";
		String targetFinalFilePath = currentDir+"/pdfFile/targetFinal";
		String comparefilePath = currentDir+"/pdfFile/compareResult/";
		
		boolean movingFiles=true;
		
		//Get the list of files in Source Directory
		 String[] sourcepathnames;
		 File sourceF = new File(sourceFilePath);
		 sourcepathnames = sourceF.list();
	        // For each pathname in the pathnames array
	        for (String pathname : sourcepathnames) {
	            // Print the names of files and directories
	            System.out.println(pathname);
	        }
		
		//Get the list of files in target directory
			 String[] targetpathnames;
			 File targetF = new File(targetFilePath);
			 targetpathnames = targetF.list();
		        // For each pathname in the pathnames array
		        for (String pathname : targetpathnames) {
		            // Print the names of files and directories
		            System.out.println(pathname);
		        }
			
		//If the file name is exist in the target folder

		        Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                String strDate = dateFormat.format(date);  
                System.out.println("Converted String: " + strDate);  
		        
                //Validating the folders are available which should be today()
                String tempDirectoryPath=comparefilePath + strDate;
                File tempDirectory = new File(tempDirectoryPath.toString());
                //assertTrue(tempDirectory.exists());
                
                if(!tempDirectory.exists())
                {
                
                	//creating one folder
                	File comparedirwithDateTimeName = new File(tempDirectoryPath); 
                	comparedirwithDateTimeName.mkdir();
                	
                	//do the comparision operation here
                }
                
                               
                if(sourcepathnames.length>0)
                {
                	for (String pathname : sourcepathnames) 
                	{
    		            // Print the names of files and directories
    		            System.out.println(pathname);
    		            
    			            
    			            if(targetpathnames.length>0)
    		                {
    			            	//File is exist or not
    			                try {
    			                    	//File file = new File("c:/JavaProgram/demo1.txt");
    			                		//file.createNewFile();
    			                		//System.out.println(file.exists());
    			                	    			                    
    			                    
    			                    for (String pathname1 : targetpathnames) 
        			            	{
        	    			            // Print the names of files and directories
        	    			            System.out.println(pathname1);
        	    			            
        	    			            //Main block where PDF will be valdiated
        	    			            if(pathname.equalsIgnoreCase(pathname1))
        	    		                {
        	    			            pathname=pathname.substring(0,pathname.indexOf("."));
        	    			            pathname1=pathname1.substring(0,pathname1.indexOf("."));
        	    			            
        	    			            	//Preparing the Datefolder folder strcuture for compare and store the data
        	    			              SourcefilePathwithoutFilename = sourceFilePath + "/"+ pathname + ".pdf";
      	    			         	      targetfilePathwithoutFilename = targetFilePath + "/"+ pathname1 + ".pdf";
      	    			         	      //String resultSourcefilePathwithoutFilename = sourceFinalFilePath + "//"+ strDate +"//"+ pathname + ".pdf";
      	    			         	      //String resulttargetfilePathwithoutFilename = targetFinalFilePath  + "//"+ strDate +"//"+  pathname1 + ".pdf";
      	    			         	      
      	    			         	      String resultSourcefilePathwithoutFilename = sourceFinalFilePath +"//"+ pathname + ".pdf";
      	    			         	      String resulttargetfilePathwithoutFilename = targetFinalFilePath  +"//"+  pathname1 + ".pdf";
      	    			         	      
      	    			         	      //Main Operation block
      	    			         	      
      	    			         	     String compareResultDirAndFile = tempDirectoryPath;
      	    			         	     String compareResultDifferentInText = compareResultDirAndFile + "//" + pathname + "-Differences.txt";
      	    			         	      //String ExcelReportFileName = tempDirectoryPath + "//" + pathname + ".xlsx";
      	    			         	    
      	    			         	      
        	    			            	 try {

        	    			            		PDFUtil pdfUtil = new PDFUtil();

        	    			         	       int pageCountSource = pdfUtil.getPageCount(SourcefilePathwithoutFilename); //returns the page count
        	    			         	       int pageCountTarget = pdfUtil.getPageCount(targetfilePathwithoutFilename); //returns the page count
        	    			         			
        	    			         			System.out.println(pathname + " - Source File Page Count - " + pageCountSource);
        	    			         			System.out.println(pathname1 + " - Target File Page C0unt - " + pageCountTarget);
        	    			         			
        	    			         			String sourcefileContent = pdfUtil.getText(SourcefilePathwithoutFilename); 
        	    			         			String targetfileContent = pdfUtil.getText(targetfilePathwithoutFilename);
        	    			         			
        	    			         			System.out.println(pathname + " - Source File Page Content - " + sourcefileContent);
        	    			         			System.out.println(pathname1 + " - Target File Page Content - " + targetfileContent);
        	    			         	
        	    			         			//boolean pdfhighlevelCompare = pdfUtil.compare(SourcefilePathwithoutFilename, targetfilePathwithoutFilename);
        	    			         			
        	    			         			//System.out.println("File is compared and exact match - " + pdfhighlevelCompare);
        	    			         			//String txtReportFileName = tempDirectoryPath + "//" +  pathname + "-" + pdfhighlevelCompare + ".txt";
        	    			         			  
        	    			         			 if(!pdfUtil.compare(SourcefilePathwithoutFilename, targetfilePathwithoutFilename)) {
		        	    			         			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		        	    			         			//pdfUtil.compare(filePath, targetfilePath);
		        	    			         			pdfUtil.compareAllPages(true);
		        	    			         			
		        	    			         			pdfUtil.highlightPdfDifference(true);
		        	    			         			pdfUtil.setImageDestinationPath(compareResultDirAndFile);
		        	    			         			pdfUtil.compare(SourcefilePathwithoutFilename, targetfilePathwithoutFilename);
        	    			         			 }
        	    			         			 else
        	    			         			 	{
        	    			         				pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
	        	    			         			//pdfUtil.compare(filePath, targetfilePath);
	        	    			         			pdfUtil.compareAllPages(true);
        	    			         				pdfUtil.savePdfAsImage(resultSourcefilePathwithoutFilename, 0);

        	    			         			 	}
        	    			         			
        	    			         			
	        	    			         		// compares the pdf documents and returns a boolean
	        	    			         		// true if both files have same content. false otherwise.
	        	    			         		
        	    			         			//mrthod2
		        	    			         		// Compare two PDF file using Stream
		        	    			         		//Comparer comparer = new Comparer(new FileInputStream(SourcefilePathwithoutFilename));
		        	    			         		//comparer.add(new FileInputStream(targetfilePathwithoutFilename));
		        	    			         		//comparer.compare(compareResultDirAndFile +"//" + pathname1 + "-method2.pdf");
		        	    			         		
		        	    			         		
		        	    			         			Comparer comparer = new Comparer(SourcefilePathwithoutFilename);
		        	    			         			try {
		        	    			         			    comparer.add(targetfilePathwithoutFilename);
		        	    			         			    comparer.compare(compareResultDirAndFile +"//" + pathname1 + "-method2.pdf");
		        	    			         			}
		        	    			         			finally {
		        	    			         			    comparer.dispose();
		        	    			         			}
        	    			         			
        	    			         		//Method 3
        	    			         			
        	    			         			final CompareResult result = new PdfComparator(SourcefilePathwithoutFilename, targetfilePathwithoutFilename).compare();
        	    			         			if (result.isNotEqual()) {
        	    			         			    System.out.println("Differences found!");
        	    			         			}
        	    			         			if (result.isEqual()) {
        	    			         			    System.out.println("No Differences found!");
        	    			         			}
        	    			         			if (result.hasDifferenceInExclusion()) {
        	    			         			    System.out.println("Differences in excluded areas found!");
        	    			         			}
        	    			         			System.out.println(result.getDifferences()); // returns page areas, where differences were found
        	    			        
        	    			         			
        	    			         			//Method 4:
        	    			         				File pdfFile1=new File(SourcefilePathwithoutFilename);
        	    			         				File pdfFile2=new File(targetfilePathwithoutFilename);
        	    			         				
        	    			         				Logger LOG=Logger.getLogger(this.getClass());
        	    			         			    LOG.info("Comparing PDF files ("+pdfFile1+","+pdfFile2+")");
        	    			         			    PDDocument pdf1 = PDDocument.load(pdfFile1);
        	    			         			    PDDocument pdf2 = PDDocument.load(pdfFile2);
        	    			         			    PDPageTree pdf1pages = pdf1.getDocumentCatalog().getPages();
        	    			         			    PDPageTree pdf2pages = pdf2.getDocumentCatalog().getPages();
        	    			         			    try
        	    			         			    {
        	    			         			        if (pdf1pages.getCount() != pdf2pages.getCount())
        	    			         			        {
        	    			         			            String message = "Number of pages in the files ("+pdfFile1+","+pdfFile2+") do not match. pdfFile1 has "+pdf1pages.getCount()+" no pages, while pdf2pages has "+pdf2pages.getCount()+" no of pages";
        	    			         			            LOG.debug(message);
        	    			         			            throw new TestException(message);
        	    			         			        }
        	    			         			        PDFTextStripper pdfStripper = new PDFTextStripper();
        	    			         			        LOG.debug("pdfStripper is :- " + pdfStripper);
        	    			         			        LOG.debug("pdf1pages.size() is :- " + pdf1pages.getCount());
        	    			         			        for (int i = 0; i < pdf1pages.getCount(); i++)
        	    			         			        {
        	    			         			            pdfStripper.setStartPage(i + 1);
        	    			         			            pdfStripper.setEndPage(i + 1);
        	    			         			            String pdf1PageText = pdfStripper.getText(pdf1);
        	    			         			            String pdf2PageText = pdfStripper.getText(pdf2);
        	    			         			            if (!pdf1PageText.equals(pdf2PageText))
        	    			         			            {
        	    			         			                String message = "Contents of the files ("+pdfFile1+","+pdfFile2+") do not match on Page no: " + (i + 1)+" pdf1PageText is : "+pdf1PageText+" , while pdf2PageText is : "+pdf2PageText;
        	    			         			                LOG.debug(message);
        	    			         			                System.out.println("fff");
        	    			         			                LOG.debug("pdf1PageText is " + pdf1PageText);
        	    			         			                LOG.debug("pdf2PageText is " + pdf2PageText);
        	    			         			                String difference = StringUtils.difference(pdf1PageText, pdf2PageText);
        	    			         			                
        	    			         			               try {
        	    			         			                  File myObj = new File(compareResultDifferentInText);
        	    			         			                  if (myObj.createNewFile()) {
        	    			         			                    System.out.println("File created: " + myObj.getName());
        	    			         			                  } else {
        	    			         			                    System.out.println("File already exists.");
        	    			         			                  }
        	    			         			                } catch (IOException e) {
        	    			         			                  System.out.println("An error occurred.");
        	    			         			                  e.printStackTrace();
        	    			         			                }
        	    			         			               try {
        	    			         			                  FileWriter myWriter = new FileWriter(compareResultDifferentInText);
        	    			         			                 myWriter.write(difference);
        	    			         			                 myWriter.close();
        	    			         			                 System.out.println("Successfully wrote to the file.");
        	    			         			               } catch (IOException e) {
        	    			         			                 System.out.println("An error occurred.");
        	    			         			                 e.printStackTrace();
        	    			         			               }

        	    			         			                LOG.debug("difference is "+difference);
        	    			         			                throw new TestException(message+" [[ Difference is ]] "+difference);
        	    			         			            }
        	    			         			        }
        	    			         			        LOG.info("Returning True , as PDF Files ("+pdfFile1+","+pdfFile2+") get matched");
        	    			         			    } finally {
        	    			         			        pdf1.close();
        	    			         			        pdf2.close();
        	    			         			    }
        	    			         			
        	    			         			    movingFiles=false;
        	    			         			
        	    			                 }
        	    			                 catch(Exception e)
        	    			                 {
        	    			                 	System.out.println("Error-" + e.toString());
        	    			                 }
        	    			            	 
        	    			            	 if(movingFiles) {
		        	    			            	 //Source file moving
		        	    			            	 //move the files to result folder
		        	    			            	 File file = new File(SourcefilePathwithoutFilename);
		        	    			                 // renaming the file and moving it to a new location
		        	    			                 if(file.renameTo
		        	    			                    (new File(resultSourcefilePathwithoutFilename)))
		        	    			                 {
		        	    			                     // if file copied successfully then delete the original file
		        	    			                     file.delete();
		        	    			                     System.out.println(resultSourcefilePathwithoutFilename + " - File moved successfully");
		        	    			                 }
		        	    			                 else
		        	    			                 {
		        	    			                     System.out.println(resultSourcefilePathwithoutFilename + " - Failed to move the file");
		        	    			                 }
		        	    			            	 
		        	    			                 //Target file moving
		        	    			                 //move the files to result folder
		        	    			            	 File filetarget = new File(targetfilePathwithoutFilename);
		        	    			                 // renaming the file and moving it to a new location
		        	    			                 if(filetarget.renameTo
		        	    			                    (new File(resulttargetfilePathwithoutFilename)))
		        	    			                 {
		        	    			                     // if file copied successfully then delete the original file
		        	    			                	 filetarget.delete();
		        	    			                     System.out.println(resulttargetfilePathwithoutFilename + " - File moved successfully");
		        	    			                 }
		        	    			                 else
		        	    			                 {
		        	    			                     System.out.println(resulttargetfilePathwithoutFilename + " - Failed to move the file");
		        	    			                 }
		        	    			            	 
		        	    			            	 //Save one more places in same sharepath
        	    			            	 }
        	    		                }
        	    			            
        	    			            
        			            	}
        			            	
    			                 } catch(Exception e) {
    			                    e.printStackTrace();
    			                 }
    			            	
    			            	
    		                }
    			            
    			        }
                }
                //File checking 
		        
		    
		        
		        
			//do the PDF compare process
		    //move the file to compare folder		
			//Result folder create datetime stamped folder and then create the compared the file.pdf
	
		
		//Else skip the process
		
		
		
		
	}
	
	
		
	@Test(enabled=false)
	public void firstPDFTest_old()throws IOException 
	{
		//Current folder
		
		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir);
		String filePath = currentDir+"/pdfFile/Source/source.pdf";
		String targetfilePathwithoutFilename = currentDir+"/pdfFile/target/";
		String SourcefilePathwithoutFilename = currentDir+"/pdfFile/source/";
		String targetfilePath = currentDir+"/pdfFile/target/target.pdf";
		String ComparefilePath = currentDir+"/pdfFile/compareResult";
		String fileListExcel = currentDir + "/pdfFile/fileList.xls";
		
		String sourceFilePath = currentDir+"/pdfFile/Source/";
		
		//Get the list of files in Source Directory
		
		
		//Get the list of files in target directory
		
		//If the file name is exist in the target folder

			//do the PDF compare process
		    //move the file to compare folder		
			//Result folder create datetime stamped folder and then create the compared the file.pdf
	
		
		//Else skip the process
		
		
	
		//Create an object of File class to open xlsx file
        File file = new File("E:\\TestData\\TestData.xls");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wb=new HSSFWorkbook(inputStream);
        
        //Creating a Sheet object using the sheet Name
        HSSFSheet sheet=(HSSFSheet) wb.getSheet("Sheet1");
        
        HSSFRow row2=sheet.getRow(1);
        
        for(int i=1;i<sheet.getLastRowNum();i++) {
        //Create a row object to retrieve row at index 1
      
        
        //Create a cell object to retreive cell at index 5
        HSSFCell cell=row2.getCell(0);
        
        //Get the address in a variable
        String fielName= cell.getStringCellValue();
        
        try {
	        PDFUtil pdfUtil = new PDFUtil();
			
	        int pageCount = pdfUtil.getPageCount(SourcefilePathwithoutFilename + "/" + fielName + ".pdf"); //returns the page count
			
			System.out.println("Page COunt - " + pageCount);
			
			String fileContent = pdfUtil.getText(SourcefilePathwithoutFilename + "/" + fielName + ".pdf"); 
			
			System.out.println("Page Content - " + fileContent);
	
			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
			//pdfUtil.compare(filePath, targetfilePath);
	
			pdfUtil.highlightPdfDifference(true);
			pdfUtil.setImageDestinationPath(ComparefilePath);
			pdfUtil.compare(targetfilePathwithoutFilename + "/" + fielName + ".pdf", SourcefilePathwithoutFilename + "/" + fielName + ".pdf");
        }
        catch(Exception e)
        {
        	System.out.println("Error-" + e.toString());
        }
        }
		//Method two
		
		/*
		 * Comparer comparer = new Comparer(new FileInputStream("source.pdf"));
		 * comparer.add(new FileInputStream("target.pdf")); comparer.compare(new
		 * FileOutputStream("result.pdf"));
		 */
		
	}

	

}
