package controllers;

import orchestrators.OrchestratorResult;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import scala.Option;

/**
 * Created by daniel.rothig on 06/10/2016.
 *
 * Controller capable of wrapping views into a layout template. This decouples views from their layouts,
 * allowing them to be rendered as components, e.g. for the VisualTest controller.
 *
 */
class PageController extends Controller {

    protected <T> Result renderOrchestratorResult(OrchestratorResult<T> result, OrchestratorResultMapper<T> mapper) {
        if (result.success()) {
            return mapper.map(result.get());
        } else {
            return status(500, result.message());
        }
    }
    protected Html page(Html content) {
        return views.html.common.page.govukTemplateDefaults.render("Payment practices reporting", content);
    }

    protected String getPostParameter(String key) {
        try {
            String[] values = request().body().asFormUrlEncoded().get(key);
            return values.length > 0
                    ? values[values.length - 1]
                    : "";
        } catch (NullPointerException ignored) {
            return null;
        }
    }

    protected interface OrchestratorResultMapper<T> {
        public Result map(T orchestratorResultData);
    }
}
