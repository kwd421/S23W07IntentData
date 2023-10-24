package kr.ac.kumoh.ce.s20160042.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kr.ac.kumoh.ce.s20160042.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val KEY_NAME = "number"
        const val one = "1"
        const val two = "2"
    }
    private lateinit var main: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnImage1.setOnClickListener(this)
        main.btnImage2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {


        val value = when (v?.id) {
            main.btnImage1.id -> {
                Toast.makeText(this, "이미지2", Toast.LENGTH_SHORT).show()
                one
        }
            main.btnImage2.id -> {
                Toast.makeText(this, "이미지2", Toast.LENGTH_SHORT).show()
                two
        }
            else -> return
    }
        val intent = Intent(this, ImageActivity::class.java)
        intent.putExtra(KEY_NAME, value)
        startActivity(intent)
    }
}