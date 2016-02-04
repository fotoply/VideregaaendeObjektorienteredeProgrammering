package loan_company.model.loans;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public class Business extends Loan {

    public Business(int ID, String loanHolderName, int amount, LoanDuration duration) {
        super(ID, loanHolderName, amount, duration);
        setInterestRate(getDiskonto() + COMPANY_RENT);
    }

    @Override
    public String toString() {
        return "\n" + COMPANY_NAME +
                "\n- Business loan -" +
                super.toString();
    }
}
