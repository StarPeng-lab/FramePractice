package cn.she.test;

import cn.she.dao.ProvinceDao;
import cn.she.dao.impl.ProvinceDaoImpl;
import cn.she.domain.Province;
import org.junit.Test;
import java.util.List;

public class ProvinceTest {
    @Test
    public void find() throws Exception {
        ProvinceDao dao = new ProvinceDaoImpl();
        List<Province> list = dao.findAll();
        for(Province p : list){
            System.out.println(p.getId()+" : "+p.getName());
        }
    }

}
