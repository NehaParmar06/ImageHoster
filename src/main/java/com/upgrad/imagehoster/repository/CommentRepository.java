package com.upgrad.imagehoster.repository;

import com.upgrad.imagehoster.model.Comment;
import com.upgrad.imagehoster.model.Image;
import com.upgrad.imagehoster.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public void addComment(Comment newComment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Comment> getComments(Image image) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c from Comment c where c.image =:image", Comment.class);
            List<Comment> resultList = typedQuery.getResultList();
            return resultList;
        } catch (NoResultException nre) {
            return null;
        }
    }
}
