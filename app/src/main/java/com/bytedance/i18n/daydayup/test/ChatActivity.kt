package com.bytedance.i18n.daydayup.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytedance.i18n.daydayup.R
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.ArrayList

class ChatActivity : AppCompatActivity() {

    private var msgList = ArrayList<Msg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // set layout manager
        val layoutManager = LinearLayoutManager(this)
        msg_recycler_view.layoutManager = layoutManager

        //set adapter
        val adapter = MsgAdapter(msgList)
        msg_recycler_view.adapter = adapter

        send_msg.setOnClickListener {

            var content = input_text.text.toString()

            val msg = if (content.startsWith("#")){
                Msg(content, Msg.TYPE_REVEIVED)
            }else{
                Msg(content, Msg.TYPE_SENT)
            }

            msgList.add(msg)
            adapter.notifyItemChanged(msgList.size - 1)
            msg_recycler_view.scrollToPosition(msgList.size - 1)
            input_text.setText("")

        }

    }

}