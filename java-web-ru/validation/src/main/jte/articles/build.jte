@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page
@param String content = null

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <div class="alert alert-danger" role="alert">
                    ${error.getMessage()}
                </div>
            @endfor
        @endfor
    @endif
    <div class="form-article">
        <form action="/articles" method="POST">
            <h1 class="h3 mb-3 fw-normal">Create article</h1>

            <div class="form-floating">
                <input type="title" name="title" required class="form-control" value="${page.getTitle()}" id="floatingTitle" placeholder="Title">
                <label for="floatingTitle">Title</label>
            </div>
            <label type="labelForContent">Content:</label>
            <div class="form-floating">
              <textarea type="content" name="content" required class="form-control" id="floatingContent" placeholder="Content">
              ${page.getContent()}
              </textarea>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
        </form>
    </div>
`,
style=@`
    <style type="text/css">
        .form-article {
          width: 100%;
          padding: 15px;
          margin: auto;
        }

        .form-article label[type="labelForContent"] {
          margin-top: 10px;
        }

        .form-article .form-floating:focus-within {
          z-index: 2;
        }

        .form-article input[type="title"] {
          margin-bottom: -1px;
        }

        .form-article textarea[type="content"] {
          margin-top: 5px;
          margin-bottom: 10px;
          height: 500px;
        }
    </style>
`
)