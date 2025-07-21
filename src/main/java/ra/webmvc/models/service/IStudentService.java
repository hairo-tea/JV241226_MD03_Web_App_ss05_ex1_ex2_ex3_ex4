package ra.webmvc.models.service;

import ra.webmvc.models.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    List<Student> getStudentsByName(String keyword);

    List<Student> sortASC();

    List<Student> sortDESC();
}
