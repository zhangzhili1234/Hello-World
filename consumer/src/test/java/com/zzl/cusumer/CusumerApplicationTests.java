package com.zzl.cusumer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CusumerApplicationTests {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("abc", "123");
    }

    @Test
    public void testShiro() {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("abc", "123");
        subject.login(token);
        System.out.println("是否认证：" + subject.isAuthenticated());
    }

    @Test
    public void testShiro1() {
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("abc", "123");
        subject.login(token);
        System.out.println("是否认证：" + subject.isAuthenticated());
        subject.checkRoles("admin", "user");
        subject.checkPermission("user:delete");
    }

    @Test
    public void testShiro2() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        
        DefaultSecurityManager manager = new DefaultSecurityManager();
        // manager.setRealm();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("abc", "123");
        subject.login(token);
        System.out.println("是否认证：" + subject.isAuthenticated());
        subject.checkRoles("admin", "user");
        subject.checkPermission("user:delete");
    }
}
