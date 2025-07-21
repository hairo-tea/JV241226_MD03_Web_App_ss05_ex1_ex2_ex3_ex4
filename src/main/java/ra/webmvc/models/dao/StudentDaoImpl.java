package ra.webmvc.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ra.webmvc.models.entity.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements IStudentDao {
    @Autowired
    private ConnectionDB connectionDB;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = connectionDB.openConnection();
            callableStatement = connection.prepareCall("{call listStudent()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday").toLocalDate());
                student.setAvgMark(resultSet.getDouble("avgMark"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           connectionDB.closeConnection(connection, callableStatement);
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try{
            connection = connectionDB.openConnection();
            callableStatement = connection.prepareCall("{call findStudentId(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday").toLocalDate());
                student.setAvgMark(resultSet.getDouble("avgMark"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(connection, callableStatement);
        }
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        Connection connection = null;
        CallableStatement call = null;
        try{
            connection = connectionDB.openConnection();
            call = connection.prepareCall("{call addStudent(?,?,?,?)}");
            call.setString(1, student.getStudentName());
            call.setString(2, student.getEmail());
            call.setDate(3, Date.valueOf(student.getBirthday()));
            call.setDouble(4, student.getAvgMark());
            call.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(connection, call);
        }
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection conn= null;
        CallableStatement call = null;
        try{
            conn = connectionDB.openConnection();
            call = conn.prepareCall("{call updateStudent(?,?,?,?,?)}");
            call.setInt(1, student.getId());
            call.setString(2, student.getStudentName());
            call.setString(3, student.getEmail());
            call.setDate(4, Date.valueOf(student.getBirthday()));
            call.setDouble(5, student.getAvgMark());
            call.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(conn,call);
        }
        return true;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = connectionDB.openConnection();
            call = conn.prepareCall("{call deleteStudent(?)}");
            call.setInt(1, id);
            call.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(conn,call);
        }
        return true;
    }

    @Override
    public List<Student> getStudentsByName(String keyword) {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        try{
            connection = connectionDB.openConnection();
            callableStatement = connection.prepareCall("{call search_student_by_name(?)}");
            callableStatement.setString(1, keyword);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday").toLocalDate());
                student.setAvgMark(resultSet.getDouble("avgMark"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(connection, callableStatement);
        }
        return students;
    }

    @Override
    public List<Student> sortASC() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Student> students = new ArrayList<>();
        try {
            connection = connectionDB.openConnection();
            callableStatement = connection.prepareCall("{call sort_by_id_ASC()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday").toLocalDate());
                student.setAvgMark(resultSet.getDouble("avgMark"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(connection, callableStatement);
        }
        return students;
    }

    @Override
    public List<Student> sortDESC() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Student> students = new ArrayList<>();
        try{
            connection = connectionDB.openConnection();
            callableStatement = connection.prepareCall("{call sort_by_id_desc()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setEmail(resultSet.getString("email"));
                student.setBirthday(resultSet.getDate("birthday").toLocalDate());
                student.setAvgMark(resultSet.getDouble("avgMark"));
                students.add(student);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            connectionDB.closeConnection(connection, callableStatement);
        }
        return students;
    }
}
