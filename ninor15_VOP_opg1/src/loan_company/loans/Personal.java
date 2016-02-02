package loan_company.loans;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public class Personal extends Loan {
    @Override
    public double getTotal() {
        return 0;
    }

    @Override
    public void setInterestRate() {

    }

    @Override
    public double getInterestRate() {
        return 0;
    }
}
