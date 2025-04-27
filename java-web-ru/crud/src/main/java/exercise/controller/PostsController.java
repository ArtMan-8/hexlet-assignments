package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var pageSize = 5;
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var totalPages = PostRepository.getEntities().size() / pageSize;

        var posts = PostRepository.findAll(pageNumber, pageSize);
        var page = new PostsPage(posts, pageNumber, totalPages);
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var postId = ctx.pathParamAsClass("id", Long.class).getOrDefault(-1L);
        var post = PostRepository.find(postId);

        if (post.isPresent()) {
            var page = new PostPage(post.get());
            ctx.render("posts/show.jte", model("page", page));
        } else {
            throw new NotFoundResponse("Page not found");
        }
    }
    // END
}
