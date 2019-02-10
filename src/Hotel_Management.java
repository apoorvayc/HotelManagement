

import java.util.Scanner;
class Menu_Card 
{
	String item;
	double price;
	int quantity;
	void set(String item,double price)
	{
		this.item = item;
		this.price = price;
		this.quantity = 0;
	}
    
	public String toString()
	{
		return item+"  "+price;
	}
	void display1()  
	{
			for(int a1=0;a1<10;a1++)
			{
				try
				{
					System.out.print(this.item.charAt(a1));
				}
				catch(java.lang.StringIndexOutOfBoundsException e)
				{
					System.out.print(" ");
				}
			}
			for(int a2=0;a2<10;a2++)
			{
				try
				{
					System.out.print(Double.toString(this.price).charAt(a2));
				}
				catch(java.lang.StringIndexOutOfBoundsException e)
				{ 
					System.out.print(" ");
				}	
			}
			System.out.println("");
	}
}
class Bill extends Menu_Card
{
	String user_number;
	String user_name;
	int user_age;
	String bill_item;
	int bill_quan;
	double bill_price;
	double points;
	
	public void set_details_of_user(String n, int ni, String number) {
		this.user_name = n;
		this.user_age = ni; 
		this.user_number = number;
	}
	public void set_bill(String bill_item2, int bill_quan2, double price1) {
		this.bill_item = bill_item2;
		this.bill_quan = bill_quan2;
		this.bill_price = price1;
	}
	String getuser()
	{
		return this.user_name;
	}
	public int getage() {
		return this.user_age;
	}
	
	public void set_pts(double d) {
		this.points = d;
	}
	
	public double getpoints() {
		// TODO Auto-generated method stub
		return this.points;
	}
	
	public static void display2(String str1)
	{
		for(int d2=0;d2<10;d2++)
		{
			try {
				System.out.print(str1.charAt(d2));
			}
			catch(java.lang.StringIndexOutOfBoundsException e)
			{
				System.out.print(" ");
			}
		}
	}
}
public class Hotel_Management extends Bill
{
	 public static void main(String[]args)
	 {
		 Scanner sc = new Scanner(System.in);
		 int i = 0;
		 System.out.println("------------------------------------------------------------------------------------------");
		 System.out.println(" Hey Admin enter number of elements in menu card");
		 int j = sc.nextInt();
		 Menu_Card[] m = new Menu_Card[j];
		 Bill[][] b = new Bill[j][j];
		 
		 while(i<j)
		{
			 m[i] = new Menu_Card();
			  System.out.println("Enter Item-name and Price for Item No."+ (i+1));
			 String s = sc.next();
			 double d = sc.nextDouble();
			 m[i].set(s,d);
			 i++;
		}
		i = 0;
		System.out.println("------------------------------------MENU CARD-------------------------------------------------");
		for(int d1=0;d1<10;d1++)
		{
			try {
			  System.out.print("ITEM".charAt(d1));
			}
			catch(java.lang.StringIndexOutOfBoundsException e)
			{
				 System.out.print(" ");
			}
		}
		 for(int d2=0;d2<10;d2++)
		{
			try {
			  System.out.print("PRICE".charAt(d2));
			}
			catch(java.lang.StringIndexOutOfBoundsException e)
			{
				 System.out.print(" ");
			}
		}
		System.out.println("");
		
		 while(i<j)
		 {
		 m[i].display1();
		 i++;
		 }
		 int c = 0;
		loop2:
			while(true)
		  {
				double total_bill = 0;
				System.out.println("--------------------------------------------------------------------------------------------------");
				System.out.println("WELCOME User, Enter your name, age and contact no. ");
				String name = sc.next();
				int age = sc.nextInt();
				String contact_no = sc.next();
				int amt = 0;
			 loop3:
			 try
			{
			 for(int c1=0;c1<=c;c1++)
			 {
				 if(b[c1][0].user_number.equals(contact_no))
				 {
					 c = c1;
					 break loop3;
				 }
				 else
					 continue;
			 }
		    }
			catch(java.lang.NullPointerException e)
			{
		    b[c][amt] = new Bill();
		    b[c][amt].user_name = name;
		    b[c][amt].user_age = age;
		    b[c][amt].user_number = contact_no;
		    b[c][amt].set_details_of_user(b[c][amt].user_name,b[c][amt].user_age,b[c][amt].user_number);
			}
			loop1:
			while(true)
			{
			  System.out.println("Choose what you want to eat and specify quantity ");
			  b[c][amt].bill_item = sc.next();
			  b[c][amt].bill_quan = sc.nextInt();
			  b[c][amt].set(b[c][amt].bill_item,b[c][amt].bill_quan);
			  for(int k=0;k<j;k++)
			  {
				  if((m[k].item).equals(b[c][amt].bill_item))
				  {
				      b[c][amt].set_bill(b[c][amt].bill_item,b[c][amt].bill_quan,m[k].price);
					  total_bill += m[k].price*b[c][amt].bill_quan;
				  }
			  }			  
			 
			  System.out.println("enter 0 to exit else 1 to continue order ");
			  int exit = sc.nextInt();
			  if(exit == 0)
			  {
				   display2("ITEM");
				   display2("QUANTITY");
				   display2("PRICE");
				  System.out.println("");
				  for(int l=0;l<=amt;l++)
				  {
				       display2(b[c][l].bill_item);
					   display2(Integer.toString(b[c][l].bill_quan));
					   for(int c4=0;c4<Integer.toString(b[c][l].bill_quan).length();c4++)
					   {
						   System.out.print(Integer.toString(b[c][l].bill_quan).charAt(c4));
					   } 
					   System.out.print("*");
					   for(int c3=(Integer.toString(b[c][l].bill_quan).length());c3<10;c3++)
					   {				 
							   try
							   {
						           System.out.print(Double.toString(b[c][l].bill_price).charAt(c3-(Integer.toString(b[c][l].bill_quan).length())));
					           }
							   catch(java.lang.StringIndexOutOfBoundsException e)
							   {
								   System.out.print(" ");
							   }
					   }     
					   System.out.println("");
					   b[c][l].bill_item = null;
					   b[c][l].bill_price = 0;
					   b[c][l].bill_quan = 0;
				  	}
				  break loop1;    
			  }
			  else
			  {
				  amt++;
				  b[c][amt] = new Bill();
			  }
		  }
		 if(b[c][0].points == 0)
		{
			 System.out.println(b[c][0].getuser()+", your Total bill is "+total_bill);
			 System.out.println("--------------------------------------------------------------------------------------------------");
			 b[c][0].set_pts(total_bill/100);
		}
		 else
		{
		 System.out.println(b[c][0].getuser()+", your Total bill after applying discount(i.e. "+b[c][0].getpoints()+"%) from previous records is "+(total_bill-(total_bill*0.01*b[c][0].getpoints())));
		 b[c][0].set_pts(b[c][0].getpoints()+(total_bill/100));
		 System.out.println("--------------------------------------------------------------------------------------------------");
		}
		 System.out.println("GREETINGS Admin, are further user's waiting?(y/n)");
		 String user_choice = sc.next();
		 c++;
		 if(user_choice.equalsIgnoreCase("n"))
			break loop2;
		 }
		 sc.close();
	}
} 
