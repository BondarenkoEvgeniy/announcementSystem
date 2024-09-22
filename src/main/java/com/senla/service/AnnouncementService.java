package com.senla.service;

import com.senla.api.dao.IAnnouncementDao;
import com.senla.api.service.IAnnouncementService;
import com.senla.config.ExtendedModelMapper;
import com.senla.model.Announcement;
import com.senla.model.dto.AnnouncementDto;
import com.senla.model.dto.filter.AnnouncementFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class AnnouncementService implements IAnnouncementService {

    @Autowired
    private IAnnouncementDao announcementDao;
    @Autowired
    private ExtendedModelMapper modelMapper;

    @Override
    public void createAnnouncement(AnnouncementDto announcementDto) {
        Announcement announcement = modelMapper.map( announcementDto, Announcement.class );
        announcement.setPostingDate( LocalDate.now() );
        announcementDao.save( announcement );
    }

    @Override
    public void updateAnnouncement(AnnouncementDto announcementDto){
        Announcement announcementFirst = modelMapper.map( announcementDto, Announcement.class );
        Announcement announcementSecond = announcementDao.getById( announcementDto.getId() );
        announcementSecond.setName( announcementFirst.getName() );
        announcementSecond.setDescription( announcementFirst.getDescription() );
        announcementSecond.setAnnouncementStatus( announcementFirst.getAnnouncementStatus() );
        announcementSecond.setPrice(announcementFirst.getPrice());
        announcementDao.update( announcementSecond );
    }

    @Override
    public List<AnnouncementDto> getByFilter(AnnouncementFilter announcementFilter) {
        return modelMapper.mapList(announcementDao.getByFilter(announcementFilter), AnnouncementDto.class);
    }

    @Override
    public void deleteAnnouncement(Long id){
        Announcement announcement = announcementDao.getById( id );
        announcementDao.delete( announcement );
    }
}

