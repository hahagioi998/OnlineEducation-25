import com.yzz.serviceoss.vo.AliOSS;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.ws.rs.core.Application;


/**
 * @ClassName Test
 * @Author yky
 * @Date 2020/12/31
 * @Version 1.0
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class Test {
	
	@Autowired
	AliOSS aliOSS;
	
	@org.junit.Test
	public void testAliOSS(){
		AliOSS aliOSS = new AliOSS();
		System.out.println(aliOSS.getAccessKeyId());
		System.out.println(this.aliOSS.getAccessKeyId());
	}
}
