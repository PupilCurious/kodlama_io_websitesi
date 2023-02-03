package business;

import core.logging.Logger;
import dataAccess.TeacherDao;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherManager {
    private TeacherDao teacherDao;
    private Logger[] loggers;
    private List<Teacher> teachers = new ArrayList<>();

    public TeacherManager(TeacherDao teacherDao, Logger[] loggers, List<Teacher> teachers){
        this.teacherDao = teacherDao;
        this.loggers = loggers;
        this.teachers = teachers;

    }

    public void add(Teacher teacher){

        teachers.add(teacher);
        for (Logger logger:loggers) {
            logger.log(teacher.getFirstName() + " " + teacher.getLastName() + " Eğitmen Eklendi");

        }
        teacherDao.add(teacher);
        System.out.println("---------------------");


    }

}
