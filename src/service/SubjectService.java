package service;

import model.Exam;
import model.Subject;

import java.util.List;

public interface SubjectService {

    Subject createSubject ();
    Subject searchSubjectByName(String subjectName, List<Subject> subjectsList);
    void displaySubjectList(List<Subject> subjectList);
    List<Subject> createExam (Exam exam, List<Subject> subjectList, String subject);
}
