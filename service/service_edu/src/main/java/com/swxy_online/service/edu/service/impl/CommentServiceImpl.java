package com.swxy_online.service.edu.service.impl;

import com.swxy_online.service.edu.entity.Comment;
import com.swxy_online.service.edu.mapper.CommentMapper;
import com.swxy_online.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author exion
 * @since 2023-09-05
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
