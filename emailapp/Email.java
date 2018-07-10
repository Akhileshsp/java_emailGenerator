package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength =10;
	private String alternateEmail;
	private String companySuffix = "akhiesh.com";
	
	//Constructor to receive the first and last name
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created : "+this.firstName+" "+this.lastName);
		
		//call method asking for department
		this.department = setDepartment();
		//System.out.println("Department : "+this.department);
	
		//Call a method that generates a random password
		this.password = randomPassword(defaultPasswordLength);
		//System.out.println("Your password is : "+ this.password);
		
		//combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companySuffix;
		//System.out.println("Your Email is : "+ email);
	}

	
	//ask for the department
	private String setDepartment(){
		System.out.println("New worker: "+firstName +". \n"+ "Department codes\n 1)for Sales\n 2)for Development\n 3)for Accounting \n 0)for None enter the department");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice == 1){
			return "sales";
		}
		else if(deptChoice == 2){
			return "dev";
		}
		else if(deptChoice == 3){
			return "acct";
		}
		else{
			return "";
		}
	}
	
	//Generate a random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++){	
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity){
		this.mailboxCapacity = capacity;
	}
	
	//set the alternate emil
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail;
	}
	
	//change the password
	public void changePassword(String password){
		this.password = password;
	}
	
	public int getMailboxCapacity(){
		return mailboxCapacity;
	}
	public String getAlternateEmail(){
		return alternateEmail;
	}
	public String getPassword(){
		return password;
	}

	public String showInfo(){
		return "DISPLAY NAME: "+firstName + " "+lastName +"\n"+
				"COMPANY EMAIL: "+email+"\n"+
				"MAILBOX CAPACITY: "+mailboxCapacity+"mb"+"\n";
	}
}
