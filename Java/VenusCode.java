class VenusCode{
	private int maxColumn;
	public static void main(String[] args) {
		//Usage:
		//	1. Instantiate it;
		VenusCode test= new VenusCode();
		//	2. Simply pass a String to its .encode() method and it will return a modified string;
		System.out.print(test.encode(args[0]));
		//	3. You can change the maximum column if you like;
		test.setMaxColumn(5);
	}
	public VenusCode(){
		setMaxColumn(7);//default value;
	}
	public VenusCode(int maxColumn_new){
		setMaxColumn(maxColumn_new);
	}
	public void setMaxColumn(int maxColumn_new){
		maxColumn=maxColumn_new;
	}
	public int getMaxColumn(){
		return maxColumn;
	}
	public String encode(String inputString){
		String outputString="";
		if (inputString.length()<=maxColumn) {
			//if maxColumn is too large for input string;
			maxColumn=inputString.length()/2+1;
		}
		if (maxColumn<=0) {
			maxColumn=1; //minimum column is 1;
		}
		int rawCount=inputString.length()/maxColumn+1;

		for (int i=0;i<rawCount;i++) {
			for (int j=0; j<maxColumn; j++) {
				//Taking out characters by given interval to form a line;
				int charIndex=i+j*rawCount; 
				if (charIndex<inputString.length()) {
					char theChar=inputString.charAt(charIndex);
					outputString+=theChar;
					if(theChar < 127){outputString+=" ";}
					//additional space for half-full to keep output tidy;
					outputString+=" ";//Space between columns;
				}
			}
			outputString+="\n"; //End of this line;
		}

		return outputString;
	}
	//public String decode(String inputString){}
}

