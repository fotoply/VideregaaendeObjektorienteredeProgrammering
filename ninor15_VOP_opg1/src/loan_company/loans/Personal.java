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
        setInterestRate(getDiskonto()+ LoanInterface.PERSONAL_RENT);
        setAmountOwed(getAmountLoaned()+LoanInterface.PERSONAL_CREATION_FEE);
    }

    @Override
    public String toString() {
        return LoanInterface.COMPANY_NAME +
                "\n- Personal loan -" +
                "\nAccount:\t\t" + getLoanHolderID() +
                "\nName:\t\t" + getLoanHolderName() +
                "\nDate:\t\t" + getStartedDate().toString() +
                "\nDuration:\t\t" + getDuration().getTimeInYears() + " years" +
                "\nAmount:\t\t" + getAmountLoaned() +
                "\nTotal:\t\t" + getTotal();
    }
}
