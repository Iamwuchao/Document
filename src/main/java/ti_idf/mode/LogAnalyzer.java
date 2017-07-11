package ti_idf.mode;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import tf_idf.fileutil.CharUtil;

public class LogAnalyzer implements Analyzer{

	public List<String> getAllWord(Document document){
		List<String> wordsList = Lists.newLinkedList();
		IKAnalyzer analyzer = new IKAnalyzer();
		analyzer.setUseSmart(true);
		String content = document.getContent();
		//System.out.println("content"+content);
		StringReader reader = new StringReader(content);
		try {
			TokenStream ts = analyzer.tokenStream("", reader);
			CharTermAttribute term = ts.getAttribute(CharTermAttribute.class); 
			ts.reset();
			while(ts.incrementToken()){
				wordsList.add(term.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		analyzer.close();
		reader.close();
		}
		getSpecialCharacter(document,wordsList);
		return wordsList;
	}

	
	
	private void getSpecialCharacter(Document document,List<String> wordList){
		String content = document.getContent();
		Set<String> wordsSet = Sets.newHashSet();
		wordsSet.addAll(wordList);
		for(int i=0;i<content.length();i++){
			char ch = content.charAt(i);
			if(wordsSet.contains(String.valueOf(ch))) continue;
			if(CharUtil.isChinesePunctuation(ch))
			{
				wordList.add(String.valueOf(ch));
			}
			else if(CharUtil.isENPunctuation(ch))
			{
				wordList.add(String.valueOf(ch));
			}
		}
	}
}
