package com.zeek1910.exampleproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zeek1910.exampleproject.ChatAdapter
import com.zeek1910.exampleproject.R
import com.zeek1910.exampleproject.TextMessage
import java.util.Date


class ChatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var sendButton: ImageButton

    private val chatAdapter = ChatAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        editText = view.findViewById(R.id.editText)
        sendButton = view.findViewById(R.id.buttonSend)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = chatAdapter
        recyclerView.layoutManager = layoutManager
        chatAdapter.setMessages(getMessagesList())

        sendButton.setOnClickListener {
            val message = editText.text.toString()
            if (message.isNotEmpty()) {
                chatAdapter.addMessage(TextMessage(message, Date()))
                editText.text.clear()
            }
        }
    }

    private fun getMessagesList(): List<TextMessage> {
        return listOf(
            TextMessage("Hello", Date()),
            TextMessage("Hi", Date()),
            TextMessage("How are you?", Date()),
            TextMessage("I'm good", Date()),
            TextMessage("What are you doing?", Date()),
            TextMessage("Nothing much", Date()),
            TextMessage("I'm bored", Date()),
            TextMessage("Let's go out", Date()),
            TextMessage("Sure", Date()),
            TextMessage("Where do you want to go?", Date()),
            TextMessage("How about the park?", Date()),
            TextMessage("Sounds good", Date()),
            TextMessage("See you there", Date()),
            TextMessage("Bye", Date()),
            TextMessage("Bye", Date())
        )
    }

}