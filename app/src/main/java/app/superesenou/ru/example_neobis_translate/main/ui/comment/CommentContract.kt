package app.superesenou.ru.example_neobis_translate.main.ui.comment

import app.superesenou.ru.example_neobis_translate.main.models.ContactComment

interface CommentContract {

    interface View{

        fun onFailure()
        fun onSuccessGetComments(list: List<ContactComment>)
    }

    interface Presenter{

      fun  getSectionComments()
    }
}