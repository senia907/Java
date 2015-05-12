package compression_algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
/**
* The full Huffman Algorithm, one function for Compressing an InPutStream and sending it to an OutPutStream,
* the other one is for DeCompressing a compressed BitSet with a Dictionary.
* @author  Senia Kalma
* @since   4/5/2015
*/

public class HuffmanAlg extends CommonCompressor {

	@Override
	public OutputStream compress(InputStream in,OutputStream out) throws IOException, ClassNotFoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder rec = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		String line;
		while((line = reader.readLine())!=null){
			rec.append(line);
			rec.append(newLine);
			line = reader.readLine();
		}
		reader.close();
		String input=rec.toString();
		//System.out.print("Original string is: "+input+" and its: "+input.length()+" chars long");
		
		HashMap<Character, Hchar> countAppearance=new HashMap<>();	//Counting each letter Appearances
		for(char c: input.toCharArray()){
			Hchar hc=countAppearance.get(c);
			if(hc==null){
				hc=new Hchar();
				hc.character=""+c;
				hc.count=0;
				countAppearance.put(c, hc);
			}
			hc.count++;
		}
		
		PriorityQueue<Hchar> pq=new PriorityQueue<Hchar>(	//Adds all the chars to a PQ by the compare func
		new Comparator<Hchar>() {
			public int compare(Hchar o1, Hchar o2) {
			return o1.count-o2.count;
			}
		});
		pq.addAll(countAppearance.values());
		
		while(pq.size()>1){		//Algorithms main loop - Building the tree
			Hchar hc0=pq.poll();
			Hchar hc1=pq.poll();
			Hchar hc2=new Hchar();
			hc2.count=hc0.count+hc1.count;
			hc2.character=hc0.character+hc1.character;
			hc2.left=hc0;
			hc2.right=hc1;
			pq.add(hc2);
		}

		DFSbinRep(pq.poll(),"");	//Call for recursive function - Adding "0" for left node and "1" for right
		
		ArrayList<CharNode> DicArr = new ArrayList<CharNode>();	//ArrayList holding CharNodes containing a char, its number of appearances and its string and bit reprasention.
		
		// now working on converting the string to bits using the Dictionary we just made.
		String stringRep="";
		
		//System.out.println("Compressed string is:");
		for(char c: input.toCharArray()){
			if(c!='\t' && c!='\r' && c!='\n'){
				//System.out.println(countAppearance.get(c).character+countAppearance.get(c).binRep);
				//System.out.print(countAppearance.get(c).binRep);
				stringRep+=countAppearance.get(c).binRep;
				CharNode CNode = new CharNode();
				CNode.ch=(countAppearance.get(c).character).charAt(0);
				CNode.bitRep=String2BitSet(countAppearance.get(c).binRep);
				CNode.appr=countAppearance.get(c).count;
				DicArr.add(CNode);
			}
		}
		//System.out.println("");
	    /*System.out.print("Our BitSet is:");
	    for(int i=0;i<stringRep.length();i++){
	    	if(i%220==0)
	    		System.out.println("");
	    	System.out.print(stringRep.charAt(i));
	    }
	    System.out.println("");*/
		//We worked with string till here, yet it isn't efficient, so we will convert and send a BitSet
		BitSet bits = new BitSet();
		bits=String2BitSet(stringRep);		//Converting stringRep to a BitSet(Rep) - <2>
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		//We will sort our Dictionary, for fast finding the most common characters
		Collections.sort(DicArr, new Comparator<CharNode>(){
			@Override
			public int compare(CharNode w0, CharNode w1) {
				return (w1.appr)-(w0.appr);
			}
		});
		//Clearing all duplications NEW
		/*for(int i=0;i<DicArr.size()-1;i++){
			for(int j=0;j<DicArr.size();j++){
				if(DicArr.get(i).ch==(DicArr.get((j)).ch))
					DicArr.remove(j);
			}

		}*/
		for(int j=0;j<DicArr.size()-1;j++){
			for(int i=0;i<DicArr.size()-1;i++){
				if(DicArr.get(i).ch==(DicArr.get((i+1)).ch))
						DicArr.remove(i+1);
			}
		}
		
		//
		
		out2.writeObject(DicArr);		//Writing the Dictionary
		out2.writeObject(bits);			//Writing the BitSet
		out2.flush();
		out2.close();
		
		return out;
	}	//Compress close
	
	private BitSet String2BitSet(String string) {
		BitSet bits = new BitSet();
		bits.set((string.length()+1));	//LAST BIT=TRUE AS A PLACE HOLDER (!!!) - NOT PART OF THE ORIGINAL STRING
		for(int i=0;i<string.length();i++){
			if(string.substring(i, (i+1)).equals("1")){
				bits.set(i, true);
			}
			else
				bits.set(i, false);
		}
		return bits;
	}
	
	private String BitSet2String(BitSet bits) {
		String string = null;
		
		for(int i=0;i<bits.length()-1;i++){		//LAST BIT=TRUE AS A PLACE HOLDER (!!!) - NOT PART OF THE ORIGINAL STRING
			if(bits.get(i)==true)
				string+="1";
			else
				string+="0";
		}
		return string;
	}

	private void DFSbinRep(Hchar node,String bin) {	
		node.binRep+=bin;
		if(node.left!=null){
			DFSbinRep(node.left, node.binRep+"0");
		}
		if(node.right!=null){
			DFSbinRep(node.right, node.binRep+"1");
		}
	}
	

	@Override
	public OutputStream deCompress(InputStream in,OutputStream out) throws IOException, ClassNotFoundException {
		ArrayList<CharNode> DicArr;
		ObjectInputStream mIn = new ObjectInputStream(in);
		DicArr = (ArrayList<CharNode>) mIn.readObject();	//ArrayList holding CharNodes as the Dictionary
		BitSet bits = new BitSet();
		bits = (BitSet) mIn.readObject();
	    
	    int ComIndex=0;		//Index of the already processed data.
	    String readString = "";
	    String deCom = "";	//Processed string(Chars..)
	    for(int i=0;i<(bits.length()-1);i++){	//Remember that the last bit=true as a place holder and its not a part of the "real" string
	    	if(bits.get(i)==true)
	    		readString+="1";
	    	else
	    		readString+="0";
	    		Iterator<CharNode> iter = DicArr.iterator();
	    		while(iter.hasNext()){
	    			CharNode CNode = iter.next();
	    			String temp="";
	    			for(int j=0;j<CNode.bitRep.length()-2;j++){
	    				if(CNode.bitRep.get(j)==true)
	    					temp+="1";
	    				else
	    					temp+="0";
	    			}
	    			if(temp.equals((readString.substring(ComIndex, i)))){
	    				deCom+=CNode.ch;
	    				ComIndex=i;
	    			}
	    		}
	    }
	    mIn.close();
	    //System.out.println("Our Huffman Dictionary is:");
	    //System.out.println(DicArr);
	    /*System.out.print("Our BitSet is:");
	    for(int i=0;i<readString.length();i++){
	    	if(i%220==0)
	    		System.out.println("");
	    	System.out.print(readString.charAt(i));
	    }
	    System.out.println("");*/

		//We worked with string till here, yet it isn't efficient, so we will convert and send a BitSet
	    //System.out.println("Converted string is: \n"+deCom);
	    OutputStreamWriter out2 = new OutputStreamWriter(out);
	    out2.write(deCom);
		out2.flush();
	    out2.close();
		return out;
		}
}
