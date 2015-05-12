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

/**
* Class that extends CommonCompressor(implements Compressor) that used to compress and deCompress data by saving
* the index(s) of the word.
* @author  Senia Kalma
* @since   4/5/2015
*/
public class WordDictionary	extends CommonCompressor {

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
		String input=rec.toString();
		//System.out.println("Original string is: "+input+" and its: "+input.length()+" chars long\n");
		//Start
		ZippedDir dict = new ZippedDir();
		String[] sp = input.split(" ");
		
		for (int i = 0; i < sp.length; i++){
			String word = sp[i];
			ArrayList<Integer> indices;
			if (dict.containsKey(word))
				indices = dict.get(word);
			else
				indices = new ArrayList<Integer>();
			indices.add(i);
			dict.put(word, indices);
		}		
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		//System.out.println("ZippedDir made by WordDictionary: ");
		//System.out.println(dict);
			out2.writeObject(dict);
			out2.flush();
			out2.close();
		
		return out;
	}

	@Override
	public OutputStream deCompress(InputStream in,OutputStream out) throws ClassNotFoundException, IOException {
		ZippedDir input;
		ObjectInputStream mIn = new ObjectInputStream(in);
		input = (ZippedDir) mIn.readObject();
		//System.out.println("Recieved data is:");
		//System.out.println(input);
		//Start..
		String temp="";
		for (String word: input.keySet()){
			temp+=(word + ":");
			ArrayList<Integer> indices = input.get(word);
			int more1=0;
			for (int index : indices){
				if(more1>0)
					temp+=",";
				temp+=(index);
				more1++;
			}
			temp+="<";
			temp+="\n";
		}
		String fin="";
		
		String[] inter = temp.split("<");	// Containing a STRIBG: word:in1,in2,in3..
		int count=0;
		for(int k=0;k<inter.length-1;k++){
			for(int i=0;i<inter.length-1;i++){
				String[] inside = inter[i].split(":");	//inside[i]=line(i) = word:in1,in2..
				if(inside[1].contains(",")){
					String occur[] = inside[1].split(",");
					for(int j=0;j<occur.length;j++){
						int now =Integer.parseInt(occur[j]);
						if(now==count){
							fin+=inside[0]+" ";
							count++;
							i=0;
							k=0;
						}
					}
					fin+="\n";
				}
				else{
					int now =Integer.parseInt(inside[1]);
					if(now==count){
						fin+=inside[0]+" ";
						count++;
						i=0;
						k=0;
					}
				}
			}	//Big for
			
		}//biggest for
		
		String rfin=fin.replace("\n", "");
		//System.out.println("Decompressed string is: ");
		//System.out.println(rfin);

		/*ObjectOutputStream out2 = new ObjectOutputStream(out);
		out2.writeObject(fin);		//Writing the string to the outputStream we got
		out2.flush();
		out2.close();*/
	    OutputStreamWriter out2 = new OutputStreamWriter(out);
	    out2.write(rfin);
		out2.flush();
	    out2.close();
	    
		return out;
	}

}
