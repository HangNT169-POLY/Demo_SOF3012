package com.poly.sof3012.B1_5_Hibernate.repository;

import com.poly.sof3012.B1_5_Hibernate.entity.Product;
import com.poly.sof3012.B1_5_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {

    private Session s;

    public ProductRepository() {
        // MO CONG KET NOI => SESSION
        // => MO 1 LAN DUY NHAT (singleton)
        s = HibernateUtil.getFACTORY().openSession();
    }
    // Them/Sua/Xoa/Load/Detail

    // READ => SELECT
    public List<Product> getAll() {
        // Truy van tren thuc the => FROM tu thuc the
        return s.createQuery("FROM Product ").list();
    }
}
