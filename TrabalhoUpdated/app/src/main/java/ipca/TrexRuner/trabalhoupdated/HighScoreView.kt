package ipca.TrexRuner.trabalhoupdated

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView

class HighScoreView: SurfaceView, Runnable {

    var playing : Boolean = false
    var gameThread : Thread? = null
    var paint : Paint
    var canvas : Canvas
    var surfaceHolder : SurfaceHolder
    var score : Int = 0

    var viewWidth = 0
    var viewHeight = 0



    constructor(context: Context?,
                viewWidth : Int,
                viewHeight : Int ) : super(context) {
        paint = Paint()
        paint.textSize = 100.0f
        canvas = Canvas()
        surfaceHolder = holder
        this.viewWidth = viewWidth
        this.viewHeight = viewHeight
    }



    override fun run() {
        while (playing) {
            draw()
            update()
            control()
        }
    }

    fun update(){}
    fun draw(){}
    fun control(){
        Thread.sleep(30)
    }

    fun pause(){
        playing = false
        gameThread!!.join()
    }

    fun resume(){
        playing = true
        gameThread = Thread(this)
        gameThread!!.start()
    }
}