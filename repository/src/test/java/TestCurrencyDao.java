import com.av.data.services.CurrencyService;
import com.av.domain.accounting.Currency;
import org.joda.time.DateTimeUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by vasiliev-alexey on 21.01.17.
 */

public class TestCurrencyDao extends AbstractTestDao {
    @Autowired
    @Qualifier("currencyService")

    private CurrencyService service;


    @Test
    public void CurrencyShouldBeSave() {


        String tmp = Long.toString(DateTimeUtils.currentTimeMillis());

        Currency  currency = new Currency();
        currency.setCode("code_" + tmp);
        currency.setName("name_" + tmp);

        service.save(currency);

        Assert.assertNotNull(  "Валюта должна быть сохранена" , currency.getId());



    }

}
