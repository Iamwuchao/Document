package ti_idf.mode;

public class TFIDF implements Comparable<TFIDF> {
	private String word;
	private double value;
	
	public TFIDF(String word,double value){
		this.word = word;
		this.value = value;
	}
	
	@Override
	public int compareTo(TFIDF tdidf) {
		
		if(this.value == tdidf.value)
			return 0;
		return this.value>tdidf.value?-1:1;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	

}
