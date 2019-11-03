
import doublyLinkedList.*;

import java.io.*;
import java.util.HashMap;
import comparator.*;

public class MainDrive {
	
	private final String PATH = "/Users/singtaifung/Desktop/Conventry/PADS/q7/test.txt";
	private HashMap<Integer, List> hashMap; 
	public MainDrive() {
		hashMap = new HashMap<Integer, List>();

	}

	public static void main(String[] args) {
		try {
				MainDrive app = new MainDrive();
				app.run();		
				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void run() throws IOException {
				readFile();
				System.out.println(hashMap.toString());

		
	}
	
	private void readFile()  throws IOException {
		File file = new File(PATH);
		FileInputStream fInputStream = new FileInputStream(file);
		InputStreamReader input = new InputStreamReader(fInputStream);
		BufferedReader reader = new BufferedReader(input);
		
		String line;
		
		while ((line = reader.readLine()) != null) {
			String[] sentence = line.split("[.:!?,\\s]+");
			
			for (String word : sentence) {
				int length = word.length();

				List current;
				if((current = hashMap.get(length)) == null) {
					List newList = new List(new CompareString());
					newList.addToTail(word);
					hashMap.put(length, 
							newList);
				}else {
					current.addToTail(word);
					current.mergeSort();
				}

				
			}
		}
		reader.close();
	}

}
