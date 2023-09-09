package com.swxy_online.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swxy_online.service.edu.vo.TeacherQueryVo;
import com.swxy_online.service.edu.entity.Teacher;
import com.swxy_online.service.edu.mapper.TeacherMapper;
import com.swxy_online.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author exion
 * @since 2023-09-05
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Page<Teacher> selectPage(Page<Teacher> pageInfo, TeacherQueryVo teacherQueryVo) {
        //显示分页查询列表
        //1、排序 sort字段
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        //2、分页查询
        if (teacherQueryVo == null){
            return baseMapper.selectPage(pageInfo, queryWrapper);
        }
        //3、条件查询
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String begin = teacherQueryVo.getJoinDateBegin();
        String end = teacherQueryVo.getJoinDateEnd();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.likeRight("name", name);
        }
        if (level != null){
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)){
            queryWrapper.ge("join_date", begin);
        }
        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("join_date", end);
        }
        return baseMapper.selectPage(pageInfo, queryWrapper);
    }
}
