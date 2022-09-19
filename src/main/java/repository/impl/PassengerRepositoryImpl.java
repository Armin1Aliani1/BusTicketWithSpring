package repository.impl;

import base.BaseRepositoryImpl;
import domain.Passenger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import repository.PassengerRepository;

public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger> implements PassengerRepository {


    private org.springframework.orm.hibernate3.HibernateTemplate template;

    public PassengerRepositoryImpl(org.springframework.orm.hibernate3.HibernateTemplate hibernateTemplate) {
        super(hibernateTemplate);
    }

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Class<Passenger> getEntityClass() {
        return Passenger.class;
    }
}
