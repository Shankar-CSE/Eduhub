package com.eduhub.eduhub.Controller;

import com.eduhub.eduhub.Services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("course")
    public ResponseEntity<CourseService> getCourse(){
        CourseService courseService = new CourseService(111,"JAVA",4);
        return new ResponseEntity<>(courseService, HttpStatus.OK);
    }

    @GetMapping("courses")
    public ResponseEntity<List<CourseService>> getCourses(){
        List CourseList = new ArrayList<>();
        CourseList.add(new CourseService(111,"JAVA",4));
        CourseList.add(new CourseService(112,"spring",2));
        CourseList.add(new CourseService(113,"spring boot",2));
        CourseList.add(new CourseService(114,"C++",4));
        CourseList.add(new CourseService(115,"JavaScript",3));

        return new ResponseEntity<>(CourseList, HttpStatus.OK);
    }




}
