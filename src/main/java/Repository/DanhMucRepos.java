package Repository;

import entity.DanhMuc;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.Hibernates;

import java.util.List;

public class DanhMucRepos {

    public List<DanhMuc> getAll() {
        Session session = Hibernates.getFACTORY().openSession();
        Query query = session.createQuery("SELECT sp From DanhMuc sp");
        List<DanhMuc> list = query.getResultList();
        session.close();
        return list;
    }
}
