package com.online.edu;

import com.online.edu.dao.TestDao;
import com.online.edu.dao.UserDao;
import com.online.edu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class plusTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TestDao testDao;

    @Test
    public void selectAllUser(){
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("loginname","cy");
        conditions.put("password","123");
        List<User> userList = userDao.selectByMap(conditions);
        System.out.println(userList);
        for(User user : userList) {
            System.out.println(user.getLoginname());
            System.out.println(user.getType());
        }

//        User usertype = userService.userType(loginname, type);
        Map<String, Object> con = new HashMap<>();
        con.put("loginname","cy");
        con.put("type","1");
        List<User> userL = userDao.selectByMap(con);
        System.out.println(userL);

    }
    @Test
    public void testInsert(){
        com.online.edu.entity.Test test = new com.online.edu.entity.Test();
        test.setName("切格瓦拉");
        test.setPassword("dawdsac");
        test.setGender(0);
        int result = testDao.insert(test);
        System.out.println(result);
    }

    @Test
    public int testUpdate(){
        com.online.edu.entity.Test test = new com.online.edu.entity.Test();
        test.setId(1);
        test.setName("lao_yan");
        test.setGender(0);
        int result = testDao.updateById(test);
        return result;
    }
    @Test
    public void testSelect(){
//        System.out.println(testDao.selectById(2));
//       List list = new ArrayList();
//       list.add(1);
//       list.add(2);
//
//        List list1 = testDao.selectBatchIds(list);
//        list1.forEach(lis ->System.out.println(testDao.selectBatchIds(list)));
        Map<String,Object> map = new HashMap();
        map.put("name","云");
        map.put("password","1455");
        List<com.online.edu.entity.Test> tests = testDao.selectByMap(map);
        if(tests.isEmpty()){
            System.out.println("用户不存在");
        }else {
            System.out.println(tests);
        }
    }
    @Test
    public void testDelete(){
        testDao.deleteById(1);
    }

    @Test
    public void checkNameNo(){
        Map<String, Object> map = new HashMap<>();
        map.put("loginname","cy");
        map.put("password","234");
        List<User> userList = userDao.selectByMap(map);
        System.out.println(userList);
        if(userList.isEmpty()){
            System.out.println("密码错误，请重新输入密码");
        }else {
            System.out.println("密码验证通过！");
    }
    }
}
