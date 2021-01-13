import com.yzz.service_msm.msm.ServiceMsmApplication;
import com.yzz.service_msm.msm.service.MsmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName MSMTest
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@SpringBootTest(classes = ServiceMsmApplication.class)
@RunWith(SpringRunner.class)
public class MSMTest {
	
	@Resource
	private MsmService msmService;
	
	@Test
	public void test(){
		msmService.sendMsg("123");
	}
}
