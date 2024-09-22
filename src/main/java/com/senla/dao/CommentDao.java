package com.senla.dao;

import com.senla.api.dao.ICommentDao;
import com.senla.model.Comment;
import com.senla.model.dto.filter.CommentFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CommentDao extends AbstractDao<Comment> implements ICommentDao {

    @Override
    protected Class<Comment> getClazz() {
        return Comment.class;
    }

    @Override
    public List<Comment> getByFilter(CommentFilter commentFilter) {
        return null;
    }
}
