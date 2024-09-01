package service;

import model.Exam;
import model.Professor;
import model.Subject;

import java.util.List;
import java.util.Map;

public interface ISubjectService {

    Subject createSubject ();
    Subject searchSubjectByName(String subjectName, List<Subject> subjectsList);
    void displaySubjectList(List<Subject> subjectList);
    List<Subject> createExam (Exam exam, List<Subject> subjectList, String subject);
    void assignProfessorToSubject(Subject subject, Professor professor, Map<Subject, Professor> courseProfessorMap);
}
