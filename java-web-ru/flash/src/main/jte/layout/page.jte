@import exercise.dto.BasePage
@import gg.jte.Content

@param Content content
@param BasePage page = null

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet, Флеш-сообщения</title>
</head>
<body>
    ${content}
    @if(page != null && page.getFlashMessage() != null)
        <div class="alert alert-primary" role="alert">
            ${page.getFlashMessage()}
        </div>
    @endif
</body>
</html>
