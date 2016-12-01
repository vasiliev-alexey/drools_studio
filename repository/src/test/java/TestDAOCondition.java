import com.av.domain.ConstantCondition;
import com.av.domain.StandardValueType;
import com.av.repositories.ConditionService;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * Created by Vasiliev.Alexey on 27.11.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:repository-beans.xml"})
public class TestDAOCondition {

    @Autowired
    @Qualifier("conditionService")

    private ConditionService  conditionService;


    @Test
    public void ConstantConditionShouldBeSave() {


        ConstantCondition constantCondition = new ConstantCondition();
        constantCondition.setCode("code1");
        constantCondition.setName("Name1");
        constantCondition.setValueType(StandardValueType.String);
        constantCondition.setStringValue("simple 1");


        conditionService.Save(constantCondition);
        Assert.assertNotNull("Объект долженг быть сохранен" , constantCondition.getId() );

    }
    @Test
    public void ConstantDateConditionShouldBeSave() {
        ConstantCondition constantCondition = new ConstantCondition();
        constantCondition.setCode("code_date1");
        constantCondition.setName("Name_DATE_1");
        constantCondition.setValueType(StandardValueType.Date);
        constantCondition.setDateValue(LocalDate.now());

        conditionService.Save(constantCondition);
        Assert.assertNotNull("Объект c датой должен быть сохранен" , constantCondition.getId() );

    }

    @Test
    public void ConstantDoubleConditionShouldBeSave() {
        ConstantCondition constantCondition = new ConstantCondition();
        constantCondition.setCode("code_double1");
        constantCondition.setName("Name_Double_1");
        constantCondition.setValueType(StandardValueType.Double);
        constantCondition.setDoubleValue(1D);

        conditionService.Save(constantCondition);
        Assert.assertNotNull("Объект c датой должен быть сохранен" , constantCondition.getId() );

    }

}
