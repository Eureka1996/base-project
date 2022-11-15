package com.wufuqiang.thrift.client;

import com.wufuqiang.thrift.User;
import com.wufuqiang.thrift.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author wufuqiang
 * @date 2022/6/26 10:16
 **/

public class SimpleClient {
    public static void main(String[] args) {
        TTransport transport = null;
        try{
            // 使用阻塞IO
            transport = new TSocket("localhost", 9090);
            // 指定二进制编码格式
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            UserService.Client client = new UserService.Client(protocol);
            transport.open();
            User result = client.getById(111);
            System.out.println("User info:"+result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
