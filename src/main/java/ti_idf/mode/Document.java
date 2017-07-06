package ti_idf.mode;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class Document {
   protected final String content;
    protected final Analyzer analyzer;
	private List<String> wordList;
	public Document(String content,Analyzer analyzer){
		this.analyzer = analyzer;
		this.content = content;
	}
  
	abstract public void setAnalysis(Analyzer analyzer);
	
	public List<String> getAllWords(){
		if(wordList==null || wordList.isEmpty()){
			wordList = analyzer.getAllWord(this);
		}
		return wordList;
	}
	
	public String getContent(){
		return content;
	}
	
	public Analyzer getAnalyzer(){
		return analyzer;
	}
  
}
