package com.senla.api.dao;

import com.senla.model.Comment;

import java.util.List;

public interface ICommentDao {
    Comment getById(Long id);

    void save (Comment comment);

    Comment update(Comment comment);

    void delete(Comment comment);

    List<Comment> getAll();
}
