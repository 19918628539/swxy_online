package com.swxy_online.service.edu.controller.admin;


import com.swxy_online.service.edu.entity.Teacher;
import com.swxy_online.service.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author exion
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/getTeacherList")//查询讲师列表
    public List<Teacher> getTeacherList(){
        return teacherService.list();




    }
    @DeleteMapping("/removeTeacherById/{teacherId}")//删除讲师，根据id删除
    public Boolean removeTeacherById(@PathVariable String teacherId){
        return teacherService.removeById(teacherId);
    }
}

