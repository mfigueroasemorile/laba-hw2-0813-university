package service.impl;

import model.Exam;
import model.Professor;
import model.Subject;
import service.ISubjectService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class SubjectServiceImpl implements ISubjectService {


    @Override
    public Subject createSubject (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter subject name: ");
        String subjectName = scanner.next();
        return new Subject(subjectName);
    }

    @Override
    public Subject searchSubjectByName(String subjectName, List<Subject> subjectsList){
        for (Subject subject : subjectsList) {
            if (subject.getName().equalsIgnoreCase(subjectName)) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public void displaySubjectList(List<Subject> subjectList){
        if(!subjectList.isEmpty()){
            System.out.println("-------------Available subjects-------------");
            for (Subject subject : subjectList){
                System.out.println(subject.getName());
            }
        } else {
            System.out.println("There isn't any subject available");
        }

    }

    @Override
    public List<Subject> createExam (Exam exam, List<Subject> subjectList, String subject){
        for (Subject s : subjectList) {
            if (s.getName().equalsIgnoreCase(subject)) {
                s.setExam(exam);
            }
        }
        return subjectList;
    }

    @Override
    public void assignProfessorToSubject(Subject subject, Professor professor, Map<Subject, Professor> courseProfessorMap) {
        courseProfessorMap.put(subject, professor);
    }
}
