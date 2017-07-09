package td_idf.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

import td_idf.tdutil.TDUtil;
import tf_idf.fileutil.FileProcess;
import tf_idf.fileutil.FileProcessFactory;
import ti_idf.mode.Document;
import ti_idf.mode.LogDocument;
import ti_idf.mode.TFIDF;
import ti_idf.mode.TF_IDFCache;

public class Main {
 public static void main(String[] args0){
	 String filePath = "/Users/zyd/apm/hislog_message.txt";
	 System.out.println("abc");
	 FileProcess process =  FileProcessFactory.getLogFileProcess();
	 try {
		List<LogDocument> documentList = process.getAllDocuments(filePath, Charsets.UTF_8);
		System.out.println("DocumentList : "+documentList.size());
		int docSize = documentList.size();
		TF_IDFCache tf_idf = TDUtil.getTD_IDF(documentList);
		List<TFIDF> list = Lists.newLinkedList();
		Map<String,Integer> tf=tf_idf.getTfCache();
		Map<String,Integer> idf =tf_idf.getIdfCache();
		Set<String> wordsSet = tf.keySet();
		for(String word:wordsSet){
			//System.out.println(word+"@@@@ "+tf.get(word));
			
			double value = tf.get(word);//(1.0*idf.get(word));
			list.add(new TFIDF(word,value));
		}
		
		Collections.sort(list);
		int i=0;
		for(TFIDF tt:list){
			
			if(tt.getValue()<docSize && tt.getWord().length()>1)
			{
				i++;
				System.out.println(tt.getWord()+" : "+tt.getValue());
			}
			if(i>100) break;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
