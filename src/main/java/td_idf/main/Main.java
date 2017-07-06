package td_idf.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import tf_idf.fileutil.FileProcess;
import tf_idf.fileutil.FileProcessFactory;
import ti_idf.mode.Document;
import ti_idf.mode.LogDocument;

public class Main {
 public static void main(String[] args0){
	 String filePath = "/Users/zyd/apm/hislog_operation.txt";
	 System.out.println("abc");
	 FileProcess process =  FileProcessFactory.getLogFileProcess();
	 try {
		List<LogDocument> documentList = process.getAllDocuments(filePath, Charset.forName("UTF8"));
		for(Document doc :documentList){
			List<String> list = doc.getAllWords();
			if(list==null) continue;
			for(String str:list){
				System.out.println(str);
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
