package com.eduhub.eduhub.Controller;


import com.eduhub.eduhub.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // Returns one Student
    @GetMapping("student")
    public ResponseEntity<StudentService> getStudent() {
        StudentService studentService = new StudentService(1, "Shankar", "L");
        return new ResponseEntity<>(studentService, HttpStatus.OK);
    }

    // Returns list of Students
    @GetMapping("students")
    public ResponseEntity<List<StudentService>> getStudents() {
        List<StudentService> studentServiceList = new ArrayList<>();
        studentServiceList.add(new StudentService(1, "Shankar", "L"));
        studentServiceList.add(new StudentService(2, "Tom", "Holland"));
        studentServiceList.add(new StudentService(3, "Peeter", "Porker"));
        studentServiceList.add(new StudentService(4, "Tony", "Stark"));

        return new ResponseEntity<>(studentServiceList, HttpStatus.OK);
    }

    // Get Student details using https://localhost:8080/id/firstName/lastName
    @GetMapping("{id}/{firstName}/{lastName}")
    public ResponseEntity<StudentService> studentServicePathVariable(@PathVariable("id") int studentId,
                                                                     @PathVariable("firstName") String firstName,
                                                                     @PathVariable("lastName") String lastName) {
        StudentService studentService2 = new StudentService(studentId, firstName, lastName);
        return new ResponseEntity<>(studentService2, HttpStatus.OK);
    }

    // Get Student details using http://localhost:8080/query?id=studentId&firstName=firstName&lastName=lastName
    @GetMapping("query")
    public ResponseEntity<StudentService> studentServiceResponseVariable(@RequestParam int id,
                                                                         @RequestParam String firstName,
                                                                         @RequestParam String lastName) {
        StudentService studentService3 = new StudentService(id, firstName, lastName);
        return ResponseEntity.ok(studentService3);
    }

    // Create a new Student
    @PostMapping("create")
    public ResponseEntity<StudentService> createStudent(@RequestBody StudentService studentService4) {
        System.out.println(studentService4.getId());
        System.out.print(studentService4.getFirstName());
        System.out.println(studentService4.getLastName());
        return ResponseEntity.ok(studentService4);
    }

    // Update Student
    @PutMapping("update")
    public ResponseEntity updateStudent() {
        return ResponseEntity.badRequest().body("Love You Baby!");
    }

    // Update based on id
    @PutMapping("{id}/update")
    public ResponseEntity updateStudents(@PathVariable("id") int studentId,
                                         @RequestBody StudentService studentService5) {
        return ResponseEntity.accepted().body(studentService5);
    }

    // Delete Student
    @DeleteMapping("{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.accepted().body("Data deleted successfully");
    }
}