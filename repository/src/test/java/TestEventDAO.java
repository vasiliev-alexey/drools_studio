import com.av.data.services.EventService;
import com.av.data.services.ModelService;
import com.av.domain.accounting.Event;

import com.av.domain.settings.Model;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by vasiliev-alexey on 21.12.16.
 */



public class TestEventDAO extends AbstractTestDao {


    @Autowired
    @Qualifier("eventService")
    private EventService service;

    @Autowired
    private ModelService modelService;

    @Test
    public void EventShouldBeSave() {


        Event event = new Event();

        Long l = DateTimeUtils.currentTimeMillis();

        event.setName("name_" + l.toString());
        event.setCode(l.toString());


        Model model = modelService.getAll().stream().findAny().get();
        event.setModel(model);
        event.setEnabled(true);

        service.save(event);

        Assert.notNull(event);


    }
}
