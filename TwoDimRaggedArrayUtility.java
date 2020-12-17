package application;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility {
	String holidayFile;
	public TwoDimRaggedArrayUtility(){
		
	}
	
	public static double getAverage(double[][] data) {
		double total=0;
		int counter= 0;
		for(int j = 0; j<data.length; j++) {
			for(int i=0; i<data[j].length; i++) {
			total+=data[j][i];
			counter++;
			}		
		}
		return total/counter;
	}
	
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				if(data[i][j]>highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}
	
	
	public static double getHighestInColumn(double[][] data, int col) {
		int index = getHighestInColumnIndex(data, col);
		
		return data[index][col];
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int maxIndex=0;
		
		for (int i = 0; i < data.length; i++) {
			  if (data[i].length > col) {
			    maxIndex = i;
			    break;
			   }
			}
		
		for(int j=0; j<data.length; j++){ 
			if(data[j].length > col){
			if(data[j][col] > data[maxIndex][col]) {
				maxIndex=j;
			}
			}
		}
		return maxIndex;
		
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for(int i=0; i<data[row].length; i++) {
			if(data[row][i] > highest) {
				highest = data[row][i];
			}
		}
	return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = 0;
		double highest = data[row][0];
			for(int i=0; i<data[row].length; i++) {
				if(data[row][i] > highest) {
					index = i;
				}
			}
		return index;
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				if(data[i][j]<lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
	
	static public double getLowestInColumn(double data[][], int col)
    {
		int lowestIndex=0;
		for (int i = 0; i < data.length; i++) {
			  if (data[i].length > col) {
			   lowestIndex = i;
			    break;
			   }
			}
        double colHigh = data[lowestIndex][col];
        //for loop only goes through one column
        for(int row = 0; row < data.length; row++)
        {
            //if the index of the column is less or equal to the length of array -1
            if (col <= data[row].length-1)
            {
                if(data[row][col] < colHigh)
                {
                    colHigh = data[row][col];
                }
            }
        }
        return colHigh;
    }
	
	
	
	/*public static double getLowestInColumn(double[][] data, int col) {
		int index = getLowestInColumnIndex(data, col);
		
		return data[index][col];
	}*/
	
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lowestIndex=0;
		
		for (int i = 0; i < data.length; i++) {
			  if (data[i].length > col) {
			    lowestIndex = i;
			    break;
			   }
			}
		
		for(int j=0; j<data.length; j++){ 
			if(data[j].length > col){
			if(data[j][col] < data[lowestIndex][col]) {
				lowestIndex=j;
			}
			}
		}
		return lowestIndex;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for(int i=0; i<data[row].length; i++) {
			if(data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		double lowest = data[row][0];
			for(int i=0; i<data[row].length; i++) {
				if(data[row][i] <= lowest) {
					index = i;
					 lowest = data[row][i];
				}
			}
		return index;		
	}
	
	
	public static double getRowTotal(double[][] data, int row) {
		double total=0;
		
		for(int i = 0; i<data[row].length; i++) {
				total += data[row][i];
		}
		
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double total=0;
		
		for(int j = 0; j<data.length; j++) {
			if(data[j].length > col){
			total+=data[j][col];	
			}
		else 
			continue;
		}
		return total;
	}
	
	public static double getTotal(double[][] data) {
		double total=0;
		
			for(int j = 0; j<data.length; j++) {
				for(int i=0; i<data[j].length; i++) {
				total+=data[j][i];
				}		
			}
			return total;
	}
	
	
	
	public static void writeToFile(double[][] data, java.io.File outputFile)throws IOException {
		//file = new FileWriter("Holidays.txt");
		FileWriter writer = new FileWriter(outputFile);
		PrintWriter file = new PrintWriter(writer);
			for(int i=0; i<data.length; i++) {
				for(int j=0; j<data[i].length; j++) {
				file.print(Double.toString(data[i][j]) + " ");
				}
				file.println();
			}
			file.close();
		}
	
	
	
	public static double[][] readFile(java.io.File file) throws FileNotFoundException{
		//file = new File("dataSet1.txt");
		Scanner s = new Scanner(file);
		String[] temp = new String[10];
		int rows=0, columns = 0;
		String numbers = "";
		while(s.hasNextLine()) {
			if(s.nextLine() != null) {
				rows++;
			}
		}
		
		double[][] data = new double[rows][];
		s.close();
		
		s = new Scanner(file);
		
		for(int i=0; i<rows; i++) {
		String[] column = s.nextLine().split(" ");
		double[] data2 = new double[column.length];
		for(int j=0; j<column.length; j++) {
			data2[j] = Double.parseDouble(column[j]);
		}
		data[i] = data2;
		}
		s.close();
		return data;
		
		
	}
}		