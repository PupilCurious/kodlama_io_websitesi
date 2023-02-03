import business.CategoryManager;
import business.CourseManager;
import business.TeacherManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.Hibernate;
import dataAccess.Jdbc;
import entities.Category;
import entities.Course;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        //Yeni Kurs oluşturma bölümü
        Course course = new Course("Java",1000);
        Course course1 = new Course("C#",0);

        //Eklediğimiz kursların isim ve fiyatlarını karşılaştırmak için listede tutuyoruz.
        List<Course> courses = new ArrayList<>();

        //Yeni Kategori oluşturma bölümü
        Category category = new Category("Programlama");
        Category category1 = new Category("Tasarım");

        //Eklediğimiz Kategorileri koşullara uygunluğunu kontrol etmek için listede tutuyoruz.
        List<Category> categories = new ArrayList<>();

        //Yeni Eğitmen oluşturma bölümü
        Teacher teacher = new Teacher("Engin","Demiroğ");
        Teacher teacher1 = new Teacher("Engin","Demiroğ");

        //Eklediğimiz Eğitmenlerin koşullara uygunluğunu kontrol etmek için listede tutuyoruz.
        List<Teacher> teachers = new ArrayList<>();

        //Çoklu loglama yapabilmek için log türlerini bir dizi içerisinde tutuyoruz.
        Logger[] loggers = new Logger[] {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        //Yeni Kurs Ekleme Bölümü
        CourseManager courseManager = new CourseManager(new Hibernate(),loggers,courses);
        courseManager.add(course);
        courseManager.add(course1);

        //Yeni Kategori Ekleme Bölümü
        CategoryManager categoryManager = new CategoryManager(new Hibernate(), loggers, categories);
        categoryManager.add(category);
        categoryManager.add(category1);

        //Yeni Eğitmen Ekleme Bölümü
        TeacherManager teacherManager = new TeacherManager(new Hibernate(), loggers, teachers);
        teacherManager.add(teacher);
        teacherManager.add(teacher1);
    }
}

   /*

   kodlama.io web sitesinin ana sayfasında bulunan eğitmen, kategori ve kurs bölümlerini katmanlı mimaride kodlamak istiyoruz.

        Önceki derste yaptığımız tekniklerle hem jdbc hem de hibernate üzerinde yazmış gibi simüle ediniz.

        Çoklu loglama yapısını simule ediniz.

        Aşağıdaki isterleri gerçekleştiriniz.

        Kurs ismi tekrar edemez
        Kategori ismi tekrar edemez
        Bir kursun fiyatı 0 dan küçük olamaz
        Kodlarınızı github'a aktarınız

    */