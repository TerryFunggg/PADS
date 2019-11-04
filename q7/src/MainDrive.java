
import doublyLinkedList.*;

import java.io.*;
import java.util.HashMap;
import comparator.*;

public class MainDrive {
	
	private final String PATH =  "./"
			+ "test.txt";
	private HashMap<Integer, List> hashMap;  // key is length of the word , V is doubly Linked list
	
	public MainDrive() {
		hashMap = new HashMap<Integer, List>();
	}

	public static void main(String[] args) {
		try {
				 new MainDrive().run();
	
		} catch (EmptyComparatorException e) {
			System.out.println(e.getMessage());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void run() throws IOException, EmptyComparatorException {
		// Read File
		File file = new File(PATH);
		FileInputStream fInputStream = new FileInputStream(file);
		InputStreamReader input = new InputStreamReader(fInputStream);
		BufferedReader reader = new BufferedReader(input);
		
		String line;
		int count = 0;
		while ((line = reader.readLine()) != null) {
			// Split sentences using regular expression
			String[] sentence = line.split("[.:!?,\\s]+");
			// For each word
			for (String word : sentence) {
				count++;
				// get the length of the word
				int length = word.length();

				List current;
				//if hasMap.get() return null , we should create a new list for new key length 
				// else it will return the list which belong with the key length.
				if((current = hashMap.get(length)) == null) {
					//cause there no key length in the map , so create new key and list.
					List newList = new List(new CompareString());
					//put the current word into the list
					newList.addToTail(word);
					hashMap.put(length,newList);
				}else {
					//the key length already in the map,so just add the word to same length of the list.
					current.addToTail(word);
				}	
			}
		}
		reader.close();
		
		int size = 0;
		// implement the DoublyLinked list to alphabetical order
		for (Integer key : hashMap.keySet()) {
			// using key to get the list
			List current = hashMap.get(key);
			current.mergeSort();
			size += current.getSize();
		}
		System.out.println(hashMap.toString());
		System.out.println("Total words from input file: " + count + "\r\nTotal words from DoublyList: " + size);

		
	}
	
	

}
