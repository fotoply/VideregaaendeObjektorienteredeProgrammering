/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loan_company.control;

import loan_company.model.LoanInterface;
import loan_company.model.loans.Business;
import loan_company.model.loans.Personal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author erso Created on 03-11-2009, 10:58:52
 *         Updated for VOP 2.sem F15 05-02-2015
 */
public class LoanDriver {
    public static final String LOAN_FILE_NAME = LoanInterface.COMPANY_NAME + ".txt";
    // Liste som skal indeholde de oprettede lån
    private List<LoanInterface> loans;

    private static LoanDriver instance;
    public int loanID = 123123123;

    public static LoanDriver getInstance() {
        if(instance == null) {
            instance = new LoanDriver();
        }
        return instance;
    }

    private LoanDriver() {
        loans = new ArrayList<>();
    }

    public static void main(String[] args) {

        LoanDriver loanDriver = LoanDriver.getInstance();
        // Til læsning af input
        Scanner scanner = new Scanner(System.in);

        // Tæller som fungerer som løbenumre for lånene:
        int loanCount = 1234;

        // Sålænge der ønskes oprettet nye lån
        boolean done = false;
        while (!done) {
            // Mulighed for afslutning:
            System.out.println("Opret nyt lån: tast 1. Afslut: tast 2");
            int choise = scanner.nextInt();
            scanner.nextLine(); // Fjerner \n efter tallet
            if (choise == 2) {
                done = true;    // Afslut
            } else {
                // Indlæsning af diverse oplysninger
                System.out.println("Indtast navn: ");
                String name = scanner.nextLine();

                System.out.println("Vælg låne type\n. Privat: tast 1. Forretning: tast 2");
                int type = scanner.nextInt();

                System.out.println("Indtast beløb (max 500.000 dKr):");
                int amount = scanner.nextInt();

                System.out.println("Indtast løbetid (1,  3 eller 5 år):");
                int term = scanner.nextInt();
                LoanInterface.LoanDuration duration;

                if (term == 3) {
                    duration = LoanInterface.LoanDuration.MIDDLE_TERM;
                } else if (term == 5) {
                    duration = LoanInterface.LoanDuration.LONG_TERM;
                } else {
                    duration = LoanInterface.LoanDuration.SHORT_TERM;
                }

                if (type == 1) { // Privatlån valgt
                    loanDriver.addPersonalLoan(loanCount++, name, amount, duration);
                } else if (type == 2) { // Forretningslån valgt
                    loanDriver.addBusinessLoan(loanCount++, name, amount, duration);
                } else {  // Fejl
                    System.out.println("Ukendt lånetype!!!");
                }

            }
        } // Slut på loopet

        // Udskriv listen. toString() i alle lån kaldes automatisk
        System.out.println(loanDriver.getLoans());

        loanDriver.writeToFile(new File(LOAN_FILE_NAME));

        System.out.println("\nFrom File:\n" + loanDriver.readFromFile(new File(LOAN_FILE_NAME)));
    }

    public void addPersonalLoan(int loanId, String name, int amount, LoanInterface.LoanDuration term) {
        // Fjern udkommenteringen herunder når PersonalLoan er implementeret
        loans.add(new Personal(loanId, name, amount, term));

    }

    public void addBusinessLoan(int loanId, String name, int amount, LoanInterface.LoanDuration term) {
        // Fjern udkommenteringen herunder når BusinessLoan er implementeret
        loans.add(new Business(loanId, name, amount, term));

    }

    public List<LoanInterface> getLoans() {
        return loans;
    }

    //Implementeres i opgave B
    public void writeToFile(File saveFile) {
        //File saveFile = new File(LOAN_FILE_NAME);
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(saveFile, true)));
            for (LoanInterface loan : loans) {
                //String lineToWrite = loan.getLoanHolderID() + "," + loan.getLoanHolderName() +
                //        "," + loan.getLoanType() + "," + loan.getAmountOwed() + "," +
                //        loan.getDuration().getTimeInYears() + "," + loan.getStartedDate().getTime();
                writer.print(loan.toString());
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    //Implementeres i opgave B
    public String readFromFile(File loanFile) {
        // Benyt en Scanner til at læse filen ved navn LOAN_FILE_NAME
        // Returner det læste som en String.
        // Hint: Benyt en StringBuilder til at bygge den endelige string med
        //       Husk at tilføjr linjeskifte efter hver læst linje.
        try {
            Scanner fileScanner = new Scanner(loanFile);
            StringBuilder text = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                text.append(fileScanner.nextLine());
                text.append("\n");
            }
            return text.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Fejl i læsning af fil";
    }

}
