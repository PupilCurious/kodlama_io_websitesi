package dataAccess;

import entities.Category;
import entities.Course;
import entities.Teacher;

public class Hibernate implements CourseDao, CategoryDao, TeacherDao{

    @Override
    public void add(Course course) {
        System.out.println(course.getName() + " Kursu İçin Hibernate Yöntemi Uygulandı");

    }

    @Override
    public void add(Category category) {
        System.out.println(category.getName() + " Kategorisi için Hibernate Yöntemi Uygulandı.");

    }

    @Override
    public void add(Teacher teacher) {
        System.out.println(teacher.getFirstName() + " " + teacher.getLastName() + " Eğitmeni için Hibernate Yöntemi Uygulandı.");
    }
}
