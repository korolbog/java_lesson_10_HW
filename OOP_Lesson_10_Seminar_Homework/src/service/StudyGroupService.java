package service;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {

    public StudyGroup create(Teacher teacher, List<Student> studentList) {
        return new StudyGroup(teacher, studentList);
    }


}
