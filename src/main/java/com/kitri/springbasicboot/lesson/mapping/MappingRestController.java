package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/students")    // localhost:8080/students
public class MappingRestController {
    static HashMap<Long, Student> students = new HashMap<>();
    static {
        students.put(1L, new Student(1L, "한민선"));
        students.put(2L, new Student(2L, "한민선"));
        students.put(3L, new Student(3L, "한민선"));
        students.put(4L, new Student(4L, "한민선"));
    }
    @GetMapping("/student")
    public String student(){
        return "학생";
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return students.get(id);
    }
    @GetMapping("")
    public Object[] getAll(){
        return students.values().stream().toArray();
        // new ArrayList<Student>(students.values());
    }
    @GetMapping("/all2")
    public ArrayList<Student> getAll2(){
        // students.values().stream().toArray();
        return new ArrayList<Student>(students.values());
    }
    @PostMapping(path = "",consumes = {"application/json"})
    public Long addStudent(){
        new Student(5L, "아무개");
        return 5L;
        // new ArrayList<Student>(students.values());
    }
    @GetMapping(path = "/produces", produces = {"application/json"})
    public String produces(){
        return "OK";
    }
}