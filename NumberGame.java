import java.util.Scanner;
public class NumberGame{
    public static void main(String[]args)throws Exception{
        System.out.println("Number Game......");
        Thread.sleep(1000);
        System.out.println("Starting Game......");
        Thread.sleep(1000);
        System.out.println("Enter Your name......");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("Hi"+name);
        int attemptLimit=5,numberofRounds=3;
        int roundNumber=1;
        int[]scores=new int[numberofRounds];
        while(roundNumber<=numberofRounds)
        {
            System.out.println("Generating random number......please wait");
            int minValue=1,maxValue=100;
            int target=GetRandomNumber(minValue,maxValue);
           
            Thread.sleep(1000);
            System.out.println("Random Number Generated");
            boolean won=false;
            int attempt=-1;
            while(true){
                System.out.println("Enter your guess number");
                attempt++;
                if(attempt==attemptLimit)
                {
                System.out.println("you hav reached the maximum attempt Sorry!Tryagain");
                break;
                }
                int guess=0;
                while(true){
                    guess=scanner.nextInt();
                    if(guess>=minValue&&guess<=maxValue){break;}
                    System.out.println("please Enter the number>=" + minValue +"and<="+ maxValue);
                }
                if(guess==target){
                    System.out.println("Congrats you have guessed the generated numberin"+attempt+"attempt");
                    won=true;
                    break;
                }
                else if(guess<target){
                    System.out.println("Guess Number is low!");
                    minValue=guess+1;
                    System.out.println("target Number can be>="+minValue+"and<="+maxValue);
                }else{
                    System.out.println("Guess Number is high!");
                    maxValue=guess-1;
                    System.out.println("target Number can be>="+minValue+"and<="+maxValue);
                }
                }
                if(!won)
                {
                    Thread.sleep(1000);
                    System.out.println("you haven't won the first round");
                    scores[roundNumber-1]=100-(attempt*20);
                    break;
                }else{
                    Thread.sleep(1000);
                    scores[roundNumber-1]=100-(attempt*20);
                    roundNumber++;
                    System.out.println("promoting to next round:"+roundNumber);
                }
            }
            scanner.close();
            Thread.sleep(1000);
            for(int i=0;i<numberofRounds;i++){
                int round=i+1;
                System.out.println("Round:"+ round +"score:"+ scores[i]);
            }
            return;
        }
        static int GetRandomNumber(int minValue,int maxValue)
        {
            return(int)(Math.random()*(maxValue-minValue+1)+minValue);
        }
    }