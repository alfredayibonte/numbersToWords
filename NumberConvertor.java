import java.util.Scanner;
public class NumberConvertor {

		private static final int FIRST = 0;
		private static final int LAST = 1;
		private static  int[] FIRST_AND_LAST_NUMBERS= new int[2];
		
		 static String[] texts = { "one", "two", "three", "four", "five",
	     		"six", "seven", "eight", "nine", "ten", "eleven",
	     		"twelve", "thirteen", "fourteen", "fifteen", "sixteen",
	     		"seventeen", "eighteen", "nineteen", "twenty", "thirty",
	     		"fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		 private static final String[] hundredToQuintillionText = {
			 "",
		        "thousand",
		        "million",
		        "billion",
		        "trillion",
		        "quadrillion",
		        "quintillion"
		    };

		/**
		 * @param args
		 */
		public static void main(String[] args) {
	       System.out.println("please enter number: \n");
	       Scanner scan = new Scanner(System.in);
	       int number = scan.nextInt();
	       scan.close();
	       String answer = (number==0? "Zero": outPut(number));
	       System.out.println(answer);

		}
		
		
		public static String outPut(int n){
			
	        if (n < 0) {
	            n = -n;
	            return "negative "+ outPut(n);
	        }

			switch((String.valueOf(n)).length()){
			case 1:
				return texts[n-1];
			case 2:
				if(n>=10 && n<=20){
					return texts[n-1];
				}else if(n == 30){
					return texts[n-10];
				}else if(n == 40){
					return texts[n-19];
				}else if(n == 50){
					return texts[n-28];
				}else if( n == 60){ return texts[n-37];}
				else if( n == 70){return texts[n-46];}
				else if(n == 80){return texts[n-55];}
				else if( n == 90){return texts[n-64];}
				else{
					String number = String.valueOf(n);
					int frontNumber = Integer.parseInt(number.substring(0,1)+"0");
					int lastNumber = Integer.parseInt(number.substring(1));
					return outPut(frontNumber)+" "+outPut(lastNumber);		
				}
			case 3:
				FIRST_AND_LAST_NUMBERS = getFrontAndLastNumbers(n);
				if(n<=999 && n>99)
				{
					if( n%100 == 0)return outPut(FIRST_AND_LAST_NUMBERS[FIRST])+
							" "+ "hundred";
					return outPut(FIRST_AND_LAST_NUMBERS[FIRST])+
							" "+"hundred"+" and "+outPut(FIRST_AND_LAST_NUMBERS[LAST]);	
				}
				
			 default:
				return outPutAboveNinetyNine(n);
				
			
			}
			
			
			
		}
		
		public static String outPutAboveNinetyNine(int n){
			
			if (n == 0) { return "zero"; }
	        
	          
	        if (n < 0) {
	            n = -n;
	            return "negative "+outPutAboveNinetyNine(n);
	        }
	        
	        String answer = "";
	        int temp = 0;
	       
	        
	        while(true) {
	            int number = n % 1000;
	            if (number != 0){
	            	            	
	            	String s = outPut(number);         	
	                answer = s+ " "+hundredToQuintillionText[temp]+" " +showAnd(answer)+answer;
	            }
	            temp++;
	            n /= 1000;
	            if(n <= 0) break;
	        } 
	        

	      
	        return answer;
				
	
			
			
		}
	
		public static int[] getFrontAndLastNumbers(int n){
			String number = String.valueOf(n);
			int frontNumber = Integer.parseInt(number.substring(0,1));
			int lastNumber = Integer.parseInt(number.substring(1));
			int firstAndLast[] = {frontNumber, lastNumber};
			return firstAndLast;
			
		}
		   public static String showAnd(String lastAnswer){
		    	return (lastAnswer.trim().length() == 0)? "":" and ";
		    }

	}
