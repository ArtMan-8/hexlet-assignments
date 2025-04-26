@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <div>
            <h1>Список пользователей</h1>
            <form action="/users" method="get">
                <input type="search" required name="term" value="${page.getTerm()}">
                <input type="submit" value="Искать">
            </form>
            @if(page.getUsers() != null)
                @for(var user : page.getUsers())
                    <div>
                        <p>${user.getFirstName()} ${user.getLastName()}</p>
                    </div>
                @endfor
            @endif
        </div>
    `
)