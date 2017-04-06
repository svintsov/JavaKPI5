import com.bazyl.credits.model.Credit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CreditTest {

    Credit credit1;

    @Before
    public void init(){
        credit1= new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2018,9,1),
                new BigDecimal(100),5);
    }

    @Test
    public void calculateYear(){
        Assert.assertEquals(1,credit1.getTimeDuration());
    }
}
