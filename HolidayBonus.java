package application;

public class HolidayBonus {
	TwoDimRaggedArrayUtility twoDim = new TwoDimRaggedArrayUtility();

	public HolidayBonus() {
	
	}

	public static double[] calculateHolidayBonus(double[][] data,
		double high, double low, double other) throws Exception {
		
		double bonus[] = new double[data.length];
		int index1, index2,maxCol = 0;

	        //for loop
	        for(int i = 0; i < data.length; i++)
	        {
	            for(int j = 0; j < data[i].length; j++)
	            {
	                if(data[i][j] <=  0)
	                {
	                    bonus[i]  += 0;
	                }
	                else if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j))
	                {
	                    bonus[i] += high;
	                }
	                else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j))
	                {
	                    bonus[i] += low;
	                }
	                else
	                {
	                    bonus[i] += other;
	                }

	            }
	        }
	        return bonus;
	    }
	

	public static double calculateTotalHolidayBonus(double[][] data,
	 double high,double low,double other) {
		double total=0;
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				 if(data[i][j] <=  0)
	                {
	                    total += 0;
	                }
	                else if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j))
	                {
	                    total += high;
	                }
	                else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j))
	                {
	                    total += low;
	                }
	                else
	                {
	                    total += other;
	                }
			}
		}
		
		return total;
	}


}
