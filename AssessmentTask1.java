/*
Enter the customer's name: Alice
Available Books:
1. Mystery of the Ancient Tomb - $12.99
2. The Rise of the Robots - $15.49
3. Understanding the Universe - $20.99
Enter quantity for 'Mystery of the Ancient Tomb' (Book 1): 3
Enter quantity for 'The Rise of the Robots' (Book 2): 2
Enter quantity for 'Understanding the Universe' (Book 3): 1
Customer Order Summary:
Customer Name: Alice
Total Books Ordered: 6
Mystery of the Ancient Tomb: 3 copies @ $12.99 each
The Rise of the Robots: 2 copies @ $15.49 each
Understanding the Universe: 1 copies @ $20.99 each
Total Cost: $90.94
Discount Applied: 5.0%
Amount Payable: $86.393

*/


import java.util.Scanner;

public class AssessmentTask1 {
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);


    String[] customerNames = {"Alice", "Bob", "Charlie"};
    double[] bookPrices = {12.99, 15.49, 20.99};
    String[] bookNames = {"Mystery of the Ancient Tomb", "The Rise of the Robots", "Understanding the Universe"};
    int[] bookQtyPerCustomer = {0,0,0};
    
    int bookAmountTotal = 0;
    String customerName = "";
    double GrossBookCost = 0;
    
    System.out.print("Enter the customer's name: ");
    customerName = keyboard.nextLine();
    
    for(int i = 0; i < bookNames.length; i++){
        System.out.println((i+1) + ". " + bookNames[i] + " - $" + bookPrices[i]);
    }



    boolean validInput = false;
    while(!validInput){
        bookAmountTotal = 0;
        GrossBookCost = 0;

        for(int i = 0; i < bookNames.length; i++){
            System.out.print("Enter quantity for '" + bookNames[i] + "' (Book "+(i+1)+"): ");
            bookQtyPerCustomer[i] = keyboard.nextInt();
            keyboard.nextLine();
            bookAmountTotal = bookAmountTotal + bookQtyPerCustomer[i];
            GrossBookCost = GrossBookCost + (bookPrices[i] * bookQtyPerCustomer[i]);
        }

        if(bookAmountTotal > 10){
            System.out.println("ERROR!\n"+
            "Error: Total number of books ordered cannot exceed 10.\n"+
            "Please enter valid quantities.\n");
        } else {
            validInput = true;
        }
    }

    keyboard.close();
    
    
    double DiscountRate = CalculateDiscount(bookAmountTotal);
    
    double NetBookCost = GrossBookCost * (1 - DiscountRate / 100);

    System.out.println("Customer Order Summary:\r\n" +
            "Customer Name: " + customerName + "\r" +
            "Total Books Ordered: " + bookAmountTotal + "\r");
            
    for(int i = 0; i < bookQtyPerCustomer.length; i++){
     System.out.println(bookNames[i] + ": " + bookQtyPerCustomer[i] + " copies @ $" + bookPrices[i] + " each") ;  
    }

    System.out.println(
            "\nTotal Cost: $" + GrossBookCost + "\r" + 
            "Discount Applied: " + DiscountRate + "%\r" + 
            "Amount Payable: $"+ NetBookCost);


  }
  
   
  public static double CalculateDiscount(int bookAmountTotal) {
    double DiscountRate;
    if(bookAmountTotal >=10) {
      DiscountRate = 15.0;
    }
    else if(bookAmountTotal >=7) {
      DiscountRate = 10.0;
    }
    else if(bookAmountTotal >=4) {
      DiscountRate = 5.0;
    }
    else{
      DiscountRate = 0.0;
    }
    
    return DiscountRate;
      
  }
}
