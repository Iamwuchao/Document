package ti_idf.mode;

import java.util.List;

import com.google.common.collect.HashMultiset;

public abstract class Document {
   protected final String content;
   protected final Analyzer analyzer;
   private  HashMultiset<String> wordsMultiset;
	public Document(String content,Analyzer analyzer){
		this.analyzer = analyzer;
		this.content = content;
	}
 
	
	public HashMultiset<String> getAllWords(){
		if(wordsMultiset==null || wordsMultiset.isEmpty()){
			wordsMultiset = HashMultiset.create();
			wordsMultiset.addAll(analyzer.getAllWord(this));
		}
		return wordsMultiset;
	}
	
	public String getContent(){
		return content;
	}
	
	public Analyzer getAnalyzer(){
		return analyzer;
	}
  
}
