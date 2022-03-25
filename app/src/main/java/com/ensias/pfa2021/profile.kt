import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ensias.pfa2021.Home
import com.ensias.pfa2021.Login_activity
import com.ensias.pfa2021.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class profile:Fragment(),View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        var view1:View=view.findViewById(R.id.profile_view)
        view1=inflater.inflate(R.layout.info_profile, container, false)
        val btn: Button = view.findViewById(R.id.logout_btn)

        btn.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.logout_btn -> {
                var  progressBar4: ProgressBar? =view?.findViewById(R.id.progressBar4)
                progressBar4?.visibility=View.VISIBLE
                val intentprincipale = Intent(context,Login_activity::class.java)
                progressBar4?.visibility=View.GONE
                FirebaseAuth.getInstance().signOut()
                Toast.makeText(context,"ثم التسجيل الخروج", Toast.LENGTH_SHORT).show()
                startActivity(intentprincipale)

    }
}}}