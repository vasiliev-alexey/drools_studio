import com.av.ModelValidator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
 import com.av.domain.Model;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vasiliev-alexey on 26.12.16.
 */
public class ModelValidatortest {


    @Test
     public void testModelCodeEmpty() {
        ModelValidator  validator  = new ModelValidator();
        Model m = new Model();
        m.setCode("Tst1");
        Map<String,String> map = new HashMap<String,String>();
        MapBindingResult err = new MapBindingResult(map, Model.class.getName());
        validator.validate(m , err);

        Assert.assertTrue("Ошибка имя модели не заполнено" , err.hasErrors() );

     }

}
