package com.wufuqiang.jdbc;

import com.wufuqiang.jdbc.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu Fuqiang
 * @date 2021/11/20 12:58 下午
 */
public class JdbcTemplate {

    public static <T> T query(String sql,IRowMapper<T> rsh,Object ... params){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < params.length;i++){
                ps.setObject(i+1,params[i]);
            }
            rs = ps.executeQuery();
            return rsh.mapping(rs);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close();
        }
        return null;
    }

    public static void main(String[] args) {
        String sql = "select count(*) total from student";
        final Long total = JdbcTemplate.query(sql, new IRowMapper<Long>() {
            @Override
            public Long mapping(ResultSet rs) throws Exception {
                Long totalCount = null;
                if (rs.next()) {
                    totalCount = rs.getLong("total");
                }
                return totalCount;
            }
        });
        
        String sql2 = "select * from student";
        final List<Student> students = JdbcTemplate.query(sql2, new IRowMapper<List<Student>>() {
            @Override
            public List<Student> mapping(ResultSet rs) throws Exception {
                List<Student> list = new ArrayList<>();
                while(rs.next()){
                    long id = rs.getLong("id");
                    final String name = rs.getString("name");
                    final int age = rs.getInt("age");
                    Student student = new Student();
                    list.add(student);
                }
                return list;
            }
        });


    }
}
