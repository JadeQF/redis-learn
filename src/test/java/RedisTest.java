import cn.learn.AppMain;
import cn.learn.entity.Student;
import cn.learn.service.StudentService;
import cn.learn.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMain.class)
public class RedisTest {
    @Resource
    private StudentService studentService;

    @Test
    public void testFindAndDelete() {
        RedisUtil.setVal("key", "sno1");
        RedisUtil.deleteVal("key");
    }

    @Test
    public void testStudentService() {
        Student result = studentService.findBySno(110);
        System.out.println(result);
    }

}
