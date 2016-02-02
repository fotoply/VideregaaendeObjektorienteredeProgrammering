package loan_company;

/**
 *
 * @author erso  Created on 03-11-2009, 10:02:34
 *  Updated for VOP 2.sem F15 05-02-2015
 */
public interface LoanInterface {

    static final String COMPANY = "Fuskes Finans Aps";
    static final int SHORT_TERM = 1;
    static final int MIDDLE_TERM = 3;
    static final int LONG_TERM = 5;
    static final double MAX_LOAN = 500000.00;
    static final double PRIVATE_INTEREST = 5.0; // + diskonto
    static final double BUSINESS_INTEREST = 4.0; // + diskonto
    
    double getTotal();
    void setInterestRate();
    double getInterestRate();

}
