package com.wufuqiang.es;

import com.wufuqiang.es.utils.EsUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author wufuqiang
 * @date 2022/2/5 5:24 PM
 **/

public class TestMain {

    EsUtils esUtils = new EsUtils();

    @Test
    public void test() throws IOException {
        //EsUtils esUtils = new EsUtils();
        esUtils.search();
    }

    @Test
    public void createIndex() throws IOException {
        esUtils.createIndex("user");
    }

    @Test
    public void deleteIndex() throws IOException {
        esUtils.deleteIndex("user");
    }

    @Test
    public void insertDocument() throws IOException {
        esUtils.insertDocument();
    }

    @Test
    public void insertDocumentBatch() throws IOException {
        esUtils.insertBatch("user");
    }
}
