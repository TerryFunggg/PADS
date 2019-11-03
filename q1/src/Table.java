

/**
 * @author Terry Fung
 * @since 23-10-2019
 */

public class Table {
		private final int ROWS = 3;						// Set the number of rows
		private final String C1 = "n*(n-1)/2";
		private final String C2 = "2*n+26";
		private int[] maxLengthOfCols; 					// Store the max length of field in each column
		private String[][] table;						// Using 2d array store the data to represent the table
		private int tableWidth;							// The total width of table
		
		public Table(String[] args) {
			table = new String[ROWS][args.length + 1];
			maxLengthOfCols = new int[args.length + 1];
			tableWidth = 0;
			init(args);
		}
		
		public String print() {
			return formatTable();
		}
		
		public  double c1(double n) {
			return n * ((n - 1)/2);
		}
		
		public  double c2(double n) {
			return 2 * n + 26;
		}
		
		//==== Private function ====
		
		private void init(String[] args) {
			table[0][0] = "";
			table[1][0] = C1;
			table[2][0] = C2;
			for (int i = 0; i < args.length; i++) {
				table[0][i+1] = args[i];
				table[1][i+1] = c1(Double.parseDouble((args[i]))) +"" ;
				table[2][i+1] = c2(Double.parseDouble((args[i]))) +"" ;		
			}	
			
			// find the total length of field for each rows  && sum all the max length of field column in each row
			int max = 0;
			for (int i = 0; i < table[0].length; i++) {
				for (int j = 0; j < table.length; j++) {
					 max = table[j][i].length() > max ? table[j][i].length() : max;		
				}
				tableWidth += maxLengthOfCols[i] = max;
				max = 0;
			}
		}
			
		private String formatTable() {
			String result = "";
			String drawLine = drawLine();
			
			for (int i = 0; i < table.length; i++) { // table rows
				for (int j = 0; j < table[0].length; j++) { // table column
					result += addSpace(maxLengthOfCols[j], table[i][j].length());
					result += table[i][j] + "|"; //add data
				}
				result +=  "\r\n" +drawLine + "\r\n"; // add Line
			}	
			
			return result; 
		}
		
		
		private String drawLine() {
			String l  = "";

			// the numbers of "|" are equal to numbers of n.
			for (int i = 0; i < tableWidth + maxLengthOfCols.length; i++) {
				l += "-";
			}		
			return l;
		}
		
		private String addSpace(int maxFieldLength , int currentFieldLength) {
			String result = "";
			int space = maxFieldLength -  currentFieldLength; // 
			for (int k = 0; k <space; k++) {
					result += " ";
			}
			return result;
		}
}
