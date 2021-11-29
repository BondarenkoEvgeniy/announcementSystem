package com.senla.dao;

import com.senla.api.dao.IMessageDao;
import com.senla.model.Message;
import com.senla.model.dto.filter.MessageFilter;
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
public class MessageDao extends AbstractDao<Message> implements IMessageDao {

    @Override
    protected Class getClazz() {
        return Message.class;
    }

    @Override
    public List<Message> getByFilter(MessageFilter filter) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(getClazz());
        Root<Message> root = query.from(getClazz());
        query.where(getPredicates(filter, builder, root));
        CriteriaQuery<Message> all = query.select(root);
        return getCurrentSession().createQuery(all).getResultList();
    }

    private Predicate[] getPredicates(MessageFilter messageFilter, CriteriaBuilder builder, Root<Message> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (messageFilter.getId() != null) {
            predicates.add(builder.equal(root.get("id"), messageFilter.getId()));
        }
        if (!ObjectUtils.isEmpty(messageFilter.getMessageText())) {
            predicates.add(builder.like(root.get("messageText"), "%" + messageFilter.getMessageText() + "%"));
        }
        if (messageFilter.getMessageFromUser() != null) {
            predicates.add(builder.equal(root.join("messageFromUser").get("id"), messageFilter.getMessageFromUser()));
        }
        return predicates.toArray(new Predicate[]{});
    }
}
