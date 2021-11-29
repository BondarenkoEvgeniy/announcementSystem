package com.senla.api.service;

import com.senla.model.dto.CommentDto;

public interface ICommentService {

    void createComment(CommentDto commentDto);

    void updateComment(CommentDto commentDto);

    void deleteComment(Long id);
}
