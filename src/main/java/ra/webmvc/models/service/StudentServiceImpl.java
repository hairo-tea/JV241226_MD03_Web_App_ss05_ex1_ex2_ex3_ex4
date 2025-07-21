package ra.webmvc.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.webmvc.models.dao.IStudentDao;
import ra.webmvc.models.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
      return studentDao.getStudentById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public List<Student> getStudentsByName(String keyword) {
        return studentDao.getStudentsByName(keyword);
    }

    @Override
    public List<Student> sortASC() {
        return studentDao.sortASC();
    }

    @Override
    public List<Student> sortDESC() {
        return studentDao.sortDESC();
    }
}
