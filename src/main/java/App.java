import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String collectionName = request.queryParams("collectionName");
      ToyCollection newCollection = new ToyCollection(collectionName);
      model.put("collections", request.session().attribute("collections"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<ToyCollection> collections = request.session().attribute("collections");
      if (collections == null) {
        collections = new ArrayList<ToyCollection>();
        request.session().attribute("collections", collections);
      }

      model.put("template", "templates/toys.vtl");
      // model.put("")
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/toys", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/dinoToy-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/toys", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String type = request.queryParams("type");
      int size = request.queryParams(Integer.parseInt("size"));
      String rarity = request.queryParams("rarity");
      String condition = request.queryParams("condition");
      String manufactured = request.queryParams("manufactured");
      int price = request.queryParams(Integer.parseInt("price"));
      DinoToys newToy = new DinoToys(type, size, rarity, condition, manufactured, price);
      model.put("template", "templates/toys.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("collections", ToyCollection.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




  }
}
