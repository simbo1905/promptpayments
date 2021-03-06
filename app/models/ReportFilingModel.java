package models;

import utils.DecimalConverter;
import utils.UtcConverter;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Model to be populated by web form
 */
public class ReportFilingModel {
    private String TargetCompanyCompaniesHouseIdentifier;

    private String AverageTimeToPay;
    private String PercentInvoicesPaidBeyondAgreedTerms;
    private String PercentInvoicesWithin30Days;
    private String PercentInvoicesWithin60Days;
    private String PercentInvoicesBeyond60Days;

    private String StartDate_year;
    private String StartDate_month;
    private String StartDate_day;

    private String EndDate_year;
    private String EndDate_month;
    private String EndDate_day;

    private String PaymentTerms;
    private String MaximumContractPeriod;
    private Boolean PaymentTermsChanged;
    private String PaymentTermsChangedComment;
    private Boolean PaymentTermsChangedNotified;
    private String PaymentTermsChangedNotifiedComment;
    private String PaymentTermsComment;


    private String DisputeResolution;

    private Boolean HasPaymentCodes;
    private String PaymentCodes;

    private Boolean OfferEInvoicing = null;
    private Boolean OfferSupplyChainFinance = null;
    private Boolean RetentionChargesInPolicy = null;
    private Boolean RetentionChargesInPast = null;

    /* Formatted getters */

    public BigDecimal getAverageTimeToPayAsDecimal() {
        return DecimalConverter.getBigDecimal(AverageTimeToPay);
    }

    public BigDecimal getPercentInvoicesPaidBeyondAgreedTermsAsDecimal() {
        return DecimalConverter.getBigDecimal(PercentInvoicesPaidBeyondAgreedTerms);
    }

    public BigDecimal getPercentInvoicesWithin30DaysAsDecimal() {
        return DecimalConverter.getBigDecimal(PercentInvoicesWithin30Days);
    }

    public BigDecimal getPercentInvoicesWithin60DaysAsDecimal() {
        return DecimalConverter.getBigDecimal(PercentInvoicesWithin60Days);
    }

    public BigDecimal getPercentInvoicesBeyond60DaysAsDecimal() {
        return DecimalConverter.getBigDecimal(PercentInvoicesBeyond60Days);
    }

    public Calendar getStartDate() { return UtcConverter.tryMakeUtcDate(StartDate_year, StartDate_month, StartDate_day); }

    public Calendar getEndDate() { return UtcConverter.tryMakeUtcDate(EndDate_year, EndDate_month, EndDate_day); }

    public String getStartDateString() {
        return new UiDate(getStartDate()).ToDateString();
    }

    public String getEndDateString() {
        return new UiDate(getEndDate()).ToDateString();
    }


    /**
     * @deprecated ORM ONLY, use MakeEmptyModelForTarget() instead.
     */
    @Deprecated
    public ReportFilingModel() {

    }

    public static ReportFilingModel MakeEmptyModelForTarget(String targetCompanyCompaniesHouseIdentifier) {
        ReportFilingModel rtn = new ReportFilingModel();
        rtn.TargetCompanyCompaniesHouseIdentifier = targetCompanyCompaniesHouseIdentifier;
        return rtn;
    }

    public static ReportFilingModel makeReportFilingModel(String targetCompanyCompaniesHouseIdentifier, double averageTimeToPay, double percentInvoicesPaidBeyondAgreedTerms, double percentInvoicesWithin30Days, double percentInvoicesWithin60Days, double percentInvoicesBeyond60Days, String startDate_year, String startDate_month, String startDate_day, String endDate_year, String endDate_month, String endDate_day, String paymentTerms, String maximumContractPeriod, Boolean paymentTermsChanged, String paymentTermsChangedComment, Boolean paymentTermsChangedNotified, String paymentTermsChangedNotifiedComment, String paymentTermsComment, String disputeResolution, Boolean hasPaymentCodes, String paymentCodes, Boolean offerEInvoicing, Boolean offerSupplyChainFinance, Boolean retentionChargesInPolicy, Boolean retentionChargesInPast) {
        ReportFilingModel rfm = new ReportFilingModel();

        rfm.TargetCompanyCompaniesHouseIdentifier = targetCompanyCompaniesHouseIdentifier;
        rfm.AverageTimeToPay = "" + averageTimeToPay;
        rfm.PercentInvoicesPaidBeyondAgreedTerms = "" + percentInvoicesPaidBeyondAgreedTerms;
        rfm.PercentInvoicesWithin30Days = "" + percentInvoicesWithin30Days;
        rfm.PercentInvoicesWithin60Days = "" + percentInvoicesWithin60Days;
        rfm.PercentInvoicesBeyond60Days = "" + percentInvoicesBeyond60Days;
        rfm.StartDate_year = startDate_year;
        rfm.StartDate_month = startDate_month;
        rfm.StartDate_day = startDate_day;
        rfm.EndDate_year = endDate_year;
        rfm.EndDate_month = endDate_month;
        rfm.EndDate_day = endDate_day;
        rfm.PaymentTerms = paymentTerms;
        rfm.MaximumContractPeriod = maximumContractPeriod;
        rfm.PaymentTermsChanged = paymentTermsChanged;
        rfm.PaymentTermsChangedComment = paymentTermsChangedComment;
        rfm.PaymentTermsChangedNotified = paymentTermsChangedNotified;
        rfm.PaymentTermsChangedNotifiedComment = paymentTermsChangedNotifiedComment;
        rfm.PaymentTermsComment = paymentTermsComment;
        rfm.DisputeResolution = disputeResolution;
        rfm.HasPaymentCodes = hasPaymentCodes;
        rfm.PaymentCodes = paymentCodes;
        rfm.OfferEInvoicing = offerEInvoicing;
        rfm.OfferSupplyChainFinance = offerSupplyChainFinance;
        rfm.RetentionChargesInPolicy = retentionChargesInPolicy;
        rfm.RetentionChargesInPast = retentionChargesInPast;

        return rfm;
    }

