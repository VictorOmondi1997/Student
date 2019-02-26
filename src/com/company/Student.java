package com.company;

import java.util.Scanner;
public class Student{
    Scanner sc = new Scanner(System.in);
    private String regNo,
                   name,
                   course;
    private double yos;
    private double feeBal;
    private byte[] marks;

    public Student(String regNo, String name, String course, double yos, double feeBal){
        this.regNo=regNo;
        this.name=name;
        this.course=course;
        this.yos=yos;
        this.feeBal=feeBal;
        marks= new byte[5];
    }

    public void setMarks(){
        System.out.println("Enter Marks For the Units done by "+name);
        byte counter,
            y=0;
        for(counter=0; counter<marks.length;counter++){
            System.out.println("Enter marks For Unit: "+ y++);
            marks[counter]=sc.nextByte();
        }
    }
    public void getResult(){
        System.out.println("Marks Before Sorting");
        for(byte m: marks){
            System.out.print(m+",");
        }
        //Sorting
        byte x, y, temp;
        for(x=0;x<marks.length;x++){
            for(y=0;y<(marks.length -1);y++){
                if(marks[y]>marks[y+1]){
                    temp=marks[y];
                    marks[y]=marks[y+1];
                    marks[y+1]=temp;
                }
            }
        }
        System.out.println("\nAfter Sorting, marks are: ");
        for(byte k: marks){
            System.out.print(k+",");
        }
    }
    public void payFee(){
        double deposit;
        System.out.println("\nEnter The Amount To Pay: ");
        deposit=sc.nextDouble();

        feeBal=feeBal-deposit;
    }
    public double checkBalance(){
        return feeBal;
    }


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Student vick = new Student("CIT-222-045/2017", "Victor Omondi", "CT", 2.1, 50000);
        System.out.println("Welcome: Choose An Option");
        System.out.println("1.Set Marks \t2.Get Results \n3.Pay Fee \t\t4.Get Fee Balance");
        byte option;
        System.out.print("\nEnter Option Here: ");
        option=scanner.nextByte();
        while(option>4){
            System.out.println("Wrong Input: Press 1 or 2 or 3 or 4");
            System.out.print("Enter option Here__:");
            option=scanner.nextByte();
        }
        vick.setMarks();
        vick.getResult();
        vick.payFee();
        System.out.println("Your Current Fee Balance is: "+vick.checkBalance()); //;
    }
}