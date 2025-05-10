@import exercise.util.NamedRoutes
@import exercise.dto.MainPage

@param MainPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        @if(page.getName() == null)
            <div>
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            </div>
        @else
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <div class="mb-3">
                    Логин: ${page.getName().toString()}
                </div>
                <input type="submit" class="btn btn-primary" value="Выйти" />
            </form>
        @endif
    </div>
`
)