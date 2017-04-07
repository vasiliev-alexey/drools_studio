import com.av.data.services.ChartOfAccountStructureService;
import com.av.data.services.EventService;
import com.av.data.services.ModelService;
import com.av.domain.accounting.ChartOfAccountStructure;
import com.av.domain.accounting.Event;

import com.av.domain.accounting.EventRule;
import com.av.domain.settings.Condition;
import com.av.domain.settings.Model;
import javafx.collections.FXCollections;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.HashSet;

/**
 * Created by vasiliev-alexey on 21.12.16.
 */



public class TestEventDAO extends AbstractTestDao {


    @Autowired
    @Qualifier("eventService")
    private EventService service;

    @Autowired
    private ModelService modelService;
    @Autowired
    private ChartOfAccountStructureService chartOfAccountStructureService;

    @Test
    public void EventShouldBeSave() {


        Event event = new Event();

        Long l = DateTimeUtils.currentTimeMillis();

        event.setName("name_" + l.toString());
        event.setCode(l.toString());


        Model model = modelService.getAll().stream().findAny().get();
        event.setModel(model);
        event.setEnabled(true);

       ChartOfAccountStructure chartOfAccountStructure=
               chartOfAccountStructureService.getAll().stream().findFirst().get();

        event.setChartOfAccountStructure(chartOfAccountStructure);
        service.save(event);

        Assert.notNull(event);


    }

    @Test
    public void EventWithRulesShouldBeSave() {


        Event event = new Event();

        Long l = DateTimeUtils.currentTimeMillis();

        event.setName("name_" + l.toString());
        event.setCode(l.toString());


        Model model = modelService.getAll().stream().findAny().get();
        event.setModel(model);
        event.setEnabled(true);

        event.setEventRules(FXCollections.observableArrayList());

        EventRule rule1 = new EventRule();
        rule1.setCode("rule_code_1_"+l);
        rule1.setName("rule_name_1_"+l);
        rule1.setEnabledFlag(true);

        EventRule rule2 = new EventRule();
        rule2.setCode("rule_code_2_"+l);
        rule2.setName("rule_name_2_"+l);
        rule2.setEnabledFlag(false);
        event.getEventRules().add(rule1);
        event.getEventRules().add(rule2);

        event.getEventRules().forEach(e -> e.setEvent(event));


        service.save(event);

        Assert.notNull(event.getId() , "Событие  с правилами должно быть сохранено");


    }


    @Test
    public void EventWithConditionShouldBeSave() {


        Event event = new Event();

        Long l = DateTimeUtils.currentTimeMillis();

        event.setName("name_" + l.toString());
        event.setCode(l.toString());


        Model model = modelService.getAll().stream().findAny().get();
        event.setModel(model);
        event.setEnabled(true);

        event.setEventRules(FXCollections.observableArrayList());

        EventRule rule1 = new EventRule();
        rule1.setCode("rule_code_1_"+l);
        rule1.setName("rule_name_1_"+l);
        rule1.setEnabledFlag(true);

        EventRule rule2 = new EventRule();
        rule2.setCode("rule_code_2_"+l);
        rule2.setName("rule_name_2_"+l);
        rule2.setEnabledFlag(false);
        event.getEventRules().add(rule1);
        event.getEventRules().add(rule2);

        event.getEventRules().forEach(e -> e.setEvent(event));

        Condition condition = new Condition();
        condition.setCode("condition_code_" + l);
        condition.setCode("condition_name_" + l);

        rule1.setCondition(condition);

        service.save(event);


        Assert.notNull(event.getId() , "Событие  с условием должно быть сохранено");


    }


}
