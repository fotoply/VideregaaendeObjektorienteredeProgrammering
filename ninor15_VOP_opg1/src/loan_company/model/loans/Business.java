package loan_company.model.loans;

/**
 * Created 2/2/16
 *
 * @author Niels Norberg
 */
public class Business extends Loan {

    public Business(int ID, String loanHolderName, int amount, LoanDuration duration) {
        super(ID, loanHolderName, amount, duration);
        setInterestRate(getDiskonto()+ COMPANY_RENT);
    }

    @Override
    public String toString() {
        return  "\n" + COMPANY_NAME +
                "\n- Business loan -" +
                "\nAccount:\t" + getLoanHolderID() +
                "\nName:\t\t" + getLoanHolderName() +
                "\nDate:\t\t" + getStartedDate().toString() +
                "\nDuration:\t" + getDuration().getTimeInYears() + " years" +
                "\nAmount:\t\t" + getAmountLoaned() +
                "\nTotal:\t\t" + getTotal() +
                "\n**************************";
    }

    @Override
    public String getLoanType() {
        return "Business";
    }
}
