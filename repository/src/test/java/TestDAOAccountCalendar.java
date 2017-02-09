import com.av.data.services.AccountCalendarService;
import com.av.domain.accounting.AccountCalendar;
import com.av.domain.accounting.AccountPeriod;
import org.joda.time.DateTimeUtils;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

/**
 * Created by vasiliev-alexey on 19.01.17.
 */

public class TestDAOAccountCalendar extends AbstractTestDao {

    @Autowired
    @Qualifier("accountCalendarService")

    private AccountCalendarService service;

    @Test
    public void AccountCalendarShouldBeSave() {

        AccountCalendar accountCalendar = new AccountCalendar();
        Long l = DateTimeUtils.currentTimeMillis();

        accountCalendar.setName("name_" + l.toString());
        accountCalendar.setCode("code" + l.toString());

        accountCalendar.setPeriodList(new ArrayList<AccountPeriod>());

        for (int i = 0; i <= 13; i++) {
            AccountPeriod period = new AccountPeriod();
            period.setCode("code_period_"+ i);
            period.setName("period_name_"+ i);
            period.setEndDate( LocalDate.now().dayOfMonth().withMaximumValue());
            period.setStartDate( LocalDate.now().dayOfMonth().withMinimumValue());
            period.setAccountCalendar(accountCalendar);
            period.setPeriodNum(i);


            if(i== 0 || i ==13) {
                period.setAdjustmentFlag(true);
            }
            accountCalendar.getPeriodList().add(period);

        }




        service.save(accountCalendar);
        Assert.assertNotNull("Объект долженг быть сохранен", accountCalendar.getId());

    }



}
