package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) throws Exception {
        try {
            String firstName = ctx.formParamAsClass("firstName", String.class).get();
            String lastName = ctx.formParamAsClass("lastName", String.class).get();
            String email = ctx.formParamAsClass("email", String.class).get();
            String password = ctx.formParamAsClass("password", String.class).get();

            String encriptedPassword = Security.encrypt(password);
            User user = new User(firstName, lastName, email, encriptedPassword, Security.generateToken());
            UserRepository.save(user);
            ctx.cookie("token", user.getToken());
            ctx.redirect(NamedRoutes.userPath(user.getId()));
        }   catch (Exception e) {
            if (StringUtils.isNotBlank(e.getMessage())) {
                ctx.render("users/build.jte", model("error", e.getMessage()));
            }
        }
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        if (user.getToken().equals(ctx.cookie("token"))) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
