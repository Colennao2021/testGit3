package com.example.project1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.project1.R
import com.example.project1.main.MainActivity

class LoginFragment : Fragment() {
    //lateinit var txtUserName: TextView
    lateinit var txtPassword: TextView
    lateinit var btnLogin: Button
    lateinit var activity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        var txtUserName=view.findViewById(R.id.txt_username_sign_in)
        txtPassword=view.findViewById(R.id.txt_password_sign_in)
        btnLogin=view.findViewById(R.id.btn_login)
        activity= getActivity() as MainActivity
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            if(checkLogin()){
                val action =LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                findNavController().navigate(action)
            }
            else
            {
                Toast.makeText(activity,"Username or Password invalid",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkLogin(): Boolean {
        return (txtUserName.text.toString().trim().equals("1") && txtPassword.text.toString().trim().equals("1"))
    }
}