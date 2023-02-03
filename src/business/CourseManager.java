package business;

import core.logging.Logger;
import dataAccess.CourseDao;
import entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private CourseDao courseDao;
    private Logger[] loggers;
    private List<Course> courses = new ArrayList<>();


    public CourseManager(CourseDao courseDao, Logger[] loggers,List<Course> courses) {
        this.courseDao = courseDao;
        this.loggers = loggers;
        this.courses = courses;

    }

    public void add(Course course) throws Exception {
        for(Course course1:courses) {
            if (course.getName().equals(course1.getName())) {
                throw new Exception("!!! Kurs ismi tekrar edemez !!!");
            }
            if (course.getPrice() <= 0) {
                throw new Exception("!!! Bir kursun fiyatı 0 dan küçük olamaz !!!");
            }
        }
        courses.add(course);
        for (Logger logger:loggers){
            logger.log(course.getName() + " Kursu Eklendi");
        }
        courseDao.add(course);

        System.out.println("---------------------------------");

    }
}


