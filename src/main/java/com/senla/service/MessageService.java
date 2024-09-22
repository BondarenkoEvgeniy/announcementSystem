package com.senla.service;

import com.senla.api.dao.IMessageDao;
import com.senla.api.service.IMessageService;
import com.senla.config.ExtendedModelMapper;
import com.senla.model.Message;
import com.senla.model.dto.MessageDto;
import com.senla.model.dto.filter.MessageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageDao messageDao;
    @Autowired
    private ExtendedModelMapper modelMapper;

    @Override
    public void createMessage(MessageDto messageDto) {
        Message message = modelMapper.map(messageDto, Message.class);
        message.setMessageDate( LocalDate.now() );
        messageDao.save( message );
    }

    @Override
    public void updateMessage(MessageDto messageDto) {
        Message messageFirst = modelMapper.map(messageDto, Message.class);
        Message messageSecond = messageDao.getById( messageDto.getId() );
        messageSecond.setMessageText( messageFirst.getMessageText() );
        messageDao.update( messageSecond );
    }

    @Override
    public void deleteMessage(Long id){
        Message message = messageDao.getById( id );
        messageDao.delete( message );
    }

    @Override
    public List<MessageDto> getByFilter(MessageFilter messageFilter) {
        return modelMapper.mapList(messageDao.getByFilter(messageFilter), MessageDto.class);
    }
}
