//Model Adaptor
interface AdvanceMediaPlayer{
    fun playVlc(fileName:String)
    fun playMp4(fileNAme:String)
}
interface MediaPlayer{
    fun play(audioType: String,fileName:String)
}
open class MediaAdapter:MediaPlayer{
    private var advancedMusicPlayer:AdvanceMediaPlayer?=null
    override fun play(audioType:String,fileName:String){
        if(audioType.equals("vlc",true)){
            if(advancedMusicPlayer==null){
                advancedMusicPlayer=VlcPlayer()
            }
            advancedMusicPlayer?.playVlc(fileName)
        }
        else if(audioType.equals("mp4",true)){
            if(advancedMusicPlayer == null){
                advancedMusicPlayer=Mp4Player()
            }
            advancedMusicPlayer?.playMp4(fileName)
        }
    }
}
class AudioPlayer:MediaAdapter(){
    override fun play(audioType:String,fileName:String){
        if(audioType.equals("mp3",true)){
            println("Playng mp3 file.name: $fileName")
        }
        else if(audioType.equals("vlc",true)||audioType.equals("mp4",true)){
            MediaAdapter().play(audioType,fileName)
        }
        else{
            println("Invalid media. $audioType format not supported")
        }
    }
}
class Mp4Player: AdvanceMediaPlayer{
    override fun playMp4(fileName:String){
        println("Playing mp4 file.Name: $fileName")
    }
    override fun playVlc(fileName:String){
        println("Only support mp4 type")
    }
}
class VlcPlayer: AdvanceMediaPlayer{
    override fun playMp4(fileName:String){
        println("only support vlc type")
    }
    override fun playVlc(fileName: String){
        println("Playing vlc file. Name: $fileName")
    }
}
fun main(args: Array<String>){
    val audioPlayer = AudioPlayer()
    audioPlayer.play("mp3","beyond the horizon.mp3")
    audioPlayer.play("mp4","alone.mp4")
    audioPlayer.play("vlc","far far away.vlc")
    audioPlayer.play("avi","mind me.avi")
}