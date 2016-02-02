package loan_company.loans;

import loan_company.LoanInterface;

import java.util.Date;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public abstract class Loan implements LoanInterface {
    private int amount;
    private double interestRate;
    private LoanInterface.LoanDuration duration;
    private Date startedDate;
    private String loanHolderName;
    private int ID;

    public Loan(int ID, String loanHolderName, int amount, LoanDuration duration) {
        this.ID = ID;
        this.loanHolderName = loanHolderName;
        this.amount = amount;
        this.duration = duration;
        this.startedDate = new Date();
    }

    @Override
    public double getTotal() {
        return amount;
    }

    public double getDiskonto() {
        return LoanInterface.diskonto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    public LoanDuration getDuration() {
        return duration;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public String getLoanHolderName() {
        return loanHolderName;
    }

    public int getID() {
        return ID;
    }

    protected void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
