package hnu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Description: ${爬取数据}
 *
 * @author zhangcanhui
 * @version 1.0
 * @date: 2018/11/8 16:24
 * @since JDK 1.8
 */
public class GetDataTest {
    public static String url="http://www.tianyancha.com/search?key=%E8%85%BE%E8%AE%AF";
    public static Map<String,String> headers=new HashMap<>();
    static {
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("Accept-Encoding", " gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Cache-Control", "no-cache");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "TYCID=459b7760671911e88a962752a04d49e3; undefined=459b7760671911e88a962752a04d49e3; ssuid=8800877279; aliyungf_tc=AQAAAJaEZlt/LgoAlAFM2q76k16Acws9; csrfToken=ebZ222cIdpZBqAQLLefohzTT; _ga=GA1.2.1043693661.1541656659; _gid=GA1.2.248580359.1541656659; bannerFlag=true; RTYCID=d60f1634a5e44461887b801ec5347579; CT_TYCID=0e2bded5cce44b44a8bef56c29a204a0; cloud_token=a2cb19178fca467285af880f0aaf1d25; token=70a1ce32f1a84d3395364a9858a0e47f; _utm=8dc98349cf3f4b6293ecee4786167b04; tyc-user-info=%257B%2522myQuestionCount%2522%253A%25220%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522state%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522monitorUnreadCount%2522%253A%25220%2522%252C%2522discussCommendCount%2522%253A%25220%2522%252C%2522new%2522%253A%25221%2522%252C%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTI3NDk2MzgyNiIsImlhdCI6MTU0MTY2NzA1NSwiZXhwIjoxNTU3MjE5MDU1fQ.U-vu1TOdC_0ThSu6ZCgGusoRz_ft6FY0gbzdMvX7k4J0RWl68hKhSDud-PRIcHYof0_TqgHZWAMFeU1IN632Yg%2522%252C%2522redPoint%2522%253A%25220%2522%252C%2522pleaseAnswerCount%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522bizCardUnread%2522%253A%25220%2522%252C%2522mobile%2522%253A%252215274963826%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTI3NDk2MzgyNiIsImlhdCI6MTU0MTY2NzA1NSwiZXhwIjoxNTU3MjE5MDU1fQ.U-vu1TOdC_0ThSu6ZCgGusoRz_ft6FY0gbzdMvX7k4J0RWl68hKhSDud-PRIcHYof0_TqgHZWAMFeU1IN632Yg; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1541656659,1541659805,1541667039; _gat_gtag_UA_123487620_1=1; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1541667910");
        headers.put("DNT", "1");
        headers.put("Host", "www.tianyancha.com");
        headers.put("Pragma", "no-cache");
        headers.put("Referer", "https://www.tianyancha.com/search?key=%E8%85%BE%E8%AE%AF");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
    }
    public static void main(String args[]){
        org.jsoup.Connection connection= Jsoup.connect(url);
        connection.headers(headers);
        try {
            Document document=connection.post();
            Elements elements=document.getElementsByClass("result-list");
            Element resultElement=elements.get(0);
            Elements searchElements=resultElement.getElementsByClass("search-item");
            Element itemElement=searchElements.get(0);
            Element contentElement=itemElement.getElementsByClass("content").get(0);
            Element contactElemet=contentElement.getElementsByClass("contact").get(0);
            Element emailElement=contactElemet.getElementsByClass("col").get(1);
            String email=emailElement.getElementsByTag("span").get(1).text();
            Element phoneElement=contactElemet.getElementsByClass("col").get(0);
            String phone=phoneElement.getElementsByTag("span").get(1).text();
            Element infoElement=contentElement.getElementsByClass("info").get(0);
            Element aLinkElement=infoElement.getElementsByClass("title text-ellipsis").get(0).getElementsByTag("a").get(0);
            String legalName=aLinkElement.text();
            String detailAdress=aLinkElement.attr("abs:href");
            Elements titleElements=infoElement.getElementsByClass("title  text-ellipsis");
            String registerMoney=titleElements.get(0).getElementsByTag("span").get(0).text();
            String registerTime=titleElements.get(1).getElementsByTag("span").get(0).text();
            System.out.println("phone:"+phone);
            System.out.println("email:"+email);
            System.out.println("legalName:"+legalName);
            System.out.println("detailAdress:"+detailAdress);
            System.out.println("registerMoney:"+registerMoney);
            System.out.println("registerTime:"+registerTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getData(){

    }

    public static void getDetailData(){

    }
}
