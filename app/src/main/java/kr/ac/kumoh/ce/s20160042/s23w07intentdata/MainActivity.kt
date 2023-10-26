package kr.ac.kumoh.ce.s20160042.s23w07intentdata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s20160042.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val KEY_NAME = "number"
        const val one = "1"
        const val two = "2"
    }

    private lateinit var main: ActivityMainBinding
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode != Activity.RESULT_OK)
            return@registerForActivityResult

        val result = it.data?.getIntExtra(
            ImageActivity.IMAGE_RESULT,
            ImageActivity.NONE) // 없을 때 반환값
        val str = when (result) {
            ImageActivity.LIKE -> "좋아요"
            ImageActivity.DISLIKE -> "싫어요"
            else -> ""
        }
        when (it.data?.getStringExtra(ImageActivity.IMAGE_NAME)) {
            one -> main.btnImage1.text = "1 ($str)"
            two -> main.btnImage2.text = "2 ($str)"
        }
    }

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
        val intent = Intent(this,
            //ImageActivity::class.java)
            AnotherActivity::class.java)
        intent.putExtra(KEY_NAME, value)
        startActivity(intent)
    }
}