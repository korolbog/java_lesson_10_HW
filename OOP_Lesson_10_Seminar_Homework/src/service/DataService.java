package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<User> userList = new ArrayList<>();

    public void create(String firstName, String lastName, String middleName, Type type) {
        int id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher);
        }
    }

    public User getUserById(Type type, int id) {
        boolean itsStudent = Type.STUDENT == type;
        User currentUser = null;

        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id) {
                currentUser = user;
            }
            if (user instanceof User && itsStudent && ((Student) user).getStudentId() == id) {
                currentUser = user;
            }
        }
        return currentUser;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }

    private int getFreeId(Type type) {
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent) {
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof User && itsStudent) {
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                teachers.add((Teacher) user);
            }
        }
        return teachers;
    }

    public Teacher findTeacherById(int teacherId) {
        for (User user : userList) {
            if (user instanceof Teacher && ((Teacher) user).getTeacherId() == teacherId) {
                return (Teacher) user;
            }
        }
        return null;
    }

    public Student findStudentById(int studentId) {
        for (User user : userList) {
            if (user instanceof Student && ((Student) user).getStudentId() == studentId) {
                return (Student) user;
            }
        }
        return null;
    }

    public List<Student> findStudentListByIdList(int[] studentIdList) {
        List<Student> studentList = new ArrayList<>();
        for (int studentId : studentIdList) {
            Student student = this.findStudentById(studentId);
            if (student != null) {
                studentList.add(student);
            }
        }
        return studentList;
    }
}
