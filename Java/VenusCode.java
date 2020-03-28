import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

class VenusCode{
	private int maxColumn;
	public static void main(String[] args) {
		VenusCode test= new VenusCode();
		System.out.print(test.encode(args[0]));
	}
	public VenusCode(){
		setMaxColumn(7);//default
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
			//if maxColumn is too large for input string, cut input in half.
			maxColumn=inputString.length()/2+1;
		}
		int rawCount=inputString.length()/maxColumn+1;

		for (int i=0;i<rawCount;i++) {
			for (int j=0; j<maxColumn; j++) {
				int charIndex=i+j*rawCount;
				if (charIndex<inputString.length()) {
					char theChar=inputString.charAt(charIndex);
					outputString+=theChar;
					if(theChar < 127){outputString+=" ";} //additional space for half-full
					outputString+=" ";
				}
			}
			outputString+="\n"; //End of this line.
		}

		return outputString;
	}
	//public String decode(String inputString){}
}

