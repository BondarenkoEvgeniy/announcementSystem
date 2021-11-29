package com.senla.api.dao;

import com.senla.model.Message;
import com.senla.model.dto.filter.MessageFilter;

import java.util.List;

public interface IMessageDao {
    Message getById(Long id);

    void save (Message message);

    Message update(Message message);

    void delete(Message message);

    List<Message> getAll();

    List<Message> getByFilter(MessageFilter messageFilter);
}
