@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            @if(!page.getPosts().isEmpty())
                <ul>
                    @for(var post : page.getPosts())
                        <li>
                            <a href="${NamedRoutes.postsPath()}/${post.getId()}">${post.getName()}</a>
                        </li>
                    @endfor
                </ul>
            @endif
        </main>
        <nav>
            @if(page.getCurrentPage() > 1)
                <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() - 1}">назад</a>
            @endif
            @if(page.getCurrentPage() < page.getTotalPages())
                <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}">вперёд</a>
            @endif
        </nav>
    </div>
`
)
