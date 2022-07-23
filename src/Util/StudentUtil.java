/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Beans.Student;
import main.Config;

/**
 *
 * @author Azer
 */
public class StudentUtil {
    public static Student fillStudent(){
        String name=InputUtil.requiredText("Enter name");
        String surname=InputUtil.requiredText("Enter surname");
        int age=InputUtil.requiredNumber("Enter age");
        String className=InputUtil.requiredText("Enter class");
        
        Student st=new Student(name,surname,age,className);
        return st;
    }
    
    public static void printAllRegisteredStudents(){
        if(Config.students==null){
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
                System.out.println((i+1)+"."+Config.students[i].getFullInfo());
            }
    }
    
    public static void registerStudents(){
        int count=InputUtil.requiredNumber("How many students do you want to register?");
        Config.students=new Student[count];
            
        for (int i = 0; i < count; i++) {
            System.out.println((i+1)+".Register");
            Config.students[i]=Util.StudentUtil.fillStudent();
        }
            
        System.out.println("Registration completed successfully");
    }
    
    public static Student[] findStudents(String text){
        int count=0;
        for (int i = 0; i < Config.students.length; i++) {
            if(Config.students[i].getName().contains(text)||Config.students[i].getSurname().contains(text)||Config.students[i].getClassName().contains(text)){
                count++;
            }
        }
        
        Student[] result=new Student[count];
        int found=0;
        for (int i = 0; i < Config.students.length; i++) {
            if(Config.students[i].getName().contains(text)||Config.students[i].getSurname().contains(text)||Config.students[i].getClassName().contains(text)){
                result[found++]=Config.students[i];
            }
        }
         
        return result;
    }
    
    public static void FindStudentsAndPrint(){
        String text=InputUtil.requiredText("Type name class or surname");
        Student[] students=findStudents(text);
        if(students==null){
            System.out.println("No students found");;
        }else{
            for (int i = 0; i < students.length; i++) {
                System.out.println(students[i].getName()
                        +" "+students[i].getSurname()
                        +" "+students[i].getAge()
                        +" "+students[i].getClassName());
            }
        }        
    }
    
    public static void UpdateStudent(){
        StudentUtil.printAllRegisteredStudents();
        
        int number = InputUtil.requiredNumber("Which student you want to update");
        System.out.println("Yeni Melumatlari daxil edin:");
        String changeParameters = InputUtil.requiredText("What you want to update? mes:name,surname,age,class");        
        String[] parameters = changeParameters.split(",");
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].equalsIgnoreCase("name")) {
                Config.students[number - 1].setName(Util.InputUtil.requiredText("Enter name"));
            } else if (parameters[i].equalsIgnoreCase("surname")) {
                Config.students[number - 1].setSurname(Util.InputUtil.requiredText("Enter surname"));
            } else if (parameters[i].equalsIgnoreCase("age")) {
                Config.students[number - 1].setAge(Util.InputUtil.requiredNumber("Enter age"));
            } else if (parameters[i].equalsIgnoreCase("class")) {
                Config.students[number - 1].setClassName(Util.InputUtil.requiredText("Enter className"));
            }
        }    
    }
    
}
