package com.iam.brandon.snapimages

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

const val IMG_SIZE = 2048

const val URL_BASE = "https://picsum.photos/"

class NetworkManager(context: MyCallback){
    val myContext = context

    fun getImages(){

        val asyncNetwork = @SuppressLint("StaticFieldLeak")
        object : AsyncTask<Void, Bitmap?, Bitmap?>() {
            override fun onPreExecute() {
                super.onPreExecute()
            }

            override fun doInBackground(vararg params: Void?): Bitmap? {

                val number = 13

                val connection = URL("$URL_BASE$IMG_SIZE/$IMG_SIZE/?image=$number").
                        openConnection() as HttpURLConnection

                val responseCode = connection.responseCode

                var returnSt: Bitmap? = null

                if (responseCode==HttpURLConnection.HTTP_OK){
                    returnSt = BitmapFactory.decodeStream(BufferedInputStream(connection.inputStream))
                }

                return returnSt
            }

            override fun onProgressUpdate(vararg values: Bitmap?) {
                super.onProgressUpdate(*values)
            }

            override fun onPostExecute(result: Bitmap?) {
                myContext.handleBitmap(result!!)
            }
        }

        asyncNetwork.execute()
    }
}