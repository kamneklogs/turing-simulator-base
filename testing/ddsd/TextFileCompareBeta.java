import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileCompareBeta {
	public static final String TEXT_ONE_PATH = "data/binarySearchQueriesOutputV1.txt";
	public static final String TEXT_ANOTHER_PATH = "data/binarySearchQueriesOutputV1_MyOutput.txt";
	public static final String DIFFERENCES_DETAIL_PATH = "data/DETAIL_OUTPUT_COMPARISON.txt";
	

	public static void main(String[] args) throws IOException {
		BufferedReader br1 = new BufferedReader(new FileReader(TEXT_ONE_PATH));
		BufferedReader br2 = new BufferedReader(new FileReader(TEXT_ANOTHER_PATH));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(DIFFERENCES_DETAIL_PATH));
		
		System.out.println("COMPARING THESE FILES:");
		bw.write("COMPARING THESE FILES:\n");
		System.out.println("=> FILE 1: "+TEXT_ONE_PATH);
		bw.write("=> FILE 1: "+TEXT_ONE_PATH+"\n");
		System.out.println("=> FILE 2: "+TEXT_ANOTHER_PATH);
		bw.write("=> FILE 2: "+TEXT_ANOTHER_PATH+"\n");
		
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		boolean equals = true;
		int line = 1;
		int differences = 0;
		
		while(line1!=null && line2!=null) {
			if(!line1.equals(line2)) {
				equals = false;
				differences++;
				bw.write("LINE "+line+": DIFFERENCES FOUND!\n");
				bw.write("-> FILE 1: '"+line1+"'\n");
				bw.write("-> FILE 2: '"+line2+"'\n");
			}
			
			line1 = br1.readLine();
			line2 = br2.readLine();
			line++;
		}
		
		System.out.println(line+" LINES WERE COMPARED.");
		bw.write(line+" LINES WERE COMPARED.\n");
		
		if(!equals) {
			System.out.println("THE FILES ARE NOT EQUALS. "+differences+" DIFFERENCES WERE FOUND!!");
			bw.write(line+" LINES WERE COMPARED.\n");
		}else if(line1!=null || line2!=null){
			System.out.println("THE FILES HAVE NOT THE SAME LINES NUMBER");
			bw.write("THE FILES HAVE NOT THE SAME LINES NUMBER\n");
		}else {
			System.out.println("THE FILES ARE EQUALS");
			bw.write("THE FILES ARE EQUALS\n");
		}
		
		br1.close();
		br2.close();
		bw.close();
	}

}
