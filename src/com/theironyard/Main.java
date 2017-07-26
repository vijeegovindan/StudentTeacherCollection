package com.theironyard;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /* ADD STUDENTS USING ARRAYLIST */
        List<Student> StudentList = new ArrayList<Student>();
        for(int i=1; i<16; i++){
            Student student = new Student("StudentFN" + i, "StudentLN" + i , i , 1);
            StudentList.add(student);
        }

        /* ADD TEACHERS USING ARRAYLIST */
        List<Teacher> TeacherList = new ArrayList<Teacher>();
        for(int i=1;i<4;i++){
            Teacher teacher = new Teacher("TeacherFN" + i, "TeacherLN" + i , i , 1);
            TeacherList.add(teacher);
         }

        /* GROUP STUDENTS USING HASHSET  */
        Set<Student> setOfStudents1 = new HashSet<Student>(); // Group 1
        for(int i=0; i<5; i++){
            setOfStudents1.add(StudentList.get( i ));
        }
        Set<Student> setOfStudents2 = new HashSet<Student>(); // Group 2
        for(int i=5; i<10; i++){
            setOfStudents2.add(StudentList.get( i ));
        }
        Set<Student> setOfStudents3 = new HashSet<Student>(); // Group 3
        for(int i=10; i<15; i++){
            setOfStudents3.add(StudentList.get( i ));
        }

        /* MAP STUDENTS TO TEACHER */
        HashMap<Teacher, Set<Student>> TeacherStudent = new HashMap<>();
        TeacherStudent.put(TeacherList.get(0), setOfStudents1 );
        TeacherStudent.put(TeacherList.get(1), setOfStudents2 );
        TeacherStudent.put(TeacherList.get(2), setOfStudents3 );

        System.out.println("----------------------------------------------");
        System.out.println("Display of Teacher-Student Using keySet ");
        System.out.println("----------------------------------------------");
        for(Teacher teacher : TeacherStudent.keySet() ){
            System.out.println("Teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + "  ID: " +  teacher.getId() + ",Grade: "+ teacher.getGrade());
            System.out.println("----------------------------------------------");
            System.out.println("Students Details given below");
            System.out.println("----------------------------");
            for(Student student: TeacherStudent.get(teacher)){
                System.out.println("Student FullName: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Student ID: " + student.getId());
                System.out.println("Grade: " + student.getGrade());
            }
            System.out.println("----------------------------------------------");
        }


        /* USING ENTRY SET IN MAP */
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Display of Teacher-Student Using Map entrySet ");
        System.out.println("----------------------------------------------");

        for(Map.Entry<Teacher, Set<Student>> teacher: TeacherStudent.entrySet() ){
            System.out.println("Teacher: " + teacher.getKey().getFirstName() + " " + teacher.getKey().getLastName() + "  ID: " +  teacher.getKey().getId() + ",Grade: "+ teacher.getKey().getGrade());
            System.out.println("----------------------------------------------");
            System.out.println("Students Details given below");
            System.out.println("-----------------------------");
            for(Student student: teacher.getValue()){
                System.out.println("FullName: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Student ID: " + student.getId());
                System.out.println("Grade: " + student.getGrade());
            }
        }
    }
}
