@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <div>
        <h1>Пользователь ${page.getUser().getId()}</h1>
        <p>${page.getUser().getLastName()} ${page.getUser().getFirstName()}, ${page.getUser().getEmail()}</p>
    </div>
`)