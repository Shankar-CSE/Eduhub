package com.eduhub.eduhub.Controller;

import com.eduhub.eduhub.Services.CourseService;
import com.eduhub.eduhub.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    public List<CourseService> courseList = new ArrayList<>();

    // Constructor to initialize data
    public CourseController() {
        courseList.add(new CourseService(1,"Java",2));
        courseList.add(new CourseService(2,"C++",2));
        courseList.add(new CourseService(3,"Python",2));
        courseList.add(new CourseService(4,"DBMS",1));
        courseList.add(new CourseService(5,"ML",1));
    }

    // Return one Course
    @GetMapping("courses")
    public ResponseEntity<CourseService> getCourseServices(){
        CourseService course  = new CourseService(1,"Java",2);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Return list of Courses
    @GetMapping("course-list")
    public ResponseEntity<List<CourseService>> getCourseServiceList(){
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }

    // Get using Id
    @GetMapping("get-coursecode")
    public ResponseEntity<CourseService> getCourseService(){
        return ResponseEntity.ok(courseList.get(0));
    }

    @GetMapping("course-query")
    public ResponseEntity<CourseService> CourseServiceResponseVariable(@RequestParam int courseCode,
                                                         @RequestParam String subjectName,
                                                         @RequestParam int courseCredits)
    {
        CourseService course = new CourseService(courseCode, subjectName,courseCredits);
        return ResponseEntity.ok(course);
    }

//    // Get using CourseServiceCode using String
//    @GetMapping("/get-coursecode/{courseCode}")
//    public ResponseEntity<Course> getCourse(@PathVariable String courseCode){
//        return courseList.stream().filter( c->c.getCourseCode().equalsIgnoreCase(courseCode)).findFirst().map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }


    // Getting as Query with search/get-course
//    @GetMapping("/search/get-course")
//    public ResponseEntity<Course> searchCourse(@RequestParam String courseCode){
//   return courseList.stream().filter( c->c.getCourseCode().equalsIgnoreCase(courseCode)).findFirst().map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//   }


    // Create a new Student
    @PostMapping("create-course")
    public ResponseEntity<CourseService> createCourseService(@RequestBody CourseService course){
        courseList.add(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    // Update based on id
    @PutMapping("{courseCode}/update-course")
    public ResponseEntity<CourseService> updateCourseService(@PathVariable("courseCode") int courseCode,
                                               @RequestBody CourseService updateCourseService)
    {
//for(CourseService course : courseList){
//    if(course.getCourseServiceCode()==courseCode){
//        course.setSubjectName(updateCourseService.getSubjectName());
//        course.setCourseServiceCredits(updateCourseService.getCourseServiceCredits());
//        return ResponseEntity.ok(course);
//    }
//}
        CourseService course = courseList.stream().filter(c -> c.getCourseCode()==courseCode)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Course","CourseCode",String.valueOf(courseCode)));
        course.setSubjectName(updateCourseService.getSubjectName());
        course.setCredits(updateCourseService.getCredits());

        return ResponseEntity.ok(course);
    }


    @PutMapping("query/{courseCode}")
    public String queryCourse(@PathVariable String courseCode) throws Exception{
        if(courseCode.startsWith("*")){
            throw new IllegalAccessException("It is having a special Character");
        }
        else if (courseCode.startsWith("6")){
            throw new RuntimeException("Course code cannot start with 6");
        }
        return  "Valid Course Code : " + courseCode;
    }


//    // Delete Student (String method)
//    @DeleteMapping("delete-course/{courseCode}")
//    public ResponseEntity<String> deleteCourse(@PathVariable("courseCode") int courseCode){
//        Course course = courseList.stream().filter(c -> c.getCourseCode().equalsIgnoreCase(code)).findFirst().orElse(null);
//        courseList.remove(course);
//        return ResponseEntity.ok("deleted");
//    }

    // Delete Student
    @DeleteMapping("delete-course/{courseCode}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseCode") int courseCode){
        CourseService course = courseList.stream().filter(c -> c.getCourseCode()==courseCode)
                .findFirst()
                .orElse(null);
        courseList.remove(course);
        return ResponseEntity.ok("deleted");
    }



}