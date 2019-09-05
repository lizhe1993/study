package springboot.mongo.springbootmongo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: MongoDBTest
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/29 15:30
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findAllUsersTest() {
        List<Map> users = this.mongoTemplate.findAll(Map.class, "users");
        if (users != null && !users.isEmpty()) {
            users.forEach(x->{
                System.out.println(x.toString());
            });
        }
    }

    @Test
    public void insertOneTest(){

        Map<String,Object> insert =Maps.newHashMap();
        insert.put("contact","15801372602");
        insert.put("dob","1992-11-11");
        insert.put("name","dazhe");

        Map<String, Object> user = this.mongoTemplate.insert(insert, "user");

        System.out.println(user.get("_id"));
    }

    @Test
    public void aa(){
        List<String> aa = Lists.newArrayList("lizhe","zhanghau","liusi");
        List<String> ad = aa.stream().filter(x->x.equals("lizhe")).collect(Collectors.toList());
        System.out.println(ad.toString());
    }
}
