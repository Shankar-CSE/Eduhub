package com.eduhub.eduhub.controller;

import com.eduhub.eduhub.component.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService CourseService;

    @GetMapping("/courses")
    public String getCourse(){
        return CourseService.getCourse();
    }
}
