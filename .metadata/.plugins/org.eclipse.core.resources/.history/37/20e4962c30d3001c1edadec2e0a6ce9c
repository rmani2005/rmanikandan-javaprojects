package pdfValidation;

import java.io.IOException;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

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

}
