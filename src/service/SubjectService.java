package service;

import model.Student;
import model.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectService {


    public Subject createSubject (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter subject name: ");
        String subjectName = scanner.next();
        return new Subject(subjectName);
    }

    public Subject searchSubjectByName(String subjectName, List<Subject> subjectsList){
        for (Subject subject : subjectsList) {
            if (subject.getName().equalsIgnoreCase(subjectName)) {
                return subject;
            }
        }
        return null;
    }
}
