package com.wufuqiang.thrift.service;

import com.wufuqiang.thrift.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author wufuqiang
 * @date 2022/6/26 10:51
 **/

public class TNonblockingService {
    public static void main(String[] args) {
        try{
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
            // 获取processor
            UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
            // 指定TCompactProtocol
            TCompactProtocol.Factory protocolFactory = new TCompactProtocol.Factory();

            TFramedTransport.Factory tTransport = new TFramedTransport.Factory();

            TNonblockingServer.Args targs = new TNonblockingServer.Args(serverTransport);
            targs.processor(processor);
            targs.protocolFactory(protocolFactory);
            targs.transportFactory(tTransport);

            TServer server = new TNonblockingServer(targs);
            System.out.println("Starting the simple server ...");
            // 启动服务
            server.serve();


        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
