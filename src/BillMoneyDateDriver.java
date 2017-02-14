/**
 Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen additions By Connor Teal
 */
public class BillMoneyDateDriver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        //Construct some money
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        
        money1.setMoney(30,50);
        money2.setMoney(-12,55);
        assert(money2.getDollars() == 10);
        
        money2.setDollars(100);
        assert(money2.getDollars() == 100);
        assert(money2.getMoney() == 100.55);
        money2.setDollars(-100);
        assert(money2.getDollars() == 100): "check setDol";
        money2.add(50);
        assert(money2.getDollars() == 150);
        money2.add(50,30);
        assert(money2.getMoney() == 200.85);
        
        Money money3 = new Money(money2);
        assert(money3.equals(money2));
        
        assert(money3.getCents() == 85);
        money3.setCents(123);
        assert(money3.getCents() == 85): "Cent check broken";
        money3.setCents(-5);
        assert(money3.getCents() == 85): "Shouldn't subtract";
       
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
        money1.add(money2);
        System.out.println(money1);
        
        System.out.println(money1.getDollars());
        
        //Date Tests
        Date date1 = new Date(0,1,1);
        Date date2 = new Date(1,0,1);
        Date date3 = new Date(1,1,-1);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        
        assert(date1.equals(date2));
        date1.setDay(-3);
        assert(date1.equals(date2));
        date1.setDay(32);
        assert(date1.equals(date2));
        date1.setMonth(-2);
        assert(date1.equals(date2));
        date1.setMonth(13);
        assert(date1.equals(date2));
        date1.setYear(-1);
        assert(date1.equals(date2));
        
        date1.setDay(3);
        assert(!date1.equals(date2));
        assert(date1.getDay() == 3);
        date1.setYear(1000);
        assert(date1.getYear() == 1000);
        date1.setMonth(3);
        assert(date1.getMonth() == 3);    
        Date date4 = new Date(date1); 
        System.out.println(date4);
        System.out.println(date1);
        assert(date2.datePrecedes(date1));
        assert(!date2.datePrecedes(date2));
    
    
        //Construct some bills
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2007);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
       
        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2007));
        Bill bill4 = new Bill(bill2);
        bill4.setPaid(new Date(1,21,1));
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        
        
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        assert(!bill3.isPaid());
        bill3.setPaid(new Date(2,1,2019));
        assert(bill3.isPaid());
        bill3.setUnpaid();
        assert(!bill3.isPaid());
        assert(bill3.getDueDate().equals(dueDate));
        bill3.setAmount(new Money(500,32));
        assert(!bill3.getAmount().equals(amount));
        bill3.setOriginator("abc");
        assert(bill3.getOriginator().equals("abc"));
        bill3.setPaid(new Date(2,2,2017));
        assert(bill3.equals(bill3));
        
        Bill bill5 = new Bill(bill3);
        assert(bill5.equals(bill3));
        
        
        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
        System.out.println(bill4);
        
    }
}
