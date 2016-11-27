import com.av.domain.Model;
import com.av.domain.ModelAttr;
import com.av.domain.ModelAttrGroup;
import com.av.repositories.ModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * Created by Vasiliev.Alexey on 25.11.16.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:infrastructure.xml"})
public class TestDaoModel {


    @Autowired
    @Qualifier("modelService")
    private ModelService service;


    @Test
    public void ModelshouldBeSave() {

        Model m = new Model();
        //m.setId(222L);
        m.setCode("code1");
        m.setName("name1");

        ModelAttrGroup attrGroup = new ModelAttrGroup();
        attrGroup.setCode("mag_code_1");
        attrGroup.setName("mag_name_1");
        m.setModelAttrGroups(new ArrayList<>());
        m.getModelAttrGroups().add(attrGroup);
        attrGroup.setModel(m);

        ModelAttr attr = new ModelAttr();
        attr.setCode("att_1");
        attr.setName("att_1_name");
        attr.setModelAttrGroup(attrGroup);

        attrGroup.setModelAttrList(new ArrayList<>());
        attrGroup.getModelAttrList().add(attr);

        Model p = service.Save(m);

        System.out.println(p.getId());

        Assert.notNull(p);


    }

}
