import controller.Controller;
import model.StudyGroup;

public class Main {
    public static void main(String[] args) {

        Controller myController = new Controller();

        myController.createStudent("Ivan", "Ivanov", "Ivanovich");
        myController.createStudent("Petr", "Petrov", "Petrovich");
        myController.createStudent("Sidor", "Sidorov", "Sidorovich");
        myController.createStudent("Baldur", "Baldurov", "Baldurovich");

        myController.createTeacher("Sauron", "Sauronov ", "Sauronovich");
        myController.createTeacher("Gendalf", "Gendalfonov", "Gendalfovich");

        myController.getAllStudents();
        myController.getAllTeachers();
        int[] studentIdList = {1, 2, 4};
        int teacherId = 2;

        StudyGroup myStudyGroup = myController.createStudyGroup(teacherId, studentIdList);
        System.out.println(myStudyGroup);
    }
}