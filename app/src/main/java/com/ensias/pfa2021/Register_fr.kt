package com.ensias.pfa2021
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.content.Intent
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register_fr : Fragment(),View.OnClickListener  {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.register_fr, container, false)
        val btn:Button  = view.findViewById(R.id.register_btn)
        btn.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        var email:EditText?=view?.findViewById(R.id.email_register)
        var pasword: EditText? =view?.findViewById(R.id.pasword_register)
        var register_auth: FirebaseAuth= Firebase.auth
        when (v?.id) {
            R.id.register_btn -> {
                register_auth= FirebaseAuth.getInstance()
                var email=email?.text.toString()
                var  pasword=pasword?.text.toString()
                var  progressBar: ProgressBar? =view?.findViewById(R.id.progressBar)
                if(email.isNotEmpty() && pasword.isNotEmpty()){
                 progressBar?.visibility=View.VISIBLE
                    register_auth?.createUserWithEmailAndPassword(email, pasword)
                            ?.addOnCompleteListener {
                                if (it.isSuccessful){
                                    val intentprincipale = Intent(context, Home::class.java)
                                    Toast.makeText(context,"ثم التسجيل بنجاح",Toast.LENGTH_SHORT).show()
                                    startActivity(intentprincipale)
                                    progressBar?.visibility=View.GONE



                                }else{
                                        Toast.makeText(context,"لم يثم التسجيل  تحقق من المعلومات التي ادخلتها",Toast.LENGTH_LONG).show()
                                    progressBar?.visibility=View.GONE
                                    }
                            }

                }else{
                    Toast.makeText(context,"اذخل المعلومات الازمة",Toast.LENGTH_LONG).show()

                }
                  }

            else -> {
            }
    }
}}

