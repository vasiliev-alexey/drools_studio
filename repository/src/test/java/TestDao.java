import com.av.domain.Model;
import com.av.repositories.ModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by alexey on 25.11.16.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:infrastructure.xml"})
public class TestDao {


    @Autowired
    @Qualifier("modelService")
    private ModelService service;


    @Test
    public void ModelshouldBeSave() {

        Model m = new Model();
        //m.setId(222L);
        m.setCode("code1");
        m.setName("name1");

        Model p = service.Save(m);

        System.out.println(p.getId());

        Assert.notNull(p);



    }

}
