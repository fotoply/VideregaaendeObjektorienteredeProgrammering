package loan_company;

import java.util.Date;

/**
 *
 * @author erso  Created on 03-11-2009, 10:02:34
 *  Updated for VOP 2.sem F15 05-02-2015
 */
public interface LoanInterface {

    String COMPANY_NAME = "Fuskes Finans Aps";
    String CURRENCY_DENOTATION = "DKK";
    int MAX_AMOUNT_LOANABLE = 500000;
    double DISKONTO = 0.0;

    double PERSONAL_RENT = 0.05;
    int PERSONAL_CREATION_FEE = 1000;

    double COMPANY_RENT = 0.04;

    public enum LoanDuration {
        SHORT_TERM(1), MIDDLE_TERM(3), LONG_TERM(5);
        private int timeInYears;

        LoanDuration(int timeInYears) {
            this.timeInYears = timeInYears;
        }

        public int getTimeInYears() {
            return timeInYears;
        }
    }

    /**
     * Returns the total amount that will have to be paid at the end of the loan.
     */
    double getTotal();
    double getInterestRate();

    int getAmountOwed();
    int getAmountLoaned();
    int getLoanHolderID();
    String getLoanHolderName();
    Date getStartedDate();
    LoanDuration getDuration();
    String getLoanType();

}
