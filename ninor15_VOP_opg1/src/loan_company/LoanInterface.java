package loan_company;

/**
 *
 * @author erso  Created on 03-11-2009, 10:02:34
 *  Updated for VOP 2.sem F15 05-02-2015
 */
public interface LoanInterface {

    static final String COMPANY = "Fuskes Finans Aps";
    String currencyDenotation = "DKK";
    int maxAmountLoanable = 500000;
    double diskonto = 0.0;

    double personalRent = 0.05;
    int personalCreationFee = 1000;

    double companyRent = 0.04;

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
    
    double getTotal();
    double getInterestRate();

}
