package com.senla.api.dao;

import com.senla.model.Announcement;
import com.senla.model.dto.filter.AnnouncementFilter;

import java.util.List;

public interface IAnnouncementDao {
    Announcement getById(Long id);

    void save (Announcement announcement);

    Announcement update(Announcement announcement);

    void delete(Announcement Announcement);

    List<Announcement> getAll();

    List<Announcement> getByFilter(AnnouncementFilter announcementFilter);
}
