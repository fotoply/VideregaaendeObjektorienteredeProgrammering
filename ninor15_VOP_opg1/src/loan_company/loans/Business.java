package loan_company.loans;

import loan_company.LoanInterface;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public class Business extends Loan {

    public Business(int ID, String loanHolderName, int amount, LoanDuration duration) {
        super(ID, loanHolderName, amount, duration);
        setInterestRate(getDiskonto()+ LoanInterface.COMPANY_RENT);
    }

    @Override
    public String toString() {
        return "Business{}";
    }
}
