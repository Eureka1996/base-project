package com.wufuqiang.clickhouse;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Wu Fuqiang
 * @date 2021/10/21 4:49 下午
 */
public class ClickHouseDemo {

    /**
     * 测试连通性
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @Test
    public void testConnection() throws ClassNotFoundException, IOException{
        Properties properties = getProperties("config.properties");
        String host = properties.getProperty("clickhouse.host");
        String port = properties.getProperty("clickhouse.port");
        String user = properties.getProperty("clickhouse.user");
        String password = properties.getProperty("clickhouse.password");
        String url = String.format("jdbc:clickhouse://%s:%s",host,port);
        System.out.println(url);
        Class.forName("ru.yandex.clickhouse.ClickHouseDriver");
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println(String.format("clickhouse %s:%s 连通性良好.",host,port));
            }else{
                System.out.println(String.format("clickhouse %s:%s 无法连通.",host,port));
            }
        } catch (SQLException throwables) {
            System.out.println(String.format("clickhouse %s:%s 无法连通.",host,port));
            throwables.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void getDatabases() throws IOException, ClassNotFoundException, SQLException {

        Properties properties = getProperties("config.properties");
        String host = properties.getProperty("clickhouse.host");
        String port = properties.getProperty("clickhouse.port");
        String user = properties.getProperty("clickhouse.user");
        String password = properties.getProperty("clickhouse.password");
        String url = String.format("jdbc:clickhouse://%s:%s",host,port);
        System.out.println(url);
        Class.forName("ru.yandex.clickhouse.ClickHouseDriver");
        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select distinct name from system.databases";
        Set<String> databases = new TreeSet<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()
        ){
            while (resultSet.next()){
                final String database = resultSet.getString(1);
                databases.add(database);
            }
        }catch (Exception e){

        }
        databases.forEach(System.out::println);
    }



    public Properties getProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        InputStream in = ClickHouseDemo.class.getClassLoader().getResourceAsStream(fileName);
        properties.load(in);
        return properties;
    }
}
