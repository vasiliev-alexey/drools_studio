import com.av.validators.ModelBaenValidationService;
import com.av.validators.ModelValidator;
import org.junit.Assert;

import com.av.domain.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.util.*;

/**
 * Created by vasiliev-alexey on 26.12.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:validator-beans.xml"})
public class TestModelValidator {


    @Autowired
    @Qualifier("modelValidator")
    private ModelValidator modelValidator;

    @Autowired
    private ModelBaenValidationService modelBaenValidationService;

    @Test
    public void modelNameEmptyShouldThrowError() {
        Model m = new Model();
        m.setCode("Tst1");
        Map<String,String> map = new HashMap<String,String>();
        MapBindingResult err = new MapBindingResult(map, Model.class.getName());
        modelValidator.validate(m , err);
        Assert.assertTrue("Ошибка имя модели не заполнено" , err.hasErrors() );
    }


    @Test
    public void modelCodeEmptyShouldThrowError() {
        Model m = new Model();
        m.setModelName("Tst1");
        Map<String,String> map = new HashMap<String,String>();
        MapBindingResult err = new MapBindingResult(map, Model.class.getName());
        modelValidator.validate(m , err);
        List<ObjectError> list = err.getAllErrors();
        Optional<ObjectError> codeErr = list.stream().filter(e ->  ModelValidator.CODEEMPTY.equals(e.getCode())).findFirst();
        Assert.assertTrue("Ошибка Код модели не заполнено" , codeErr.isPresent());
    }


    @Test
    public  void tstModel() {

        Model m = new Model();
        Set<ConstraintViolation<Model>> err = modelBaenValidationService.validateModel(m);


        err.forEach( e -> {
            System.out.println(e);
        });

    }



}
