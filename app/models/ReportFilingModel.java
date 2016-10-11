package models;

import utils.DecimalConverter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

import static utils.DecimalConverter.getBigDecimal;

/**
 * Model to be populated by web form
 */
public class ReportFilingModel {
    private String TargetCompanyCompaniesHouseIdentifier;

    private Double AverageTimeToPay;
    private Double PercentInvoicesPaidBeyondAgreedTerms;
    private Double PercentInvoicesWithin30Days;
    private Double PercentInvoicesWithin60Days;
    private Double PercentInvoicesBeyond60Days;

    private int StartDate_year;
    private int StartDate_month;
    private int StartDate_day;

    private int EndDate_year;
    private int EndDate_month;
    private int EndDate_day;

    private String PaymentTerms;
    private String DisputeResolution;
    private String PaymentCodes;

    private Boolean OfferEInvoicing = null;
    private Boolean OfferSupplyChainFinance = null;
    private Boolean RetentionChargesInPolicy = null;
    private Boolean RetentionChargesInPast = null;

    /* Formatted getters */

    public BigDecimal getAverageTimeToPayAsDecimal() {return DecimalConverter.getBigDecimal(AverageTimeToPay); }
    public BigDecimal getPercentInvoicesPaidBeyondAgreedTermsAsDecimal() {return DecimalConverter.getBigDecimal(PercentInvoicesPaidBeyondAgreedTerms); }
    public BigDecimal getPercentInvoicesWithin30DaysAsDecimal() {return DecimalConverter.getBigDecimal(PercentInvoicesWithin30Days); }
    public BigDecimal getPercentInvoicesWithin60DaysAsDecimal() {return DecimalConverter.getBigDecimal(PercentInvoicesWithin60Days); }
    public BigDecimal getPercentInvoicesBeyond60DaysAsDecimal() {return DecimalConverter.getBigDecimal(PercentInvoicesBeyond60Days); }

    public Calendar getStartDate() {return makeUtcDate(StartDate_year, StartDate_month, StartDate_day);}
    public Calendar getEndDate() {return makeUtcDate(EndDate_year, EndDate_month, EndDate_day);}

    public String getStartDateString() {return new UiDate(getStartDate()).ToDateString(); }
    public String getEndDateString() {return new UiDate(getEndDate()).ToDateString(); }
    /* Getters and setters */

    /**
     * @deprecated ORM ONLY
     */
    @Deprecated
    public ReportFilingModel() {

    }

    public static ReportFilingModel MakeEmptyModelForTarget(String targetCompanyCompaniesHouseIdentifier) {
        ReportFilingModel rtn = new ReportFilingModel();
        rtn.TargetCompanyCompaniesHouseIdentifier = targetCompanyCompaniesHouseIdentifier;
        return rtn;
    }

    public ReportFilingModel(String targetCompanyCompaniesHouseIdentifier, double averageTimeToPay, double percentInvoicesPaidBeyondAgreedTerms, double percentInvoicesWithin30Days, double percentInvoicesWithin60Days, double percentInvoicesBeyond60Days, int startDate_year, int startDate_month, int startDate_day, int endDate_year, int endDate_month, int endDate_day, String paymentTerms, String disputeResolution, String paymentCodes, Boolean offerEInvoicing, Boolean offerSupplyChainFinance, Boolean retentionChargesInPolicy, Boolean retentionChargesInPast) {
        TargetCompanyCompaniesHouseIdentifier = targetCompanyCompaniesHouseIdentifier;
        AverageTimeToPay = averageTimeToPay;
        PercentInvoicesPaidBeyondAgreedTerms = percentInvoicesPaidBeyondAgreedTerms;
        PercentInvoicesWithin30Days = percentInvoicesWithin30Days;
        PercentInvoicesWithin60Days = percentInvoicesWithin60Days;
        PercentInvoicesBeyond60Days = percentInvoicesBeyond60Days;
        StartDate_year = startDate_year;
        StartDate_month = startDate_month;
        StartDate_day = startDate_day;
        EndDate_year = endDate_year;
        EndDate_month = endDate_month;
        EndDate_day = endDate_day;
        PaymentTerms = paymentTerms;
        DisputeResolution = disputeResolution;
        PaymentCodes = paymentCodes;
        OfferEInvoicing = offerEInvoicing;
        OfferSupplyChainFinance = offerSupplyChainFinance;
        RetentionChargesInPolicy = retentionChargesInPolicy;
        RetentionChargesInPast = retentionChargesInPast;
    }

