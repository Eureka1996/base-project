package com.wufuqiang.thrift.client;

import com.wufuqiang.thrift.User;
import com.wufuqiang.thrift.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @author wufuqiang
 * @date 2022/6/26 20:30
 **/

public class NonblockingClient {
    public static void main(String[] args) {
        TTransport transport = null;
        try{
            transport = new TFramedTransport(new TSocket("localhost", 9090));
            TProtocol protocol = new TCompactProtocol(transport);
            UserService.Client client = new UserService.Client(protocol);
            transport.open();
            User user = client.getById(152);
            System.out.println("User:"+user);

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
