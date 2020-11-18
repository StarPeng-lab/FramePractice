package cn.she.dao.impl;

import cn.she.dao.ProvinceDao;
import cn.she.domain.Province;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    @Override
    public List<Province> findAll() throws Exception{

        /**
         * 从数据库中取数，须有四个属性
         * 数据库驱动，连接数据库的地址，数据库用户名称，数据库密码
         */

        List<Province> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8","root","root");
            //3、获取执行数据的对象
            pst= conn.prepareCall("select * from province");
            //4、执行sql，获得结果集对象
            rs = pst.executeQuery();
            //5、把结果集转为java的List集合
            while(rs.next()){
                Province p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                list.add(p);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
            pst.close();
            rs.close();
        }

        return list;
    }
}
