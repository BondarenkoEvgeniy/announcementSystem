package com.senla.api.service;

import com.senla.model.Announcement;
import com.senla.model.dto.AnnouncementDto;
import com.senla.model.dto.filter.AnnouncementFilter;

import java.util.List;

public interface IAnnouncementService {

    void createAnnouncement(AnnouncementDto announcementDto);

    void updateAnnouncement(AnnouncementDto announcementDto);

    List<AnnouncementDto> getByFilter(AnnouncementFilter announcementFilter);

    void deleteAnnouncement(Long id);
}
