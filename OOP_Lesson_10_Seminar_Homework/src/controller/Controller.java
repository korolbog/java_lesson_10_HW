package controller;

import model.*;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;
import view.TeacherView;

import java.util.List;

public class Controller {
    private DataService service = new DataService();
    private StudyGroupService studyGroupService = new StudyGroupService();


    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();


    public void createStudent(String firstName, String lastName, String middleName) {
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }

    public void getAllStudents() {
        List<Student> userList = service.getAllStudents();
        for (User user : userList) {
            studentView.printOnConsole((Student) user);
        }
    }

    public void getAllTeachers() {
        List<Teacher> userList = service.getAllTeachers();
        for (User user : userList) {
            teacherView.printOnConsole((Teacher) user);
        }
    }

    public void createTeacher(String firstName, String lastName, String middleName) {
        service.create(firstName, lastName, middleName, Type.TEACHER);
    }

    public StudyGroup createStudyGroup(int teacherId, int[] studentIdList) {
        Teacher teacher = service.findTeacherById(teacherId);
        List<Student> studentList = service.findStudentListByIdList(studentIdList);
        return studyGroupService.create(teacher, studentList);
    }
}
