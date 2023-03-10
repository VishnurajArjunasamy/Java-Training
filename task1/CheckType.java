package task1;

public class CheckType {
	static int numLength(int n) {	
		return (Integer.toString(n)).length();
	}
	
    public static String typeCheck(int number){
        String numberType="";

        //Armstrong number
        int originalNum, remainder, result = 0;
        originalNum = number;

        while (originalNum != 0)
        {
            remainder = originalNum % 10;
            result += Math.pow(remainder, numLength(number));
            originalNum /= 10;
        }

        if(result == number){
            numberType= numberType+" Armstrong";
        }

        //perfect number check
        int sum=0;
        for(int i=1;i<number;i++){
            if(number%i==0){
                sum+=i;
            }
        }
        if(sum==number){
            numberType=numberType+" perfect";
        }

        //palindrome check
        if(!(number/10==0)){
            int temp=number;
            sum=0;remainder=0;    
            while(temp>0){
                remainder=temp%10;  
                sum=(sum*10)+remainder;    
                temp=temp/10;    
            }    
        if(number==sum){
            numberType=numberType+" palindrome";
        }
        }
        
        
        return ("This number is"+ numberType+" number");
    }
    
    public static void main(String[] args) {
        System.out.println(typeCheck(12));
    }
}
