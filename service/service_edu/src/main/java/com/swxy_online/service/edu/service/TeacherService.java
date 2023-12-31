package com.swxy_online.service.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swxy_online.service.edu.vo.TeacherQueryVo;
import com.swxy_online.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author exion
 * @since 2023-09-05
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> selectPage(Page<Teacher> pageInfo, TeacherQueryVo teacherQueryVo);
}
