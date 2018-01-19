package com.tcs.springframework.test.dstest;

/**
 * Created by jt on 5/21/16.
 */

import com.tcs.springframework.test.config.DataSourceConfig;
import com.tcs.springframework.test.ds.FakeDataSource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DataSourceConfig.class)
@ActiveProfiles("com/tcs")
@Ignore
public class DataSourceTest {

    private FakeDataSource fakeDataSource;

    @Autowired
    public void setFakeDataSource(FakeDataSource fakeDataSource) {
        this.fakeDataSource = fakeDataSource;
    }

    @Test
    public void TestDataSource() throws Exception {

        System.out.println(fakeDataSource.getConnectionInfo());

    }
}