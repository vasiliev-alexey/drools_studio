import com.av.data.services.ChartOfAccountService;
import com.av.domain.accounting.ChartOfAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by vasiliev-alexey on 21.01.17.
 */
public class TestChartOfAccount extends AbstractTestDao {


    @Autowired
    @Qualifier("chartOfAccountService")

    private ChartOfAccountService service;


    @Test
    public void CurrencyShouldBeSave() {


        ObservableList<ChartOfAccount> list =FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 2; j++) {
                ChartOfAccount a = new ChartOfAccount();
                a.setSegment1("segment1_"+i);
                a.setSegment2("segment2_"+i);
                a.setSegment3("segment3_"+i);
                a.setSegment4("segment4_"+i);
                a.setSegment5("segment5_"+i);
                a.setSegment6("segment6_"+i);
                a.setSegment7("segment7_"+i);
                a.setSegment8("segment8_"+i);
                a.setSegment9("segment9_"+i);
                a.setSegment10("segment10_"+i);
                a.setEnableFlag(true);

                list.add(a);
            }


        }
        service.save(list);


    }
}
