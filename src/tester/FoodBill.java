package tester;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodBill {
    public static void main(String[] args)
    {
        int bill[] = new int[9];
        String item[] = new String[]{"Tea","Coffee","Samosa","Chocolate Shake","Mango Shake","Straberry Shake","Veg Sandwich","Chicken Sandwich","Dosa"};
        Double price[] = new Double[]{10.00,20.00,30.00,40.00,50.00,60.00,70.00,80.00,90.00};
        Scanner input = new Scanner(System.in);
        Double total = 0.00;
        
        do
        {       
            System.out.println("Enter a choice :");
            for(int i= 0; i<9;i++)
                System.out.println("  "+(i+1)+".  "+item[i]);
            System.out.println("  10. Generate Bill");
            int ch;
            try{
            ch = input.nextInt();
            if(ch>0 && ch<11){
                if(ch != 10)
                {
                    Boolean flag = false;
                    do{
                    try{
                        System.out.println("Enter the quantity :");
                        flag= true;
                        bill[ch-1] += input.nextInt(); 
                    }catch(InputMismatchException e)
                    {
                        System.out.println("Quantity must be integer.");
                        flag = false;
                    }
                    }while(!flag);
                }
                else{
                    //generate bill...
                    System.out.println("Item --------- Qyt  ** Unit Price");
                    for(int i =0;i<9;i++)
                    {
                        if(bill[i]>0)
                        {
                        total += bill[i]*price[i];
                        System.out.println(item[i]+" --------- "+bill[i]+" ** "+price[i]);
                        }
                    }

                    System.out.println("-------------------------------------------------");
                    System.out.println("Total Amnt --------- INR " +total);
                    System.out.println("-------------------------------------------------");
                    System.exit(0);

                }
                
            }
            else
            {
                System.out.println("Enter a valid choice");
            }
            }catch(InputMismatchException e)
            {
                System.out.println("Choice must be integer.");
            }
        
        }while(true);
    }
}