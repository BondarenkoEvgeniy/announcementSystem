package com.senla.api.service;

import com.senla.model.Message;
import com.senla.model.dto.MessageDto;
import com.senla.model.dto.filter.MessageFilter;

import java.util.List;

public interface IMessageService {

    void createMessage(MessageDto messageDto);

    void updateMessage(MessageDto messageDto);

    void deleteMessage(Long id);

    List<MessageDto> getByFilter(MessageFilter messageFilter);
}
