package com.senla.dao;

import com.senla.api.dao.IAnnouncementDao;
import com.senla.model.Announcement;
import com.senla.model.dto.filter.AnnouncementFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class AnnouncementDao extends AbstractDao<Announcement> implements IAnnouncementDao {

    @Override
    protected Class<Announcement> getClazz() {
        return Announcement.class;
    }

    @Override
    public List<Announcement> getByFilter(AnnouncementFilter announcementFilter) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Announcement> query = builder.createQuery( Announcement.class );
        Root<Announcement> root = query.from( Announcement.class );
        //if (adsPredicate(announcementFilter, builder, root).length != 0) {
        query.where( adsPredicate( announcementFilter, builder, root ) );
        if (announcementFilter.getOrderBy() != null && announcementFilter.getOrderDirection() != null) {
            if (announcementFilter.getOrderDirection().equals( "asc" )) {
                query.orderBy( builder.asc( root.get( announcementFilter.getOrderBy() ) ) );
            }
            if (announcementFilter.getOrderDirection().equals( "desc" )) {
                query.orderBy( builder.desc( root.get( announcementFilter.getOrderBy() ) ) );
            }
        }
        CriteriaQuery<Announcement> all = query.select( root );
        return getCurrentSession().createQuery( all ).getResultList();
        //}
        /*Session session = getCurrentSession();
        Query query1 = session.createQuery("select a from Announcement");
        List list1 = query1.getResultList();
        list1.addAll(list1);
        return list1;*/
    }

    private Predicate[] adsPredicate(AnnouncementFilter announcementFilter, CriteriaBuilder builder, Root<Announcement> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (!ObjectUtils.isEmpty(announcementFilter.getName())) {
            predicates.add(builder.like(root.get("name"), "%" + announcementFilter.getName() + "%"));
        }
        if (announcementFilter.getId() != null) {
            predicates.add(builder.equal(root.get("id"), announcementFilter.getId() ));
        }
        if (!ObjectUtils.isEmpty(announcementFilter.getAnnouncementStatus())) {
            predicates.add(builder.equal(root.get("announcementStatus"), announcementFilter.getAnnouncementStatus()));
        }
        if (!ObjectUtils.isEmpty(announcementFilter.getPostingDate())) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("postingDate"), announcementFilter.getPostingDate()));
        }
        if (announcementFilter.getPriceFrom() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("price"), announcementFilter.getPriceFrom()));
        }
        if (announcementFilter.getPriceTo() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("price"), announcementFilter.getPriceTo()));
        }
        if (!ObjectUtils.isEmpty(announcementFilter.getUserId())) {
            predicates.add(builder.equal(root.join( "user" ).get("id"), announcementFilter.getUserId()));
        }
        return predicates.toArray(new Predicate[]{});
    }
}
