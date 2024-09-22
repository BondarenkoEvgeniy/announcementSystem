package com.senla.controller;

import com.senla.api.service.IAnnouncementService;
import com.senla.api.service.ICommentService;
import com.senla.model.dto.AnnouncementDto;
import com.senla.model.dto.CommentDto;
import com.senla.model.dto.filter.AnnouncementFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ad")
public class AnnouncementController {

    @Autowired
    private IAnnouncementService announcementService;

    @Autowired
    private ICommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createAd(@RequestBody AnnouncementDto announcementDto) {
        announcementService.createAnnouncement(announcementDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateAd(@RequestBody AnnouncementDto announcementDto) {
        announcementService.updateAnnouncement(announcementDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<AnnouncementDto>> getAdsByFilter(AnnouncementFilter announcementFilter) {
        return ResponseEntity.ok(announcementService.getByFilter(announcementFilter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/comment")
    public ResponseEntity<Void> addComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
        return ResponseEntity.noContent().build();
    }
}
