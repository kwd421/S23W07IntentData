package kr.ac.kumoh.ce.s20160042.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s20160042.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val IMAGE_NAME = "image name"
        const val IMAGE_RESULT = "image result"

        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }
    private lateinit var main: ActivityImageBinding
    private lateinit var imageName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        Log.i("Image!!!", intent.getStringExtra(MainActivity.KEY_NAME) ?: "없음")

        imageName = intent.getStringExtra(MainActivity.KEY_NAME) ?: "None"
        val res = when(intent.getStringExtra(MainActivity.KEY_NAME))
        {
            MainActivity.one -> R.drawable.image1
            MainActivity.two -> R.drawable.image2
            else -> R.drawable.ic_launcher_foreground
        }

        main.image.setImageResource(res)

        main.btnLike.setOnClickListener(this)
        main.btnDislike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when(v?.id) {
            main.btnLike.id -> LIKE
            main.btnDislike.id -> DISLIKE
            else -> NONE
        }
        // TODO: IMAGE_NAME putExtra 필요
        intent.putExtra(IMAGE_RESULT, imageName)
        setResult(RESULT_OK, intent)
        finish()
    }
}