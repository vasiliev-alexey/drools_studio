import com.av.data.services.ChartOfAccountStructureService;
import com.av.domain.accounting.ChartOfAccountStructure;
import com.av.domain.accounting.SegmentDescription;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
public class TestChartOfAccountStructureDAO extends AbstractTestDao {

    @Autowired
    @Qualifier("chartOfAccountStructureService")

    private ChartOfAccountStructureService service;


    @Test
    public void ChartOfAccountStructureShouldBeSave() {

        ChartOfAccountStructure structure = new ChartOfAccountStructure();
        String  tmpDate = LocalDateTime.now().toString();
        structure.setCode("code_"+ tmpDate);
        structure.setName("name_"+tmpDate);
        service.Save(structure);
        Assert.assertTrue("structure not saved", structure.getId() > 0);
    }
    @Test
    public void ChartOfAccountAndSegmentsStructureShouldBeSave() {

        ChartOfAccountStructure structure = new ChartOfAccountStructure();
        String  tmpDate = LocalDateTime.now().toString();
        structure.setCode("code_"+ tmpDate);
        structure.setName("name_"+tmpDate);
structure.setSegmentDescriptionList(new ArrayList<>());
        for (int i = 1; i <= 12 ; i++) {

            SegmentDescription segmentDescription  = new SegmentDescription();
            segmentDescription.setPosition(i);
            segmentDescription.setChartOfAccountStructure(structure);
            segmentDescription.setDescription(String.format("desc_%d_%s", i, tmpDate));
            segmentDescription.setChartOfAccountStructure(structure);

            structure.getSegmentDescriptionList().add(segmentDescription);

        }


        service.Save(structure);
        Assert.assertTrue("structure not saved", structure.getId() > 0);
    }

}
