@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
    <div>
        <h1>Список пользователей</h1>
        @if(page.getUsers().isEmpty())
            <p>Пользователей нет</p>
        @else
            @for(var user : page.getUsers())
                <div>
                    <p><a href="/users/${user.getId()}">${user.getEmail()}</a></p>
                    <p>${user.getLastName()} ${user.getFirstName()}, ${user.getEmail()}</p>
                </div>
            @endfor
        @endif
    </div>
`)