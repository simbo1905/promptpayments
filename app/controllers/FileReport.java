package controllers;

import com.google.inject.Inject;
import components.PagedList;
import models.*;
import orchestrators.FileReportOrchestrator;
import orchestrators.OrchestratorResult;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Http;
import play.mvc.Result;
import utils.DatePickerHelper;
import utils.TimeProvider;
import utils.common.SelectOption;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel.rothig on 27/09/2016.
 *
 * Controller for submitting payment reports
 */
public class FileReport extends PageController {

    @Inject
    private FileReportOrchestrator fileReportOrchestrator;

    @Inject
    private TimeProvider timeProvider;

    private Form<ReportFilingModel> reportForm;

    @Inject
    public FileReport(FormFactory formFactory) {
        reportForm = formFactory.form(ReportFilingModel.class);
    }


    public Result index() {return ok(page(views.html.FileReport.index.render())); }
    public Result start() {return ok(page(views.html.FileReport.start.render())); }
    public Result guidance() {return ok(page(views.html.FileReport.guidance.render())); }

    public Result findCompanies() {return ok(page(views.html.FileReport.findCompanies.render())); }

    public Result login(String companiesHouseIdentifier) {
        String authorizationUri = fileReportOrchestrator.getAuthorizationUri(companiesHouseIdentifier);
        return redirect(authorizationUri);
        //return ok(page(views.html.FileReport.login.render(companiesHouseIdentifier)));
    }

    public Result loginCallback(String state, String code) {
        OrchestratorResult<Http.Cookie> result = fileReportOrchestrator.tryAuthorize(code, state);
        if (result.success()) {
            response().setCookie(result.get());
            OrchestratorResult<FilingData> model = fileReportOrchestrator.tryMakeReportFilingModel(result.get().value(), state);
            if (model.success()) {
                return ok(page(views.html.FileReport.file.render(
                        reportForm.fill(model.get().model),
                        new AllOkReportFilingModelValidation(),
                        model.get().company,
                        model.get().date,
                        new DatePickerHelper(timeProvider)
                )));
            } else {
                return status(500, model.message());
            }
        } else {
            return status(500, result.message());
        }
    }

    public Result companies(int page) {
        String company = request().body().asFormUrlEncoded().get("companyname")[0];
        OrchestratorResult<PagedList<CompanySummary>> companies = fileReportOrchestrator.findRegisteredCompanies(company, page, 25);
        if (companies.success()) {
            return ok(page(views.html.FileReport.companies.render(companies.get(), company)));
        } else {
            return status(501, companies.message());
        }
    }

    public Result reviewFiling() {
        OrchestratorResult<ValidatedFilingData> data = fileReportOrchestrator.tryValidateReportFilingModel(reportForm.bindFromRequest(request()).get());
        if (data.success()) {
            if (data.get().validation.isValid()) {
                return ok(page(views.html.FileReport.review.render(reportForm.fill(data.get().model), data.get().company, data.get().date)));
            } else {
                return ok(page(views.html.FileReport.file.render(reportForm.fill(data.get().model), data.get().validation, data.get().company, data.get().date, new DatePickerHelper(timeProvider))));
            }
        } else {
            return status(401, data.message());
        }
    }

    public Result editFiling() {
        OrchestratorResult<ValidatedFilingData> data = fileReportOrchestrator.tryValidateReportFilingModel(reportForm.bindFromRequest(request()).get());
        if (data.success()) {
            return ok(page(views.html.FileReport.file.render(reportForm.fill(data.get().model), data.get().validation, data.get().company, data.get().date, new DatePickerHelper(timeProvider))));
        } else {
            return status(401, data.message());
        }
    }

    public Result submitFiling() {
        ReportFilingModel model = reportForm.bindFromRequest(request()).get();
        OrchestratorResult<Integer> resultingId = fileReportOrchestrator.tryFileReport(request().cookie("auth").value(), model);
        if (resultingId.success()) {
            return redirect(routes.ViewReport.view(model.getTargetCompanyCompaniesHouseIdentifier(), resultingId.get()));
        } else {
            return status(401, resultingId.message());
        }
    }
}

