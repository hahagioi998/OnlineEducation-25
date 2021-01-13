import com.yzz.commonutils.vo.AliOSS;
import com.yzz.serviceoss.ServiceOssApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @ClassName Test
 * @Author yky
 * @Date 2020/12/31
 * @Version 1.0
 */
@SpringBootTest(classes = ServiceOssApplication.class)
@RunWith(SpringRunner.class)
public class OssTest {
	
	@Resource
	AliOSS aliOSS;
	
	@Test
	public void testAliOSS(){
		System.out.println(aliOSS.getAccessKeyId());
		System.out.println(aliOSS.getAccessKeyId());
	}
}
