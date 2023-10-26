package kr.ac.kumoh.ce.s20160042.s23w07intentdata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import kr.ac.kumoh.ce.s20160042.s23w07intentdata.AnotherActivity.Companion.DISLIKE
import kr.ac.kumoh.ce.s20160042.s23w07intentdata.AnotherActivity.Companion.LIKE
import kr.ac.kumoh.ce.s20160042.s23w07intentdata.ui.theme.S23W07IntentDataTheme

class AnotherActivity : ComponentActivity() {
    companion object {
        const val IMAGE_NAME = "image name"
        const val IMAGE_RESULT = "image result"

        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23W07IntentDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumberImage()
                }
            }
        }
    }
}

fun onResultClick(activity: Activity, imageName: String, imageResult: Int) {
    val intent = Intent()
    intent.putExtra(ImageActivity.IMAGE_NAME, imageName)
    intent.putExtra(ImageActivity.IMAGE_RESULT, imageResult)
    activity.setResult(AppCompatActivity.RESULT_OK, intent)
    activity.finish()
}

@Composable
fun NumberImage(modifier: Modifier = Modifier) {
    val activity = LocalContext.current as Activity
    val intent = activity.intent
    val imageName = intent.getStringExtra(MainActivity.KEY_NAME) ?: "none"
    val res = when (imageName) {
        MainActivity.one -> R.drawable.image1
        MainActivity.two -> R.drawable.image2
        else -> R.drawable.ic_launcher_foreground
    }
    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(id = res),
        contentScale = ContentScale.Crop,
        contentDescription = "Number Image"
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {
            onResultClick(activity, imageName, LIKE)
        }) {
            Text("좋아요")
        }
        Button(onClick = {
            onResultClick(activity, imageName, DISLIKE)
        }) {
            Text("싫어요")
        }
    }
}