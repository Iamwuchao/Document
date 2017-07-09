package td_idf.tdutil;

import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultiset;

import ti_idf.mode.Document;
import ti_idf.mode.LogDocument;
import ti_idf.mode.TF_IDFCache;

public class TDUtil {
  public static TF_IDFCache getTD_IDF(List<LogDocument> documentList){
	  TF_IDFCache tf = new TF_IDFCache();
	  for(Document doc :documentList){
		  List<String> wordList = doc.getAllWords();
		  HashMultiset<String> multiSet = HashMultiset.create(); 
		  multiSet.addAll(wordList); 
		  for(String word:multiSet){
			 Map<String,Integer> hm = tf.getTfCache();
			 int count = 0;
			 if(hm.containsKey(word))
			     count = tf.getTfCache().get(word)+multiSet.count(word);
			 else
				 count=multiSet.count(word);
			 tf.getTfCache().put(word, count);
			 Map<String,Integer> idf = tf.getIdfCache();
			 if(idf.containsKey(word))
				 idf.put(word, idf.get(word)+1);
			 else
				 idf.put(word, 1);
		  }
	  }
	  return tf;
  }
}
