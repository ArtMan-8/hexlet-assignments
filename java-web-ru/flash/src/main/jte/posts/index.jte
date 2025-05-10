@import exercise.dto.posts.PostsPage

@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <div class="mb-3">
        <h2>Все посты</h2>
        @for(var post : page.getPosts())
            <div>
                <h3>${post.getName()}</h3>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    </div>
`,
)
