import com.bazyl.credits.controller.DBController;
import com.bazyl.credits.model.Bank;
import com.bazyl.credits.model.Credit;
import com.bazyl.credits.view.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BankTest {
    Bank bank1;
    Bank bank2;
    Bank bank3;
    Console console;

    @Before
    public void init(){
        bank1 = new Bank("Priv");
        bank2 = new Bank("Agro");
        bank3 = new Bank("Gog");
        console = new Console();
    }

    @Test
    public void testID1(){
        Assert.assertEquals(0,bank1.getId());
    }

    @Test
    public void testID2(){
        Assert.assertEquals(1,bank2.getId());
    }

    @Test
    public void testPrintCredit(){
        Credit credit1 = new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2018,9,1),
                new BigDecimal(100),5);
        Credit credit2 = new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2019,9,1),
                new BigDecimal(200),5);
        bank1.addCredit(credit1);
        bank1.addCredit(credit2);
        console.showBank(bank1);
    }

    @Test
    public void testCloseCredit(){
        Credit credit1 = new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2018,9,1),
                new BigDecimal(100),5);
        Credit credit2 = new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2019,9,1),
                new BigDecimal(200),5);
        bank1.addCredit(credit1);
        bank1.addCredit(credit2);
        bank1.deleteCredit(credit1);
        console.showBank(bank1);
    }

    @Test
    public void testIncreaseCredit(){
        Credit credit1 = new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2018,9,1),
                new BigDecimal(100),5);
        Credit credit2 = new Credit(Currency.getInstance(Locale.US),new GregorianCalendar(2019,9,1),
                new BigDecimal(200),5);
        bank1.addCredit(credit1);
        bank1.addCredit(credit2);
        console.showBank(bank1);
        credit1.increaseDebt(new BigDecimal(666));
        console.showBank(bank1);
    }

    @Test
    public void DBTest1() {
        DBController controller = new DBController();
        bank1.setCredits(controller.retreiveAllCredits());
        console.showBank(bank1);
    }

    @Test
    public void DBTest2() {
        DBController controller = new DBController();
        bank1.setCredits(controller.retreiveAllCredits());
        controller.closeCredit(1);
        //console.showBank(bank1);
    }

    @Test
    public void DBTest3() {
        DBController controller = new DBController();
        controller.increaseDebt(new BigDecimal(999), 2);
    }

}
