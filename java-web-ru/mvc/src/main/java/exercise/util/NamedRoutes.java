package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    // BEGIN
    public static String postEditPath(Long id) {
        return postEditPath(String.valueOf(id));
    }

    public static String postEditPath(String id) {
        return "/posts/" + id + "/edit";
    }

    public static String postUpdatePath(Long id) {
        return postUpdatePath(String.valueOf(id));
    }

    public static String postUpdatePath(String id) {
        return "/posts/" + id;
    }
    // END
}
