package com.ensias.pfa2021
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login_fr: Fragment(),View.OnClickListener   {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view:View=inflater.inflate(R.layout.login_fr, container, false)
            val btn: Button = view.findViewById(R.id.btn_login);
            btn.setOnClickListener(this)
            return view
        }

    override fun onClick(v: View?) {
        var email: EditText?=view?.findViewById(R.id.email_login)
        var pasword: EditText? =view?.findViewById(R.id.password_login)
        var login_auth: FirebaseAuth = Firebase.auth
        when (v?.id) {
            R.id.btn_login -> {
                login_auth= FirebaseAuth.getInstance()
                var email=email?.text.toString()
                var  pasword=pasword?.text.toString()
                var  progressBar2: ProgressBar? =view?.findViewById(R.id.progressBar2)
                if(email.isNotEmpty() && pasword.isNotEmpty()){
                    progressBar2?.visibility=View.VISIBLE
                    login_auth.signInWithEmailAndPassword(email,pasword).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intentprincipale = Intent(context, Home::class.java)
                            Toast.makeText(context,"ثم التسجيل الدخول", Toast.LENGTH_SHORT).show()
                            progressBar2?.visibility=View.GONE
                            startActivity(intentprincipale)
                        }else{
                            Toast.makeText(context,"لم يثم التسجيل  تحقق من المعلومات التي ادخلتها",Toast.LENGTH_LONG).show()
                            progressBar2?.visibility=View.GONE
                        }
                    }

                }else{
                    Toast.makeText(context,"اذخل المعلومات الازمة",Toast.LENGTH_LONG).show()
                }
                    }

                }

            }

}
