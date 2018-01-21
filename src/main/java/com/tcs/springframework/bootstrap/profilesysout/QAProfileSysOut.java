package com.tcs.springframework.bootstrap.profilesysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by at on 5/21/16.
 */
@Component
@Profile("qa")
public class QAProfileSysOut {

    @Autowired
    public QAProfileSysOut(@Value("${com.tcs.springframework.profile.message}") String msg) {
        System.out.println("##################################");
        System.out.println("##################################");
        System.out.println("##               QA             ##");
        System.out.println(msg);
        System.out.println("##################################");
        System.out.println("##################################");
    }
}
