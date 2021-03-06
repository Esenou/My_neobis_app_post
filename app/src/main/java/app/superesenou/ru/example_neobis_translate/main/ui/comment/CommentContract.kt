package app.superesenou.ru.example_neobis_translate.main.ui.comment

import app.superesenou.ru.example_neobis_translate.main.models.ContactComment
import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar

interface CommentContract {

    interface View:IProgressBar{

        fun onFailure()
        fun onSuccessGetComments(list: List<ContactComment>)
    }

    interface Presenter{

      fun  getSectionComments()
    }
}