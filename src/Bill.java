 
/**
 * The bill class is a class that represents a bill. It's composed of a
 * couple of classes (Dates and Money). A bill has a money value (Money),
 * a due date (Date), a paid date (Date), and an Originator (String).
 * 
 * A class invariant is that the due date must not precede the paid date.
 * 
 * Bills are mutable and we can both set and get attributes of the bill.
 * 
 * @Connor Teal
 */
public class Bill
{
    private Money amount;
    private Date dueDate;
    private Date paidDate = null;
    private String originator;

    /**
     * Three Argument Constructor will create an object
     * given amount, due date, and originator.
     * 
     * @param Money amount of bill
     * @param Date dueDate date bill is due
     * @param String originator is the originator of bill
     */
    public Bill(Money amount, Date dueDate, String originator){
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        this.originator = originator;
    }

    /**
     * Copy Constructor will copy an object creating an
     * 'identical' object.
     * 
     * @param a Bill to be copied
     */
    public Bill(Bill billToCopy){
        this.amount = billToCopy.getAmount();
        this.dueDate = billToCopy.getDueDate();
        this.originator = billToCopy.getOriginator();
        if(billToCopy.isPaid()){
            this.paidDate = billToCopy.getPaidDate();
        }
    }

    /**
     * getDueDate returns the due date
     * 
     * @return Object the duedate
     */
    public Date getDueDate(){
        return new Date(this.dueDate);
    }

    /**
     * getAmount returns the dollar amount
     * 
     * @return Object the amount of the bill
     */
    public Money getAmount(){
        return new Money(this.amount);
    }

    /**
     * getPaidDate returns the paid date
     * 
     * @return Object the paid date for the bill
     */
    public Date getPaidDate(){
        return new Date(this.paidDate);
    }

    /**
     * getOriginator returns the orginator of the bill
     * as a string
     * 
     * @return String the originator of the bill
     */
    public String getOriginator(){
        return this.originator;
    }

    /**
     * isPaid will check to see if the bill has been payed
     * 
     * @return boolean true if paid
     */
    public boolean isPaid(){
        if(paidDate == null){
            return false;
        }
        return true;
    }

    /**
     * setPaid will set the paid date for the bill
     * 
     * @param Object date paid
     * @return Nothing
     */
    public void setPaid(Date paid){
        try{
            
            if(paid.datePrecedes(new Date(dueDate))){
                throw new Exception("Due date is past due. Can't pay.");
            }
            this.paidDate = new Date(paid);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * setUnpaid will set the bill to unpaid
     * 
     * @return Nothing
     */
    public void setUnpaid(){
        this.paidDate = null;
    }

    /**
     * setDueDate will set the duedate of the bill. It will
     * verify that the due date isn't set prior to a paid date.
     * 
     * @param Object date to be set
     * @return Nothing
     */
    public void setDueDate(Date due){
        try{
            if(paidDate.datePrecedes(due)){
                throw new Exception("Due date can't be set before paid date.");
            }
            this.dueDate = new Date(due);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * setAmount will set the bill amount
     * 
     * @param Object money is amount to be set
     * @return Nothing
     */
    public void setAmount(Money amount){
        this.amount = new Money(amount);
    }

    /**
     * setOriginator will set the originator of the bill
     * 
     * @param String orginator of the bill
     * @return Nothing
     */
    public void setOriginator(String originator){
        this.originator = originator;
    }

    /**
     * equals will compare a bill to another bill passed
     * as an argument
     * 
     * @param Object bill to compare with
     * @boolean true if bills are equal
     */
    public boolean equals(Bill otherBill){
        if(this.amount.equals(otherBill.getAmount()) &&
        this.dueDate.equals(otherBill.getDueDate()) &&
        this.paidDate.equals(otherBill.getPaidDate()) &&
        this.originator.equals(otherBill.originator)){
            return true;
        }
        return false;
    }

    /**
     * toString will return a summary of the bill as a String
     * 
     * @return String summary of the bill
     */
    @Override
    public String toString(){
        String retVal = "";
        retVal += "====================================== \n";
        retVal += "Originator: " + this.originator + "\n";
        retVal += "Amount Due: " + new Money(amount).toString();
        retVal += "\n";
        retVal += "Due Date: " + new Date(dueDate).toString();
        retVal += "\n";
        if(this.isPaid()){
            retVal += "Paid Date: " + new Date(paidDate).toString();
        }else{
            retVal += "Paid Date: UNPAID";
        }
        retVal += "\n";
        return retVal;
    }
}
