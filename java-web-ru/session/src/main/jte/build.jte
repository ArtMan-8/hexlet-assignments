@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage

@param LoginPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <form action="${NamedRoutes.loginPath()}" method="post">
                <div class="mb-3">
                    <label class="form-label">
                        Логин
                        <input type="text" class="form-control" required name="name" />
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                        Пароль
                        <input type="password" class="form-control" required name="password" />
                    </label>
                </div>
                @if(page.getError() != null)
                    <div>${page.getError()}</div>
                @endif
                <input type="submit" class="btn btn-primary" value="Войти" />
            </form>
        </div>
    `
)