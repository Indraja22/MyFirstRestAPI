package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    //List<Course> list;
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl(List<Course> list) {
       /*list = new ArrayList<>();

       list.add(new Course(1223,"Python Masterclass",
               "This is a Python course for beginners"));
       list.add(new Course(1213,"Java Masterclass",
               "This is a Java course for beginners"));
       this.list = list;*/
    }

    @Override
    public List<Course> getCourses() {
       //return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        /*Course course = null;
        for(Course c : list){
            if(c.getId() == courseId){
                course = c;
                break;
            }
        }
        return course;*/
        return courseDao.getById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        /*list.add(course);
        return course;*/
         courseDao.save(course);
         return course;
    }

    @Override
    public Course updateCourse(Course course) {
         courseDao.save(course);
         return course;
    }

}
