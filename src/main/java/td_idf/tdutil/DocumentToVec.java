package td_idf.tdutil;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

import ti_idf.mode.Document;
import ti_idf.mode.Vector;

public class DocumentToVec {
   public static List<Vector> logDoc2Vec(HashMap<String,Document> docMap,List<String> keyWordsList){
	   List<Vector> vectorList = Lists.newLinkedList();
	   Set<String> keySet =  docMap.keySet();
	   for(String docId:keySet){
		   Document doc = docMap.get(docId);
		   HashMultiset<String> wordsMset = doc.getAllWords();
		   if(wordsMset==null || wordsMset.isEmpty()) continue;
		   Vector vec = new Vector();
		   keyWordsList.forEach((word)->{
			   if(wordsMset.contains(word)){
				   vec.getVector().add((double) wordsMset.count(word));
			   }
			   else
				   vec.getVector().add(0.0);
		   });
		   vec.setDocId(docId);
		   vectorList.add(vec);
	   }
	   return vectorList;
   }
}
