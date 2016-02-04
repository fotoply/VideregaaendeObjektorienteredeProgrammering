package loan_company.model.loans;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public class Personal extends Loan {

    public Personal(int ID, String loanHolderName, int amount, LoanDuration duration) {
        super(ID, loanHolderName, amount, duration);
        setInterestRate(getDiskonto() + PERSONAL_RENT);
        setAmountOwed(getAmountLoaned() + PERSONAL_CREATION_FEE);
    }

    @Override
    public String toString() {
        return "\n" + COMPANY_NAME +
                "\n- Personal loan -" +
                super.toString();
    }
}
