package loan_company.loans;

import loan_company.LoanInterface;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public class Personal extends Loan {

    public Personal(int ID, String loanHolderName, int amount, LoanDuration duration) {
        super(ID, loanHolderName, amount, duration);
        setInterestRate(getDiskonto()+ LoanInterface.personalRent);
    }
}
