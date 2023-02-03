package business;

import core.logging.Logger;
import dataAccess.CategoryDao;
import dataAccess.CourseDao;
import entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {

   private CategoryDao categoryDao;
   private Logger[] loggers;
   private List<Category> categories = new ArrayList<>();


   public CategoryManager(CategoryDao categoryDao, Logger[] loggers, List<Category> categories){
         this.categoryDao = categoryDao;
         this.loggers = loggers;
         this.categories = categories;
   }

   public void add(Category category) throws Exception{

       for (Category category1:categories){
           if(category.getName().equals(category1.getName())){
               throw new Exception("!!! Kategori ismi tekrar edemez !!!");
           }
       }
       categories.add(category);
       for (Logger logger:loggers){
            logger.log(category.getName() + " Kategorisi Eklendi");
        }
        categoryDao.add(category);
        System.out.println("---------------------");

   }
}
