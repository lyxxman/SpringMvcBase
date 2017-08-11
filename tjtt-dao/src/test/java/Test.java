import junit.framework.TestCase;
import redis.clients.jedis.Jedis;

/**
 * @Author: luoyi
 * @Description:
 * @Date: 15:13 2017/8/10
 * @Version: 1.0.0
 * @Modified By: xxx
 */
public class Test extends TestCase {

//    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost");       // 连接到Redis服务器
        jedis.set("greeting", "Hello, world!");     // 将字符串缓存到Redis服务器
        System.out.println(jedis.get("greeting") + "========");  // 从Redis缓存中获取数据
        jedis.set("name", "欢迎来到Redis缓存！");
        String name= jedis.get("name");
        System.out.print(name+"===========");
    }
}
