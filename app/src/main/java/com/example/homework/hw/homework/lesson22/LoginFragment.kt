package com.example.homework.hw.homework.lesson22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homework.R
import com.example.homework.databinding.LoginFragmentBinding

class LoginFragment : Fragment(), View.OnClickListener {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        binding?.btnAutho?.setOnClickListener {
            if (_binding?.tfLogin?.editText?.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Введите логин", Toast.LENGTH_LONG).show()

                _binding?.tfLogin?.error = getString(R.string.errorAutho)
                return@setOnClickListener
            }else{
                Toast.makeText(requireContext(), "Введите логин", Toast.LENGTH_LONG).show()

                _binding?.tfLogin?.error = getString(R.string.errorAutho)

            }
        }
    }
}


/*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.login_fragment)

        //val binding: FragmentLoginBinding = DataBindingUtil.setContentView(this, R.layout.login_fragment)

    }
*/