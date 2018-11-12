package hnu.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: ${todo} {一句话描述类是干什么的}<br/>
 *
 * @author zhangcanhui
 * @version 1.0
 * @date: 2018/11/8 14:41
 * @since JDK 1.8
 */
@RestController
public class GetDataController {
    @RequestMapping(value="/get")
    public void getData(){
        String url="https://www.tianyancha.com/search?key=%E8%85%BE%E8%AE%AF";
        try{
            org.jsoup.nodes.Document doc= Jsoup.connect(url).get();
            Elements elements=doc.getElementsByClass("content");
            Element firstElement=elements.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
