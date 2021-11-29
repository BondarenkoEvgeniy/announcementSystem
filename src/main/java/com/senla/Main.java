package com.senla;

import com.senla.api.service.IAnnouncementService;
import com.senla.api.service.ICommentService;
import com.senla.api.service.IMessageService;
import com.senla.api.service.IUserService;
import com.senla.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext ( SpringConfig.class  );
        IUserService userService = context.getBean( IUserService.class );
        IMessageService messageService = context.getBean( IMessageService.class );
        IAnnouncementService announcementService = context.getBean( IAnnouncementService.class );
        ICommentService commentService = context.getBean( ICommentService.class );
    }
}
