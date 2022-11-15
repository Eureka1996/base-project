package com.wufuqiang.thrift.service;

import com.wufuqiang.thrift.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author wufuqiang
 * @date 2022/6/26 10:51
 **/

public class ThreadPoolService {
    public static void main(String[] args) {
        try{
            TServerSocket serverTransport = new TServerSocket(9090);
            UserService.Processor processor = new UserService.Processor(new UserServiceImpl());

            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();

            TThreadPoolServer.Args targs = new TThreadPoolServer.Args(serverTransport);
            targs.processor(processor);
            targs.protocolFactory(protocolFactory);

            TServer server = new TThreadPoolServer(targs);
            System.out.println("Starting the simple server ...");
            // 启动服务
            server.serve();


        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
