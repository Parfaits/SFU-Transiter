package com.example.sfutransiter.views.comment_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sfutransiter.R
import com.example.sfutransiter.databinding.FragmentCommentBoardBinding

class CommentBoard : Fragment() {
    private var _binding: FragmentCommentBoardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommentBoardBinding.inflate(inflater, container, false)
        val busName : TextView = binding.root.findViewById(R.id.txtBusTitle)
        arguments?.let {
            busName.text = it.getString("routeID")!!
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CommentBoard()

        val TAG: String = CommentBoard::class.java.simpleName
    }
}