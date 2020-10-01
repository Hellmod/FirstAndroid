package com.example.myapplication


import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class Book : AppCompatActivity() {

    val TAG="zdarzenie"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)


    }

    fun oknoDialogowe(view: View){
        var dialog: ProgressDialog? =ProgressDialog.show(this,"Realizuję zadanie","Proszę czekać...");
        Thread(Runnable {
            kotlin.run { Thread.sleep(3000) }
            if (dialog != null) {
                dialog.dismiss()
            }
        }).start()
    }

    fun oknoZPostepem(view: View){
        var progressDialog:ProgressDialog=ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setIcon(R.mipmap.ic_launcher)
        progressDialog.setTitle("Pobieram dane...")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"OK",DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i: Int ->
            fun onClick(dialog:DialogInterface, which:Int){
            Toast.makeText(baseContext,"Kliknięto OK",Toast.LENGTH_LONG).show()
        }
        })

        progressDialog.show()
        Thread(Runnable {
            kotlin.run {
                for (i in 1..10){
                Thread.sleep(500)
                progressDialog.incrementProgressBy(10)
            }

            }
            if (progressDialog != null) {
                progressDialog.dismiss()
            }
        }).start()

    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")

    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}