import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ensias.pfa2021.*
import kotlinx.android.synthetic.main.fragment_inspiration.view.*

class Inspiration:Fragment(),View.OnClickListener {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {  //val breakfast= findViewById<Button>(R.id.b_breakfast)
        //breakfast.setOnClickListener {
        //Handler code here.
        //val intent = Intent(this,Breakfast ::class.java)

        //}
        var v = inflater.inflate(R.layout.fragment_inspiration, container, false)
        val btn1: Button = v.findViewById(R.id.b_breakfast)
        btn1.setOnClickListener(this)
        val btn2: Button=v.findViewById(R.id.b_lunch)
        btn2.setOnClickListener(this)
        val btn3: Button=v.findViewById(R.id.b_dessert)
        btn3.setOnClickListener(this)

        return v
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.b_breakfast -> {
                val intent2 = Intent(context, Breakfast::class.java)
                startActivity(intent2)
            }
            R.id.b_lunch -> {
                val intent3 = Intent(context, Lunch::class.java)
                startActivity(intent3)
            }
            R.id.b_dessert -> {
            val intent4 = Intent(context, Dessert::class.java)
            startActivity(intent4)
        }
        }
    }


}


