package ra.webmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.webmvc.models.entity.Student;
import ra.webmvc.models.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/add")
    public String processAddStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(
            @PathVariable("id") int id,
            Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/edit/{id}")
    public String processEditStudent(
            @PathVariable("id") int id,
            @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

   @GetMapping("/search")
    public String searchAndSort(
            @RequestParam("keyword") String keyword,
            @RequestParam(name = "order" , required = false, defaultValue = "asc") String order,
            Model model) {
        List<Student> filter = studentService.getStudentsByName(keyword);
        //sắp xết kết quả tìm kiếm
       if("asc".equals(order)) {
           filter.sort((s1,s2)-> s1.getId()-s2.getId());
       }else if("desc".equals(order)) {
           filter.sort((s1,s2)-> s2.getId()-s1.getId());
       }
       model.addAttribute("students", filter);
       return "students";
   }
}
