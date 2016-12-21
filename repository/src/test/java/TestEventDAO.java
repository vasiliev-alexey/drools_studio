import com.av.domain.*;
import com.av.repositories.EventService;
import com.av.repositories.ModelService;
import org.joda.time.DateTimeUtils;
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
 * Created by vasiliev-alexey on 21.12.16.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:repository-beans.xml"})
public class TestEventDAO {


    @Autowired
    @Qualifier("eventService")
    private EventService service;

    @Test
    public void EventShouldBeSave() {


        Event event = new Event();

        Long l = DateTimeUtils.currentTimeMillis();

        event.setName("name_" + l.toString());
        event.setCode(l.toString());
        service.save(event);

        Assert.notNull(event);


    }
}
