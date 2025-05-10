package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage(user);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) throws Exception{
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void login(Context ctx) throws Exception {
        try {
            String username = ctx.formParamAsClass("name", String.class).get();
            String password = ctx.formParamAsClass("password", String.class).get();

            var user = UsersRepository.findByName(username).orElse(null);
            if (user != null && user.getPassword().equals(encrypt(password))) {
                ctx.sessionAttribute("user", username);
                ctx.redirect("/");
            } else {
                throw new Exception("Wrong username or password");
            }
        } catch (Exception e)  {
            String username = ctx.formParamAsClass("name", String.class).get();
            var page = new LoginPage(username, e.getMessage());
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect("/");
    }
    // END
}
