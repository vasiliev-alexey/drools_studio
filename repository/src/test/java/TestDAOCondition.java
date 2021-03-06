import com.av.data.services.ConditionService;
import com.av.data.services.EventService;
import com.av.data.services.ModelService;
import com.av.domain.accounting.EventRule;
import com.av.domain.settings.*;

import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/**
 * Created by Vasiliev.Alexey on 27.11.16.
 */

public class TestDAOCondition extends AbstractTestDao {

    @Autowired
    @Qualifier("conditionService")

    private ConditionService conditionService;
    @Autowired
    private ModelService modelService;

    @Autowired
    private EventService eventService;

    private long rndValue = System.nanoTime();


    @Test
    public  void conditionShouldBeSave() {

        Condition condition = new Condition();
        condition.setCode("code_" + rndValue);
        condition.setConditionName("name_" + rndValue);

        //EventRule eventRule = eventService.getAll().get(0).getEventRules().get(0);

        conditionService.save(condition);

        Assert.assertTrue("Условие долэно быть сохранено" , condition.getId() > 0);



    }

    /*
    @Test
    public void ConstantConditionShouldBeSave() {


        ConstantCondition constantCondition = new ConstantCondition();
        constantCondition.setCode("code1");
        constantCondition.setName("Name1");
        constantCondition.setValueType(StandardValueType.String);
        constantCondition.setStringValue("simple 1");


        conditionService.save(constantCondition);
        Assert.assertNotNull("Объект долженг быть сохранен", constantCondition.getId());

    }

    @Test
    public void ConstantDateConditionShouldBeSave() {
        ConstantCondition constantCondition = new ConstantCondition();
        constantCondition.setCode("code_date1");
        constantCondition.setName("Name_DATE_1");
        constantCondition.setValueType(StandardValueType.Date);
        constantCondition.setDateValue(LocalDate.now());

        conditionService.save(constantCondition);
        Assert.assertNotNull("Объект c датой должен быть сохранен", constantCondition.getId());

    }

    @Test
    public void ConstantDoubleConditionShouldBeSave() {
        ConstantCondition constantCondition = new ConstantCondition();
        constantCondition.setCode("code_double1");
        constantCondition.setName("Name_Double_1");
        constantCondition.setValueType(StandardValueType.Double);
        constantCondition.setDoubleValue(1D);

        conditionService.save(constantCondition);
        Assert.assertNotNull("Объект c датой должен быть сохранен", constantCondition.getId());

    }

    @Test
    public void DocumentAttributeShouldBeSave() {

      ModelAttr attr=   modelService.getAll().filtered(m -> m.getModelAttrGroups() != null).filtered(m -> m.getModelAttrGroups().size() != 0).get(0).getModelAttrGroups().get(0).getModelAttrList().get(0);
        String rnd = Long.toString(DateTimeUtils.currentTimeMillis());
        DocumentAttribute documentAttribute = new DocumentAttribute();
        documentAttribute.setCode("code_doc_" + rnd);
        documentAttribute.setName("Name_doc_" + rnd);
        documentAttribute.setConditionType(ConditionType.DOCUMENT_ATTRIBUTE);
        documentAttribute.setAttr(attr);

        conditionService.save(documentAttribute);
        Assert.assertNotNull("Объект атрибута должен быть сохранен", documentAttribute.getId());

    }
*/


}