    public String getTargetCompanyCompaniesHouseIdentifier() {
        return TargetCompanyCompaniesHouseIdentifier;
    }

    public void setTargetCompanyCompaniesHouseIdentifier(String targetCompanyCompaniesHouseIdentifier) {
        TargetCompanyCompaniesHouseIdentifier = targetCompanyCompaniesHouseIdentifier;
    }

    public int getStartDate_year() {
        return StartDate_year;
    }

    public void setStartDate_year(int startDate_year) {
        StartDate_year = startDate_year;
    }

    public int getStartDate_month() {
        return StartDate_month;
    }

    public void setStartDate_month(int startDate_month) {
        StartDate_month = startDate_month;
    }

    public int getStartDate_day() {
        return StartDate_day;
    }

    public void setStartDate_day(int startDate_day) {
        StartDate_day = startDate_day;
    }

    public int getEndDate_year() {
        return EndDate_year;
    }

    public void setEndDate_year(int endDate_year) {
        EndDate_year = endDate_year;
    }

    public int getEndDate_month() {
        return EndDate_month;
    }

    public void setEndDate_month(int endDate_month) {
        EndDate_month = endDate_month;
    }

    public int getEndDate_day() {
        return EndDate_day;
    }

    public void setEndDate_day(int endDate_day) {
        EndDate_day = endDate_day;
    }

    public Double getAverageTimeToPay() {
        return AverageTimeToPay;
    }

    public void setAverageTimeToPay(Double averageTimeToPay) {
        AverageTimeToPay = averageTimeToPay;
    }

    public Double getPercentInvoicesPaidBeyondAgreedTerms() {
        return PercentInvoicesPaidBeyondAgreedTerms;
    }

    public void setPercentInvoicesPaidBeyondAgreedTerms(Double percentInvoicesPaidBeyondAgreedTerms) {
        PercentInvoicesPaidBeyondAgreedTerms = percentInvoicesPaidBeyondAgreedTerms;
    }

    public Double getPercentInvoicesWithin30Days() {
        return PercentInvoicesWithin30Days;
    }

    public void setPercentInvoicesWithin30Days(Double percentInvoicesWithin30Days) {
        PercentInvoicesWithin30Days = percentInvoicesWithin30Days;
    }

    public Double getPercentInvoicesWithin60Days() {
        return PercentInvoicesWithin60Days;
    }

    public void setPercentInvoicesWithin60Days(Double percentInvoicesWithin60Days) {
        PercentInvoicesWithin60Days = percentInvoicesWithin60Days;
    }

    public Double getPercentInvoicesBeyond60Days() {
        return PercentInvoicesBeyond60Days;
    }

    public void setPercentInvoicesBeyond60Days(Double percentInvoicesBeyond60Days) {
        PercentInvoicesBeyond60Days = percentInvoicesBeyond60Days;
    }

    public String getPaymentTerms() {
        return PaymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        PaymentTerms = paymentTerms;
    }

    public String getDisputeResolution() {
        return DisputeResolution;
    }

    public void setDisputeResolution(String disputeResolution) {
        DisputeResolution = disputeResolution;
    }

    public String getPaymentCodes() {
        return PaymentCodes;
    }

    public void setPaymentCodes(String paymentCodes) {
        PaymentCodes = paymentCodes;
    }

    public Boolean isOfferEInvoicing() {
        return OfferEInvoicing;
    }

    public void setOfferEInvoicing(Boolean offerEInvoicing) {
        OfferEInvoicing = offerEInvoicing;
    }

    public Boolean isOfferSupplyChainFinance() {
        return OfferSupplyChainFinance;
    }

    public void setOfferSupplyChainFinance(Boolean offerSupplyChainFinance) {
        OfferSupplyChainFinance = offerSupplyChainFinance;
    }

    public Boolean isRetentionChargesInPolicy() {
        return RetentionChargesInPolicy;
    }

    public void setRetentionChargesInPolicy(Boolean retentionChargesInPolicy) {
        RetentionChargesInPolicy = retentionChargesInPolicy;
    }

    public Boolean isRetentionChargesInPast() {
        return RetentionChargesInPast;
    }

    public void setRetentionChargesInPast(Boolean retentionChargesInPast) {
        RetentionChargesInPast = retentionChargesInPast;
    }

    private Calendar makeUtcDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(year,month,day);
        return calendar;
    }
}

