package com.swxy_online.service.edu.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swxy_online.common.base.result.R;
import com.swxy_online.service.edu.vo.TeacherQueryVo;
import com.swxy_online.service.edu.entity.Teacher;
import com.swxy_online.service.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "讲师列表查询", notes = "讲师列表查询")
    @GetMapping("/getTeacherList")//查询讲师列表
    public R getTeacherList(){
        return R.ok().data("items",teacherService.list());

    }
    @ApiOperation(value = "根据ID删除讲师", notes = "根据ID删除讲师，逻辑删除")
    @DeleteMapping("/removeTeacherById/{teacherId}")//删除讲师，根据id删除
    public R removeTeacherById(@ApiParam(value = "讲师id",required = true) @PathVariable String teacherId){
        boolean result = teacherService.removeById(teacherId);
        if (result){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("数据不存在");
        }
    }
    @GetMapping("/listPage/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码",required = true)@PathVariable Long page,
                      @ApiParam(value = "查询条数",required = true)@PathVariable Long limit,
                      @ApiParam(value = "讲师查询对象") TeacherQueryVo teacherQueryVo){
        Page<Teacher> pageInfo = new Page<>(page,limit);
        Page<Teacher> teacherPage = teacherService.selectPage(pageInfo,teacherQueryVo);
        List<Teacher> records = pageInfo.getRecords();
        long total = pageInfo.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }
}