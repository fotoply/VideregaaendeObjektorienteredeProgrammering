package loan_company.model.loans;

import loan_company.model.LoanInterface;

import java.util.Date;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public abstract class Loan implements LoanInterface {
    private int amountOwed;
    private int amountLoaned;
    private double interestRate;
    private LoanDuration duration;
    private Date startedDate;
    private String loanHolderName;
    private int loanHolderID;

    public Loan(int loanHolderID, String loanHolderName, int amountLoaned, LoanDuration duration) {
        this.loanHolderID = loanHolderID;
        this.loanHolderName = loanHolderName;

        if (amountLoaned <= 0) {
            throw new IllegalArgumentException("You can't make a loan below 1");
        }
        if (amountLoaned > MAX_AMOUNT_LOANABLE) {
            amountLoaned = MAX_AMOUNT_LOANABLE;
        }
        this.amountLoaned = amountLoaned;
        this.amountOwed = amountLoaned;

        this.duration = duration;
        this.startedDate = new Date();
    }

    @Override
    public double getTotal() {
        return amountOwed * Math.pow(getInterestRate() + 1, getDuration().getTimeInYears());
    }

    public double getDiskonto() {
        return DISKONTO;
    }

    public int getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(int amountOwed) {
        this.amountOwed = amountOwed;
    }

    public int getAmountLoaned() {
        return amountLoaned;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interestRate for a given loan. Can only be set once and is considered final after being set.
     * Must be larger than 0
     *
     * @param interestRate the interest rate for the loan
     */
    protected void setInterestRate(double interestRate) {
        if (interestRate <= 0) {
            throw new IllegalArgumentException("Loans cannot have an interest rate of less than or equal to 0");
        }
        if (this.interestRate == 0) {
            this.interestRate = interestRate;
        }
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

    public int getLoanHolderID() {
        return loanHolderID;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "amountOwed=" + amountOwed +
                ", interestRate=" + interestRate +
                ", duration=" + duration +
                ", startedDate=" + startedDate +
                ", loanHolderName='" + loanHolderName + '\'' +
                ", loanHolderID=" + loanHolderID +
                '}';
    }
}
