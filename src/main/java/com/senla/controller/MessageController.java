package com.senla.controller;

import com.senla.api.service.IMessageService;
import com.senla.model.dto.MessageDto;
import com.senla.model.dto.filter.MessageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @PostMapping
    public ResponseEntity<Void> createMessage(@RequestBody MessageDto messageDto) {
        messageService.createMessage(messageDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateMessage(@RequestBody MessageDto messageDto) {
        messageService.updateMessage(messageDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<MessageDto>> getMessageByFilter(MessageFilter messageFilter) {
        return ResponseEntity.ok(messageService.getByFilter(messageFilter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
