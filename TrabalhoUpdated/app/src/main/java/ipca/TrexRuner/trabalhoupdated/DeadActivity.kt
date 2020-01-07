package ipca.TrexRuner.trabalhoupdated

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pause.*

class DeadActivity: AppCompatActivity() {

    var gameActivity: GameActivity? = GameActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE// roda a tela
        setContentView(R.layout.activity_dead)

        //regressar para a activity do jogo
        voltarButton.setOnClickListener {
            gameActivity!!.gameView!!.resume()
            finish()
        }
        //regressar ao menu principal
        menuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}