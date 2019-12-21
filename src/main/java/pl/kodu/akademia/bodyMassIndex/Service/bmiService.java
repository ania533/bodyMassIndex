package pl.kodu.akademia.bodyMassIndex.Service;

import org.decimal4j.util.DoubleRounder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kodu.akademia.bodyMassIndex.Model.bodyMassIndex;

import java.util.List;


@Service
    public class bmiService implements IbmiService {
    @Autowired
    HibernateSessionFactoryService hfs;

    public double policzoneBMI(bodyMassIndex solve){
        double height =(double) solve.getWzrost()/(double)100;
        double bmi = (solve.getWaga()/Math.pow(height,2));
        double bmi2 = DoubleRounder.round(bmi,2);
       return  bmi2;
    }

    public void saveBmi (bodyMassIndex bodyMassIndex){
        Session session = hfs.getSession();
        Transaction tx = session.beginTransaction();
        session.save(bodyMassIndex);
        tx.commit();
        session.close();
    }
    public bodyMassIndex getbodyMassIndexById(int id){
        Session session=this.hfs.getSession();
        bodyMassIndex bodyMassIndex =(bodyMassIndex)session.createQuery("FROM pl.kodu.akademia.bodyMassIndex.Model.bodyMassIndex WHERE id= " + id).uniqueResult();
        session.close();
        return bodyMassIndex;
    }
    public void updateBMI(bodyMassIndex uptateBodyMass){
        Session session = hfs.getSession();
        session.update(uptateBodyMass);
        session.close();
    }
    public List<bodyMassIndex> getInformWithForm(){
        Session session = this.hfs.getSession();
        List<bodyMassIndex> lista = session.createQuery("FROM pl.kodu.akademia.bodyMassIndex.Model.bodyMassIndex").list();
        session.close();
        return lista;
    }
    public List<bodyMassIndex> getBodyMassIndexByWaga(int waga){
        Session session=this.hfs.getSession();
        List<bodyMassIndex> wagi=  session.createQuery("FROM pl.kodu.akademia.bodyMassIndex.Model.bodyMassIndex where waga= " + waga).list();
        session.close();
        return wagi;
    }
}



