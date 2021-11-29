package com.senla.service;

import com.senla.api.dao.ICommentDao;
import com.senla.api.service.ICommentService;
import com.senla.config.ModelMapperMapList;
import com.senla.model.Comment;
import com.senla.model.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentDao commentDao;
    @Autowired
    private ModelMapperMapList modelMapper;

    @Override
    public void createComment(CommentDto commentDto) {
        Comment comment = modelMapper.map( commentDto, Comment.class );
        comment.setCommentDate( LocalDate.now() );
        commentDao.save( comment );
    }

    @Override
    public void updateComment(CommentDto commentDto){
        Comment commentFirst = modelMapper.map( commentDto, Comment.class );
        Comment commentSecond = commentDao.getById( commentDto.getId() );
        commentSecond.setCommentText( commentFirst.getCommentText() );
        commentDao.update( commentSecond );
    }

    @Override
    public void deleteComment(Long id){
        Comment comment = commentDao.getById( id );
        commentDao.delete( comment );
    }

}
