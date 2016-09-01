package com.movies.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class MovieDao {
    @Autowired
    SessionFactory sessionFactory;
    
    public Movie getById(int id){
    return (Movie)sessionFactory.getCurrentSession().get(Movie.class, id);
        
    }
     public List<Movie> findByPage(int page){
         int perpage=3;
        Session session=sessionFactory.getCurrentSession();
        List<Movie> movies=session.createQuery("from Movies").setFirstResult(page*perpage).setMaxResults(perpage).list();
        return movies;
    }
    
    public List<Movie> findByCategory(int id){
        Session session=sessionFactory.getCurrentSession();
        List<Movie> movies=session.getNamedQuery("Movie.findByCategory").setInteger("category", id).list();
        return movies;
    }
    public Long pages(){
        return  ((Double)Math.ceil((Long)sessionFactory.getCurrentSession().createQuery("select count(id) from Movie").uniqueResult()/3)).longValue();
    }
    public void update(Movie movie){
         sessionFactory.getCurrentSession().update(movie);
     }
    
    public List<Movie> find(){
        Session session=sessionFactory.getCurrentSession();
        List<Movie> movies=session.createCriteria(Movie.class).list();
       
        return movies;
    } 

}
