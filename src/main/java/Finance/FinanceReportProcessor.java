package Finance;

public class FinanceReportProcessor {


    public static FinanceReport ConfigureByCharReport(FinanceReport financeReport, char c) {

        FinanceReport configuredFinanceReport = new FinanceReport(financeReport.getQuantityOfReports());
        for (int i = 0; i < financeReport.getQuantityOfReports(); i++) {
            int j = 0;
            if (Character.toLowerCase((char) financeReport.getReport(i).getFullName().charAt(0)) == Character.toLowerCase((char) c)) {
                configuredFinanceReport.setPayment(financeReport.getReport(i), j);
                j++;
            }
        }
        return configuredFinanceReport;

    }


    public static FinanceReport ConfigureBySumReports(FinanceReport financeReport, double a) {
        FinanceReport configuredFinanceReport = new FinanceReport(financeReport.getQuantityOfReports());
        for (int i = 0; i < financeReport.getQuantityOfReports(); i++) {
            int j = 0;
            if (Double.compare(a, financeReport.getReport(i).getAmountOfPayment()) > 0) {
                configuredFinanceReport.setPayment(financeReport.getReport(i), j);
                j++;
            }
        }
        return configuredFinanceReport;
    }


}