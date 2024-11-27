package Repository;

import entity.SanPham;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Hibernates;

import java.util.List;

public class SanPhamRepos {


    public List<SanPham> getAll() {
        Session session = Hibernates.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp From SanPham sp");
        List<SanPham> list = query.getResultList();
        session.close();
        return list;
    }

    public SanPham detail(Integer id) {
        Session session = Hibernates.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp From SanPham sp where sp.id = :idSp");
        query.setParameter("idSp", id);
        SanPham sanPham = (SanPham) query.getSingleResult();
        session.close();
        return sanPham;
    }

    public void add(SanPham sp) {
        Session session = Hibernates.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(sp);
        transaction.commit();
        session.close();
    }
    public void Update(SanPham sp) {
        Session session = Hibernates.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(sp);
        transaction.commit();
        session.close();
    }

    public void delete(SanPham sp) {
        Session session = Hibernates.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(sp);
        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepos().getAll();
        for (SanPham sanPham:
                list) {
            System.out.println(sanPham);
        }
    }
}