    /* Getters and setters */

    public String getTargetCompanyCompaniesHouseIdentifier() {
        return TargetCompanyCompaniesHouseIdentifier;
    }

    public void setTargetCompanyCompaniesHouseIdentifier(String targetCompanyCompaniesHouseIdentifier) {
        TargetCompanyCompaniesHouseIdentifier = targetCompanyCompaniesHouseIdentifier;
    }

    public String getStartDate_year() {
        return StartDate_year;
    }

    public void setStartDate_year(String startDate_year) {
        StartDate_year = startDate_year;
    }

    public String getStartDate_month() {
        return StartDate_month;
    }

    public void setStartDate_month(String startDate_month) {
        StartDate_month = startDate_month;
    }

    public String getStartDate_day() {
        return StartDate_day;
    }

    public void setStartDate_day(String startDate_day) {
        StartDate_day = startDate_day;
    }

    public String getEndDate_year() {
        return EndDate_year;
    }

    public void setEndDate_year(String endDate_year) {
        EndDate_year = endDate_year;
    }

    public String getEndDate_month() {
        return EndDate_month;
    }

    public void setEndDate_month(String endDate_month) {
        EndDate_month = endDate_month;
    }

    public String getEndDate_day() {
        return EndDate_day;
    }

    public void setEndDate_day(String endDate_day) {
        EndDate_day = endDate_day;
    }

    public String getAverageTimeToPay() {
        return AverageTimeToPay;
    }

    public void setAverageTimeToPay(String averageTimeToPay) {
        AverageTimeToPay = averageTimeToPay;
    }

    public String getPercentInvoicesPaidBeyondAgreedTerms() {
        return PercentInvoicesPaidBeyondAgreedTerms;
    }

    public void setPercentInvoicesPaidBeyondAgreedTerms(String percentInvoicesPaidBeyondAgreedTerms) {
        PercentInvoicesPaidBeyondAgreedTerms = percentInvoicesPaidBeyondAgreedTerms;
    }

    public String getPercentInvoicesWithin30Days() {
        return PercentInvoicesWithin30Days;
    }

    public void setPercentInvoicesWithin30Days(String percentInvoicesWithin30Days) {
        PercentInvoicesWithin30Days = percentInvoicesWithin30Days;
    }

    public String getPercentInvoicesWithin60Days() {
        return PercentInvoicesWithin60Days;
    }

    public void setPercentInvoicesWithin60Days(String percentInvoicesWithin60Days) {
        PercentInvoicesWithin60Days = percentInvoicesWithin60Days;
    }

    public String getPercentInvoicesBeyond60Days() {
        return PercentInvoicesBeyond60Days;
    }

    public void setPercentInvoicesBeyond60Days(String percentInvoicesBeyond60Days) {
        PercentInvoicesBeyond60Days = percentInvoicesBeyond60Days;
    }

    public String getPaymentTerms() {
        return PaymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        PaymentTerms = paymentTerms;
    }

    public String getMaximumContractPeriod() {
        return MaximumContractPeriod;
    }

    public void setMaximumContractPeriod(String maximumContractPeriod) {
        MaximumContractPeriod = maximumContractPeriod;
    }

    public Boolean isPaymentTermsChanged() {
        return PaymentTermsChanged;
    }

    public void setPaymentTermsChanged(Boolean paymentTermsChanged) {
        PaymentTermsChanged = paymentTermsChanged;
    }

    public String getPaymentTermsChangedComment() {
        return PaymentTermsChangedComment;
    }

    public void setPaymentTermsChangedComment(String paymentTermsChangedComment) {
        PaymentTermsChangedComment = paymentTermsChangedComment;
    }

    public Boolean isPaymentTermsChangedNotified() {
        return PaymentTermsChangedNotified;
    }

    public void setPaymentTermsChangedNotified(Boolean paymentTermsChangedNotified) {
        PaymentTermsChangedNotified = paymentTermsChangedNotified;
    }

    public String getPaymentTermsChangedNotifiedComment() {
        return PaymentTermsChangedNotifiedComment;
    }

    public void setPaymentTermsChangedNotifiedComment(String paymentTermsChangedNotifiedComment) {
        PaymentTermsChangedNotifiedComment = paymentTermsChangedNotifiedComment;
    }

    public String getPaymentTermsComment() {
        return PaymentTermsComment;
    }

    public void setPaymentTermsComment(String paymentTermsComment) {
        PaymentTermsComment = paymentTermsComment;
    }

    public String getDisputeResolution() {
        return DisputeResolution;
    }

    public void setDisputeResolution(String disputeResolution) {
        DisputeResolution = disputeResolution;
    }

    public Boolean isHasPaymentCodes() { return HasPaymentCodes;    }

    public void setHasPaymentCodes(Boolean hasPaymentCodes) { HasPaymentCodes = hasPaymentCodes; }

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
}

