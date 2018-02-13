package com.lnyswz.asdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import kotlinx.android.synthetic.main.activity_ssh2.*
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class SSH2Activity : AppCompatActivity() {
    var LOGIN_URL = "http://192.168.0.8/lnyswz/admin/departmentAction!listDeps.action"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ssh2)

//        Thread(runnable).start()

        text.text = LoginByPost("", "")
    }

//    var handler = Handler(){
//
//        fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            var data: Bundle = msg.getData()
//            val val1 = data.getString("value")
//            val i = Log.i("mylog","请求结果-->" + val1)
//        }
//    }

//    val runnable = Runnable(){
//        fun run(){
//            //
//            // TODO: http request.
//            //
//            var msg = Message()
//            var data = Bundle()
//            data.putString("value", "请求结果")
//            msg.setData(data)
//            handler.sendMessage(msg)
//        }
//    }

    fun LoginByPost(number: String?, passwd: String?): String {
        var msg = "valid"
        try {
            val conn = URL(LOGIN_URL).openConnection() as HttpURLConnection
            //设置请求方式,请求超时信息
            conn.setRequestMethod("POST")
            conn.setReadTimeout(5000)
            conn.setConnectTimeout(5000)
            //设置运行输入,输出:
            conn.setDoOutput(true)
            conn.setDoInput(true)
            //Post方式不能缓存,需手动设置为false
            conn.setUseCaches(false)
            //我们请求的数据:
            val data = "passwd=" + URLEncoder.encode(passwd, "UTF-8") +
                    "&number=" + URLEncoder.encode(number, "UTF-8")
            //这里可以写一些请求头的东东...
            //获取输出流
//            val data = ""
            var out = conn.outputStream
            out.write(data.toByteArray())
            out.flush()
            if (conn.getResponseCode() === 200) {
                // 获取响应的输入流对象
                val `is` = conn.getInputStream()
                // 创建字节输出流对象
                val message = ByteArrayOutputStream()
                // 定义读取的长度
                var len = 0
                // 定义缓冲区
                val buffer = ByteArray(1024)
                // 按照缓冲区的大小，循环读取
                len = `is`.read(buffer)
                while (len != -1) {
                    // 根据读取的长度写入到os对象中
                    message.write(buffer, 0, len)
                }
                // 释放资源
                `is`.close()
                message.close()
                // 返回字符串
                msg = String(message.toByteArray())
                return msg
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return msg
    }
}
