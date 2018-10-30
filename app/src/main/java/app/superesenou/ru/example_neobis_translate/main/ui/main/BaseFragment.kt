package app.superesenou.ru.example_neobis_translate.main.ui.main

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import app.superesenou.ru.example_neobis_translate.R


@Suppress("DEPRECATION")
open class BaseFragment:Fragment() {

    private var progressBar:ProgressDialog?=null;






    open fun showProgress(){
        this.run{
            progressBar=null
            if(progressBar==null ){
                progressBar=ProgressDialog(activity)
                progressBar?.setMessage(getString(R.string.loading))
                progressBar?.setCanceledOnTouchOutside(false)
                progressBar?.show()
            }
        }
    }

    open fun hideProgress(){
        this.run{
            if(progressBar != null && progressBar?.isShowing!!){
                progressBar!!.dismiss()
                progressBar = null
            }
        }
    }
    open fun onRefresh(){

    }







}

private fun BaseFragment.runOnUiThread(function: () -> Unit) {

}
