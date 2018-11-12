package hnu;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 2018/4/24.
 */

@RestController
@RequestMapping("/bgm5")  //虚拟目录吧
public class MyController {
    @GetMapping("/hello")   //方法映射
    //@ResponseBody  //表示不要对内容进行解析
    public String hello(){
        return  "Hello World!! my Program!!!!";
    }

    //GET方式得到数据，返回结果为JSON
    //注解表明浏览器地址栏中显示的参数，供js调用的方式
    @RequestMapping(value="/person/{personId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId){
        //PathVariable是前方给的参数，后面的参数函数内部使用
        Person p=new Person();
        p.setId(personId);
        p.setName("yangshenghong");
        p.setAge(53);
        return p;
    }

    @PostMapping("/person2")
    @ResponseBody
    public Person findPerson(@RequestParam String username,@RequestParam String userpass){
        Person p=new Person();
        p.setId(123456);
        p.setName(username+userpass);
        p.setAge(53);
        return p;
    }
    @PostMapping("/personverify")
    @ResponseBody
    public testpw testPerson(@RequestParam String username,@RequestParam String userpass){
        testpw p=new testpw();
        p.setId(99999);
        p.setPassyn(0);
        p.setUserName(username+userpass);
        //真实的语句应从密码表中读取数据，获取用户名为username的所有记录，比较密码是否正确
        //可能要进行RSA运算或DES加密解密，或者获取MD5值等
        if (userpass.equals("666333")){
            p.setPassyn(1);
        }
        return p;
    }
    @PostMapping("/person3")
    @ResponseBody
    public List<Person> findPerson3(@RequestParam String username,@RequestParam String userpass){
        Person p=new Person();
        List<Person> list=new ArrayList<>();
        p.setId(123456);
        p.setName(username+userpass);
        p.setAge(53);
        list.add(p);
        //没有这条语句则只有最后一条记录的数据，没有新建对象也
        p=new Person();
        p.setId(100000);
        p.setAge(88);
        p.setName("yangshenghong"+username+"-"+userpass);
        list.add(p);
        return list;
    }

}
