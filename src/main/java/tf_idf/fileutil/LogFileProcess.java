package tf_idf.fileutil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import ti_idf.mode.Analyzer;
import ti_idf.mode.AnalyzerFactory;
import ti_idf.mode.DocumentFactory;
import ti_idf.mode.LogDocument;

public class LogFileProcess implements FileProcess{

	public List<LogDocument> getAllDocuments(String path,Charset charset) throws IOException {
		File file = new File(path);
		System.out.println("####");
		if(!file.exists()) return new LinkedList<LogDocument>();
		System.out.println("$$$$$$");
		List<String> stringList = Files.readLines(file, charset);
		List<LogDocument> documentList = Lists.newLinkedList();
		stringList.forEach((String content)->{
			documentList.add(DocumentFactory.getLogDocument(content, AnalyzerFactory.getLogFileAnalyzer()));
		});
		return documentList;
	}
	
	

}
